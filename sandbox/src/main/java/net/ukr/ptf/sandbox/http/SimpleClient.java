package net.ukr.ptf.sandbox.http;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class SimpleClient {
    public static  void main(String args[]) {
        try {
            Socket s1 = new Socket ( "127.0.0.1", 5432 );
            InputStream is = s1.getInputStream ();
            DataInputStream dis = new DataInputStream ( is );
            System.out.println (dis.readUTF ());
            dis.close ();
            s1.close ();
        } catch (ConnectException connExc) {
            System.err.println ("Could not connect to the server.");
        } catch (IOException e) {
            System.out.println ("Error2!");
        }
    }
}
