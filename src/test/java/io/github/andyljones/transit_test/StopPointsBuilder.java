package io.github.andyljones.transit_test;

import java.util.ArrayList;
import java.util.Collection;

import uk.org.transxchange.DescriptorStructure;
import uk.org.transxchange.NaturalLanguagePlaceNameStructure;
import uk.org.transxchange.StopPointStructure;

public class StopPointsBuilder
{
    public final Collection<StopPointStructure> stopPoints = new ArrayList<>();
    
    public void addStopPoint(String atcoCode, String name)
    {
        NaturalLanguagePlaceNameStructure nameStructure = new NaturalLanguagePlaceNameStructure();
        nameStructure.setValue(name);
        
        DescriptorStructure descriptor = new DescriptorStructure();
        descriptor.setCommonName(nameStructure);
        
        StopPointStructure stopPoint = new StopPointStructure();
        stopPoint.setAtcoCode(atcoCode);
        stopPoint.setDescriptor(descriptor);
        
        stopPoints.add(stopPoint);
    }
}