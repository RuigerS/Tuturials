package eu.additude.zarchief.los;

public class Shadowing {
    static int vraagVariabele = 1;
    public static void main(String[] args) {
        System.out.println(vraagVariabele);
        int vraagVariabele = 2; //shadowing
        System.out.println(vraagVariabele);
        //System.out.println(this.vraagVariabele); // this. niet beschikbaar
        System.out.println(Shadowing.vraagVariabele);
        testMethodOwnClass();
        FietsBel fietsBel = new FietsBel();
        fietsBel.testMethod();
    }
    static void testMethodOwnClass() {
        int vraagVariabele = 3;
        System.out.println(vraagVariabele);
        //geen this.vraagVariabele beschikbaar
        System.out.println(Shadowing.vraagVariabele);
    }
}
class FietsBel {
    int vraagVariabele = 4;
    void testMethod() {
        System.out.println(vraagVariabele);
        int vraagVariabele = 5;
        System.out.println(Shadowing.vraagVariabele);
        System.out.println(vraagVariabele);
        System.out.println(this.vraagVariabele);
    }
}

