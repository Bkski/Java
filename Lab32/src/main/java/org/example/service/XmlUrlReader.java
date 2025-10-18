package org.example.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class XmlUrlReader {
    // Teraz nie plik, ale adres
    public static <T> T readFromUrl(String urlString, Class<T> clazz) {
        try {
            URL url = URI.create(urlString).toURL();
            // Zasób jako strumień
            InputStream inputStream = url.openStream();

            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T result = clazz.cast(unmarshaller.unmarshal(inputStream));

            // Strumień trzeba zamknąć
            inputStream.close();
            return result;
        } catch (MalformedURLException ex) {
            System.err.println("Problem z adresem URL: " + ex.getMessage());
            return null;
        } catch (IOException ex) {
            System.err.println("Problem ze strumieniem (I/O): " + ex.getMessage());
            return null;
        } catch (JAXBException ex) {
            System.err.println("Problem z danymi w zdalnym XML: " + ex.getMessage());
            return null;
        }
    }
}
