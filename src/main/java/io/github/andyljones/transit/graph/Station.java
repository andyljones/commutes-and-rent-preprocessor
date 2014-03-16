package io.github.andyljones.transit.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Station 
{
    public String getName() { return name; }
    private final String name;
    
    public Collection<Stop> getStops() { return stops; }
    private final Collection<Stop> stops;
    
    public Station(String name)
    {
        this.name = name;
        this.stops = new ArrayList<Stop>();
    }
}
