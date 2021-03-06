//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package io.github.andyljones.commutesandrent.model.uk.org.transxchange;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;


/**
 * Interchange between Journey Patterns.
 * 
 * <p>Java class for JourneyPatternInterchangeStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JourneyPatternInterchangeStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.transxchange.org.uk/}CommonInterchangeGroup"/>
 *         &lt;group ref="{http://www.transxchange.org.uk/}JourneyPatternInterchangeGroup"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.transxchange.org.uk/}IdType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JourneyPatternInterchangeStructure", propOrder = {
    "minInterchangeTime",
    "maxInterchangeTime",
    "transferMode",
    "validityPeriod",
    "stoppingArrangements",
    "interchangeActivity",
    "crossBorder",
    "guaranteedConnection",
    "changeLineNumber",
    "inbound",
    "outbound"
})
@XmlSeeAlso({
    io.github.andyljones.commutesandrent.model.uk.org.transxchange.ServiceStructure.JourneyPatternInterchange.class
})
public class JourneyPatternInterchangeStructure {

    @XmlElement(name = "MinInterchangeTime")
    protected Duration minInterchangeTime;
    @XmlElement(name = "MaxInterchangeTime")
    protected Duration maxInterchangeTime;
    @XmlElement(name = "TransferMode", defaultValue = "walk")
    protected AllModesEnumeration transferMode;
    @XmlElement(name = "ValidityPeriod")
    protected HalfOpenDateRangeStructure validityPeriod;
    @XmlElement(name = "StoppingArrangements")
    protected NaturalLanguageStringStructure stoppingArrangements;
    @XmlElement(name = "InterchangeActivity")
    protected InterchangeActivityEnumeration interchangeActivity;
    @XmlElement(name = "CrossBorder", defaultValue = "false")
    protected Boolean crossBorder;
    @XmlElement(name = "GuaranteedConnection", defaultValue = "false")
    protected Boolean guaranteedConnection;
    @XmlElement(name = "ChangeLineNumber", defaultValue = "false")
    protected Boolean changeLineNumber;
    @XmlElement(name = "Inbound", required = true)
    protected JourneyPatternUsageRefStructure inbound;
    @XmlElement(name = "Outbound", required = true)
    protected JourneyPatternUsageRefStructure outbound;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;

    /**
     * Gets the value of the minInterchangeTime property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMinInterchangeTime() {
        return minInterchangeTime;
    }

    /**
     * Sets the value of the minInterchangeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setMinInterchangeTime(Duration value) {
        this.minInterchangeTime = value;
    }

    /**
     * Gets the value of the maxInterchangeTime property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getMaxInterchangeTime() {
        return maxInterchangeTime;
    }

    /**
     * Sets the value of the maxInterchangeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setMaxInterchangeTime(Duration value) {
        this.maxInterchangeTime = value;
    }

    /**
     * Gets the value of the transferMode property.
     * 
     * @return
     *     possible object is
     *     {@link AllModesEnumeration }
     *     
     */
    public AllModesEnumeration getTransferMode() {
        return transferMode;
    }

    /**
     * Sets the value of the transferMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllModesEnumeration }
     *     
     */
    public void setTransferMode(AllModesEnumeration value) {
        this.transferMode = value;
    }

    /**
     * Gets the value of the validityPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link HalfOpenDateRangeStructure }
     *     
     */
    public HalfOpenDateRangeStructure getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Sets the value of the validityPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link HalfOpenDateRangeStructure }
     *     
     */
    public void setValidityPeriod(HalfOpenDateRangeStructure value) {
        this.validityPeriod = value;
    }

    /**
     * Gets the value of the stoppingArrangements property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public NaturalLanguageStringStructure getStoppingArrangements() {
        return stoppingArrangements;
    }

    /**
     * Sets the value of the stoppingArrangements property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public void setStoppingArrangements(NaturalLanguageStringStructure value) {
        this.stoppingArrangements = value;
    }

    /**
     * Gets the value of the interchangeActivity property.
     * 
     * @return
     *     possible object is
     *     {@link InterchangeActivityEnumeration }
     *     
     */
    public InterchangeActivityEnumeration getInterchangeActivity() {
        return interchangeActivity;
    }

    /**
     * Sets the value of the interchangeActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterchangeActivityEnumeration }
     *     
     */
    public void setInterchangeActivity(InterchangeActivityEnumeration value) {
        this.interchangeActivity = value;
    }

    /**
     * Gets the value of the crossBorder property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrossBorder() {
        return crossBorder;
    }

    /**
     * Sets the value of the crossBorder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrossBorder(Boolean value) {
        this.crossBorder = value;
    }

    /**
     * Gets the value of the guaranteedConnection property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGuaranteedConnection() {
        return guaranteedConnection;
    }

    /**
     * Sets the value of the guaranteedConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGuaranteedConnection(Boolean value) {
        this.guaranteedConnection = value;
    }

    /**
     * Gets the value of the changeLineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChangeLineNumber() {
        return changeLineNumber;
    }

    /**
     * Sets the value of the changeLineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChangeLineNumber(Boolean value) {
        this.changeLineNumber = value;
    }

    /**
     * Gets the value of the inbound property.
     * 
     * @return
     *     possible object is
     *     {@link JourneyPatternUsageRefStructure }
     *     
     */
    public JourneyPatternUsageRefStructure getInbound() {
        return inbound;
    }

    /**
     * Sets the value of the inbound property.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyPatternUsageRefStructure }
     *     
     */
    public void setInbound(JourneyPatternUsageRefStructure value) {
        this.inbound = value;
    }

    /**
     * Gets the value of the outbound property.
     * 
     * @return
     *     possible object is
     *     {@link JourneyPatternUsageRefStructure }
     *     
     */
    public JourneyPatternUsageRefStructure getOutbound() {
        return outbound;
    }

    /**
     * Sets the value of the outbound property.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyPatternUsageRefStructure }
     *     
     */
    public void setOutbound(JourneyPatternUsageRefStructure value) {
        this.outbound = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
