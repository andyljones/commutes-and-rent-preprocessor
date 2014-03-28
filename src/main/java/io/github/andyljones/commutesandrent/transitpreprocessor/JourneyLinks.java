package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternTimingLinkStructure;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Static methods for adding JourneyPatternTimingLinks to JourneyPartsHolders.
 */
public class JourneyLinks 
{
    //TODO: Fold this into JourneyHolders?
    /**
     * Adds each JourneyPatternTimingLink in a JourneyPartsHolder's JourneySectionStructures to the JourneyPartsHolder's
     * linkStructures property.
     * @param holders The JourneyPartsHolders to use.
     */
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
