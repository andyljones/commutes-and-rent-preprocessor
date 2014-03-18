package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternTimingLinkStructure;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
