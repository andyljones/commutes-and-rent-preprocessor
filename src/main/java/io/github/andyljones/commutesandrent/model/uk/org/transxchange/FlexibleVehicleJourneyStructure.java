//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package io.github.andyljones.commutesandrent.model.uk.org.transxchange;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Specific journey of a vehicle following a flexible route.
 * @id,
 * @CreationDateTime,
 * @ModificationDateTime,
 * @Modification,
 * @RevisionNumber.
 * 
 * <p>Java class for FlexibleVehicleJourneyStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlexibleVehicleJourneyStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.transxchange.org.uk/}AbstractVehicleJourneyStructure">
 *       &lt;group ref="{http://www.transxchange.org.uk/}FlexibleVehicleJourneyGroup"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlexibleVehicleJourneyStructure", propOrder = {
    "flexibleServiceTimes"
})
@XmlSeeAlso({
    io.github.andyljones.commutesandrent.model.uk.org.transxchange.VehicleJourneysStructure.FlexibleVehicleJourney.class
})
public class FlexibleVehicleJourneyStructure
    extends AbstractVehicleJourneyStructure
{

    @XmlElement(name = "FlexibleServiceTimes", required = true)
    protected FlexibleServiceTimesStructure flexibleServiceTimes;

    /**
     * Gets the value of the flexibleServiceTimes property.
     * 
     * @return
     *     possible object is
     *     {@link FlexibleServiceTimesStructure }
     *     
     */
    public FlexibleServiceTimesStructure getFlexibleServiceTimes() {
        return flexibleServiceTimes;
    }

    /**
     * Sets the value of the flexibleServiceTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlexibleServiceTimesStructure }
     *     
     */
    public void setFlexibleServiceTimes(FlexibleServiceTimesStructure value) {
        this.flexibleServiceTimes = value;
    }

}
