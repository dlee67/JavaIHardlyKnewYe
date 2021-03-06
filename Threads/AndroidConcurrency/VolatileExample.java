public class VolatileExample {
    // Keyword volatile enables all the Threads to see the declared variable.
    // https://examples.javacodegeeks.com/core-java/java-volatile-keyword-example/
    static volatile boolean stop;

    private static final Runnable job = new Runnable() {
        @Override
        public void run() {
            while (!stop) {
                System.out.println("running: " + Thread.currentThread());
            }
        }
    };

    public static void main(String... args) {
        System.out.println("starting: " + Thread.currentThread());

        new Thread(job).start();

        System.out.println("finishing: " + Thread.currentThread());
        stop = true;
   }
}
