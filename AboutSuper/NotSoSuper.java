class NotSoSuper extends SuperClass{
  public void nothing(){
    System.out.println("In nothing, getting something ...");
    //Since, super referrs to the parent class, below line of code is completely valid.
    super.thing();
  }
}
