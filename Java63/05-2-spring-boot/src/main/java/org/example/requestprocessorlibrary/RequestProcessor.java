package org.example.requestprocessorlibrary;

import lombok.AllArgsConstructor;
import org.example.model.Request;
import org.example.model.Response;
import java.util.List;
import org.springframework.stereotype.Component; // Import


@Component // Dodano adnotację
@AllArgsConstructor // Spring użyje tego konstruktora do wstrzyknięcia zależności
public class RequestProcessor {
    private final List<Handler> handlers;
    private final Dispatcher dispatcher;

    public Response processRequest(Request request) {
        return dispatcher.processRequest(request, handlers);
    }
}