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
import javax.xml.bind.annotation.XmlType;


/**
 * Classification and description of the bus service. This does not identify the individual bus journeys (defined as part of VehicleJourney)
 * 
 * <p>Java class for StandardServiceStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardServiceStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Origin" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure"/>
 *         &lt;element name="Destination" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure"/>
 *         &lt;element name="Vias" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Via" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="UseAllStopPoints" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="JourneyPattern" type="{http://www.transxchange.org.uk/}JourneyPatternStructure" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardServiceStructure", propOrder = {
    "origin",
    "destination",
    "vias",
    "useAllStopPoints",
    "journeyPattern"
})
public class StandardServiceStructure {

    @XmlElement(name = "Origin", required = true)
    protected NaturalLanguageStringStructure origin;
    @XmlElement(name = "Destination", required = true)
    protected NaturalLanguageStringStructure destination;
    @XmlElement(name = "Vias")
    protected StandardServiceStructure.Vias vias;
    @XmlElement(name = "UseAllStopPoints", defaultValue = "true")
    protected Boolean useAllStopPoints;
    @XmlElement(name = "JourneyPattern", required = true)
    protected List<JourneyPatternStructure> journeyPattern;

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public NaturalLanguageStringStructure getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public void setOrigin(NaturalLanguageStringStructure value) {
        this.origin = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public NaturalLanguageStringStructure getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public void setDestination(NaturalLanguageStringStructure value) {
        this.destination = value;
    }

    /**
     * Gets the value of the vias property.
     * 
     * @return
     *     possible object is
     *     {@link StandardServiceStructure.Vias }
     *     
     */
    public StandardServiceStructure.Vias getVias() {
        return vias;
    }

    /**
     * Sets the value of the vias property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardServiceStructure.Vias }
     *     
     */
    public void setVias(StandardServiceStructure.Vias value) {
        this.vias = value;
    }

    /**
     * Gets the value of the useAllStopPoints property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseAllStopPoints() {
        return useAllStopPoints;
    }

    /**
     * Sets the value of the useAllStopPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseAllStopPoints(Boolean value) {
        this.useAllStopPoints = value;
    }

    /**
     * Gets the value of the journeyPattern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the journeyPattern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJourneyPattern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JourneyPatternStructure }
     * 
     * 
     */
    public List<JourneyPatternStructure> getJourneyPattern() {
        if (journeyPattern == null) {
            journeyPattern = new ArrayList<JourneyPatternStructure>();
        }
        return this.journeyPattern;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Via" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "via"
    })
    public static class Vias {

        @XmlElement(name = "Via", required = true)
        protected List<NaturalLanguageStringStructure> via;

        /**
         * Gets the value of the via property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the via property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVia().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NaturalLanguageStringStructure }
         * 
         * 
         */
        public List<NaturalLanguageStringStructure> getVia() {
            if (via == null) {
                via = new ArrayList<NaturalLanguageStringStructure>();
            }
            return this.via;
        }

    }

}