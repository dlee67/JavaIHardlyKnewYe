public static final int RUN_MAX = 3;
private final Object lock = new Object();
private int running;

public void rateLimiter(NetworkRequest req) {
  synchronized (lock) {
    while (running >= RUN_MAX) {
      try { lock.wait(); }
      catch (InterruptedException e) {
        throw new AssertionError("Interrupts not supported");
      }
    }
    running++;
  }
  try { req.run(); }
  finally {
    synchronized (lock) {
      if (running-- == RUN_MAX) { lock.notify(); }
    }
  }
}
