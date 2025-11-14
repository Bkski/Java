package org.example;

import org.example.model.Request;
import org.example.model.Response;
import org.example.requestprocessorlibrary.RequestProcessor;

public class App0 {
    public static void main(String[] args) {
        System.out.println("App0 start");

        // Pobranie procesora z generatora
        RequestProcessor processor = App0Generator.createProcessor();

        // Test 1: type="lower"
        Request r1 = new Request();
        r1.setType("lower");
        r1.setData("Ala Ma Kota");
        Response resp1 = processor.processRequest(r1);
        System.out.println(resp1);

        // Test 2: type="upper"
        Request r2 = new Request();
        r2.setType("upper");
        r2.setData("Ala Ma Kota");
        Response resp2 = processor.processRequest(r2);
        System.out.println(resp2);

        // Test 3: type="reverse"
        Request r3 = new Request();
        r3.setType("reverse");
        r3.setData("Ala Ma Kota");
        Response resp3 = processor.processRequest(r3);
        System.out.println(resp3);

        // Test 4: type="unknown"
        Request r4 = new Request();
        r4.setType("unknown");
        r4.setData("Ala Ma Kota");
        Response resp4 = processor.processRequest(r4);
        System.out.println(resp4);

        System.out.println("App0 stop");
    }
}