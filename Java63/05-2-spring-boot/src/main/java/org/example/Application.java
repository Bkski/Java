package org.example;

import org.example.model.Request;
import org.example.model.Response;
import org.example.requestprocessorlibrary.RequestProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Uruchomienie Spring Boot i pobranie kontekstu
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        // Pobranie gotowego procesora z kontekstu
        RequestProcessor processor = context.getBean(RequestProcessor.class);

        // Uruchomienie testów
        // Test 1
        Request r1 = new Request();
        r1.setType("lower");
        r1.setData("Ala Ma Kota");
        Response resp1 = processor.processRequest(r1);
        System.out.println(resp1);

        // Test 2
        Request r2 = new Request();
        r2.setType("upper");
        r2.setData("Ala Ma Kota");
        Response resp2 = processor.processRequest(r2);
        System.out.println(resp2);

        // Test 3
        Request r3 = new Request();
        r3.setType("reverse");
        r3.setData("Ala Ma Kota");
        Response resp3 = processor.processRequest(r3);
        System.out.println(resp3);

        // Test 4
        Request r4 = new Request();
        r4.setType("unknown");
        r4.setData("Ala Ma Kota");
        Response resp4 = processor.processRequest(r4);
        System.out.println(resp4);

        // Zamknięcie kontekstu
        context.close();
    }
}