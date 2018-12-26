class SynchronizedMethodExampleRunner{
  public static void main(String args[]){
    SynchronizedMethodExample obj = new SynchronizedMethodExample();
    obj.sync1();
    obj.sync2();
    obj.someTask();
  }
}
