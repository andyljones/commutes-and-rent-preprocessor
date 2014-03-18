package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternTimingLinkStructure;

import java.util.GregorianCalendar;

import javax.xml.datatype.Duration;

public class StationNetworkerUtilities 
{
    public static void assertLinksAreConsecutive(JourneyPatternTimingLinkStructure firstLink, JourneyPatternTimingLinkStructure secondLink)
    {
        String refFromPreviousLink = firstLink.getTo().getStopPointRef().getValue();
        String refFromNextLink = secondLink.getFrom().getStopPointRef().getValue();

        assert refFromPreviousLink.equals(refFromNextLink) : String.format("Previous: %s\nNext: %s", refFromPreviousLink, refFromNextLink);
    }
    
    public static void addRunTime(GregorianCalendar currentTime, JourneyPatternTimingLinkStructure link) 
    {
        Duration runTime = link.getRunTime();
        if (runTime != null) { runTime.addTo(currentTime); }
    }
    
    public static void addFromWaitTime(GregorianCalendar currentTime, JourneyPatternTimingLinkStructure link) 
    {
        Duration waitTime = link.getFrom().getWaitTime();
        if (waitTime != null) { waitTime.addTo(currentTime); }
    }
    
    public static void addToWaitTime(GregorianCalendar currentTime, JourneyPatternTimingLinkStructure link) 
    {
        Duration waitTime = link.getTo().getWaitTime();
        if (waitTime != null) { waitTime.addTo(currentTime); }
    }

    public static GregorianCalendar copy(GregorianCalendar calendar)
    {
        return (GregorianCalendar) calendar.clone();
    }

}
