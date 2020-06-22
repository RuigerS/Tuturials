package eu.additude;

public class Test {
    public static void main(String[] args) {
                try{
                    throw new B();
                }catch(Exception c){
                    ((A)c).vernoemen();
                }
            }
        }
        class A extends Exception{
            void vernoemen(){
                System.out.println("b");
            }
        }
        class B extends A{
            void vernoemen(){
                System.out.println("c");
            }
        }
        class C extends Exception{
            void vernoemen(){
                System.out.println("a");

    }
}
