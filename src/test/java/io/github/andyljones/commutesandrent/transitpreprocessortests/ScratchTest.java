package io.github.andyljones.commutesandrent.transitpreprocessortests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.GregorianCalendar;
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
        try 
        {
            for (int i = 1; i <= 24; i++)
            {
                String folder = "output/processed-departure-times/" + (i-1)*60;
                Files.createDirectories(Paths.get(folder));
                DepartureTimesGenerator.generate(i, 0, folder);
            }
        }
        catch (IOException ioe)
        {
            
        }
        
    } 
}
