package io.github.andyljones.commutesandrent.locationpreprocessor;

import java.io.InputStream;

import de.micromata.opengis.kml.v_2_2_0.Kml;

public class KmlUnmarshaller 
{
    public static Kml getRootElement(String kmlFilePath)
    {
        InputStream kmlStream = KmlUnmarshaller.class.getResourceAsStream(kmlFilePath);
        Kml root = Kml.unmarshal(kmlStream);
        
        return root;
    }
}
