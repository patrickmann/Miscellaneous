import java.lang.reflect.Array;
import java.util.*;

/**
 * Re-order a string list such that anagrams are next to each other.
 * No specific sort order is required for the anagrams or groups of anagrams.
 */
public class Anagram {
    // Use a simple HashMap rather than TreeMap, since no sorting of keys required
    private static Map<String, List<String>> map = new HashMap<String, List<String>>();

    static void buildMap(String[] array) {
        map.clear();
        for (String s: array) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(s);
            }
            else {
                List<String> list = new LinkedList<String>();
                list.add(s);
                map.put(key, list);
            }
        }
    }

    public static String[] sort(String[] array) {
        buildMap(array);

        int i=0;
        for (String key: map.keySet()) {
            List<String> list = map.get(key);
            for (String value: list) {
                array[i]=value;
                i++;
            }
        }
        return array;
    }


}