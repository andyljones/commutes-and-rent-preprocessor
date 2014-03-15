package io.github.andyljones.rent;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**
 * Associates Local Authority District codes with an average rent, using data taken from the Office of 
 * National Statistics private rental market summaries.
 * @author andy
 *
 */
public class RentFinder 
{
    /**
     * The average two bedroom rent for the specified district code.
     * @param district A local authority district code
     * @return The average rent.
     */
    public String getRent(String district) { return rentMap.get(district); }
    private final Map<String, String> rentMap;
    
    private static final int DISTRICT_COLUMN_INDEX = 1;
    private static final int AVERAGE_RENT_COLUMN_INDEX = 4;
    
    /**
     * Construct a rent lookup using the csv data at the specified path.
     * @param rentFilePath The path to the csv file.
     */
    public RentFinder(final String rentFilePath)
    {
        final InputStream stream = this.getClass().getClassLoader().getResourceAsStream(rentFilePath);
        final CsvReader csvReader = new CsvReader(stream, Charset.defaultCharset());
        
        rentMap = buildDistrictToRentMap(csvReader);
    }   

    private static Map<String, String> buildDistrictToRentMap(CsvReader csvReader) 
    {
        final Map<String, String> result = new HashMap<>();
        try 
        {            
            csvReader.skipRecord(); // Skip header
            
            while (csvReader.readRecord())
            {
                final String district = csvReader.get(DISTRICT_COLUMN_INDEX);
                final String rent = csvReader.get(AVERAGE_RENT_COLUMN_INDEX);
                
                result.put(district, rent);
            }
        }
        catch (IOException ioe)
        {
            System.err.println("Reading CSV file failed!");
        }
        
        return result;
    }
}
