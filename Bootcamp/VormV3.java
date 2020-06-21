
import java.util.Scanner;

public class VormV3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);
        //Startpunt loop do while / while
        boolean doorgaan = true;
        while (doorgaan) {
            System.out.println("Hoi, wil je een gewoon vierkant (gv), variabel vierkant (vv), een rechthoek (rh) of stoppen (st)? ");
            String keuze = sc.nextLine();
            keuze = keuze.toLowerCase();
            switch (keuze) {
                case "gv":
                    System.out.println("Dit is een 4 vierkant :");
                    tekenVierkant();
                    break;
                case "vv":
                    System.out.println("Hoe groot wil je jouw vierkant ");
                    //String invoer =sc.nextLine();
                    int invoer = sci.nextInt();
                    tekenVierkantVar(invoer);
                    break;
                case "rh":
                    System.out.println("Wij tekenen een rechthoek ");
                    System.out.println("Voer hoogte in  ");
                    int hoogte = sci.nextInt();
                    System.out.println("Voer breedte in  ");
                    int breedte = sci.nextInt();
                    tekenRechthoek(hoogte, breedte);
                    break;
                case "st":
                    //beeindig loop do while while
                    doorgaan=false;
                    System.out.println("Klaar!!!  ");
                    break;
                default:
                    System.out.println("Invoer niet herkend; verwacht werd vv, gv of rh."+ keuze);
            }
        }
    }

    public static void tekenVierkant() {
        for (int i = 0; i < 4; i++) {
            System.out.println("+  +  +  +");
        }
    }

    public static void tekenVierkantVar(int bv) {
        for (int i = 0; i < bv; i++) {
            for (int j = 0; j < bv; j++) {
                System.out.print("+  ");
            }
            System.out.println("");
        }
    }

    public static void tekenRechthoek(int hoogte, int breedte) {
        for (int i = 0; i < hoogte; i++) {
            for (int j = 0; j < breedte; j++) {
                System.out.print("+  ");
            }
            System.out.println("");
        }
    }
}