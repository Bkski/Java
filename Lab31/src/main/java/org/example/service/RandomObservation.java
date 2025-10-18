package org.example.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import org.example.model.Observation;

public class RandomObservation {

    private static final Observation.TemperatureUnit[] UNITS = Observation.TemperatureUnit.values();
    private static final String[] COMMENTS = {
            "Sunny", "Cloudy", "Windy", "Foggy", "Stormy", "Clear night"
    };
    private static final Random RANDOM = new Random();

    public static Observation generate() {
        // Losowy znacznik czasowy
        LocalDateTime timeStamp = LocalDateTime.now()
                .minus(RANDOM.nextInt(7 * 24), ChronoUnit.HOURS)
                // POPRAWKA 1: Usunięto 'bound:' przed '60'
                .minus(RANDOM.nextInt(60), ChronoUnit.MINUTES);

        // Wybór losowej jednostki
        Observation.TemperatureUnit unit = UNITS[RANDOM.nextInt(UNITS.length)];

        // POPRAWKA 2: Przepisano 'switch' na składnię kompatybilną z Javą 11
        double value;
        switch (unit) {
            case Celsius:
                value = -10 + RANDOM.nextDouble() * 45; // -10 to 35
                break;
            case Fahrenheit:
                value = 14 + RANDOM.nextDouble() * 95;  // 14 to 109
                break;
            case Kelvin:
                value = 263 + RANDOM.nextDouble() * 45; // 263 to 308
                break;
            default:
                value = 0; // Nie powinno się zdarzyć
        }

        // Wybór losowego komentarza (lub brak)
        String comment = RANDOM.nextBoolean() ? COMMENTS[RANDOM.nextInt(COMMENTS.length)] : null;

        return new Observation(timeStamp, unit, value, comment);
    }
}