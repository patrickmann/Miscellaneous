/**
 * Sort a sequence of number to satisfy following constrain: a1 < a2 > a3 < a4 ...
 * Here we do a bubble sort using the alternating sequence.
 * Alternatively: simply sort the array in ascending order and then swap pairwise a2/a3, a4/a5, etc.
 */
public class SortAlternating {
    public static void sort(int[] array) {
        printArray(array);
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (i%2 == 0) {
                    //even < odd
                    if (array[i] > array[i+1]) {
                        swap(array, i, i+1);
                        sorted = false;
                    }
                } else {
                    //odd > even
                    if (array[i] < array[i+1]) {
                        swap(array, i, i+1);
                        sorted = false;
                    }
                }
            }
        }
        printArray(array);
    }

    static void printArray(int[] a) {
        for (int d: a) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
