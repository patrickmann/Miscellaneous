/**
 * Dutch National Flag problem: given int array a and pivot,
 * reorder the array such that all elements less than pivot precede all
 * elements equal to pivot, followed by all elements greater than pivot.
 * Must swap in place!
 */
public class DutchFlag {

    // 2 pass approach: first sort smaller elements to the front, then larger
    // elements to the back
    public static void partition2(int[] a, int pivotIndex) {
        if (a == null ||
                a.length == 1 ||
                pivotIndex < 0 ||
                pivotIndex > a.length - 1)
            return;

        int pivot = a[pivotIndex];
        int lo = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < pivot) {
                Utils.swap(a, i, lo);
                lo++;
            }
        }

        int hi = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] > pivot) {
                Utils.swap(a, i, hi);
                hi--;
            }
        }
    }

    // Single pass: maintain the following invariants:
    // 0 .. smaller: elements smaller than pivot
    // smaller .. equal: equal to pivot
    // equal .. larger: unclassified
    // larter .. end of array: larger than pivot
    public static void partition(int[] a, int pivotIndex) {
        if (a == null ||
                a.length == 1 ||
                pivotIndex < 0 ||
                pivotIndex > a.length - 1)
            return;

        int pivot = a[pivotIndex];
        int smaller = 0;
        int equal = 0;
        int larger = a.length;
        while (equal < larger) {
            if (a[equal] < pivot) {
                Utils.swap(a, smaller++, equal++);
            }
            else if (a[equal] == pivot) {
                equal++;
            }
            else { // a[equal] > pivot
                Utils.swap(a, equal, --larger);
            }
        }
    }
}