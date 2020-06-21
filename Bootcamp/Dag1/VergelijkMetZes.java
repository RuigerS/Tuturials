import java.util.Scanner;


public class VergelijkMetZes {

   public static void main(String[] args) {

       //int cijfer = 8;
	   //Lees cijfer
		Scanner sc = new Scanner(System.in);
		System.out.print("Welk cijfer wil je vergelijken met 6? ");
		int cijfer = sc.nextInt();	
		// Vergelijk cijfer met 6
		if(cijfer<6){System.out.println("lager");}
		if(cijfer>6){System.out.println("hoger");}
		if(cijfer==6){System.out.println("gelijk");}

   }

}

