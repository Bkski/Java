package org.example.requestprocessorlibrary;

import lombok.AllArgsConstructor;
import org.example.model.Request;
import org.example.model.Response;

@AllArgsConstructor
public class Handler {
    private final String handledType;
    private final StringProcessing processing;

    public boolean canHandle(Request request) {
        return handledType.equals(request.getType());
    }

    public Response handle(Request request) {
        Response response = new Response();
        response.setData(processing.process(request.getData()));
        response.setMessage("OK");
        return response;
    }
}