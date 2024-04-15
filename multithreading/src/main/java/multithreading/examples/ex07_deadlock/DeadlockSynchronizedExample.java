package multithreading.examples.ex07_deadlock;

public class DeadlockSynchronizedExample {
    static class Counter {
        public final Object readLock = new Object();
        public final Object writeLock = new Object();

        public volatile int value;
    }

    public static void main(String[] args) throws InterruptedException {
        var counter = new Counter();

        var inc = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (counter.readLock) {
                    synchronized (counter.writeLock) {
                        counter.value++;
                    }
                }
            }
        });
        var dec = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (counter.writeLock) {
                    synchronized (counter.readLock) {
                        counter.value--;
                    }
                }
            }
        });

        inc.start();
        dec.start();

        inc.join();
        dec.join();

        System.out.println(counter.value);
    }
}
