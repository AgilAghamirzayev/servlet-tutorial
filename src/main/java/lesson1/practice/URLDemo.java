package lesson1.practice;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com/search?q=javatpoint&oq=javatpoint&sourceid=chrome&ie=UTF-8");

            System.out.printf("Protocol: %s\n",url.getProtocol());
            System.out.printf("Host Name: %s\n",url.getHost());
            System.out.printf("Port Number: %s\n",url.getPort());
            System.out.printf("Default Port Number: %s\n",url.getDefaultPort());
            System.out.printf("Query String: %s\n",url.getQuery());
            System.out.printf("Path: %s\n",url.getPath());
            System.out.printf("File: %s\n",url.getFile());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
