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
 * The change has been requested by an external authority such as the Police. Applies only to short notice registrations.
 * 
 * <p>Java class for ChangeRequestedByExternalAuthorityStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeRequestedByExternalAuthorityStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChangeRequestDescription" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeRequestedByExternalAuthorityStructure", propOrder = {
    "changeRequestDescription"
})
public class ChangeRequestedByExternalAuthorityStructure {

    @XmlElement(name = "ChangeRequestDescription", required = true)
    protected NaturalLanguageStringStructure changeRequestDescription;

    /**
     * Gets the value of the changeRequestDescription property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public NaturalLanguageStringStructure getChangeRequestDescription() {
        return changeRequestDescription;
    }

    /**
     * Sets the value of the changeRequestDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public void setChangeRequestDescription(NaturalLanguageStringStructure value) {
        this.changeRequestDescription = value;
    }

}
