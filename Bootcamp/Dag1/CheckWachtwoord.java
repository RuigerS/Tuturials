
import java.util.Scanner;

public class CheckWachtwoord {
   public static void main(String[] args) {
       String wachtwoord = "java";
       // define Scanner
       Scanner sc = new Scanner(System.in);
       // read input
       String input;
       input = sc.nextLine();
       // check wachtwoord
		if(input.equals(wachtwoord)){
			System.out.println("Wachtwoord is OK: "+wachtwoord);
		}
		else{
			System.out.println("Wachtwoord is fout: "+wachtwoord);
		}
   }
}