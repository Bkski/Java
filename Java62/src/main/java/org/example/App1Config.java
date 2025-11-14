package org.example;

// Wymagany jest nowy import
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.requestprocessorlibrary.Dispatcher;
import org.example.requestprocessorlibrary.Handler;
import org.example.requestprocessorlibrary.RequestProcessor;
import org.example.requestprocessorlibrary.StringProcessing;
import java.util.List;

@Configuration
public class App1Config {

    @Bean
    public StringProcessing stringProcessingLower() {
        return s -> s.toLowerCase();
    }

    @Bean
    public StringProcessing stringProcessingUpper() {
        return s -> s.toUpperCase();
    }

    @Bean
    public StringProcessing stringProcessingReverse() {
        return s -> new StringBuilder(s).reverse().toString();
    }

    @Bean
    public Handler handlerLower(@Qualifier("stringProcessingLower") StringProcessing processing) {
        return new Handler("lower", processing);
    }

    @Bean
    public Handler handlerUpper(@Qualifier("stringProcessingUpper") StringProcessing processing) {
        return new Handler("upper", processing);
    }

    @Bean
    public Handler handlerReverse(@Qualifier("stringProcessingReverse") StringProcessing processing) {
        return new Handler("reverse", processing);
    }

    @Bean
    public Dispatcher dispatcher() {
        return new Dispatcher();
    }

    @Bean
    public RequestProcessor requestProcessor(List<Handler> handlers, Dispatcher dispatcher) {
        return new RequestProcessor(handlers, dispatcher);
    }
}