package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Static class for converting the XML timetables in timetables/ to departure time files for a given
 * arrival time.
 */
public class DepartureTimesGenerator {

    /**
     * Converts the XML timetables in timetables/ into a set of JSON departure time files, one for each station.
     * 
     * The departure times listed in these files are the time a commuter would have to leave each station to get to 
     * the destination station for the specified time.
     * @param hours
     * @param minutes
     * @param outputFolder
     */
    public static void generate(int hours, int minutes, String outputFolder)
    {        
        GregorianCalendar targetArrivalTime = new GregorianCalendar(1970, 0, 1, hours, minutes, 0);
        
        Collection<TransXChange> timetableRoots = DeserializationUtilities.getTimetableRoots();
        
        StationFinder finder = new StationFinder(DeserializationUtilities.getStopPoints(timetableRoots));
        List<Station> stations = new ArrayList<>(finder.getStations());
        
        StationNetworker networker = new StationNetworker(finder::getStation);
        networker.addJournies(DeserializationUtilities.getPartsHolders(timetableRoots));
        
        for (Station destination : stations)
        {
            System.out.println("Processing departure times for station " + destination.getName());
            
            LatestDepartureCalculator calculator = new LatestDepartureCalculator(destination, targetArrivalTime);
         
            Map<Station, GregorianCalendar> departureTimes = calculator.getDepartureTimes();
            
            DepartureTimeTableSerializer.serialize(targetArrivalTime, destination, departureTimes, outputFolder);
        }
    }
    
}
