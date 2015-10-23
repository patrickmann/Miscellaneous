
public class Join {
    static class MyThread extends Thread {
        String name;
        Thread waitFor = null;

        public MyThread(String name, Thread waitFor) {
            this.name = name;
            this.waitFor = waitFor;
        }

        @Override
        public void run() {
            super.run();

            if (waitFor != null)
                try {
                    waitFor.join();
                } catch (InterruptedException e) {
                    System.out.println(name + " interruped while waiting");
                }
            System.out.println(name);
        }
    }

    static void runJoin() {
        MyThread t1 = new MyThread("t1", null);
        MyThread t2 = new MyThread("t2", t1);
        MyThread t3 = new MyThread("t3", t2);
        t3.start();
        t2.start();
        t1.start();
    }
}
