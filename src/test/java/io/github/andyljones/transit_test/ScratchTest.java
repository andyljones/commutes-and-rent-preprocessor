package io.github.andyljones.transit_test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import uk.org.transxchange.StopPointStructure;
import uk.org.transxchange.TransXChange;
import io.github.andyljones.transit.DepartureTimeTableSerializer;
import io.github.andyljones.transit.DepartureTimeTables;
import io.github.andyljones.transit.LatestDepartureCalculator;
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
        DepartureTimeTables.build(9, 0, "testOutput.txt");

        
//        Station station = finder.getStation("9400ZZLUOXC3");
//        GregorianCalendar time = new GregorianCalendar(1970, 0, 1, 9, 0, 0);
//        
//        LatestDepartureCalculator calc = new LatestDepartureCalculator(station, time);
//        Map<Station, GregorianCalendar> results = calc.getDepartureTimes();
//        
//        
//        Comp comp = new Comp(results);
//        Collection<Station> sorted = results.keySet().stream().sorted(comp).collect(Collectors.toList());
//        
//        DateFormat formatter = DateFormat.getTimeInstance();
//        
//        System.out.println(station.getName() + ", " + formatter.format(time.getTime()));
//        for (Station s : sorted)
//        {
//            GregorianCalendar t = results.get(s);
//            
//            String arrivalTime = formatter.format(t.getTime());
//            System.out.format("Station: %30s\t\tDeparture time  : %s\n", s.getName(), arrivalTime);
//        }
//        
//        System.out.println(sorted.size());
    }
    
//    private class Comp implements Comparator<Station>
//    {
//        private Map<Station, GregorianCalendar> ordering;
//        
//        public Comp(Map<Station, GregorianCalendar> ordering)
//        {
//            this.ordering = ordering;
//        }
//        
//        @Override
//        public int compare(Station o1, Station o2) 
//        {
//            return ordering.get(o2).compareTo(ordering.get(o1));
//        }
//        
//    }

}
