import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntersection {
    // Given two sorted arrays (with duplicates), return the intersection (without duplicates)
    public static int[] arrayIntersection (int[] a1, int[] a2) {
        List<Integer> intersect = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;

        while (p1<a1.length && p2<a2.length) {
            int val1 = a1[p1];
            int val2 = a2[p2];
            if (val1 == val2) {
                intersect.add(val1);
                while (a1[p1] == val1 && p1 < a1.length-1) p1++;
                while (a2[p2] == val1 && p2 < a2.length-1) p2++;
                if (a1[p1] == val1) p1++;
                if (a2[p2] == val1) p2++;
            }
            else if (val1 < val2)
                p1++;
            else
                p2++;
        }

        int[] result = new int[intersect.size()];
        for (int i=0; i<intersect.size(); i++)
            result[i] = intersect.get(i);
        return result;
    }

    public static void testArrayIntersection () {
        testArrayIntersection(new int[]{1,2,3}, new int[]{2,3,4}, new int[]{2,3});
    }

    static boolean testArrayIntersection (int[] a1, int[] a2, int[] expected) {
        int[] result = arrayIntersection(a1, a2);

        boolean success = Arrays.equals(result, expected);

        System.out.print(success?"PASS: ":"FAIL: ");
        Utils.printArray(a1);
        System.out.print(" ");
        Utils.printArray(a2);
        System.out.print(" ");
        Utils.printArray(result);
        System.out.println();

        return success;
    }
}
