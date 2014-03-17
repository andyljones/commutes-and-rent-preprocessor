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

    public Optional<Stop> getPreviousStop() { return previousStop; }
    private Optional<Stop> previousStop;
    
    public Stop(Station station, Stop previousStop, GregorianCalendar arrivalTime, GregorianCalendar departureTime)
    {
        this.station = station;
        this.previousStop = Optional.ofNullable(previousStop);
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }   
    
}
