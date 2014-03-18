package io.github.andyljones.commutesandrent.transitpreprocessor;

import java.util.Comparator;

public class ReverseArrivalTimeComparator implements Comparator<Stop>
{
    @Override
    public int compare(Stop x, Stop y) 
    {
        return y.getArrivalTime().compareTo(x.getArrivalTime());
    }
    
}
