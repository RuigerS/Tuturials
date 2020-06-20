package eu.additude.zarchief.los;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Demo extends Tralala{
    int a=15493;
    public static void main(String[] args) {
    int a=34;
        System.out.println("a = " + a);
        String fiets="fiets";
        fiets.concat("bel");
        StringBuilder tas=new StringBuilder(fiets);

        ArrayList<String> myArrList1=new ArrayList<String>();
        ArrayList rustig = new ArrayList();
        myArrList1.add("voegt een nieuwe string toe aan het einde");
        myArrList1.add(1,"voegt een nieuwe string te op index 1");
        myArrList1.set(0,"Vervangende string op index 0"); //immutable
        System.out.println("myArrList1 = " + myArrList1);
        System.out.println("myArrList1 = " + myArrList1);
        LocalTime nu=LocalTime.now();
        DateTimeFormatter f2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        System.out.println(nu.format(f2));
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0 ; i < size ; ++i) System.out.println(i+ " "+arr[i]);
        rustig.add("Fietsem");
//        if(true){
//            return;
//        }
//        System.out.println("Unreachable");
        Tralala demo=new Demo();
        demo.fietsen();
    }
//    void fietsen(){
//        System.out.println("Niet te ver fietsen, local");
//    }
}

class Tralala{
    void fietsen(){
        System.out.println("Lekker fietsen");
    }
}

