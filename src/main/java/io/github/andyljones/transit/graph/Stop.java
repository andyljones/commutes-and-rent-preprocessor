package io.github.andyljones.transit.graph;

import java.util.GregorianCalendar;
import java.util.Optional;

public class Stop 
{
    public GregorianCalendar getArrivalTime() { return arrivalTime; }
    private GregorianCalendar arrivalTime;

    public GregorianCalendar getDepartureTime() { return departureTime; }
    private GregorianCalendar departureTime;

    public Station getStation() { return station; }
    private Station station;

    public Optional<Stop> getNextStop() { return nextStop; }
    private Optional<Stop> nextStop = Optional.empty();
    
    public Stop(Station station, GregorianCalendar arrivalTime, GregorianCalendar departureTime)
    {
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public boolean initializeNextStop(Stop nextStop) 
    { 
        if (this.nextStop.isPresent())
        {
            return false;
        }
        else
        {
            this.nextStop = Optional.ofNullable(nextStop);
            return true;
        }
    }
    
    
}
