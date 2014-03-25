package io.github.andyljones.commutesandrent.rentpreprocessortests;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;
import io.github.andyljones.commutesandrent.rentpreprocessor.DistrictFinder;
import io.github.andyljones.commutesandrent.rentpreprocessor.RentFinder;
import io.github.andyljones.commutesandrent.rentpreprocessor.RentGenerator;
import io.github.andyljones.commutesandrent.rentpreprocessor.RentStatisticsSerializer;
import io.github.andyljones.commutesandrent.rentpreprocessor.StationPostcodeFinder;
import io.github.andyljones.commutesandrent.transitpreprocessor.DepartureTimesGenerator;
import io.github.andyljones.commutesandrent.transitpreprocessor.DeserializationUtilities;
import io.github.andyljones.commutesandrent.transitpreprocessor.Station;
import io.github.andyljones.commutesandrent.transitpreprocessor.StationFinder;

public class ScratchTest {
    
    
    //@Test
    public void scratch()
    {
        RentGenerator.generate("131212-Table2.1.csv", "room-bedroom-rents.json");
        RentGenerator.generate("131212-Table2.2.csv", "studio-rents.json");
        RentGenerator.generate("131212-Table2.3.csv", "1-bedroom-rents.json");
        RentGenerator.generate("131212-Table2.4.csv", "2-bedroom-rents.json");
        RentGenerator.generate("131212-Table2.5.csv", "3-bedroom-rents.json");
        RentGenerator.generate("131212-Table2.6.csv", "4-bedroom-rents.json");
    } 
}
