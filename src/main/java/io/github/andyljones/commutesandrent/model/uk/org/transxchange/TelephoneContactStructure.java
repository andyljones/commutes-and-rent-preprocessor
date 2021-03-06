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
import javax.xml.bind.annotation.XmlType;


/**
 * A telephone number, using GovTalk constructs.
 * 
 * <p>Java class for TelephoneContactStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TelephoneContactStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TelNationalNumber" type="{http://www.govtalk.gov.uk/core}TelephoneNumberType"/>
 *         &lt;element name="TelExtensionNumber" type="{http://www.govtalk.gov.uk/core}TelephoneExtensionType" minOccurs="0"/>
 *         &lt;element name="TelCountryCode" type="{http://www.govtalk.gov.uk/core}TelCountryCodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelephoneContactStructure", propOrder = {
    "telNationalNumber",
    "telExtensionNumber",
    "telCountryCode"
})
public class TelephoneContactStructure {

    @XmlElement(name = "TelNationalNumber", required = true)
    protected String telNationalNumber;
    @XmlElement(name = "TelExtensionNumber")
    protected String telExtensionNumber;
    @XmlElement(name = "TelCountryCode")
    protected String telCountryCode;

    /**
     * Gets the value of the telNationalNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelNationalNumber() {
        return telNationalNumber;
    }

    /**
     * Sets the value of the telNationalNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelNationalNumber(String value) {
        this.telNationalNumber = value;
    }

    /**
     * Gets the value of the telExtensionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelExtensionNumber() {
        return telExtensionNumber;
    }

    /**
     * Sets the value of the telExtensionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelExtensionNumber(String value) {
        this.telExtensionNumber = value;
    }

    /**
     * Gets the value of the telCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelCountryCode() {
        return telCountryCode;
    }

    /**
     * Sets the value of the telCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelCountryCode(String value) {
        this.telCountryCode = value;
    }

}
