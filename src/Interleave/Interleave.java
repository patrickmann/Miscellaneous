package Interleave;

// Synchronized counter class
public class Interleave {
    private int ctrInt = 0;
    private boolean isOdd = false;

    public int get() {
        return ctrInt;
    }

    // If current counter value matches isOdd then increment and print, else wait
    public synchronized void printNumber (boolean isOdd, String tag) {
        //System.out.println(tag + " " + ctrInt);
        while (this.isOdd != isOdd) {
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }

        ++ctrInt;
        System.out.print(tag + ctrInt + " ");
        this.isOdd = (ctrInt % 2 == 1);
        notifyAll();
    }
}