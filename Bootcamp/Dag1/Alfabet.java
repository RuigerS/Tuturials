import java.util.Scanner;

public class Alfabet {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       // Schrijf hier je code
	   String input;
       String alfabet="abcdefghijklmnopqrstuvwxyz";
	   boolean nogEenKeer;
		for (int i = 0; i < alfabet.length(); i++) {
			nogEenKeer=true;
			while(nogEenKeer){
			input = sc.nextLine();
			input=input.toLowerCase();
			if(alfabet.charAt(i)==input.charAt(0)){
				System.out.println("OK");
				nogEenKeer=false;
				}
			else{
				System.out.println("FOUT");
			}
			}
		}
   }
}