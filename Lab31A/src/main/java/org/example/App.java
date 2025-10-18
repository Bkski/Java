package org.example;

import org.example.service.RandomObservation;
import org.example.service.XmlFileWriter;
import org.example.service.XsdFileGenerator;
import org.example.model.Observation;
import org.example.model.ObservationList;

public class App {

    public static void main(String[] args) {

        System.out.println("Generating XSD files...");
        XsdFileGenerator.generate(Observation.class, ObservationList.class);
        System.out.println("...XSD files generated.");


        System.out.println("Generating single observation to observation.xml...");
        Observation observation = RandomObservation.generate();
        XmlFileWriter.write(observation, "observation.xml");
        System.out.println("...single observation saved.");


        System.out.println("Generating 1000 observations to observations.xml...");
        ObservationList observationList = new ObservationList();
        for (int i = 0; i < 1000; i++) {
            observationList.addObservation(RandomObservation.generate());
        }
        XmlFileWriter.write(observationList, "observations.xml");
        System.out.println("...1000 observations saved.");

        System.out.println("Done.");
    }
}