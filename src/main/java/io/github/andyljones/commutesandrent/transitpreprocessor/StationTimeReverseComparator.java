package io.github.andyljones.commutesandrent.transitpreprocessor;

import java.util.Comparator;

/**
 * Compares StationTime objects in reverse time order.
 */
public class StationTimeReverseComparator implements Comparator<StationTime>
{
    @Override
    public int compare(StationTime x, StationTime y) 
    {
        return y.getTime().compareTo(x.getTime());
    }
}
