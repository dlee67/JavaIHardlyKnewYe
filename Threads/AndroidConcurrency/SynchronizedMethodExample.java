public class SynchronizedMethodExample {
    private int executionCount;

    public synchronized void sync1() {
        for(int counter = 0; counter < 1000000000/2; counter++){
          executionCount++;
        }
        //someTask();
    }

    public void sync2() {
        synchronized (this) {
            for(int counter = 0; counter < 1000000000/2; counter++){
              executionCount++;
            }
            //someTask();
        }
    }

    public void someTask() {
        System.out.println("Execution counter at: " + executionCount);
    }
}
