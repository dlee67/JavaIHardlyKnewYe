public class VolatileExample {
    // Variable marked with volatile behaves as if every reference to it were
    // wrapped in a synchronization block.
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
