package org.example.requestprocessorlibrary;

import lombok.AllArgsConstructor;
import org.example.model.Request;
import org.example.model.Response;
import java.util.List;

@AllArgsConstructor
public class RequestProcessor {
    private final List<Handler> handlers;
    private final Dispatcher dispatcher;

    public Response processRequest(Request request) {
        return dispatcher.processRequest(request, handlers);
    }
}