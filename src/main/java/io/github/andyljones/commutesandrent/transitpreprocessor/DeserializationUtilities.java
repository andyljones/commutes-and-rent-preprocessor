package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.StopPointStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;

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

/**
 * Static methods for extracting various components from a collection of timetables.
 */
public class DeserializationUtilities 
{
    private static final String TIMETABLE_DIRECTORY_PATH = "/timetables";
    
    /**
     * Deserializes the timetables in timetables/ and returns their root elements.
     * @return A collection of root elements from the timetables.
     */
    public static Collection<TransXChange> getTimetableRoots()
    {
        Collection<TransXChange> result = new ArrayList<>();
        try
        {
            Path timetableDirectory = Paths.get(DepartureTimesGenerator.class.getResource(TIMETABLE_DIRECTORY_PATH).toURI());

            System.out.println(timetableDirectory.toString());
            List<Path> timetableFiles = Files.list(timetableDirectory).collect(Collectors.toList());
            
            // Unmarshall each timetable file and add it's root element to the result.
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
    
    /**
     * Extracts all StopPointStructures from the provided TransXChange models.
     * @param timetableRoots The root elements of the TransXChange structures to extract the stop points from
     * @return All StopPointStructures from the TransXChange models.
     */
    public static Collection<StopPointStructure> getStopPoints(Collection<TransXChange> timetableRoots) 
    {   //TODO: Move this over to StationFinder?
        return timetableRoots.stream().flatMap(root -> root.getStopPoints().getStopPoint().stream()).collect(Collectors.toList());
    }

    /**
     * Extracts from each provided TransXChange structure a collection of JourneyPartsHolder, and returns their union.
     * @param timetableRoots The root elements of the TransXChange structures to extract the JourneyPartsHolders from
     * @return All JourneyPartsHolders from the TransXChange models.
     */
    public static Collection<JourneyPartsHolder> getPartsHolders(Collection<TransXChange> timetableRoots)
    {   //TODO: Move this over the JourneyHolders?
        return timetableRoots.stream().flatMap(root -> JourneyHolders.asHolders(root).stream()).collect(Collectors.toList());
    }
}
