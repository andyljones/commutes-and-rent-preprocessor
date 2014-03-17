package io.github.andyljones.transit;

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

import io.github.andyljones.transit.graph.Station;
import io.github.andyljones.transit.graph.Stop;

public class LatestDepartureCalculator 
{
    private final Map<Station, StationTime> latestStationTimes = new HashMap<>();
    
    private final Queue<StationTime> processingQueue = new PriorityQueue<>(new StationTimeReverseComparator());
    private final Set<Station> processed = new HashSet<>();
    
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
    
    private void initialize(Station destinationStation, GregorianCalendar destinationTime)
    {
        StationTime destinationStationTime = new StationTime(destinationStation, destinationTime);
        processingQueue.add(destinationStationTime);
        latestStationTimes.put(destinationStation, destinationStationTime);
    }

    private void process(StationTime stationTime) 
    {
        Queue<Stop> stops = stationTime.getStation().getStops();
        Collection<Stop> upcomingStops = getStopsArrivingBeforeTime(stops, stationTime.getTime());
        
        for (Stop stop : upcomingStops)
        {
            tryUpdateLatestStationTime(stop.getPreviousStop());
        }
    }

    private void tryUpdateLatestStationTime(Optional<Stop> optionalStop) 
    {
        if (optionalStop.isPresent() && !processed.contains(optionalStop.get().getStation()))
        {
            Stop stop = optionalStop.get();
            Station station = stop.getStation();
            GregorianCalendar time = stop.getDepartureTime();
            
            StationTime latestStationTime = latestStationTimes.get(station);
            StationTime candidateStationTime = new StationTime(station, time);
            
            if (latestStationTime == null)
            {
                processingQueue.add(candidateStationTime);
                
                latestStationTimes.put(station, candidateStationTime);
            }
            else if (candidateStationTime.getTime().compareTo(latestStationTime.getTime()) == 1)
            {
                processingQueue.remove(latestStationTime);
                processingQueue.add(candidateStationTime);
                
                latestStationTimes.put(station, candidateStationTime);
            }
        }
    }

    private static Collection<Stop> getStopsArrivingBeforeTime(Queue<Stop> stops, GregorianCalendar time) 
    {
        Collection<Stop> stopsBeforeTargetTime = stops.stream()
                .filter(stop -> stop.getArrivalTime().compareTo(time) <= 0)
                .collect(Collectors.toList());
        
        return stopsBeforeTargetTime;
    }
    
    public Map<Station, GregorianCalendar> getDepartureTimes() 
    { 
        return latestStationTimes.values().stream().collect(Collectors.toMap(st -> st.getStation(), st -> st.getTime()));
    }

    
}
