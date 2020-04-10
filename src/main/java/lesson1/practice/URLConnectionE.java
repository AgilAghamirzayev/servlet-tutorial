package lesson1.practice;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionE {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.javatpoint.com/java-tutorial");
            URLConnection urlCon = url.openConnection();
            InputStream stream = urlCon.getInputStream();
            int i;
            while ((i=stream.read())!=-1){
                System.out.print((char)i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
