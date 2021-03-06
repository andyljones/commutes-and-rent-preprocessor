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
 * A change to an altered connected service justifies the ShortNoticeRegistration.
 * 
 * <p>Java class for ChangeToConnectAlteredServiceStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeToConnectAlteredServiceStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlteredServiceRequiringConnection" type="{http://www.transxchange.org.uk/}AnnotatedServiceRefStructure"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeToConnectAlteredServiceStructure", propOrder = {
    "alteredServiceRequiringConnection"
})
public class ChangeToConnectAlteredServiceStructure {

    @XmlElement(name = "AlteredServiceRequiringConnection", required = true)
    protected AnnotatedServiceRefStructure alteredServiceRequiringConnection;

    /**
     * Gets the value of the alteredServiceRequiringConnection property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotatedServiceRefStructure }
     *     
     */
    public AnnotatedServiceRefStructure getAlteredServiceRequiringConnection() {
        return alteredServiceRequiringConnection;
    }

    /**
     * Sets the value of the alteredServiceRequiringConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotatedServiceRefStructure }
     *     
     */
    public void setAlteredServiceRequiringConnection(AnnotatedServiceRefStructure value) {
        this.alteredServiceRequiringConnection = value;
    }

}
