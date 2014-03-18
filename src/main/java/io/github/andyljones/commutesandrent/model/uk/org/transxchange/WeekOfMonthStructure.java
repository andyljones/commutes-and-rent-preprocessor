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
 * Description of week within a calendar month i.e. is the week the 1st, 2nd, 3rd, 4th, 5th or last week of the calendar month.
 * 
 * <p>Java class for WeekOfMonthStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WeekOfMonthStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WeekNumber" type="{http://www.transxchange.org.uk/}WeekInMonthEnumeration"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeekOfMonthStructure", propOrder = {
    "weekNumber"
})
public class WeekOfMonthStructure {

    @XmlElement(name = "WeekNumber", required = true)
    protected WeekInMonthEnumeration weekNumber;

    /**
     * Gets the value of the weekNumber property.
     * 
     * @return
     *     possible object is
     *     {@link WeekInMonthEnumeration }
     *     
     */
    public WeekInMonthEnumeration getWeekNumber() {
        return weekNumber;
    }

    /**
     * Sets the value of the weekNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeekInMonthEnumeration }
     *     
     */
    public void setWeekNumber(WeekInMonthEnumeration value) {
        this.weekNumber = value;
    }

}