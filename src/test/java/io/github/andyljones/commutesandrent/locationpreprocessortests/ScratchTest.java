package io.github.andyljones.commutesandrent.locationpreprocessortests;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import io.github.andyljones.commutesandrent.locationpreprocessor.KmlUnmarshaller;
import io.github.andyljones.commutesandrent.locationpreprocessor.LocationFinder;
import io.github.andyljones.commutesandrent.locationpreprocessor.LocationSerializer;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;
import io.github.andyljones.commutesandrent.transitpreprocessor.DeserializationUtilities;
import io.github.andyljones.commutesandrent.transitpreprocessor.Station;
import io.github.andyljones.commutesandrent.transitpreprocessor.StationFinder;

import org.junit.Test;

import de.micromata.opengis.kml.v_2_2_0.Kml;

public class ScratchTest 
{
    //@Test
    public void scratch()
    {
        Collection<TransXChange> roots = DeserializationUtilities.getTimetableRoots();
        
        Collection<Station> stations = new StationFinder(DeserializationUtilities.getStopPoints(roots)).getStations();
        List<String> stationNames = stations.stream().map(station -> station.getName()).collect(Collectors.toList());
        
        Kml kml = KmlUnmarshaller.getRootElement("/station-locations/station-locations.kml");
        LocationFinder lf = new LocationFinder(kml);
        
        System.out.println(stationNames.size());
        for (String name : stationNames)
        {
            System.out.format("%30s \t %s\n", name, lf.getLocation(name));
        }
        
        
        LocationSerializer.serialize(stationNames, lf::getLocation, "output/processed-locations/locations.json");
    }
}
