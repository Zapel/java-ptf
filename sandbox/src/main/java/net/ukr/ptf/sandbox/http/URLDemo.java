package net.ukr.ptf.sandbox.http;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String args[]) throws MalformedURLException {
        URL hp = new URL("http://www.herbschildt.com/Articles");

        System.out.println ("Протокол: " + hp.getProtocol ());
        System.out.println ("Хост: " + hp.getHost ());
        System.out.println ("Протокол: " + hp.getPort ());
        System.out.println ("Файл: " + hp.getFile ());
        System.out.println ("Полная форма: " + hp.toExternalForm ());
    }
}
