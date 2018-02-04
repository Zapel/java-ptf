package net.ukr.ptf.sandbox.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UCDemo {
    public static void main(String args[]) throws IOException {
        int c;
        URL hp = new URL("https://www.chint.net.ua/");
        URLConnection hpCon = hp.openConnection ();

        long d = hpCon.getDate ();
        if(d == 0)
            System.out.println ("Сведения о дате отсутствуют.");
        else System.out.println ("Дата: " + new Date (d));

             System.out.println ("Тип содержимого: " + hpCon.getContentType ());

        d = hpCon.getExpiration ();
        if(d == 0)
             System.out.println ("Сведения о сроке действия отсутствуют.");
        else System.out.println ("Срок действия последней модификации: " + new Date());

        d = hpCon.getLastModified ();
        if(d == 0)
             System.out.println ("Сведения о дате последней модификации отсуствуют.");
        else System.out.println ("Дата последней модификации: " + new Date());

        long len = hpCon.getContentLengthLong ();
        if(len == -1)
            System.out.println ("Длина содержимого недоступна.");
        else System.out.println ("Длина содержимого: " + len);
        if(len != 0) {
            System.out.println ( "=== Содержимое ===" );
            InputStream input = hpCon.getInputStream ();
            while ((c = input.read ()) != -1) {
                System.out.print((char) c);
            }
            input.close ();
        } else System.out.println ("Длина содержимого: " + len);
    }
}
