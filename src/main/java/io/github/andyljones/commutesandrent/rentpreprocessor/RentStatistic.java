package io.github.andyljones.commutesandrent.rentpreprocessor;

import java.util.Optional;

/**
 * A datatype for rent statistics, holding the lower quartile, median and upper quartile rents for an area.
 */
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
