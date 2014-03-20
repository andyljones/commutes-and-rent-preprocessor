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

public class LocationFinder 
{
    public LongLat getLocation(String stationName) { return coordinatesMap.get(normalizeName(stationName)); }
    private final Map<String, LongLat> coordinatesMap;
    
    public LocationFinder(Kml kmlModel)
    {
        Document kmlDocument = (Document) kmlModel.getFeature();
        Collection<Feature> features = kmlDocument.getFeature();
        
        coordinatesMap = buildCoordinatesMap(features);
    }

    private static Map<String, LongLat> buildCoordinatesMap(Collection<Feature> features) 
    {
        Map<String, LongLat> result = new HashMap<>();
        for (Feature feature : features)
        {
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
    
    private static LongLat getCoordinates(Geometry geometry) 
    {
        Point point = (Point) geometry;
        
        Coordinate coordinates = point.getCoordinates().get(0);
        
        return new LongLat(coordinates.getLongitude(), coordinates.getLatitude());
    }

    private static String normalizeName(String stationName) 
    {
                
        String[] nameComponents = stationName.split("( Station| \\()");
        String normalizedName = nameComponents[0].replaceAll("\'", "").trim();
        
        return normalizedName;
    }
}
