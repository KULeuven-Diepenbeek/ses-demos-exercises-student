package multithreading.exercises.ex02_cache;

public class Downloader {

    public String download(String url) {
        try {
            System.out.println("Downloading " + url + " (" + Thread.currentThread() + ")");
            Thread.sleep(1000);
            System.out.println("Done downloading " + url + " (" + Thread.currentThread() + ")");
            return "Contents of " + url;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
