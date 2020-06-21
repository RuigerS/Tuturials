public class ReverseString {

   public static void main(String[] args) {
       String str = "Ik programmeer Java!";
       String reverse;
       System.out.println(str);
       // reverse = omgekeerde van str
		StringBuilder sb = new StringBuilder(str);
		reverse=sb.reverse().toString();
       // print reverse
		System.out.println(reverse);
   }
}