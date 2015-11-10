import java.util.LinkedList;
import java.util.List;

public class PermuteString {
    static public List<String> permute(String s) {
        if (s == null)
            return null;

        List<String> result = new LinkedList<>();
        permute(result, "", s);
        return result;
    }

    static private void permute(List<String> result, String prefix, String suffix) {
        // Only 1 char left: nothing to permute
        if (suffix.length() == 1) {
            result.add(prefix + suffix.charAt(0));
            return;
        }

        // For each char in suffix: extend current prefix and recurse
        for (int i = 0; i < suffix.length(); i++) {
            String newPrefix = prefix + suffix.charAt(i);
            String newSuffix;
            if (i == 0)
                newSuffix = suffix.substring(1);
            else if (i == suffix.length()-1)
                newSuffix = suffix.substring(0, suffix.length()-1);
            else
                newSuffix = suffix.substring(0, i) + suffix.substring(i + 1);

            permute(result, newPrefix, newSuffix);
        }
    }
}
