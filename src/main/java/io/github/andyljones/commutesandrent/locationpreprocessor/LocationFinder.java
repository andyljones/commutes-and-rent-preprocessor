package io.github.andyljones.commutesandrent.locationpreprocessor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Feature;
import de.micromata.opengis.kml.v_2_2_0.Geometry;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;

/**
 * Converts a model of a KML file into a map from station names to locations.
 */
public class LocationFinder 
{
    /**
     * Returns the location that the KML file associates with a station name.
     * @param stationName
     * @return
     */
    public LongLat getLocation(String stationName) { return coordinatesMap.get(normalizeName(stationName)); }
    private final Map<String, LongLat> coordinatesMap;
    
    /**
     * Takes a KML model containing station locations and uses it to construct the {@link getLocation} function.
     * @param kmlModel The KML model to use.
     */
    public LocationFinder(Kml kmlModel)
    {
        // Get the list of geographic features in the KML model.
        Document kmlDocument = (Document) kmlModel.getFeature();
        Collection<Feature> features = kmlDocument.getFeature();
        
        coordinatesMap = buildCoordinatesMap(features);
    }

    // Build a map from the name of each valid feature to its coordinates.
    private static Map<String, LongLat> buildCoordinatesMap(Collection<Feature> features) 
    {
        Map<String, LongLat> result = new HashMap<>();
        for (Feature feature : features)
        {
            // Discard features that aren't the location of a station
            if (feature instanceof Placemark)
            {
                Placemark placemark = (Placemark) feature;
                String name = normalizeName(placemark.getName());
                LongLat coordinates = getCoordinates(placemark.getGeometry());
                
                result.put(name, coordinates);
            }
        }
        
        return result;        
    }
    
    // Extracts a latitude-longitude from a Geometry object and then stores it in a LongLat object.
    private static LongLat getCoordinates(Geometry geometry) 
    {
        Point point = (Point) geometry;
        Coordinate coordinates = point.getCoordinates().get(0);
        
        return new LongLat(coordinates.getLongitude(), coordinates.getLatitude());
    }

    // Converts a name to a more standard format.
    // This helps because the names of stations found in the KML file often don't quite match the names of stations in 
    // the TransXChange file. Some hand-editing is still needed, but this eliminates a lot of it.
    private static String normalizeName(String stationName) 
    {
        String[] nameComponents = stationName.split("( Station| \\()");
        String normalizedName = nameComponents[0].replaceAll("\'", "").trim();
        
        return normalizedName;
    }
}
