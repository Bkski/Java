package org.example.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XsdFileGenerator {

    // Można podać dowolne klasy modelu
    public static boolean generate(Class<?>... jaxbClasses) {
        try {
            // Klasy modelu trafią do kontekstu
            JAXBContext context = JAXBContext.newInstance(jaxbClasses);

            SchemaOutputResolver resolver = new SchemaOutputResolver() {
                @Override
                public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                    // Jak mają być tworzone te nazwy i pliki
                    File file = new File(suggestedFileName);
                    StreamResult result = new StreamResult(file);
                    result.setSystemId(file.getAbsolutePath());
                    return result;
                }
            };

            // Wygenerowanie plików xsd dla całego modelu
            context.generateSchema(resolver);
            return true;

        } catch (JAXBException ex) {
            // Nie udało się z klas zrobić Struktury XSD
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            // Nie udało się zapisać plików
            ex.printStackTrace();
            return false;
        }
    }
}