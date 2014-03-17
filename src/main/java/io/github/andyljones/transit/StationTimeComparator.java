package io.github.andyljones.transit;

import java.util.Comparator;

public class StationTimeComparator implements Comparator<StationTime>
{
    @Override
    public int compare(StationTime x, StationTime y) 
    {
        return x.getTime().compareTo(y.getTime());
    }
}
