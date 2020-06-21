public class KaartSpel {

  public static void main(String[] args) {
    for(int i=0;i<4;i++){
       for(int k=1;k<=13;k++){
         switch (i){
           case 0:System.out.print("Schoppen " );break;
           case 1:System.out.print("Harten " );break;
           case 2:System.out.print("Ruiten " );break;
           case 3:System.out.print("Klaveren " );break;
         }
         switch (k){
          case 1:System.out.println("Aas");break;
          case 11:System.out.println("Boer");break;
          case 12:System.out.println("Vrouw");break;
          case 13:System.out.println("Heer");break;
          default:System.out.println(k);break;    
         }
       }
    }
       System.out.println("Joker");
       System.out.println("Joker");
  }
}