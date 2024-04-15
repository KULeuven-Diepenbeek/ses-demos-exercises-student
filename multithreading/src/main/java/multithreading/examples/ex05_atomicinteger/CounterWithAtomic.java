package multithreading.examples.ex05_atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterWithAtomic {
    static class Counter {
        private final AtomicInteger count = new AtomicInteger(0);

        public void increment() { count.incrementAndGet(); }
        public void decrement() { count.decrementAndGet(); }
        public int getCount() { return count.get(); }
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
