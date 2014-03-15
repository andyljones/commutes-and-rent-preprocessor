package io.github.andyljones.rent;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**
 * Associates postcodes with their Local Authority District Code, using data taken from the Office of National 
 * Statistics' postcode lookup database.
 * @author andy
 *
 */
public class DistrictFinder 
{
    /**
     * Returns the Local Authority District Code associated with a postcode; returns null if there is no such code.
     * @param postcode The postcode to look up.
     * @return The code of the district the postcode lies in.
     */
    public String getDistrict(String postcode) { return districtMap.get(postcode); }
    private final Map<String, String> districtMap;
    
    private static final int POSTCODE_COLUMN_INDEX = 0;
    private static final int DISTRICT_COLUMN_INDEX = 1;
    
    /**
     * Constructs the lookup function using data stored at the specified location.
     * @param localAuthorityFilePath
     */
    public DistrictFinder(final String localAuthorityFilePath)
    {
        final InputStream stream = this.getClass().getClassLoader().getResourceAsStream(localAuthorityFilePath);
        final CsvReader csvReader = new CsvReader(stream, Charset.defaultCharset());
        
        districtMap = buildPostcodeToDistrictMap(csvReader);
    }   

    private static Map<String, String> buildPostcodeToDistrictMap(CsvReader csvReader) 
    {
        final Map<String, String> result = new HashMap<>();
        try 
        {
            while (csvReader.readRecord())
            {
                final String postcode = csvReader.get(POSTCODE_COLUMN_INDEX);
                final String district = csvReader.get(DISTRICT_COLUMN_INDEX);
                
                result.put(postcode, district);
            }
        }
        catch (IOException ioe)
        {
            System.err.println("Reading CSV file failed!");
        }
        
        return result;
    }
}
