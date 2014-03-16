package io.github.andyljones.transit;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import uk.org.transxchange.JourneyPatternTimingLinkStructure;

public class JourneyLinks 
{
    public static void addToHolders(final Collection<JourneyPartsHolder> holders)
    {
        for (final JourneyPartsHolder holder : holders)
        {
            final List<JourneyPatternTimingLinkStructure> links = holder.sectionStructures.stream()
                    .flatMap(s -> s.getJourneyPatternTimingLink().stream())
                    .collect(Collectors.toList());

            holder.linkStructures.addAll(links);
        }
    }
}
