package ProducerConsumer;

import java.util.Random;

public class Consumer  implements Runnable{
    MyQ queue;

    public Consumer(MyQ queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        for (int i=1; i<5; i++){
            System.out.println("C: " + queue.get());

            try {
                Thread.sleep(rnd.nextInt(500));
            } catch (InterruptedException e) {
                System.out.println("C interrupted");
            }
        }
    }
}
