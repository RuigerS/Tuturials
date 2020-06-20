package eu.additude.zarchief.los;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Klok {
    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 10; i++) {
        for(;;){
//            System.out.println("i " + i);
//            TimeUnit.MILLISECONDS.sleep(100);
            TimeUnit.SECONDS.sleep(1);
            LocalTime time= LocalTime.now();
            DateTimeFormatter timePresent   = DateTimeFormatter.ofPattern("'Het is nu: 'HH mm ss");
            System.out.println(timePresent.format(time));
        }
    }
}

