class RaceCondition{

  volatile static boolean done = false;
  volatile static long i = 0;
  static Object lock = new Object();

  public static void main(String args[]){
    threadOne();
    Thread threadTwo = new Thread(){
      public void run(){
        try{
          System.out.println("In the synchronized block of ThreadTwo.");
          for(int counter = 0; counter < 1000000000/2; counter++){
            i++;
          }
          System.out.println("Finished ThreadTwo.");
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
          System.out.println("In the synchronized block of ThreadOne.");
          for(int counter = 0; counter < 1000000000/2; counter++){
            i++;
          }
          done = true;
        } catch(Exception e){
          System.out.println("Something broke in Thread two.");
        }
      }
    };
    threadOne.start();
  }
}
