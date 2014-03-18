package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.StopPointStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class StationFinder {

    public Collection<Station> getStations() { return new HashSet<>(stationMap.values()); }
    public Station getStation(final String atcoCode) { return stationMap.get(atcoCode); }
    private final Map<String, Station> stationMap;
    
    public StationFinder(final Collection<StopPointStructure> stopPoints)
    {
        stationMap = buildStationMap(stopPoints);
    }

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

    private static Map<String, Station> buildStationNameMap(Collection<String> stationNames) 
    {        
        final Map<String, Station> result = stationNames.stream().distinct().collect(Collectors.toMap(name -> name, name -> new Station(name)));
        
        return result;
    }

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
