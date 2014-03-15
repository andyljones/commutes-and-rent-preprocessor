//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package uk.org.transxchange;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Specific journey of a vehicle following a JourneyPattern where the VehicleJourney includes all or some of the Stops identified by the associated JourneyPattern. The order of VehicleJourneyTimingLink elements in the VehicleJourney element should represent the order in which they appear in the physical VehicleJourney.
 * @id,
 * @CreationDateTime,
 * @ModificationDateTime,
 * @Modification,
 * @RevisionNumber.
 * 
 * <p>Java class for VehicleJourneyStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleJourneyStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.transxchange.org.uk/}AbstractVehicleJourneyStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.transxchange.org.uk/}StandardVehicleJourneyGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleJourneyStructure", propOrder = {
    "departureTime",
    "frequency",
    "vehicleJourneyTimingLink"
})
public class VehicleJourneyStructure
    extends AbstractVehicleJourneyStructure
{

    @XmlElement(name = "DepartureTime", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar departureTime;
    @XmlElement(name = "Frequency")
    protected FrequentServiceStructure frequency;
    @XmlElement(name = "VehicleJourneyTimingLink")
    protected List<VehicleJourneyTimingLinkStructure> vehicleJourneyTimingLink;

    /**
     * Gets the value of the departureTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the value of the departureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDepartureTime(XMLGregorianCalendar value) {
        this.departureTime = value;
    }

    /**
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link FrequentServiceStructure }
     *     
     */
    public FrequentServiceStructure getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrequentServiceStructure }
     *     
     */
    public void setFrequency(FrequentServiceStructure value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the vehicleJourneyTimingLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleJourneyTimingLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleJourneyTimingLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleJourneyTimingLinkStructure }
     * 
     * 
     */
    public List<VehicleJourneyTimingLinkStructure> getVehicleJourneyTimingLink() {
        if (vehicleJourneyTimingLink == null) {
            vehicleJourneyTimingLink = new ArrayList<VehicleJourneyTimingLinkStructure>();
        }
        return this.vehicleJourneyTimingLink;
    }

}