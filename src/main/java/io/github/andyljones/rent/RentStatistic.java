package io.github.andyljones.rent;

import java.util.Optional;

public class RentStatistic 
{
    public Optional<Integer> getLowerQuartile() {return lowerQuartile; }
    private final Optional<Integer> lowerQuartile;
    
    public Optional<Integer> getMedian() {return median; }
    private final Optional<Integer> median;
    
    public Optional<Integer> getUpperQuartile() {return upperQuartile; }
    private final Optional<Integer> upperQuartile;
    
    public RentStatistic(Optional<Integer> lowerQuartile, Optional<Integer> median, Optional<Integer> upperQuartile)
    {
        this.lowerQuartile = lowerQuartile;
        this.median = median;
        this.upperQuartile = upperQuartile;
    }
}
