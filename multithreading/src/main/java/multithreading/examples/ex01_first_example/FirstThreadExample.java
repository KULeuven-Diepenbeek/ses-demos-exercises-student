package multithreading.examples.ex01_first_example;

import java.time.Duration;

public class FirstThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Hello");
        });

        t1.start();
        t1.join(Duration.ofSeconds(2));

        System.out.println("All done");
    }}
