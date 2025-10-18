package org.example.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "weather-observations", namespace = "http://example.org/weather-observation")
@XmlAccessorType(XmlAccessType.FIELD)
public class ObservationList {

    @XmlElement(name = "observation")
    private List<Observation> observations = new ArrayList<>();

    // Konstruktor domyślny
    public ObservationList() {}

    // Konstruktor parametryzowany
    public ObservationList(List<Observation> observations) {
        this.observations = observations;
    }

    // Gettery i Settery
    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    // Metoda pomocnicza
    public void addObservation(Observation observation) {
        this.observations.add(observation);
    }

    @Override
    public String toString() {
        return "ObservationList{" +
                "observations=" + observations +
                '}';
    }
}