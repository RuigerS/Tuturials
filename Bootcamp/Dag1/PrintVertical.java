public class PrintVertical{

   public static void main(String[] args) {
       String org = "Bruine bloemen!";
       // Print String org met een letter per regel
       // De karakters a, o, i, u, e worden gevolgd door een *
for (int i = 0; i < org.length(); i++) {
			System.out.print(org.charAt(i));
			if(org.charAt(i)=='a'||org.charAt(i)=='e'||org.charAt(i)=='i'||org.charAt(i)=='o'||org.charAt(i)=='u'||org.charAt(i)=='y'){
			System.out.println("*");
			}
			else{
				System.out.println(" ");
			}	
		}
   }
}