package io.github.andyljones.transit.graph;

import java.util.Comparator;

public class StopDepartureTimeComparator implements Comparator<Stop>
{
    @Override
    public int compare(Stop x, Stop y) 
    {
        return x.getDepartureTime().compareTo(y.getDepartureTime());
    }
    
}
