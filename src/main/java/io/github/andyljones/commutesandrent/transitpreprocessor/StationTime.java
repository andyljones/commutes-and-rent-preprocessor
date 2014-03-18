package io.github.andyljones.commutesandrent.transitpreprocessor;

import java.util.GregorianCalendar;

public class StationTime {

    public GregorianCalendar getTime() { return time; }
    private final GregorianCalendar time;
    
    public Station getStation() { return station; }
    private final Station station;
    
    public StationTime(Station station, GregorianCalendar time)
    {
        this.station = station;
        this.time = time;
    }
    
}
