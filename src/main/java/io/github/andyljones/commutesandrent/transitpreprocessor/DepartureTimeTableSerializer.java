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

public class DepartureTimeTableSerializer 
{
    private static final long MILLIS_TO_MINUTES = 60_000;
    
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
