package io.github.andyljones.commutesandrent.locationpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;
import io.github.andyljones.commutesandrent.transitpreprocessor.DeserializationUtilities;
import io.github.andyljones.commutesandrent.transitpreprocessor.Station;
import io.github.andyljones.commutesandrent.transitpreprocessor.StationFinder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import de.micromata.opengis.kml.v_2_2_0.Kml;

/**
 * Static class for converting a KML file containing the locations of stations into a JSON file containing only that information.
 */
public class LocationGenerator 
{
    /**
     * Extracts station location information from a KML file and writes it to a JSON file.
     * @param sourceFilename The KML file to be used as a source of station locations
     * @param destinationFilename The JSON to use to store the results.
     */
    public static void generate(String sourceFilename, String destinationFilename)
    {
        //TODO: Remove this dependency on timetables. Just take every station from the location file.
        Collection<TransXChange> roots = DeserializationUtilities.getTimetableRoots();
        
        Collection<Station> stations = new StationFinder(DeserializationUtilities.getStopPoints(roots)).getStations();
        List<String> stationNames = stations.stream().map(station -> station.getName()).collect(Collectors.toList());
        
        Kml kml = KmlUnmarshaller.getRootElement("/station-locations/" + sourceFilename);
        LocationFinder lf = new LocationFinder(kml);
        
        LocationSerializer.serialize(stationNames, lf::getLocation, "output/processed-locations/" + destinationFilename);
    }
}
