package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternSectionRefStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternSectionStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternSectionsStructure;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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