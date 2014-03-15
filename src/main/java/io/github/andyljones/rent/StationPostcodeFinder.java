package io.github.andyljones.rent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

/**
 * Maps station names to postcodes.
 * @author andy
 *
 */
public class StationPostcodeFinder {
    
    public String getPostcode(String stationName) { return nameToPostcodeMap.get(stationName); }
    private final Map<String, String> nameToPostcodeMap;
     
    private static final Pattern POSTCODE_REGEX = Pattern.compile("^((GIR 0AA)|((([A-PR-UWYZ][A-HK-Y]?[0-9][0-9]?)|(([A-PR-UWYZ][0-9][A-HJKSTUW])|([A-PR-UWYZ][A-HK-Y][0-9][ABEHMNPRV-Y]))) *[0-9][ABD-HJLNP-UW-Z]{2}))$");
    private static final String DEFAULT_POSTCODE = "SW1H 0BD";
    
    /**
     * Construct a getPostcode function using the specified location data. Discards invalid postcodes.
     * @param stationLocations Station location data.
     */
    public StationPostcodeFinder(final Kml stationLocations)
    {
        nameToPostcodeMap = buildNameToPostcodeMap(stationLocations);
    }
    
    private static Map<String, String> buildNameToPostcodeMap(final Kml locations) 
    {
        final Document document = (Document) locations.getFeature();
        final List<Placemark> placemarks = document.getFeature().stream().map(feature -> (Placemark) feature).collect(Collectors.toList());
        
        final Map<String, String> result = new HashMap<>();
        for (Placemark placemark : placemarks)
        {
            final String name = extractName(placemark.getName());
            final String postcode = extractPostcode(placemark.getDescription());
            
            if (validatePostcode(postcode))
            {
                final String sevenLetterPostcode = formatToSevenCharacters(postcode);

                result.put(name, sevenLetterPostcode);
            }
        }
        
        return result;
    }

    private static String extractName(final String fullName)
    {
        final String[] nameComponents = fullName.split(" [Ss]tation");
        final String shortName = nameComponents[0].trim();      
        
        return shortName;
    }
    
    private static String extractPostcode(final String address) 
    {
        final String[] addressComponents = address.split(", ");
        final String postcode = addressComponents[addressComponents.length - 1].trim();
        
        return postcode;
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

    private static boolean validatePostcode(String postcode) 
    {
        final boolean wellFormatted = POSTCODE_REGEX.matcher(postcode).matches();
        final boolean notDefault = !postcode.equals(DEFAULT_POSTCODE);
        
        return wellFormatted && notDefault;
    }
}
