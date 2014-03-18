package io.github.andyljones.commutesandrent.rentpreprocessortests;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;
import io.github.andyljones.commutesandrent.rentpreprocessor.DistrictFinder;
import io.github.andyljones.commutesandrent.rentpreprocessor.RentFinder;
import io.github.andyljones.commutesandrent.rentpreprocessor.RentStatisticsSerializer;
import io.github.andyljones.commutesandrent.rentpreprocessor.StationPostcodeFinder;
import io.github.andyljones.commutesandrent.transitpreprocessor.DepartureTimeTables;
import io.github.andyljones.commutesandrent.transitpreprocessor.DeserializationUtilities;
import io.github.andyljones.commutesandrent.transitpreprocessor.StationFinder;
import io.github.andyljones.commutesandrent.transitpreprocessor.transit.graph.Station;

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
