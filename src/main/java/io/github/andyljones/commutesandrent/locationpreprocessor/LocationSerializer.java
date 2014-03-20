package io.github.andyljones.commutesandrent.locationpreprocessor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.function.Function;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class LocationSerializer 
{    
    public static void serialize(Collection<String> stationNames, Function<String, LongLat> getCoords, String filename)
    {
        JsonElement statisticsArray = buildCoordinatesArray(stationNames, getCoords);
        
        Gson gson = new GsonBuilder().serializeNulls().create();

        try
        {
            Writer fileWriter = new FileWriter(filename);
            Writer out = new PrintWriter(fileWriter);
            
            out.write(gson.toJson(statisticsArray));
            
            out.close();
        }
        catch (IOException ioe)
        {
            System.err.println("Failed to write departure time tables!");
            ioe.printStackTrace();
        }
    }

    private static JsonElement buildCoordinatesArray(Collection<String> stationNames, Function<String, LongLat> getCoords) 
    {
        JsonArray result = new JsonArray();
        
        for (String stationName : stationNames)
        {
            LongLat coords = getCoords.apply(stationName);
            JsonElement statObject = buildCoordinateObject(stationName, coords);
            
            result.add(statObject);
        }
        
        return result;
    }
    
    private static JsonElement buildCoordinateObject(String stationName, LongLat coords)
    {
        JsonObject result = new JsonObject();
        
        result.addProperty("name", stationName);
        result.addProperty("longitude", coords.getLongitude());
        result.addProperty("latitude", coords.getLatitude());
        
        return result;
    }
}
