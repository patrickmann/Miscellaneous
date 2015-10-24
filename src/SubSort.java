/**
 * Given array of integers, find indexes m and n, such that if you sort elements m through n the array will be sorted.
 * Minimize the size of the subsequence.
 */
public class SubSort {
    public static void subSort(int[] a) {
        if (a==null) {
            System.out.println("empty array");
            return;
        }

        if (a.length<2) {
            System.out.println("array too short");
            return;
        }

        // Find first out of order element descending
        int lo = -1;
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                lo = i;
            }
        }
        if (lo == -1) {
            System.out.println("array already sorted");
            return;
        }

        // Find first out of order element descending
        int hi = a.length;
        for (int i=a.length-1; i>0; i--) {
            if (a[i] < a[i-1]) {
                hi = i;
            }
        }

        // Determine min and max of candidate sequence
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i=lo; i<=hi; i++) {
            if (a[i]>max)
                max=a[i];
            if (a[i]<min)
                min=a[i];
        }

        // Now extend minimum candidate sequence until it meets the criteria
        while (lo > 0 && a[lo-1] > min)
            lo--;
        while (hi < a.length-1 && a[hi+1] < max)
            hi++;

        System.out.println("Min sub sort: "+lo+" - "+hi);
    }
}
