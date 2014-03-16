package io.github.andyljones.transit;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import uk.org.transxchange.JourneyPatternStructure;
import uk.org.transxchange.ServicesStructure;

public class JourneyPatterns 
{
    public static void addToHolders(ServicesStructure services, Collection<JourneyPartsHolder> holders) 
    {
        Map<String, JourneyPatternStructure> patternIdMap = buildPatternsMap(services);

        for (JourneyPartsHolder holder : holders)
        {
            String patternRef = holder.journeyStructure.getJourneyPatternRef().getValue();
            JourneyPatternStructure pattern = patternIdMap.get(patternRef);
            
            holder.patternStructure = pattern;
        }
    }

    private static Map<String, JourneyPatternStructure> buildPatternsMap(ServicesStructure services) 
    {
        List<JourneyPatternStructure> patterns = services.getService().stream()
                .flatMap(s -> s.getStandardService().getJourneyPattern().stream())
                .collect(Collectors.toList());
        
        Map<String, JourneyPatternStructure> result = patterns.stream().collect(Collectors.toMap(p -> p.getId(), p -> p));
                
        return result;

    }
}
