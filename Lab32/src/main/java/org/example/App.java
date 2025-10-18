package org.example;

import org.example.model.Observation;
import org.example.model.ObservationList;
import org.example.service.XmlFileReader;
import org.example.service.XmlValidator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    // Dane w głównym katalogu projektu:
    final static String[] schemaFiles = {"schema1.xsd", "schema2.xsd"};
    final static String dataObservationFile = "observation.xml";
    final static String dataObservationsFile = "observations.xml";

    public static void main(String[] args) {
        boolean result_1 = XmlValidator.validate(dataObservationFile, schemaFiles);
        boolean result_list = XmlValidator.validate(dataObservationsFile, schemaFiles);
        System.out.println("Validate: " + dataObservationFile + " -> " + result_1);
        System.out.println("Validate: " + dataObservationsFile + " -> " + result_list);

        if (!result_1 || !result_list) {
            System.out.println("\nJeden z plików jest niezgodny ze schematem. Koniec programu.");
            return;
        }

        // Przeczytanie pliku z pojedynczym pomiarem
        System.out.println("\n---");
        Observation observation = XmlFileReader.readObservation(dataObservationFile, Observation.class);
        System.out.println(observation);
        
        System.out.println("\n---");
        ObservationList observationList = XmlFileReader.readObservation(dataObservationsFile, ObservationList.class);

        if (observationList != null) {
            List<Observation> observationListFiltered = observationList.getObservations().stream()
                    // Filtr: bierzemy tylko te z komentarzem
                    .filter(o -> o.getComment() != null)
                    // Mapowanie: konwertujemy wszystkie jednostki na Celsjusza
                    .map(o -> {
                        double valueInCelsius;
                        switch (o.getUnit()) {
                            case Fahrenheit:
                                valueInCelsius = (o.getValue() - 32) * 5.0 / 9.0;
                                break;
                            case Kelvin:
                                valueInCelsius = o.getValue() - 273.15;
                                break;
                            case Celsius:
                            default:
                                valueInCelsius = o.getValue();
                                break;
                        }
                        // Zwracamy nowy obiekt Observation ze znormalizowaną wartością
                        return new Observation(o.getTimeStamp(), Observation.TemperatureUnit.Celsius, valueInCelsius, o.getComment());
                    })
                    // Filtr: bierzemy wartości w przedziale od -1 do +1
                    .filter(o -> o.getValue() > -1 && o.getValue() < 1)
                    // Sortowanie po wartości
                    .sorted(Comparator.comparingDouble(Observation::getValue))
                    // Zebranie wyników do nowej listy
                    .collect(Collectors.toList());

            // Wyświetlenie przefiltrowanej i posortowanej listy
            observationListFiltered.forEach(System.out::println);
        }
    }
}

