/*
  From the looks of things, lock is not a mutex like in C/C++.
  Synchronize keyword tells the only one thread to execute the block
  at a time, nothing more.
*/
class SyncPrac{

  volatile static boolean done = false;
  volatile static long i = 0;
  static Object lock = new Object();

  public static void main(String args[]){
    threadOne();
    Thread threadTwo = new Thread(){
      public void run(){
        try{
          synchronized (lock){
            System.out.println("In the synchronized block of ThreadTwo.");
            for(int counter = 0; counter < 1000000000/2; counter++){
              i++;
            }
            System.out.println("Finished ThreadTwo.");
            lock.notify();
          }
        }catch(Exception e){
          System.out.println("Something broke in Thread one");
        }
      }
    };
    threadTwo.start();
    while(!done){
      try{
        Thread.currentThread().sleep(10000);
        System.out.println("zzZ");
      } catch (Exception e){
        System.out.println("Something broke while sleeping.");
      }
    }
    System.out.println("i at: " + i);
  }

  public static void threadOne(){
    Thread threadOne = new Thread(){
      public void run(){
        try{
          synchronized(lock){
            lock.wait();
            System.out.println("In the synchronized block of ThreadOne.");
            for(int counter = 0; counter < 1000000000/2; counter++){
              i++;
            }
            done = true;
          }
        } catch(Exception e){
          System.out.println("Something broke in Thread two.");
        }
      }
    };
    threadOne.start();
  }
}
