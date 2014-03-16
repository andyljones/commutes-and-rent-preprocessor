package io.github.andyljones.rent_tests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import uk.org.transxchange.TransXChange;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import io.github.andyljones.rent.DistrictFinder;
import io.github.andyljones.rent.KmlUnmarshaller;
import io.github.andyljones.rent.RentFinder;
import io.github.andyljones.rent.StationPostcodeFinder;
import io.github.andyljones.transit.TransXChangeUnmarshaller;

public class ScratchTest {

    //@Test
    public void scratch1()
    {
        List<String> paths = null;
        try
        {
            Path path = Paths.get("src/main/resources/timetables");
            paths = Files.list(path).map(p -> "/timetables/" + p.getFileName().toString()).collect(Collectors.toList());
            
            System.out.println(paths);        
            
        }
        catch (Exception e)
        {
            
        }
        
        Set<String> names = new HashSet<>();
        for (String path : paths)
        {
            TransXChange root = TransXChangeUnmarshaller.getRootElement(path);
            
            List<String> thisNames = root.getStopPoints().getStopPoint().stream().map(aspr -> aspr.getDescriptor().getCommonName().getValue().trim()).collect(Collectors.toList());
            
            names.addAll(thisNames);
        }
        
        Kml stationKml = KmlUnmarshaller.getRootElement("station-locations/station-locations.kml");
        StationPostcodeFinder postcodeFinder = new StationPostcodeFinder(stationKml);
        DistrictFinder districtFinder = new DistrictFinder("local-authority-districts/local-authority-districts.csv");
        RentFinder rentFinder = new RentFinder("rents/131212-Table2.3.csv");

        int totalCount = 0;
        int nullCount = 0;
        for (String name : names)
        {        
            String postcode = postcodeFinder.getPostcode(name);
            String district = districtFinder.getDistrict(postcode);
            String rent = rentFinder.getRent(district);
            
            totalCount++;
            
            if (rent == null) { nullCount++; }
            
            System.out.format("%10s \t %12s \t %7s \t %s\n", postcode, district, rent, name);
        }
        
        System.out.println(nullCount + " / " + totalCount);
    }

}
