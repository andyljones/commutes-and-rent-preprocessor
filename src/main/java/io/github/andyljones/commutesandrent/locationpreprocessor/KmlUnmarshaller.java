package io.github.andyljones.commutesandrent.locationpreprocessor;

import java.io.InputStream;

import de.micromata.opengis.kml.v_2_2_0.Kml;

/**
 * Static methods for unmarshalling KML data.
 */
public class KmlUnmarshaller 
{
    /**
     * Unmarshalls a KML file and returns the root element of the generated model.
     * @param kmlFilePath The relative path to the KML file.
     * @return The root element of the generated model.
     */
    public static Kml getRootElement(String kmlFilePath)
    {
        InputStream kmlStream = KmlUnmarshaller.class.getResourceAsStream(kmlFilePath);
        Kml root = Kml.unmarshal(kmlStream);
        
        return root;
    }
}
