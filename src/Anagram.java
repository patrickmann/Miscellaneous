import java.lang.reflect.Array;
import java.util.*;

/**
 * Sort a string list such that anagrams are next to each other
 */
public class Anagram {
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
        int i=0;
        buildMap(array);
        for (String key: map.keySet()) {
            List<String> list = map.get(key);
            for (String value: list) {
                array[i]=value;
                i++;
            }
        }
        return array;
    }

    public static void print(String[] array) {
        for (String s: array)
            System.out.print(s+" ");
        System.out.println();
    }
}