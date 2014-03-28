package io.github.andyljones.commutesandrent.rentpreprocessor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.csvreader.CsvReader;

/**
 * Associates Local Authority District codes with an average rent, using data taken from the Office of 
 * National Statistics private rental market summaries.
 */
public class RentFinder 
{
    public RentStatistic getRent(String district) { return rentMap.get(district); }
    private final Map<String, RentStatistic> rentMap;
    
    private static final int DISTRICT_COLUMN_INDEX = 1;
    private static final int LOWER_QUARTILE_RENT_COLUMN_INDEX = 5;
    private static final int MEDIAN_RENT_COLUMN_INDEX = 6;
    private static final int UPPER_QUARTILE_RENT_COLUMN_INDEX = 7;
    
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

    // Converts the provided rent CSV file into a map from district codes to rent statistics.
    private static Map<String, RentStatistic> buildDistrictToRentMap(CsvReader csvReader) 
    {
        final Map<String, RentStatistic> result = new HashMap<>();
        try 
        {            
            csvReader.skipRecord(); // Skip header
            
            while (csvReader.readRecord())
            {
                final String district = csvReader.get(DISTRICT_COLUMN_INDEX);
                
                final Optional<Integer> lowerQuartileRent = tryParse(csvReader.get(LOWER_QUARTILE_RENT_COLUMN_INDEX));
                final Optional<Integer> medianRent = tryParse(csvReader.get(MEDIAN_RENT_COLUMN_INDEX));
                final Optional<Integer> upperQuartileRent = tryParse(csvReader.get(UPPER_QUARTILE_RENT_COLUMN_INDEX));
                
                final RentStatistic rentStats = new RentStatistic(lowerQuartileRent, medianRent, upperQuartileRent);
                
                result.put(district, rentStats);
            }
        }
        catch (IOException ioe)
        {
            System.err.println("Reading CSV file failed!");
        }
        
        return result;
    }
    
    // Parses a rent figure that's either a number or a "-", representing a null entry.
    private static Optional<Integer> tryParse(String rentFigure)
    {
        Optional<Integer> result;
        try
        {
            result = Optional.of(Integer.parseInt(rentFigure));
        }
        catch (NumberFormatException nfe)
        {
            result = Optional.empty();
        }
        
        return result;
    }
}
