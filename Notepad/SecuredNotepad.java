import java.util.Scanner;

public class SecuredNotepad  extends SimpleNotepad{

	private final String password;
@SuppressWarnings("resource")
public SecuredNotepad() throws InvalidPasswordException{
	String password;
	Scanner sc = new Scanner(System.in);
	boolean  hasSmallLetter=false,hasCapitalLetter=false;
		System.out.println("To create object ,please enter a password :");
		password=sc.next();
		for (int i = 0; i < password.length(); i++) {
			if(password.charAt(i)>=65&&password.charAt(i)<=90){
				hasCapitalLetter=true;
			}
			if(password.charAt(i)>=97&&password.charAt(i)<=122){
				hasSmallLetter=true;
			}
		}
	if(password.length()<5||!hasSmallLetter||!hasCapitalLetter){
		throw new InvalidPasswordException();
	}
	if(!sc.hasNext()){
		sc.close();
	}
	this.password=password;
}



public void addTextToPage(int pageNum, String text) {
	if(checkPassword()){
		super.addTextToPage(pageNum, text);
		System.out.println("Text is ADDED.");
	}else{
		System.out.println("Unable to provide this function.Please try again with correct password.");
	}
	
}


public void redactPageContent(int pageNum, String text) {

	if(checkPassword()){
		super.redactPageContent(pageNum, text);
	}else{
		System.out.println("Unable to provide this function.Please try again with correct password.");
	}
}


public void deleteContent(int pageNum) {
	if(checkPassword()){
		super.deleteContent(pageNum);
	}else{
		System.out.println("Unable to provide this function.Please try again with correct password.");
	}
}


public void printContent() {
	if(checkPassword()){
		super.printContent();
	}else{
		System.out.println("Unable to provide this function.Please try again with correct password.");
	}
	
}
/**
 * 
 * @return if password is correct
 */
private boolean checkPassword(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your password :");
	String pass = sc.next();

	if(pass.equals(this.password)){
		if(!sc.hasNext()){
			sc.close();
		}
		return true;
	}
	if(!sc.hasNext()){
		sc.close();
	}
	return false;
}

}
