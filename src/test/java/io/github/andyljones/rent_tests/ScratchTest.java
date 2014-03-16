package io.github.andyljones.rent_tests;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import uk.org.transxchange.TransXChange;
import io.github.andyljones.transit.JourneyHolders;
import io.github.andyljones.transit.JourneyPartsHolder;
import io.github.andyljones.transit.StationFinder;
import io.github.andyljones.transit.StationNetworker;
import io.github.andyljones.transit.TransXChangeUnmarshaller;
import io.github.andyljones.transit.graph.Station;
import io.github.andyljones.transit.graph.Stop;

public class ScratchTest {
    
    @Test
    public void scratch()
    {
        TransXChange root = TransXChangeUnmarshaller.getRootElement("/timetables/tfl_1-BAK-390106-y05.xml");
        
        Collection<JourneyPartsHolder> result = JourneyHolders.asHolders(root);
        
        
        StationFinder finder = new StationFinder(root.getStopPoints().getStopPoint());
        StationNetworker networker = new StationNetworker(finder::getStation);
        
        for (JourneyPartsHolder journeyParts : result)
        {
            networker.addJourney(journeyParts);
        }
        
        Station station = finder.getStation("9400ZZLUWYC1");

        DateFormat formatter = DateFormat.getTimeInstance();
        
        for (Stop stop : station.getStops())
        {
            String date = formatter.format(stop.getArrivalTime().getTime());
            System.out.format("Station: %30s\t\tArrival time: %s\n", stop.getStation().getName(), date);
        }
        
        
    }

}
