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
 * The ShortNoticeRegistration caters for a local holiday and involves a change of no more than 14 days.
 * 
 * <p>Java class for LocalHolidayChangeStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocalHolidayChangeStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LocalHolidayNote" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalHolidayChangeStructure", propOrder = {
    "localHolidayNote"
})
public class LocalHolidayChangeStructure {

    @XmlElement(name = "LocalHolidayNote", required = true)
    protected NaturalLanguageStringStructure localHolidayNote;

    /**
     * Gets the value of the localHolidayNote property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public NaturalLanguageStringStructure getLocalHolidayNote() {
        return localHolidayNote;
    }

    /**
     * Sets the value of the localHolidayNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public void setLocalHolidayNote(NaturalLanguageStringStructure value) {
        this.localHolidayNote = value;
    }

}
