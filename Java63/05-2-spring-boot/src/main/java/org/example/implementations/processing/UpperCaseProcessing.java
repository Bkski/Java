package org.example.implementations.processing;

import org.example.requestprocessorlibrary.StringProcessing;
import org.springframework.stereotype.Component;

@Component
public class UpperCaseProcessing implements StringProcessing {
    @Override
    public String process(String input) {
        return input.toUpperCase();
    }
}