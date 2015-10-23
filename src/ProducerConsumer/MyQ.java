package ProducerConsumer;

public class MyQ {
    boolean empty = true;
    int data;

    public MyQ() {}

    synchronized public void put(int data)
    {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("put wait() interrupted");
            }
        }
        this.data = data;
        empty = false;
        notifyAll();
    }

    synchronized public int get() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("get wait() interrupted");
            }
        }
        int retVal = data;
        empty = true;
        notifyAll();
        return retVal;
    }
}
