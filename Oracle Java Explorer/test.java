import java.util.*;
import java.io.*;

public class Test {
  public static void main(String[] argh) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> arrl = new ArrayList<>();
    try {
      arrl.add(sc.nextLine());
    }
    catch(NoSuchElementException exception){
      int nummer=1;
      for(String line:arrl){
        System.out.println("" + nummer + " " + line);
        nummer++;
      }
    }
  }
}