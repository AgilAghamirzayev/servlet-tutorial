package lesson1.practice;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost",8080);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str="",str1 ="";
        while (!str.equals("stop")){
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str1 = din.readUTF();
            System.out.println("Server says: "+str1);
        }
        dout.close();
        s.close();
    }
}
