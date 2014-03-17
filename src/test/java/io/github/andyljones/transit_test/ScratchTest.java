package io.github.andyljones.transit_test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.Test;

import uk.org.transxchange.TransXChange;
import io.github.andyljones.transit.EarliestArrivalCalculator;
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
        GregorianCalendar time = new ArrayList<Stop>(station.getStops()).get(100).getArrivalTime();

        
        EarliestArrivalCalculator calc = new EarliestArrivalCalculator(station, time);
        Map<Station, GregorianCalendar> results = calc.getArrivalTimes();
        
        
        Comp comp = new Comp(results);
        Collection<Station> sorted = results.keySet().stream().sorted(comp).collect(Collectors.toList());
        
        DateFormat formatter = DateFormat.getTimeInstance();
        
        System.out.println(station.getName() + ", " + formatter.format(time.getTime()));
        for (Station s : sorted)
        {
            GregorianCalendar t = results.get(s);
            
            String arrivalTime = formatter.format(t.getTime());
            System.out.format("Station: %30s\t\tArrival time  : %s\n", s.getName(), arrivalTime);
        }
    }
    
    private class Comp implements Comparator<Station>
    {
        private Map<Station, GregorianCalendar> ordering;
        
        public Comp(Map<Station, GregorianCalendar> ordering)
        {
            this.ordering = ordering;
        }
        
        @Override
        public int compare(Station o1, Station o2) 
        {
            return ordering.get(o1).compareTo(ordering.get(o2));
        }
        
    }

}
