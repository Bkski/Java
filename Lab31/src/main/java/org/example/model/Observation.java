package org.example.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement(name = "weather-observation", namespace = "http://example.org/weather-observation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Observation {

    // Typ wyliczeniowy też pójdzie automatycznie to XML
    public enum TemperatureUnit { Celsius, Fahrenheit, Kelvin }

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class) // Podłączenie sposobu zapisu LocalDateTime do XML
    private LocalDateTime timeStamp;

    @XmlElement(required = true)
    private TemperatureUnit unit;

    @XmlElement(required = true)
    private double value;

    @XmlElement(required = false)
    private String comment;

    // Konstruktor domyślny (wymagany przez JAXB)
    public Observation() {}

    // Konstruktor parametryzowany
    public Observation(LocalDateTime timeStamp, TemperatureUnit unit, double value, String comment) {
        this.timeStamp = timeStamp;
        this.unit = unit;
        this.value = value;
        this.comment = comment;
    }

    // Gettery i Settery
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public LocalDateTime getTimeStamp() { return timeStamp; }
    public void setTimeStamp(LocalDateTime timeStamp) { this.timeStamp = timeStamp; }

    public TemperatureUnit getUnit() { return unit; }
    public void setUnit(TemperatureUnit unit) { this.unit = unit; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    @Override
    public String toString() {
        return "Observation{" +
                "timeStamp='" + timeStamp + '\'' +
                ", unit=" + unit + '\'' +
                ", value=" + value +
                ", comment='" + comment + '\'' +
                '}';
    }
}