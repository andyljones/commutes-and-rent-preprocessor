package io.github.andyljones.commutesandrent.transitpreprocessor;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Constructs a departure time lookup by executing Dijkstra's algorithm, starting from a specified destination station.
 */
public class LatestDepartureCalculator 
{    
    private final Map<Station, StationTime> latestStationTimes = new HashMap<>();
    
    // Queue of stations (keyed by departure time) that are yet to be processed
    private final Queue<StationTime> processingQueue = new PriorityQueue<>(new StationTimeReverseComparator());
    
    // Set of stations that have been processed.
    private final Set<Station> processed = new HashSet<>();
    
    /**
     * Constructs a departure time lookup for the specified destination and time.
     * @param destinationStation
     * @param destinationTime
     */
    public LatestDepartureCalculator(Station destinationStation, GregorianCalendar destinationTime)
    {
        initialize(destinationStation, destinationTime);
        
        while (!processingQueue.isEmpty())
        {
            StationTime stationTime = processingQueue.poll();
            process(stationTime);
            processed.add(stationTime.getStation());
        }
    }
    
    // Set up the processing queue & adds a result to the output table for the destination station.
    private void initialize(Station destinationStation, GregorianCalendar destinationTime)
    {
        StationTime destinationStationTime = new StationTime(destinationStation, destinationTime);
        processingQueue.add(destinationStationTime);
        latestStationTimes.put(destinationStation, destinationStationTime);
    }

    // Executes a step of Dijkstra's algorithm, processing the given station.
    private void process(StationTime stationTime) 
    {
        // Get the stops (out edges) that occurred before the time associated with the station.
        Queue<Stop> stops = stationTime.getStation().getStops();
        Collection<Stop> upcomingStops = getStopsArrivingBeforeTime(stops, stationTime.getTime());
        
        // For each earlier stop, try to improve the latest departure time for station of the previous stop in the chain.
        for (Stop stop : upcomingStops)
        {
            tryUpdateLatestStationTime(stop.getPreviousStop());
        }
    }

    // Try and improve the departure time associated with a station.
    private void tryUpdateLatestStationTime(Optional<Stop> optionalStop) 
    {
        // If there's no stop in the option type (because the stop that generated it was the first in the chain),
        // or if the station of the stop has already been processed, then skip it.
        if (optionalStop.isPresent() && !processed.contains(optionalStop.get().getStation()))
        {
            Stop stop = optionalStop.get();
            Station station = stop.getStation();
            GregorianCalendar time = stop.getDepartureTime();
            
            StationTime latestStationTime = latestStationTimes.get(station);
            StationTime candidateStationTime = new StationTime(station, time);
            
            // If the station hasn't got a departure time in the results table yet, add this one.
            if (latestStationTime == null)
            {
                processingQueue.add(candidateStationTime);
                
                latestStationTimes.put(station, candidateStationTime);
            }
            // If the station has got a departure time, but it's earlier than this one, update it.
            else if (candidateStationTime.getTime().compareTo(latestStationTime.getTime()) == 1)
            {
                processingQueue.remove(latestStationTime);
                processingQueue.add(candidateStationTime);
                
                latestStationTimes.put(station, candidateStationTime);
            }
        }
    }

    // Selects out all stops in a queue happening before a specified time.
    private static Collection<Stop> getStopsArrivingBeforeTime(Queue<Stop> stops, GregorianCalendar time) 
    {
        Collection<Stop> stopsBeforeTargetTime = stops.stream()
                .filter(stop -> stop.getArrivalTime().compareTo(time) <= 0)
                .collect(Collectors.toList());
        
        return stopsBeforeTargetTime;
    }
    
    // Converts the result hashmap from a Station -> StationTime map to a Station -> Time map.
    public Map<Station, GregorianCalendar> getDepartureTimes() 
    { 
        return latestStationTimes.values().stream().collect(Collectors.toMap(st -> st.getStation(), st -> st.getTime()));
    }
}
