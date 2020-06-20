package eu.additude.zarchief.los;

public class WrapItUp {
    static int i;
    public static void main(String[] args) {
        String string = "tralala abcdefghijklmnopqrstuvwxyz 1234567890";
        System.out.println(string.charAt(3));
        System.out.println(string); //checkit still to be original
        System.out.println(string.indexOf("abc"));
        System.out.println(string.indexOf('a'));
        System.out.println(string); //checkit still to be original
        System.out.println(string.substring(3,6));
        System.out.println(string); //checkit still to be original
        System.out.println(string.trim());
        System.out.println(string); //checkit still to be original
        System.out.println(string.replace('a','4'));
        System.out.println(string); //checkit still to be original
        System.out.println(string.length());
        System.out.println(string); //checkit still to be original
        System.out.println(string.startsWith("rew"));
        System.out.println(string); //checkit still to be original
        System.out.println(string.endsWith("rew2"));
        System.out.println(string); //checkit still to be original
        System.out.println(string.substring(0,3));
        System.out.println(string.startsWith(string.substring(0,3)));
        System.out.println(string); //checkit still to be original
        System.out.println(string.substring((string.length()-3),(string.length())));
        System.out.println(string.endsWith(string.substring((string.length()-3),(string.length()))));
        System.out.println(string); //checkit still to be original
        System.out.println(i);

    }
}
