package io.github.andyljones.commutesandrent.rentpreprocessor;

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

/**
 * Static class for serializing station rent data into a JSON file.
 */
public class RentStatisticsSerializer 
{   
    /**
     * Writes each station to a JSON file along with the rent data associated with it.
     * 
     * The JSON written is an array of {name, lowerQuartile, median, upperQuartile } JSON objects, one for each station 
     * in @param stationNames.
     * @param stationNames The stations to write.
     * @param getCoords A function that associates station names with rent statistics.
     * @param filename The path of the file to write to.
     */
    public static void serialize(Collection<String> stationNames, Function<String, RentStatistic> getStats, String filename)
    {
        // Construct the JSON array that'll be written.
        JsonElement statisticsArray = buildStatisticsArray(stationNames, getStats);
        
        // Instantiate the formatter using the GSON library.
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

    // Build a JSON array of {name, lowerQuartile, median, upperQuartile } JSON objects
    private static JsonElement buildStatisticsArray(Collection<String> stationNames, Function<String, RentStatistic> getStats) 
    {
        JsonArray result = new JsonArray();
        
        // For each station name, get the corresponding rent statistics, combine them into a JSON object and then add it to the array.
        for (String stationName : stationNames)
        {
            RentStatistic rentStat = getStats.apply(stationName);
            JsonElement statObject = buildStatisticObject(stationName, rentStat);
            
            result.add(statObject);
        }
        
        return result;
    }
    
    // Build a JSON object containing the given station name and the given rent statistics.
    private static JsonElement buildStatisticObject(String stationName, RentStatistic rentStat)
    {
        JsonObject result = new JsonObject();
        
        result.addProperty("name", stationName);
        result.addProperty("lowerQuartile", rentStat.getLowerQuartile().orElse(null));
        result.addProperty("median", rentStat.getMedian().orElse(null));
        result.addProperty("upperQuartile", rentStat.getUpperQuartile().orElse(null));
        
        return result;
    }
}
