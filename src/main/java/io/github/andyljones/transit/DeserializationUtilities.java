package io.github.andyljones.transit;

import io.github.andyljones.transit.graph.Station;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import uk.org.transxchange.StopPointStructure;
import uk.org.transxchange.TransXChange;

public class DeserializationUtilities 
{
    private static final String TIMETABLE_DIRECTORY_PATH = "/timetables";
    
    public static Collection<TransXChange> getTimetableRoots()
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
    
    public static Collection<StopPointStructure> getStopPoints(Collection<TransXChange> timetableRoots) 
    {
        return timetableRoots.stream().flatMap(root -> root.getStopPoints().getStopPoint().stream()).collect(Collectors.toList());
    }

    public static Collection<JourneyPartsHolder> getPartsHolders(Collection<TransXChange> timetableRoots)
    {
        return timetableRoots.stream().flatMap(root -> JourneyHolders.asHolders(root).stream()).collect(Collectors.toList());
    }

    public static Map<Station, Map<Station, GregorianCalendar>> getDepartureTimes(List<Station> stations, GregorianCalendar targetTime)
    {
        Map<Station, Map<Station, GregorianCalendar>> result = new HashMap<>();
        for (Station station : stations)
        {
            System.out.println("Processing station " + station.getName());
            
            LatestDepartureCalculator calculator = new LatestDepartureCalculator(station, targetTime);
            Map<Station, GregorianCalendar> times = calculator.getDepartureTimes();
            
            result.put(station, times);
        }
        
        return result;
    }
}
