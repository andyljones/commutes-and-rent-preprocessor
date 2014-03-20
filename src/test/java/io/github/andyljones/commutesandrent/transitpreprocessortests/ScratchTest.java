package io.github.andyljones.commutesandrent.transitpreprocessortests;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;
import io.github.andyljones.commutesandrent.rentpreprocessor.DistrictFinder;
import io.github.andyljones.commutesandrent.rentpreprocessor.RentFinder;
import io.github.andyljones.commutesandrent.rentpreprocessor.RentStatisticsSerializer;
import io.github.andyljones.commutesandrent.rentpreprocessor.StationPostcodeFinder;
import io.github.andyljones.commutesandrent.transitpreprocessor.DepartureTimesGenerator;
import io.github.andyljones.commutesandrent.transitpreprocessor.DeserializationUtilities;
import io.github.andyljones.commutesandrent.transitpreprocessor.Station;
import io.github.andyljones.commutesandrent.transitpreprocessor.StationFinder;

public class ScratchTest {
    
    
    @Test
    public void scratch()
    {
        DepartureTimesGenerator.generate(17, 0, "output/processed-departure-times/1700");
    } 
}
