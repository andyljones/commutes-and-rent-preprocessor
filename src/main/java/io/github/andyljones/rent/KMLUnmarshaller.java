package io.github.andyljones.rent;

import java.io.InputStream;

import de.micromata.opengis.kml.v_2_2_0.Kml;

public class KMLUnmarshaller {

    /**
     * Unmarshalls a KML file and returns its root element.
     * @param kmlFilePath The path to the file to unmarshall.
     * @return The root element.
     */
    public static Kml getRoot(final String kmlFilePath)
    {
        final InputStream locationKmlStream = KMLUnmarshaller.class.getClassLoader().getResourceAsStream(kmlFilePath);
        
        final Kml locationKml = Kml.unmarshal(locationKmlStream);
        
        return locationKml;
    }
}
