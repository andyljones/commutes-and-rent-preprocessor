package io.github.andyljones.transit;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Function;

import uk.org.transxchange.JourneyPatternTimingLinkStructure;
import io.github.andyljones.transit.graph.Station;
import io.github.andyljones.transit.graph.Stop;

public class StationNetworker 
{    
    private final Function<String, Station> atcoCodeToStationMap;
    
    //TODO: Test all this as well.
    public StationNetworker(Function<String, Station> atcoCodeToStation)
    {
        this.atcoCodeToStationMap = atcoCodeToStation;
    }
    
    public void addJournies(Collection<JourneyPartsHolder> journeyParts)
    {
        journeyParts.stream().forEach(holder -> addJourney(holder));
    }
    
    private void addJourney(JourneyPartsHolder journeyParts) 
    {
        List<JourneyPatternTimingLinkStructure> links = journeyParts.linkStructures;
        
        GregorianCalendar currentTime = journeyParts.journeyStructure.getDepartureTime().toGregorianCalendar();
        
        JourneyPatternTimingLinkStructure firstLink = links.get(0);
        Stop firstStop = buildFirstStopAndUpdateTime(currentTime, firstLink);
        StationNetworkerUtilities.addRunTime(currentTime, firstLink);
        
        Stop previousStop = firstStop;
        for (int i = 1; i < links.size(); i++)
        {
            JourneyPatternTimingLinkStructure previousLink = links.get(i-1);
            JourneyPatternTimingLinkStructure nextLink = links.get(i);
            
            Stop newStop = buildStopAndUpdateTime(currentTime, previousStop, previousLink, nextLink);
            StationNetworkerUtilities.addRunTime(currentTime, previousLink);
            
            previousStop = newStop;
        }
        
        JourneyPatternTimingLinkStructure lastLink = links.get(links.size() - 1);
        Stop lastStop = buildLastStopAndUpdateTime(currentTime, previousStop, lastLink);
    }

    private Stop buildFirstStopAndUpdateTime(GregorianCalendar time, JourneyPatternTimingLinkStructure link) 
    {
        Station station = atcoCodeToStationMap.apply(link.getFrom().getStopPointRef().getValue());
     
        GregorianCalendar arrivalTime = StationNetworkerUtilities.copy(time);
        StationNetworkerUtilities.addFromWaitTime(time, link);
        GregorianCalendar departureTime = StationNetworkerUtilities.copy(time);       

        Stop result = new Stop(station, null, arrivalTime, departureTime);
        station.getStops().add(result);
        return result;
    }
    
    private Stop buildStopAndUpdateTime(GregorianCalendar time, Stop previousStop, JourneyPatternTimingLinkStructure previousLink, JourneyPatternTimingLinkStructure nextLink) 
    {
        StationNetworkerUtilities.assertLinksAreConsecutive(previousLink, nextLink);
        
        Station station = atcoCodeToStationMap.apply(previousLink.getTo().getStopPointRef().getValue());
        
        GregorianCalendar arrivalTime = StationNetworkerUtilities.copy(time);
        StationNetworkerUtilities.addToWaitTime(time, previousLink);
        StationNetworkerUtilities.addFromWaitTime(time, nextLink);
        GregorianCalendar departureTime = StationNetworkerUtilities.copy(time);  
        
        Stop result = new Stop(station, previousStop, arrivalTime, departureTime);
        station.getStops().add(result);
        return result;
    }
    
    
    private Stop buildLastStopAndUpdateTime(GregorianCalendar time, Stop previousStop, JourneyPatternTimingLinkStructure link) 
    {
        Station station = atcoCodeToStationMap.apply(link.getTo().getStopPointRef().getValue());
        
        GregorianCalendar arrivalTime = StationNetworkerUtilities.copy(time);
        StationNetworkerUtilities.addToWaitTime(time, link);
        GregorianCalendar departureTime = StationNetworkerUtilities.copy(time);       
        
        Stop result = new Stop(station, previousStop, arrivalTime, departureTime);
        station.getStops().add(result);
        return result;
    }
}
