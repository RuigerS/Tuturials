
public class ComputeFactorial {

   public static void main(String[] args) {
       int number = 9;
       int fact;
       // compute factorial of number and assign result to fact
	   fact=number;
	while(number>=2){
	number--;
	fact*=number;
		}
       // assume number >= 1
       // print fact
System.out.println(fact);
   }
}