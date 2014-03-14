//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:51:42 PM GMT 
//


package uk.org.naptan;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies hours of opening on a specified day.
 * 
 * <p>Java class for DailyOpeningHoursStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DailyOpeningHoursStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="TwentyFourHours" type="{http://www.naptan.org.uk/}EmptyType"/>
 *         &lt;element name="OpenPeriod" type="{http://www.naptan.org.uk/}ClosedTimeRangeStructure" maxOccurs="unbounded"/>
 *         &lt;element name="Unavailable" type="{http://www.naptan.org.uk/}EmptyType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DailyOpeningHoursStructure", propOrder = {
    "twentyFourHours",
    "openPeriod",
    "unavailable"
})
public class DailyOpeningHoursStructure {

    @XmlElement(name = "TwentyFourHours")
    protected String twentyFourHours;
    @XmlElement(name = "OpenPeriod")
    protected List<ClosedTimeRangeStructure> openPeriod;
    @XmlElement(name = "Unavailable")
    protected String unavailable;

    /**
     * Gets the value of the twentyFourHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTwentyFourHours() {
        return twentyFourHours;
    }

    /**
     * Sets the value of the twentyFourHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTwentyFourHours(String value) {
        this.twentyFourHours = value;
    }

    /**
     * Gets the value of the openPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the openPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpenPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClosedTimeRangeStructure }
     * 
     * 
     */
    public List<ClosedTimeRangeStructure> getOpenPeriod() {
        if (openPeriod == null) {
            openPeriod = new ArrayList<ClosedTimeRangeStructure>();
        }
        return this.openPeriod;
    }

    /**
     * Gets the value of the unavailable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnavailable() {
        return unavailable;
    }

    /**
     * Sets the value of the unavailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnavailable(String value) {
        this.unavailable = value;
    }

}
