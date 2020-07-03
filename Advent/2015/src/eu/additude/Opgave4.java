package eu.additude;

import com.sun.org.apache.xpath.internal.objects.XString;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Opgave4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "yzbqklnj";
        int password = 0;
//        String input="abcdef";
//        String password="609043";
        boolean search = true;
        while (search) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String tryThis = input + password;
            md.update(tryThis.getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            if (myHash.substring(0, 6).equals("000000")) {
                System.out.println(myHash);
                System.out.println(password);
                search = false;
            }
            password++;
        }
    }
}
