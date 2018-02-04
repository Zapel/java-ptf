package net.ukr.ptf.sandbox.http;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLDemo {
    public static void main (String args[]) throws Exception {
        URL hp = new URL ( "http://www.google.com" );
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection ();


        System.out.println ( "Meтoд запроса: " + hpCon.getRequestMethod () );

        System.out.println ( "Koд ответа: " + hpCon.getResponseCode () );

        System.out.println ( "Oтвeтнoe сообщение: " + hpCon.getResponseMessage () );

        Map<String, List<String>> hdrMap = hpCon.getHeaderFields ();
        Set<String> hdrField = hdrMap.keySet ();
        System.out.println ( "\nДaлee следует заголовок: " );
        for (String k : hdrField) {
            System.out.println ( "Kлюч: " + k + " /Значение: " + hdrMap.get ( k ) );
        }
    }
}
