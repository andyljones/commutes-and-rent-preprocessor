package io.github.andyljones.rent_tests;

import java.io.IOException;
import java.net.URISyntaxException;
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

import de.micromata.opengis.kml.v_2_2_0.Kml;
import uk.org.transxchange.StopPointStructure;
import uk.org.transxchange.TransXChange;
import io.github.andyljones.rent.StationPostcodeFinder;
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
        Collection<TransXChange> roots = getTimetableRoots();
        
        Collection<Station> stations = new StationFinder(getStopPoints(roots)).getStations();
        
        StationPostcodeFinder finder = new StationPostcodeFinder("station-locations/tube-postcodes.csv");
        
        for (Station station : stations)
        {
            if (finder.getPostcode(station.getName()) == null)
            {
                System.out.format("%s,\n", station.getName(), finder.getPostcode(station.getName()));
            }
        }
    }
    
    
    private static Collection<StopPointStructure> getStopPoints(Collection<TransXChange> timetableRoots) 
    {
        return timetableRoots.stream().flatMap(root -> root.getStopPoints().getStopPoint().stream()).collect(Collectors.toList());
    }
    

    private static final String TIMETABLE_DIRECTORY_PATH = "/timetables";
    
    private static Collection<TransXChange> getTimetableRoots()
    {
        Collection<TransXChange> result = new ArrayList<>();
        try
        {
            Path timetableDirectory = Paths.get(DepartureTimeTables.class.getResource(TIMETABLE_DIRECTORY_PATH).toURI());

            System.out.println(timetableDirectory.toString());
            List<Path> timetableFiles = Files.list(timetableDirectory).collect(Collectors.toList());
            
            
            for (Path file : timetableFiles)
            {
                System.out.println("Loading " + file.toString());
                
                TransXChange root = TransXChangeUnmarshaller.getRootElement(TIMETABLE_DIRECTORY_PATH + "/" + file.getFileName()); 
                result.add(root);
            }
        }
        catch (IOException | URISyntaxException e)
        {
            System.err.println("Failed to open timetable files!");
            e.printStackTrace();
        }
        
        return result;
    }

}
