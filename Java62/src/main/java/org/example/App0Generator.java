package org.example;

import org.example.requestprocessorlibrary.Dispatcher;
import org.example.requestprocessorlibrary.Handler;
import org.example.requestprocessorlibrary.RequestProcessor;
import java.util.List;

public class App0Generator {
    public static RequestProcessor createProcessor() {
        // Implementacja funkcji przetwarzających jako lambdy
        Handler h1 = new Handler("lower", s -> s.toLowerCase());
        Handler h2 = new Handler("upper", s -> s.toUpperCase());
        Handler h3 = new Handler("reverse", s -> new StringBuilder(s).reverse().toString());

        List<Handler> handlers = List.of(h1, h2, h3);
        Dispatcher dispatcher = new Dispatcher();

        return new RequestProcessor(handlers, dispatcher);
    }
}