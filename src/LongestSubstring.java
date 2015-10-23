import java.util.HashSet;
import java.util.Set;

/**
 * Find the longest unique character substring of a given string
 * This is the brute force method; the more efficient approach is to update the current sequence,
 * instead of discarding and starting over
 */
public class LongestSubstring {
    static public void find(String str) {
        char[] array = str.toCharArray();
        Set<Character> charset = new HashSet<>();
        int max = 1;
        int first = 0;
        int last = 0;

        for (int i = 0; i < array.length; i++) {
            charset.clear();
            for (int j = i; j < array.length; j++) {
                if (charset.contains(array[j])) {
                    // sequence ends because of duplicate char
                    int len = j-i;
                    if (len > max) {
                        max = len;
                        first = i;
                        last = j-1;
                    }
                    break;
                } else if (j == array.length-1){
                    // sequence ends because of end of array
                    int len = j-i+1;
                    if (len> max) {
                        max = len;
                        first = i;
                        last = j;
                    }
                } else {
                    // sequence continues
                    charset.add(array[j]);
                }
            }
        }
        System.out.format("Max=%d (%d-%d) %s %s\n", max, first, last, str, str.substring(first, last+1));
    }
}
