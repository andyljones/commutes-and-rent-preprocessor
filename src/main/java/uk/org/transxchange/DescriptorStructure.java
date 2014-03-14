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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Data type for a Structured text description of stop.
 * 
 * <p>Java class for DescriptorStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DescriptorStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommonName" type="{http://www.transxchange.org.uk/}NaturalLanguagePlaceNameStructure"/>
 *         &lt;element name="ShortCommonName" type="{http://www.transxchange.org.uk/}NaturalLanguagePlaceNameStructure" minOccurs="0"/>
 *         &lt;element name="Landmark" type="{http://www.transxchange.org.uk/}NaturalLanguagePlaceNameStructure" minOccurs="0"/>
 *         &lt;element name="Street" type="{http://www.transxchange.org.uk/}NaturalLanguagePlaceNameStructure" minOccurs="0"/>
 *         &lt;element name="Crossing" type="{http://www.transxchange.org.uk/}NaturalLanguagePlaceNameStructure" minOccurs="0"/>
 *         &lt;element name="Indicator" type="{http://www.transxchange.org.uk/}NaturalLanguagePlaceNameStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DescriptorStructure", propOrder = {
    "commonName",
    "shortCommonName",
    "landmark",
    "street",
    "crossing",
    "indicator"
})
@XmlSeeAlso({
    uk.org.transxchange.StopPointStructure.AlternativeDescriptors.Descriptor.class
})
public class DescriptorStructure {

    @XmlElement(name = "CommonName", required = true)
    protected NaturalLanguagePlaceNameStructure commonName;
    @XmlElement(name = "ShortCommonName")
    protected NaturalLanguagePlaceNameStructure shortCommonName;
    @XmlElement(name = "Landmark")
    protected NaturalLanguagePlaceNameStructure landmark;
    @XmlElement(name = "Street")
    protected NaturalLanguagePlaceNameStructure street;
    @XmlElement(name = "Crossing")
    protected NaturalLanguagePlaceNameStructure crossing;
    @XmlElement(name = "Indicator")
    protected NaturalLanguagePlaceNameStructure indicator;

    /**
     * Gets the value of the commonName property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public NaturalLanguagePlaceNameStructure getCommonName() {
        return commonName;
    }

    /**
     * Sets the value of the commonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public void setCommonName(NaturalLanguagePlaceNameStructure value) {
        this.commonName = value;
    }

    /**
     * Gets the value of the shortCommonName property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public NaturalLanguagePlaceNameStructure getShortCommonName() {
        return shortCommonName;
    }

    /**
     * Sets the value of the shortCommonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public void setShortCommonName(NaturalLanguagePlaceNameStructure value) {
        this.shortCommonName = value;
    }

    /**
     * Gets the value of the landmark property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public NaturalLanguagePlaceNameStructure getLandmark() {
        return landmark;
    }

    /**
     * Sets the value of the landmark property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public void setLandmark(NaturalLanguagePlaceNameStructure value) {
        this.landmark = value;
    }

    /**
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public NaturalLanguagePlaceNameStructure getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public void setStreet(NaturalLanguagePlaceNameStructure value) {
        this.street = value;
    }

    /**
     * Gets the value of the crossing property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public NaturalLanguagePlaceNameStructure getCrossing() {
        return crossing;
    }

    /**
     * Sets the value of the crossing property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public void setCrossing(NaturalLanguagePlaceNameStructure value) {
        this.crossing = value;
    }

    /**
     * Gets the value of the indicator property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public NaturalLanguagePlaceNameStructure getIndicator() {
        return indicator;
    }

    /**
     * Sets the value of the indicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguagePlaceNameStructure }
     *     
     */
    public void setIndicator(NaturalLanguagePlaceNameStructure value) {
        this.indicator = value;
    }

}
