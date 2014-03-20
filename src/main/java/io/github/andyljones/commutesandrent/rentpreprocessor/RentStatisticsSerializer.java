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
        JsonElement statisticsArray = buildStatisticsArray(stationNames, getStats);
        
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

    private static JsonElement buildStatisticsArray(Collection<String> stationNames, Function<String, RentStatistic> getStats) 
    {
        JsonArray result = new JsonArray();
        
        for (String stationName : stationNames)
        {
            RentStatistic rentStat = getStats.apply(stationName);
            JsonElement statObject = buildStatisticObject(stationName, rentStat);
            
            result.add(statObject);
        }
        
        return result;
    }
    
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
