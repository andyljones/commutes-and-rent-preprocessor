package io.github.andyljones.rent_tests;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import uk.org.transxchange.TransXChange;
import io.github.andyljones.rent.DistrictFinder;
import io.github.andyljones.rent.RentFinder;
import io.github.andyljones.rent.RentStatisticsSerializer;
import io.github.andyljones.rent.StationPostcodeFinder;
import io.github.andyljones.transit.DepartureTimeTables;
import io.github.andyljones.transit.DeserializationUtilities;
import io.github.andyljones.transit.StationFinder;
import io.github.andyljones.transit.graph.Station;

public class ScratchTest {
    
    
    //@Test
    public void scratch()
    {
        Collection<TransXChange> roots = DeserializationUtilities.getTimetableRoots();
        
        Collection<Station> stations = new StationFinder(DeserializationUtilities.getStopPoints(roots)).getStations();
        List<String> stationNames = stations.stream().map(station -> station.getName()).collect(Collectors.toList());
        
        
        StationPostcodeFinder pf = new StationPostcodeFinder("station-locations/tube-postcodes.csv");
        DistrictFinder df = new DistrictFinder("local-authority-districts/local-authority-districts.csv");
        RentFinder rf = new RentFinder("rents/131212-Table2.3.csv");
        
        RentStatisticsSerializer.serialize(stationNames, name -> rf.getRent(df.getDistrict(pf.getPostcode(name))), "src/main/resources/processed-rents/two-bedroom-rents.json");
        
        DepartureTimeTables.build(9, 0, "src/main/resources/processed-departure-times/900arrival.json");
    } 
}
