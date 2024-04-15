package multithreading.examples.ex03_semaphore;

import java.util.concurrent.Semaphore;

class Counter {
    private volatile int count = 0;
    private final Semaphore sem = new Semaphore(1);

    public void increment() throws InterruptedException {
        sem.acquire();
        try {
            count++;
        } finally {
            sem.release();
        }
    }

    public void decrement() throws InterruptedException {
        sem.acquire();
        try {
            count--;
        } finally {
            sem.release();
        }
    }

    public int getCount() {
        return count;
    }
}

public class WithSemaphore {

    public static void main(String[] args) throws InterruptedException {

        var counter = new Counter();

        var inc = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    counter.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        var dec = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    counter.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        inc.start();
        dec.start();
        inc.join();
        dec.join();

        System.out.println(counter.getCount());
    }
}