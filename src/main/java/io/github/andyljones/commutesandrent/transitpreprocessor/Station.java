package io.github.andyljones.commutesandrent.transitpreprocessor;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Represents a station in a transport network. 
 */
public class Station 
{
    public String getName() { return name; }
    private final String name;
    
    public Queue<Stop> getStops() { return stops; }
    private final Queue<Stop> stops;
    
    public Station(String name)
    {
        this.name = name;
        this.stops = new PriorityQueue<Stop>(new ReverseArrivalTimeComparator());
    }
}
