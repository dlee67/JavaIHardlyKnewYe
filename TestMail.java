import java.util.function.Function;

class TestMail{

  //Functional Programming in Java: How functional techniques improve your Java programs
  //The below codebase is a way to increase the referential transparency.
  final Patttern emailPattern = Pattern.compile(".*");
  final Function<String, Boolean> emailChecker = s -> emailPattern.matcher(s).matches();

  public static void testMail(String email){
	 if(emailChecker.apply(email)){
		  sendVerificationMail(email);
	 }else{
		  System.out.println("e-mail broken or something...");
	 }
  }

  public static void main(String args[]){
    testMail("lol");
  }
}
