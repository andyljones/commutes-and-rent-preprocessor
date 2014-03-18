package io.github.andyljones.commutesandrent.transitpreprocessor;

import io.github.andyljones.commutesandrent.model.uk.org.transxchange.AbstractVehicleJourneyStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.TransXChange;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.VehicleJourneyStructure;
import io.github.andyljones.commutesandrent.model.uk.org.transxchange.VehicleJourneysStructure;

import java.util.ArrayList;
import java.util.Collection;

//TODO: Test this and dependents.
public class JourneyHolders 
{
    public static Collection<JourneyPartsHolder> asHolders(TransXChange root)
    {
        final Collection<JourneyPartsHolder> result = buildHolders(root.getVehicleJourneys());
        
        JourneyPatterns.addToHolders(root.getServices(), result);
        JourneySections.addToHolders(root.getJourneyPatternSections(), result);
        JourneyLinks.addToHolders(result);
        
        return result;
    }
 
    private static Collection<JourneyPartsHolder> buildHolders(VehicleJourneysStructure journeys) 
    {
        Collection<AbstractVehicleJourneyStructure> abstractJournies = journeys.getVehicleJourneyAndFlexibleVehicleJourney();
        
        Collection<JourneyPartsHolder> result = new ArrayList<>();        
        for (AbstractVehicleJourneyStructure abstractJouney : abstractJournies)
        {
            if (abstractJouney instanceof VehicleJourneyStructure)
            {
                VehicleJourneyStructure journey = (VehicleJourneyStructure) abstractJouney;
                
                JourneyPartsHolder holder = new JourneyPartsHolder();
                holder.journeyStructure = journey;
                
                result.add(holder);
            }
        }
        
        return result;
    }

}
