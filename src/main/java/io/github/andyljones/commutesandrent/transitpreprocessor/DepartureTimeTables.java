package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;
import io.github.andyljones.commutesandrent.transitpreprocessor.transit.graph.Station;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public class DepartureTimeTables {

    public static void build(int hours, int minutes, String filename)
    {
        Collection<TransXChange> timetableRoots = DeserializationUtilities.getTimetableRoots();
        
        StationFinder finder = new StationFinder(DeserializationUtilities.getStopPoints(timetableRoots));
        List<Station> stations = new ArrayList<>(finder.getStations());
        
        System.out.println("\nNumber of stations: " + stations.size() + "\n");
        
        StationNetworker networker = new StationNetworker(finder::getStation);
        networker.addJournies(DeserializationUtilities.getPartsHolders(timetableRoots));
        
        GregorianCalendar targetArrivalTime = new GregorianCalendar(1970, 0, 1, hours, minutes, 0);
        
        Map<Station, Map<Station, GregorianCalendar>> departureTimes = DeserializationUtilities.getDepartureTimes(stations, targetArrivalTime);
        
        DepartureTimeTableSerializer.serialize(targetArrivalTime, stations, departureTimes, filename);
    }
    
}
