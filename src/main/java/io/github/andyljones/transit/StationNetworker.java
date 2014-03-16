package io.github.andyljones.transit;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Function;

import javax.xml.datatype.Duration;

import uk.org.transxchange.JourneyPatternTimingLinkStructure;
import io.github.andyljones.transit.graph.Station;
import io.github.andyljones.transit.graph.Stop;

public class StationNetworker 
{    
    private final Function<String, Station> atcoCodeToStation;
    
    public StationNetworker(Function<String, Station> atcoCodeToStation)
    {
        this.atcoCodeToStation = atcoCodeToStation;
    }
    
    public void addJourney(JourneyPartsHolder journeyParts) 
    {
        List<JourneyPatternTimingLinkStructure> links = journeyParts.linkStructures;
        
        GregorianCalendar currentTime = journeyParts.journeyStructure.getDepartureTime().toGregorianCalendar();
        
        JourneyPatternTimingLinkStructure firstLink = links.get(0);
        Stop firstStop = buildFirstStopAndUpdateTime(currentTime, firstLink);
        addRunTime(currentTime, firstLink);
        
        Stop previousStop = firstStop;
        for (int i = 1; i < links.size(); i++)
        {
            JourneyPatternTimingLinkStructure previousLink = links.get(i-1);
            JourneyPatternTimingLinkStructure nextLink = links.get(i);
            
            Stop newStop = buildStopAndUpdateTime(currentTime, previousLink, nextLink);
            addRunTime(currentTime, previousLink);
            
            previousStop.setNextStop(newStop);
            previousStop = newStop;
        }
        
        JourneyPatternTimingLinkStructure lastLink = links.get(links.size() - 1);
        Stop lastStop = buildLastStopAndUpdateTime(currentTime, lastLink);
        previousStop.setNextStop(lastStop);
    }

    private Stop buildFirstStopAndUpdateTime(GregorianCalendar time, JourneyPatternTimingLinkStructure link) 
    {
        Stop result = new Stop();
        
        Station station = atcoCodeToStation.apply(link.getFrom().getStopPointRef().getValue());
        result.setStation(station);
        station.getStops().add(result);

        result.setArrivalTime((GregorianCalendar) time.clone());
        addFromWaitTime(time, link);
        result.setDepartureTime((GregorianCalendar) time.clone());        
    
        return result;
    }
    
    private Stop buildStopAndUpdateTime(GregorianCalendar time, JourneyPatternTimingLinkStructure previousLink, JourneyPatternTimingLinkStructure nextLink) 
    {
        String refFromPreviousLink = previousLink.getTo().getStopPointRef().getValue();
        String refFromNextLink = nextLink.getFrom().getStopPointRef().getValue();
        assert refFromPreviousLink.equals(refFromNextLink) : String.format("Previous: %s\nNext: %s", refFromPreviousLink, refFromNextLink);
        
        Stop result = new Stop();
        
        Station station = atcoCodeToStation.apply(previousLink.getTo().getStopPointRef().getValue());
        result.setStation(station);
        station.getStops().add(result);

        result.setArrivalTime((GregorianCalendar) time.clone());
        addToWaitTime(time, previousLink);
        addFromWaitTime(time, nextLink);
        result.setDepartureTime((GregorianCalendar) time.clone());        
        
        return result;
    }
    
    private Stop buildLastStopAndUpdateTime(GregorianCalendar time, JourneyPatternTimingLinkStructure link) 
    {
        Stop result = new Stop();
        
        Station station = atcoCodeToStation.apply(link.getTo().getStopPointRef().getValue());
        result.setStation(station);
        station.getStops().add(result);

        result.setArrivalTime((GregorianCalendar) time.clone());
        addToWaitTime(time, link);
        result.setDepartureTime((GregorianCalendar) time.clone());        
    
        return result;
    }
    
    private static void addRunTime(GregorianCalendar currentTime, JourneyPatternTimingLinkStructure link) 
    {
        Duration runTime = link.getRunTime();
        if (runTime != null) { runTime.addTo(currentTime); }
    }
    
    private static void addFromWaitTime(GregorianCalendar currentTime, JourneyPatternTimingLinkStructure link) 
    {
        Duration waitTime = link.getFrom().getWaitTime();
        if (waitTime != null) { waitTime.addTo(currentTime); }
    }
    
    private static void addToWaitTime(GregorianCalendar currentTime, JourneyPatternTimingLinkStructure link) 
    {
        Duration waitTime = link.getTo().getWaitTime();
        if (waitTime != null) { waitTime.addTo(currentTime); }
    }


   
    
}
