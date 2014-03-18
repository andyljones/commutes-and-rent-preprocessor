package io.github.andyljones.commutesandrent.transitpreprocessortests;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.DescriptorStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.NaturalLanguagePlaceNameStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.StopPointStructure;

import java.util.ArrayList;
import java.util.Collection;

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