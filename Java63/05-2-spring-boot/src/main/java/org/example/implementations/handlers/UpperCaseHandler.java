package org.example.implementations.handlers;

import org.example.requestprocessorlibrary.Handler;
import org.example.requestprocessorlibrary.StringProcessing;
import org.springframework.stereotype.Component;

@Component
public class UpperCaseHandler extends Handler {
    public UpperCaseHandler(StringProcessing upperCaseProcessing) {
        super("upper", upperCaseProcessing);
    }
}