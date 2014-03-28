package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternTimingLinkStructure;

import java.util.GregorianCalendar;

import javax.xml.datatype.Duration;

/**
 * Static class of utility methods for the StationNetworker class.
 */
public class StationNetworkerUtilities 
{
    //TODO: Return a boolean instead and assert in the caller?
    /**
     * Asserts that the destination of one link is the origin of the next.
     * @param firstLink
     * @param secondLink
     */
    public static void assertLinksAreConsecutive(JourneyPatternTimingLinkStructure firstLink, JourneyPatternTimingLinkStructure secondLink)
    {
        String refFromPreviousLink = firstLink.getTo().getStopPointRef().getValue();
        String refFromNextLink = secondLink.getFrom().getStopPointRef().getValue();

        assert refFromPreviousLink.equals(refFromNextLink) : String.format("Previous: %s\nNext: %s", refFromPreviousLink, refFromNextLink);
    }
    
    /**
     * Adds the time taken to transit a link (the link's run time) to the currentTime.
     * @param currentTime
     * @param link
     */
    public static void addRunTime(GregorianCalendar currentTime, JourneyPatternTimingLinkStructure link) 
    {
        Duration runTime = link.getRunTime();
        if (runTime != null) { runTime.addTo(currentTime); }
    }
    
    /**
     * Adds the time spent waiting at the origin of a link to the currentTime.
     * @param currentTime
     * @param link
     */
    public static void addFromWaitTime(GregorianCalendar currentTime, JourneyPatternTimingLinkStructure link) 
    {
        Duration waitTime = link.getFrom().getWaitTime();
        if (waitTime != null) { waitTime.addTo(currentTime); }
    }
    
    /**
     * Adds the time spent waiting at the destination of a link to the currentTime.
     * @param currentTime
     * @param link
     */
    public static void addToWaitTime(GregorianCalendar currentTime, JourneyPatternTimingLinkStructure link) 
    {
        Duration waitTime = link.getTo().getWaitTime();
        if (waitTime != null) { waitTime.addTo(currentTime); }
    }

    /**
     * Creates a copy of a link.
     * @param calendar
     * @return
     */
    public static GregorianCalendar copy(GregorianCalendar calendar)
    {
        return (GregorianCalendar) calendar.clone();
    }

}
