package org.example.requestprocessorlibrary;

import org.example.model.Request;
import org.example.model.Response;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Dispatcher {
    public Response processRequest(Request request, List<Handler> handlers) {
        if (handlers == null || handlers.isEmpty()) {
            Response response = new Response();
            response.setMessage("No handlers available");
            return response;
        }

        for (Handler handler : handlers) {
            if (handler.canHandle(request)) {
                return handler.handle(request);
            }
        }

        Response response = new Response();
        response.setMessage("No handler for type: " + request.getType());
        return response;
    }
}