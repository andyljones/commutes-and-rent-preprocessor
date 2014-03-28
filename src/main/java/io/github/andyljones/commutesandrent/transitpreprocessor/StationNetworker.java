package io.github.andyljones.commutesandrent.transitpreprocessor;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Function;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternTimingLinkStructure;

/**
 * Links together a set of Station objects using JourneyPartsHolder information.
 */
public class StationNetworker 
{    
    private final Function<String, Station> atcoCodeToStationMap;
    
    //TODO: Test all this as well.
    /**
     * Constructs an instance of the class for use in linking up the provided Station objects.
     * @param atcoCodeToStation A map of ATCO codes to Station objects.
     */
    public StationNetworker(Function<String, Station> atcoCodeToStation)
    {
        this.atcoCodeToStationMap = atcoCodeToStation;
    }
    
    /**
     * Uses the specified JourneyPartsHolders to link Station objects together.
     * @param journeyParts
     */
    public void addJournies(Collection<JourneyPartsHolder> journeyParts)
    {
        journeyParts.stream().forEach(holder -> addJourney(holder));
    }
    
    // Uses the links in a JourneyPartsHolder to build Stop objects that link to eachother and to Station objects.
    // Traverses the collection of links in the JourneyPartsHolder and caluclates the time at which each stop occurs.
    private void addJourney(JourneyPartsHolder journeyParts) 
    {
        List<JourneyPatternTimingLinkStructure> links = journeyParts.linkStructures;
        
        GregorianCalendar currentTime = journeyParts.journeyStructure.getDepartureTime().toGregorianCalendar();

        // Process the first link
        JourneyPatternTimingLinkStructure firstLink = links.get(0);
        Stop firstStop = buildFirstStopAndUpdateTime(currentTime, firstLink);
        StationNetworkerUtilities.addRunTime(currentTime, firstLink);
        
        // Process the intermediate links
        Stop previousStop = firstStop;
        for (int i = 1; i < links.size(); i++)
        {
            JourneyPatternTimingLinkStructure previousLink = links.get(i-1);
            JourneyPatternTimingLinkStructure nextLink = links.get(i);
            
            Stop newStop = buildStopAndUpdateTime(currentTime, previousStop, previousLink, nextLink);
            StationNetworkerUtilities.addRunTime(currentTime, previousLink);
            
            previousStop = newStop;
        }
        
        // Process the final link.
        JourneyPatternTimingLinkStructure lastLink = links.get(links.size() - 1);
        Stop lastStop = buildLastStopAndUpdateTime(currentTime, previousStop, lastLink);
    }
    
    // Constructs a Stop object corresponding to the origin of a JourneyPatternTimingLink.
    // Also updates the time object to be the time of departure from the stop.
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
    
    // Constructs a Stop object corresponding to the destination of one JourneyPatternTimingLink and the origin of the next.
    // Also updates the time object to be the time of departure from the stop.
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
    
    // Constructs a Stop object corresponding to the destination of a link
    // Also updates the time object to be the time of departure from the stop.
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
