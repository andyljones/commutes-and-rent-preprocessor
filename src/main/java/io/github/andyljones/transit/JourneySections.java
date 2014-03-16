package io.github.andyljones.transit;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import uk.org.transxchange.JourneyPatternSectionRefStructure;
import uk.org.transxchange.JourneyPatternSectionStructure;
import uk.org.transxchange.JourneyPatternSectionsStructure;

public class JourneySections 
{
    public static void addToHolders(final JourneyPatternSectionsStructure sectionsStructure, final Collection<JourneyPartsHolder> holders) 
    {
        final Map<String, JourneyPatternSectionStructure> sectionIdMap = buildSectionsMap(sectionsStructure);
        
        for (final JourneyPartsHolder holder : holders)
        {
            final List<JourneyPatternSectionRefStructure> sectionRefs = holder.patternStructure.getJourneyPatternSectionRefs();
            
            final List<JourneyPatternSectionStructure> sections = sectionRefs.stream()
                    .map(ref -> sectionIdMap.get(ref.getValue()))
                    .collect(Collectors.toList());
            
            holder.sectionStructures.addAll(sections);
        }
    }
    
    private static Map<String, JourneyPatternSectionStructure> buildSectionsMap(final JourneyPatternSectionsStructure sectionsStructure)
    {
        final List<JourneyPatternSectionStructure> sections = sectionsStructure.getJourneyPatternSection();
        
        final Map<String, JourneyPatternSectionStructure> result = sections.stream().collect(Collectors.toMap(s -> s.getId(), s -> s));
        
        return result;
    }
}
