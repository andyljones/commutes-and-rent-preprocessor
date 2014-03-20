package io.github.andyljones.commutesandrent.rentpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;
import io.github.andyljones.commutesandrent.transitpreprocessor.DeserializationUtilities;
import io.github.andyljones.commutesandrent.transitpreprocessor.Station;
import io.github.andyljones.commutesandrent.transitpreprocessor.StationFinder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RentGenerator 
{
    public static void generate(String sourceFilename, String destinationFilename)
    {
        Collection<TransXChange> roots = DeserializationUtilities.getTimetableRoots();
        
        Collection<Station> stations = new StationFinder(DeserializationUtilities.getStopPoints(roots)).getStations();
        List<String> stationNames = stations.stream().map(station -> station.getName()).collect(Collectors.toList());
        
        
        StationPostcodeFinder pf = new StationPostcodeFinder("station-postcodes/station-postcodes.csv");
        DistrictFinder df = new DistrictFinder("local-authority-district-postcodes/local-authority-district-postcodes.csv");
        
        String sourceFilePath = "local-authority-district-rents/" + sourceFilename;
        RentFinder rf = new RentFinder(sourceFilePath);
        
        String destinationFilePath = "output/processed-rents/" + destinationFilename;
        RentStatisticsSerializer.serialize(stationNames, name -> rf.getRent(df.getDistrict(pf.getPostcode(name))), destinationFilePath);

    }
}
