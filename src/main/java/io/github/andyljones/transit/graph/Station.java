package io.github.andyljones.transit.graph;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Station 
{
    public String getName() { return name; }
    private final String name;
    
    public NavigableSet<Stop> getStops() { return stops; }
    private final NavigableSet<Stop> stops;
    
    public Station(String name)
    {
        this.name = name;
        this.stops = new TreeSet<Stop>(new StopDepartureTimeComparator());
    }
}
