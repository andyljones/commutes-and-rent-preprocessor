package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.ObjectFactory;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TransXChangeUnmarshaller {

    /**
     * Attempts to unmarshall the specified XML file and return the root element.
     * @param transXChangeFilePath
     * @return
     */
    public static TransXChange getRootElement(final String transXChangeFilePath)
    {
        TransXChange result = null;
        try
        {
            final ClassLoader classLoader = ObjectFactory.class.getClassLoader(); 
            final JAXBContext context = JAXBContext.newInstance("io.github.andyljones.commutesandrent.model.uk.org.transxchange", classLoader);
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            
            final InputStream stream = TransXChangeUnmarshaller.class.getResourceAsStream(transXChangeFilePath);
            result = (TransXChange) unmarshaller.unmarshal(stream);
        }
        catch (JAXBException jaxbe)
        {
            System.err.println("Failed to unmarshall TransXChange file" + transXChangeFilePath);
            jaxbe.printStackTrace();
        }
        
        return result;
    }
    
}
