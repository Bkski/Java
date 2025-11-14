package org.example.implementations.handlers;

import org.example.requestprocessorlibrary.Handler;
import org.example.requestprocessorlibrary.StringProcessing;
import org.springframework.stereotype.Component;

@Component
public class LowerCaseHandler extends Handler {
    public LowerCaseHandler(StringProcessing lowerCaseProcessing) {
        super("lower", lowerCaseProcessing);
    }
}