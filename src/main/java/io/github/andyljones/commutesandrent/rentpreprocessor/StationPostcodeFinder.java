package io.github.andyljones.commutesandrent.rentpreprocessor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**
 * Maps station names to postcodes.
 * @author andy
 *
 */
public class StationPostcodeFinder {
    
    public String getPostcode(String stationName) { return nameToPostcodeMap.get(normalizeName(stationName)); }
    private final Map<String, String> nameToPostcodeMap;

    private static final int STATION_NAME_COLUMN_INDEX = 0;
    private static final int POSTCODE_COLUMN_INDEX = 1;
    
    /**
     * Construct a getPostcode function using the specified location data.
     * @param stationLocations Station location data.
     */
    public StationPostcodeFinder(String postcodeFilePath)
    {
        final InputStream stream = this.getClass().getClassLoader().getResourceAsStream(postcodeFilePath);
        final CsvReader csvReader = new CsvReader(stream, Charset.defaultCharset());
        
        nameToPostcodeMap = buildNameToPostcodeMap(csvReader);
    }

    private static Map<String, String> buildNameToPostcodeMap(CsvReader csvReader) 
    {
        final Map<String, String> result = new HashMap<>();
        try 
        { 
            while (csvReader.readRecord())
            {
                final String stationName = normalizeName(csvReader.get(STATION_NAME_COLUMN_INDEX));
                final String postcode = formatToSevenCharacters(csvReader.get(POSTCODE_COLUMN_INDEX));
                
                result.put(stationName, postcode);
            }
        }
        catch (IOException ioe)
        {
            System.err.println("Reading CSV file failed!");
        }
        
        return result;
    }

    private static String normalizeName(String stationName) 
    {
                
        String[] nameComponents = stationName.split("( Station| \\()");
        String normalizedName = nameComponents[0].replaceAll("\'", "").trim();
        
        return normalizedName;
    }

    private static String formatToSevenCharacters(String postcode) 
    {    
        final String[] components = postcode.split(" ");
        final int numberOfLetters = Arrays.stream(components).mapToInt(str -> str.length()).sum();
        
        final String result;
        if (numberOfLetters < 7)
        {
            final String padding = new String(new char[7 - numberOfLetters]).replace("\0", " ");
            result = components[0] + padding + components[1];
        }
        else
        {
            result = String.join("", components);
        }
        
        return result;
    }
}