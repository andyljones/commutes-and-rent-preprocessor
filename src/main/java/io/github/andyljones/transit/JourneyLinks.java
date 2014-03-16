package io.github.andyljones.transit;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import uk.org.transxchange.JourneyPatternTimingLinkStructure;

public class JourneyLinks 
{
    public static void addToHolders(Collection<JourneyPartsHolder> holders)
    {
        for (JourneyPartsHolder holder : holders)
        {
            List<JourneyPatternTimingLinkStructure> links = holder.sectionStructures.stream()
                    .flatMap(s -> s.getJourneyPatternTimingLink().stream())
                    .collect(Collectors.toList());

            holder.linkStructures.addAll(links);
        }
    }
}
