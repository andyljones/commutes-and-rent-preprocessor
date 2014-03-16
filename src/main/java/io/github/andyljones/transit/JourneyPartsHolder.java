package io.github.andyljones.transit;

import java.util.ArrayList;
import java.util.List;

import uk.org.transxchange.JourneyPatternSectionStructure;
import uk.org.transxchange.JourneyPatternStructure;
import uk.org.transxchange.JourneyPatternTimingLinkStructure;
import uk.org.transxchange.VehicleJourneyStructure;

public class JourneyPartsHolder
{
    public VehicleJourneyStructure journeyStructure;
    public JourneyPatternStructure patternStructure;
    public List<JourneyPatternSectionStructure> sectionStructures = new ArrayList<>();
    public List<JourneyPatternTimingLinkStructure> linkStructures = new ArrayList<>();
}
