package io.github.andyljones.transit;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.andyljones.transit.graph.Station;
import io.github.andyljones.transit.graph.Stop;

public class EarliestArrivalCalculator 
{
    private final Map<Station, StationTime> earliestStationTimes = new HashMap<>();
    
    private final Queue<StationTime> processingQueue = new PriorityQueue<>(new StationTimeComparator());
    private final Set<Station> processed = new HashSet<>();
    
    public EarliestArrivalCalculator(Station originStation, GregorianCalendar originTime)
    {
        initialize(originStation, originTime);
        
        while (!processingQueue.isEmpty())
        {
            StationTime stationTime = processingQueue.poll();
            process(stationTime);
            processed.add(stationTime.getStation());
        }
    }
    
    private void initialize(Station originStation, GregorianCalendar originTime)
    {
        StationTime originStationTime = new StationTime(originStation, originTime);
        processingQueue.add(originStationTime);
        earliestStationTimes.put(originStation, originStationTime);
    }

    private void process(StationTime stationTime) 
    {
        Queue<Stop> stops = stationTime.getStation().getStops();
        Collection<Stop> upcomingStops = getStopsDepartingAfterTime(stops, stationTime.getTime());
        
        for (Stop stop : upcomingStops)
        {
            tryUpdateEarliestArrivalTime(stop.getNextStop());
        }
    }

    private void tryUpdateEarliestArrivalTime(Optional<Stop> optionalStop) 
    {
        if (optionalStop.isPresent() && !processed.contains(optionalStop.get().getStation()))
        {
            Stop stop = optionalStop.get();
            Station station = stop.getStation();
            GregorianCalendar time = stop.getArrivalTime();
            
            StationTime earliestStationTime = earliestStationTimes.get(station);
            StationTime candidateStationTime = new StationTime(station, time);
            
            if (earliestStationTime == null)
            {
                processingQueue.add(candidateStationTime);
                
                earliestStationTimes.put(station, candidateStationTime);
            }
            else if (candidateStationTime.getTime().compareTo(earliestStationTime.getTime()) == -1)
            {
                processingQueue.remove(earliestStationTime);
                processingQueue.add(candidateStationTime);
                
                earliestStationTimes.put(station, candidateStationTime);
            }
        }
    }

    private static Collection<Stop> getStopsDepartingAfterTime(Queue<Stop> stops, GregorianCalendar time) 
    {
        Collection<Stop> stopsAfterTargetTime = stops.stream()
                .filter(stop -> stop.getArrivalTime().compareTo(time) >= 0)
                .collect(Collectors.toList());
        
        return stopsAfterTargetTime;
    }
    
    public Map<Station, GregorianCalendar> getArrivalTimes() 
    { 
        return earliestStationTimes.values().stream().collect(Collectors.toMap(st -> st.getStation(), st -> st.getTime()));
    }

    
}
