package ProducerConsumer;

import java.util.Random;

public class Producer implements Runnable {
    MyQ queue;

    public Producer(MyQ queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        for (int i = 1; i < 5; i++) {
            queue.put(i);
            System.out.println("P: " + i);
            try {
                Thread.sleep(rnd.nextInt(500));
            } catch (InterruptedException e) {
                System.out.println("P interrupted");
            }
        }
    }
}
