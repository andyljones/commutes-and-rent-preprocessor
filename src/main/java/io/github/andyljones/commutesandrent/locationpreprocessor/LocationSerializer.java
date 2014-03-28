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

/**
 * Static class for serializing station location data into a JSON file.
 */
public class LocationSerializer 
{   
    /**
     * Writes each station to a JSON file along with the latitude-longitude associated with it.
     * 
     * The JSON written is an array of {name, latitude, longitude} JSON objects, one for each station in @param stationNames.
     * @param stationNames The stations to write.
     * @param getCoords A function that associates station names with latitude-longitudes.
     * @param filename The path of the file to write to.
     */
    public static void serialize(Collection<String> stationNames, Function<String, LongLat> getCoords, String filename)
    {
        // Construct the JSON array that'll be written.
        JsonElement statisticsArray = buildCoordinatesArray(stationNames, getCoords);
        
        // Instantiate the formatter used by the GSON library.
        Gson gson = new GsonBuilder().serializeNulls().create();

        // Try to write the JSON array to file, catching any IO errors.
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

    // Build a JSON array of { station-name, station-location } objects.
    private static JsonElement buildCoordinatesArray(Collection<String> stationNames, Function<String, LongLat> getCoords) 
    {
        JsonArray result = new JsonArray();
        
        // For each station name, get the corresponding location, combine them into a JSON object and then add it to the array.
        for (String stationName : stationNames)
        {
            LongLat coords = getCoords.apply(stationName);
            JsonElement statObject = buildCoordinateObject(stationName, coords);
            
            result.add(statObject);
        }
        
        return result;
    }
    
    // Build a JSON object containing the given station name and the given coordinates.
    private static JsonElement buildCoordinateObject(String stationName, LongLat coords)
    {
        JsonObject result = new JsonObject();
        
        result.addProperty("name", stationName);
        result.addProperty("longitude", coords.getLongitude());
        result.addProperty("latitude", coords.getLatitude());
        
        return result;
    }
}
