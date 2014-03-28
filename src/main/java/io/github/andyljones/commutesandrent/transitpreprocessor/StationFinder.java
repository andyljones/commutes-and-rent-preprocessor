package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.StopPointStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds Station objects from a set of StopPointStructures.
 */
public class StationFinder {

    public Collection<Station> getStations() { return new HashSet<>(stationMap.values()); }
    public Station getStation(final String atcoCode) { return stationMap.get(atcoCode); }
    private final Map<String, Station> stationMap;
    
    /**
     * Constructs a collection of Station objects from the provided StopPointStructures.
     * @param stopPoints
     */
    public StationFinder(final Collection<StopPointStructure> stopPoints)
    {
        stationMap = buildStationMap(stopPoints);
    }

    // Constructs a map from ATCO codes to station objects by combining an ATCO code -> station name map and a station 
    // name -> station object map.
    private static Map<String, Station> buildStationMap(Collection<StopPointStructure> stopPoints) 
    {
        final Map<String, String> atcoCodeMap = buildAtcoCodeMap(stopPoints);
        final Map<String, Station> stationNameMap = buildStationNameMap(atcoCodeMap.values());
        
        final Map<String, Station> result = new HashMap<>();
        for (Map.Entry<String, String> entry : atcoCodeMap.entrySet())
        {
            final String atcoCode = entry.getKey().trim();
            final String stationName = entry.getValue().trim();
            final Station station = stationNameMap.get(stationName);
            
            result.put(atcoCode, station);
        }
        
        return result;
    }

    // Constructs a map from station names to station objects.
    private static Map<String, Station> buildStationNameMap(Collection<String> stationNames) 
    {        
        final Map<String, Station> result = stationNames.stream().distinct().collect(Collectors.toMap(name -> name, name -> new Station(name)));
        
        return result;
    }

    // Constructs a map from ATCO codes to station names.
    private static Map<String, String> buildAtcoCodeMap(Collection<StopPointStructure> stopPoints)
    {
        final Map<String, String> result = new HashMap<>();
        for (StopPointStructure stopPoint : stopPoints)
        {
            final String atcoCode = stopPoint.getAtcoCode();
            final String stationName = stopPoint.getDescriptor().getCommonName().getValue();
            
            result.put(atcoCode, stationName);
        }
        
        return result;
    }
}
