/**
 * Dutch National Flag problem: given int array a and pivot,
 * reorder the array such that all elements less than pivot precede all
 * elements equal to pivot, followed by all elements greater than pivot.
 * Must swap in place! This requires 2 passes over the array.
 */
public class DutchFlag {

    public static void partition(int[] a, int pivotIndex) {
        if (a == null ||
                a.length == 1 ||
                pivotIndex < 0 ||
                pivotIndex > a.length - 1)
            return;

        int pivot = a[pivotIndex];
        int lo = 0;
        for (int i=0; i<a.length; i++){
            if (a[i]<pivot) {
                Utils.swap(a, i, lo);
                lo++;
            }
        }

        int hi = a.length - 1;
        for (int i=a.length-1; i>=0; i--) {
            if (a[i]>pivot) {
                Utils.swap(a, i, hi);
                hi--;
            }
        }
    }
}
