import java.util.Scanner;

class Example{

  static QuickAndDirtyScanner qadScanner = () -> { return new Scanner(System.in).nextLine();};
  static Fib sum = (input) -> { return input + 1; };
  static GenericFunctionalInterface<String, String> checkEquals = (String varOne, String varTwo) -> {
    return varOne.equals(varTwo);
  };

  public static void main(String args[]){
    MyValue myValue = new MyValue(){
      public double getValue(){
        return 5.5;
      }
    };
    DivideByTwo div = (value) -> {return value/2;};
    System.out.println(div.divideByTwo(10.0));
    System.out.println(qadScanner.getInput());
    System.out.println(sum.add(2));
    System.out.println(checkEquals.isEquals("bob", "bob"));
    System.out.println(checkEquals.isEquals("alice", "bob"));
    System.out.println(new Fib(){
      public int add(int value){
        return value;
      }
    }.add(5));
  }
}
