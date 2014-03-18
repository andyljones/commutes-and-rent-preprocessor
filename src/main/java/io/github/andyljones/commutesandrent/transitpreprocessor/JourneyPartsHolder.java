package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternSectionStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.JourneyPatternTimingLinkStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.VehicleJourneyStructure;

import java.util.ArrayList;
import java.util.List;

public class JourneyPartsHolder
{
    public VehicleJourneyStructure journeyStructure;
    public JourneyPatternStructure patternStructure;
    public List<JourneyPatternSectionStructure> sectionStructures = new ArrayList<>();
    public List<JourneyPatternTimingLinkStructure> linkStructures = new ArrayList<>();
}
