package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.ServicesStructure;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Static methods for adding JourneyPatternStructures to JourneyPartsHolders.
 */
public class JourneyPatterns 
{
    //TODO: Fold this into JourneyHolders?
    /**
     * Maps the JourneyPatternRefs of each JourneyPartsHolder.journeyStructure to the corresponding JourneyPatternStructure,
     * and adds them to the JourneyPartsHolder.
     * @param holders The JourneyPartsHolders to use.
     */
    public static void addToHolders(final ServicesStructure services, final Collection<JourneyPartsHolder> holders) 
    {
        final Map<String, JourneyPatternStructure> patternIdMap = buildPatternsMap(services);

        for (final JourneyPartsHolder holder : holders)
        {
            final String patternRef = holder.journeyStructure.getJourneyPatternRef().getValue();
            final JourneyPatternStructure pattern = patternIdMap.get(patternRef);
            
            holder.patternStructure = pattern;
        }
    }

    // Uses a timetable's ServicesStructure to constructs a map from JourneyPatternRefs to JourneyPatternStructures.
    private static Map<String, JourneyPatternStructure> buildPatternsMap(final ServicesStructure services) 
    {
        final List<JourneyPatternStructure> patterns = services.getService().stream()
                .flatMap(s -> s.getStandardService().getJourneyPattern().stream())
                .collect(Collectors.toList());
        
        final Map<String, JourneyPatternStructure> result = patterns.stream().collect(Collectors.toMap(p -> p.getId(), p -> p));
                
        return result;

    }
}
