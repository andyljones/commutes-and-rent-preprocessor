//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package uk.org.transxchange;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * End of a positioning link.
 * 
 * <p>Java class for PositioningLinkUsageStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PositioningLinkUsageStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="StopPointRef" type="{http://www.transxchange.org.uk/}StopPointRefStructure"/>
 *         &lt;element name="GarageRef" type="{http://www.transxchange.org.uk/}GarageRefStructure"/>
 *         &lt;element name="LayoverPointRef" type="{http://www.transxchange.org.uk/}LayoverPointRefStructure"/>
 *         &lt;element name="Location" type="{http://www.transxchange.org.uk/}LocationStructure"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PositioningLinkUsageStructure", propOrder = {
    "stopPointRef",
    "garageRef",
    "layoverPointRef",
    "location"
})
public class PositioningLinkUsageStructure {

    @XmlElement(name = "StopPointRef")
    protected StopPointRefStructure stopPointRef;
    @XmlElement(name = "GarageRef")
    protected GarageRefStructure garageRef;
    @XmlElement(name = "LayoverPointRef")
    protected LayoverPointRefStructure layoverPointRef;
    @XmlElement(name = "Location")
    protected LocationStructure location;

    /**
     * Gets the value of the stopPointRef property.
     * 
     * @return
     *     possible object is
     *     {@link StopPointRefStructure }
     *     
     */
    public StopPointRefStructure getStopPointRef() {
        return stopPointRef;
    }

    /**
     * Sets the value of the stopPointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopPointRefStructure }
     *     
     */
    public void setStopPointRef(StopPointRefStructure value) {
        this.stopPointRef = value;
    }

    /**
     * Gets the value of the garageRef property.
     * 
     * @return
     *     possible object is
     *     {@link GarageRefStructure }
     *     
     */
    public GarageRefStructure getGarageRef() {
        return garageRef;
    }

    /**
     * Sets the value of the garageRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link GarageRefStructure }
     *     
     */
    public void setGarageRef(GarageRefStructure value) {
        this.garageRef = value;
    }

    /**
     * Gets the value of the layoverPointRef property.
     * 
     * @return
     *     possible object is
     *     {@link LayoverPointRefStructure }
     *     
     */
    public LayoverPointRefStructure getLayoverPointRef() {
        return layoverPointRef;
    }

    /**
     * Sets the value of the layoverPointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link LayoverPointRefStructure }
     *     
     */
    public void setLayoverPointRef(LayoverPointRefStructure value) {
        this.layoverPointRef = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationStructure }
     *     
     */
    public LocationStructure getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationStructure }
     *     
     */
    public void setLocation(LocationStructure value) {
        this.location = value;
    }

}