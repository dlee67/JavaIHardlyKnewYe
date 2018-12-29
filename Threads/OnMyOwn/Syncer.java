class Syncer{

  volatile int i = 0;
  Object lock = new Object();

  public void threadOne(){
    Thread threadOne = new Thread(){
      public void run(){
        synchronized(lock){
          for(int counter = 0; counter < 10000000/2; counter++){
            i++;
          }
        }
      }
    };
    threadOne.start();
  }

  public void threadTwo(){
    Thread threadTwo = new Thread(){
      public void run(){
        synchronized (lock){
          for(int counter = 0; counter < 10000000/2; counter++){
            i++;
          }
        }
      }
    };
    threadTwo.start();
    System.out.println("i at: " + i);
  }
}
