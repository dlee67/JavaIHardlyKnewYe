import java.lang.InterruptedException;

public class SynchronizedExample {
    // Every Java objects can be used as a mutex because
    // all Java objects has monitor, which is what mutex is in Java.
    static final Object lock = new Object();
    static int i = 0;

    public static void main(String... args) {
        System.out.println("starting: " + Thread.currentThread());
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                  System.out.println("In T2");
                  try{
                    for(int counter = 0; counter < 100000000/2; counter++){
                      i++;
                    }
                    //System.out.println("running: " + Thread.currentThread());
                  } catch(Exception e) {
                    System.out.println("lol, broken.");
                  }
              }
            }
        }).start();

        synchronized (lock) {
            System.out.println("In T1");
            try{
              for(int counter = 0; counter < 100000000/2; counter++){
                i++;
              }
              //System.out.println("finishing: " + Thread.currentThread());
            }catch(Exception e){
              System.out.println("lol, something broke.");
            }
        }

        // So, i was 50000000. Guessing I will have to use something along the line of POSIX.
        System.out.println("i now is: " + i);
    }
}
