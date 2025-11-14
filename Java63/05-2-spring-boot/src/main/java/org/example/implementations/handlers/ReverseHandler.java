package org.example.implementations.handlers;

import org.example.requestprocessorlibrary.Handler;
import org.example.requestprocessorlibrary.StringProcessing;
import org.springframework.stereotype.Component;

@Component
public class ReverseHandler extends Handler {
    public ReverseHandler(StringProcessing reverseProcessing) {
        super("reverse", reverseProcessing);
    }
}