package multithreading.examples.ex06_synchronized;

public class SynchronizedBlock {


    static class Counter {
        private volatile int count = 0;
        private final Object lock = new Object();

        public void increment() {
            synchronized (lock) {
                count++;
            }
        }

        public void decrement() {
            synchronized (lock) {
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        var counter = new Counter();

        var inc = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        var dec = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.decrement();
            }
        });

        inc.start();
        dec.start();
        inc.join();
        dec.join();

        System.out.println(counter.getCount());
    }
}
