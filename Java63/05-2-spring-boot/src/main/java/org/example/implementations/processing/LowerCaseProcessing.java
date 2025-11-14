package org.example.implementations.processing;

import org.example.requestprocessorlibrary.StringProcessing;
import org.springframework.stereotype.Component;

@Component
public class LowerCaseProcessing implements StringProcessing {
    @Override
    public String process(String input) {
        return input.toLowerCase();
    }
}