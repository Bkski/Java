package org.example.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class XmlValidator {
    public static boolean validate(String xmlFileName, String... xsdFileNames) {
        File xmlFile = new File(xmlFileName);
        Source[] schemaFiles = Arrays.stream(xsdFileNames)
                .map(name -> new StreamSource(new File(name).getAbsolutePath()))
                .toArray(Source[]::new);

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = factory.newSchema(schemaFiles);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile.getAbsolutePath()));
            return true;
        } catch (SAXException ex) {
            System.err.println("Validation error for " + xmlFileName + ": " + ex.getMessage());
            return false;
        } catch (IOException ex) {
            System.err.println("Could not read files for validation: " + ex.getMessage());
            return false;
        }
    }
}

