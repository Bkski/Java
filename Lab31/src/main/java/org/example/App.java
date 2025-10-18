package org.example;

import org.example.model.Observation;
import org.example.model.ObservationList;
import org.example.service.RandomObservation;
import org.example.service.XmlFileWriter;
import org.example.service.XsdFileGenerator;

public class App {

    public static void main(String[] args) {

        System.out.println("Generating XSD files...");
        // Zapis struktury i reguł danych do plików xsd
        XsdFileGenerator.generate(Observation.class, ObservationList.class);
        System.out.println("...XSD files generated.");


        System.out.println("Generating single observation to observation.xml...");
        // Pojedynczy pomiar do xml
        Observation observation = RandomObservation.generate();
        XmlFileWriter.write(observation, "observation.xml");
        System.out.println("...single observation saved.");


        System.out.println("Generating 1000 observations to observations.xml...");
        // Zapis 1000 pomiarów do xml
        ObservationList observationList = new ObservationList();
        for (int i = 0; i < 1000; i++) {
            observationList.addObservation(RandomObservation.generate());
        }
        XmlFileWriter.write(observationList, "observations.xml");
        System.out.println("...1000 observations saved.");

        System.out.println("Done.");
    }
}