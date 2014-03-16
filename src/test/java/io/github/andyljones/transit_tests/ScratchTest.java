package io.github.andyljones.transit_tests;

import java.util.Collection;

import uk.org.transxchange.TransXChange;
import io.github.andyljones.transit.JourneyHolders;
import io.github.andyljones.transit.JourneyPartsHolder;
import io.github.andyljones.transit.TransXChangeUnmarshaller;

public class ScratchTest {
    
    //@Test
    public void scratch()
    {
        TransXChange root = TransXChangeUnmarshaller.getRootElement("/transxchange-unmarshaller-test-data.xml");
        
        Collection<JourneyPartsHolder> result = JourneyHolders.asHolders(root);
        
        System.out.println(result.size());
        
    }

}
