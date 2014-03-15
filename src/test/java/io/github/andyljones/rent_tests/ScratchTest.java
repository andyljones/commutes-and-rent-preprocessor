package io.github.andyljones.rent_tests;

import org.junit.Test;

import de.micromata.opengis.kml.v_2_2_0.Kml;
import io.github.andyljones.rent.DistrictFinder;
import io.github.andyljones.rent.KmlUnmarshaller;
import io.github.andyljones.rent.RentFinder;
import io.github.andyljones.rent.StationPostcodeFinder;

public class ScratchTest {

    @Test
    public void scratch1()
    {
        Kml stationKml = KmlUnmarshaller.getRootElement("station-locations/station-locations.kml");
        StationPostcodeFinder postcodeFinder = new StationPostcodeFinder(stationKml);
        DistrictFinder districtFinder = new DistrictFinder("local-authority-districts/local-authority-districts.csv");
        RentFinder rentFinder = new RentFinder("rents/131212-Table2.3.csv");
        
        String stationName = "Bayswater";
        
        String postcode = postcodeFinder.getPostcode(stationName);
        String district = districtFinder.getDistrict(postcode);
        String rent = rentFinder.getRent(district);
        
        System.out.println(String.format("%s, %s, %s", postcode, district, rent));
    }

}
