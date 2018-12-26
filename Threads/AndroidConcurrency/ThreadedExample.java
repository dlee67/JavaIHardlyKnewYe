import java.lang.InterruptedException;

//from Java Concurrency, Android.
public class ThreadedExample {
    public static void main(String... args) throws InterruptedException{
        // Because whatever that main is in, it's also a Thread,
        // the sys.out prints out Thread[main, 5, main]
        System.out.println("starting: " + Thread.currentThread());
        new Thread() {
            @Override
            public void run() {
                //Where the newly spawned thread finshes last.
                System.out.println("running: " + Thread.currentThread());
            }
        }.start();
        // The main Thread most likely finishes first.
        Thread.currentThread().sleep(1000); // With this, the main Thread should finish last.
        System.out.println("finishing: " + Thread.currentThread());
    }
}
