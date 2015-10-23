import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Find all pairs of integers within an array which sum to a specified value.
 * Solution 1 assumes no duplicates.
 *
 * Extending this to n:
 *    for each number in set
 *       solve for n-1 and sum-number (excluding current number)
 */
public class SumPairs {
    static void printPairs(int[] numbers, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int number : numbers) {
            int complement = sum - number;
            if (set.contains(complement)) {
                System.out.println(number + "," + complement);
                set.remove(complement);
            } else {
                set.add(number);
            }
        }
    }

    /**
     * Solution 2 handles duplicates
     */
    static void printPairsWithDupes(int[] numbers, int sum) {
        // Add all array elements to a map, with number of occurrences as value
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : numbers) {
            if (map.containsKey(e)) {
                int value = map.get(e);
                map.put(e, value + 1);
            } else map.put(e, 1);
        }

        // For each entry, check for complement and consume available instances
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(0)) {
                continue;
            }
            int number = entry.getKey();
            int complement = sum - number;
            if (map.containsKey(complement) && map.get(complement) > 0) {
                for (int j = 0;
                     j < Math.min(map.get(number), map.get(complement));
                     j++) {
                    if ((number==complement) && (map.get(number) < 2)) break;
                    System.out.println(number + "," + complement);
                    map.put(number, map.get(number) - 1);
                    map.put(complement, map.get(complement) - 1);
                }
            }
        }
    }
}
