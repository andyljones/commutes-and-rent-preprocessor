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

public class RentStatisticsSerializer 
{    
    public static void serialize(Collection<String> stationNames, Function<String, RentStatistic> getStats, String filename)
    {
        JsonElement statisticsObject = buildStatisticsObject(stationNames, getStats);
        
        Gson gson = new GsonBuilder().serializeNulls().create();

        try
        {
            Writer fileWriter = new FileWriter(filename);
            Writer out = new PrintWriter(fileWriter);
            
            out.write(gson.toJson(statisticsObject));
            
            out.close();
        }
        catch (IOException ioe)
        {
            System.err.println("Failed to write departure time tables!");
            ioe.printStackTrace();
        }
    }

    private static JsonObject buildStatisticsObject(Collection<String> stationNames, Function<String, RentStatistic> getStats) 
    {
        JsonObject statisticsObject = new JsonObject();
        
        JsonArray names = new JsonArray();
        statisticsObject.add("names", names);
        
        JsonArray lowerQuartiles = new JsonArray();
        statisticsObject.add("lowerQuartiles", lowerQuartiles);
        
        JsonArray medians = new JsonArray();
        statisticsObject.add("medians", medians);
        
        JsonArray upperQuartiles = new JsonArray();
        statisticsObject.add("upperQuartiles", upperQuartiles);
        
        
        for (String stationName : stationNames)
        {
            RentStatistic stats = getStats.apply(stationName);

            names.add(new JsonPrimitive(stationName));
            lowerQuartiles.add(new JsonPrimitive(stats.getLowerQuartile().orElse(null)));
            medians.add(new JsonPrimitive(stats.getMedian().orElse(null)));
            upperQuartiles.add(new JsonPrimitive(stats.getUpperQuartile().orElse(null)));
        }
        
        return statisticsObject;
    }
}
