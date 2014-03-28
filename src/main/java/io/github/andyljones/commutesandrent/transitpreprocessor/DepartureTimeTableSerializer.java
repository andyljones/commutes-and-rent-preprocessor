package io.github.andyljones.commutesandrent.transitpreprocessor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * Static class for serializing processed timetable data into JSON files.
 */
public class DepartureTimeTableSerializer 
{
    private static final long MILLIS_TO_MINUTES = 60_000;
    
    /**
     * Constructs a departure time JSON file for the specified destination & arrival time and writes it to the specified folder.
     * The name of the file will be the name of the station.
     * 
     * The lookup table should be for the specified time and destination station. //TODO: Fix serialize's dependency on being passed the correct table
     * @param arrivalTime The time commutes should arrive at the destination station by
     * @param destination The destination station
     * @param table The departure time table for the specified arrival time and destination
     * @param foldername The folder to write the JSON file to.
     */
    public static void serialize(GregorianCalendar arrivalTime, Station destination, Map<Station, GregorianCalendar> table, String foldername)
    {
        JsonObject departureTimeTable = new JsonObject();
        departureTimeTable.addProperty("arrivalTime", arrivalTime.getTimeInMillis() / MILLIS_TO_MINUTES);
        departureTimeTable.addProperty("destination", destination.getName());
        
        departureTimeTable.add("times", buildTableObject(table));
        
        Gson gson = new GsonBuilder().serializeNulls().create();

        try
        {
            Writer fileWriter = new FileWriter(foldername + "/" + destination.getName() + ".json");
            Writer out = new PrintWriter(fileWriter);
            
            out.write(gson.toJson(departureTimeTable));
            
            out.close();
        }
        catch (IOException ioe)
        {
            System.err.println("Failed to write departure time tables!");
            ioe.printStackTrace();
        }
    }

    // Builds a JSON array from the given map. Each entry is converted to a { stationname, departuretime } JSON object
    private static JsonArray buildTableObject(Map<Station, GregorianCalendar> table)
    {
        JsonArray result = new JsonArray();
        
        for (Map.Entry<Station, GregorianCalendar> entry : table.entrySet())
        {
            JsonObject entryObject = new JsonObject();
            entryObject.addProperty("station", entry.getKey().getName());
            entryObject.addProperty("time", entry.getValue().getTimeInMillis() / MILLIS_TO_MINUTES);
            
            result.add(entryObject);       
        }
        
        return result;
    }
}
