package Interleave;

// Class to print even or odd numbers up to the given maximum
public class PrintInterleave extends Thread {
    Interleave ctr;
    int max;
    boolean odd;
    String tag;

    public PrintInterleave (Interleave ctr, int max, boolean odd, String tag) {
        this.ctr = ctr;
        this.max = max;
        this.odd = odd;
        this.tag = tag;

        // Adjust max depending on whether it is on an odd or even number. This prevents
        // overshooting by 1.
        if ((max % 2 == 1) && odd || (max % 2 == 0) && !odd) {
            this.max -= 1;
        }
        //System.out.println(tag + ": " + odd + " " + max);
    }

    public void run() {
        while (ctr.get() < max) {
            ctr.printNumber(odd, tag);
        }
        System.out.println();
    }
}