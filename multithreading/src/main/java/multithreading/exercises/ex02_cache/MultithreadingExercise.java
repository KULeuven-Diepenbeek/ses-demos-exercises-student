package multithreading.exercises.ex02_cache;

import java.util.Random;

public class MultithreadingExercise {

    private static final String[] urls = { "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx" };

    private static final Random random = new Random();
    private static String randomURL() {
        return urls[random.nextInt(urls.length)];
    }

    public static void main(String[] args) {
        // start 4 threads who use Downloader to download 100 files
    }

}
