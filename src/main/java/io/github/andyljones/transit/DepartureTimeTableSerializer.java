package io.github.andyljones.transit;

import io.github.andyljones.transit.graph.Station;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class DepartureTimeTableSerializer 
{
    private static final long MILLIS_TO_MINUTES = 60_000;
    
    public static void serialize(GregorianCalendar arrivalTime, List<Station> stations, Map<Station, Map<Station, GregorianCalendar>> table, String filename)
    {
        JsonObject departureTimeTable = new JsonObject();
        departureTimeTable.addProperty("arrivalTime", arrivalTime.getTimeInMillis() / MILLIS_TO_MINUTES);
        
        departureTimeTable.add("stations", buildTableHeader(stations));
        departureTimeTable.add("times", buildTableObject(stations, table));
        
        Gson gson = new GsonBuilder().serializeNulls().create();

        try
        {
            Writer fileWriter = new FileWriter(filename);
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
        
    private static JsonArray buildTableHeader(List<Station> stations) 
    {
        JsonArray headerArray = new JsonArray();
        
        for (Station station : stations)
        {
            headerArray.add(new JsonPrimitive(station.getName()));
        }
        
        return headerArray;
    }

    private static JsonArray buildTableObject(List<Station> stations, Map<Station, Map<Station, GregorianCalendar>> table)
    {
        JsonArray result = new JsonArray();
        
        for (int i = 0; i < stations.size(); i++)
        {
            for (int j = 0; j < stations.size(); j++)
            {
                Station destination = stations.get(i);
                Station origin = stations.get(j);
                
                Map<Station, GregorianCalendar> originMap = table.get(destination);
                
                Long timeInMinutes = null;
                if (originMap != null)
                {
                    GregorianCalendar time = originMap.get(origin);
                    timeInMinutes = time.getTimeInMillis() / MILLIS_TO_MINUTES;
                }
                
                result.add(new JsonPrimitive(timeInMinutes));
            }
        }
        
        return result;
    }
}
