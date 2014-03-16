package io.github.andyljones.transit.graph;

import java.util.GregorianCalendar;

public class Stop 
{
    private GregorianCalendar arrivalTime;
    private GregorianCalendar departureTime;

    private Station station;
    
    private Stop nextStop;
    
    public GregorianCalendar getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(GregorianCalendar arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public GregorianCalendar getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(GregorianCalendar departureTime) {
        this.departureTime = departureTime;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Stop getNextStop() {
        return nextStop;
    }

    public void setNextStop(Stop nextStop) {
        this.nextStop = nextStop;
    }
}
