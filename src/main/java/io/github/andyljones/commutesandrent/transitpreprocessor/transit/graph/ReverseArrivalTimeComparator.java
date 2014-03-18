package io.github.andyljones.commutesandrent.transitpreprocessor.transit.graph;

import java.util.Comparator;

public class ReverseArrivalTimeComparator implements Comparator<Stop>
{
    @Override
    public int compare(Stop x, Stop y) 
    {
        return y.getArrivalTime().compareTo(x.getArrivalTime());
    }
    
}
