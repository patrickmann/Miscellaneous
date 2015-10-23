/**
 * Given a sorted array of distinct integers between 1 and 99, print the missing numbers:
 * - if a single number x is missing, print x
 * - if a range x1-x2 is missing, print x1-x2
 * - separate what you print by ","
 */
public class PrintGaps {
    static boolean isFirst;

    public static void printGaps(int[] a, int max) {
        // null array
        if (a == null) {
            System.out.println("1-" + max);
            return;
        }

        isFirst = true;
        printFirst(a[0], max);

        // 2 or more elements
        for (int i = 0; i < a.length - 1; i++) {
            printInner(a[i], a[i + 1], max);
        }

        printLast(a[a.length - 1], max);
    }

    static void printInner(int num1, int num2, int max) {
        int diff = num2 - num1;
        if (diff == 1)
            return;

        if (!isFirst)
            System.out.print(",");
        else
            isFirst = false;

        if (diff == 2)
            System.out.print(num1 + 1);
        else
            System.out.print((num1 + 1) + "-" + (num2 - 1));
    }

    static void printFirst(int num, int max) {
        if (num > 1) {
            isFirst = false;
            if (num == 2)
                System.out.print("1");
            else
                System.out.print("1-" + (num - 1));
        }
    }

    static void printLast(int num, int max) {
        if (num < max) {
            if (!isFirst)
                System.out.print(",");
            if (num == max - 1)
                System.out.println(max);
            else
                System.out.println((num + 1) + "-" + max);
        } else System.out.println();
    }
}
