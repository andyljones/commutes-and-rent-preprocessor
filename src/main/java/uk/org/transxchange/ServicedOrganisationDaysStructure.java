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
 * Working days and holidays for a collection of serviced organisations.
 * 
 * <p>Java class for ServicedOrganisationDaysStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServicedOrganisationDaysStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WorkingDays" type="{http://www.transxchange.org.uk/}ServicedOrganisationRefsStructure" minOccurs="0"/>
 *         &lt;element name="Holidays" type="{http://www.transxchange.org.uk/}ServicedOrganisationRefsStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicedOrganisationDaysStructure", propOrder = {
    "workingDays",
    "holidays"
})
public class ServicedOrganisationDaysStructure {

    @XmlElement(name = "WorkingDays")
    protected ServicedOrganisationRefsStructure workingDays;
    @XmlElement(name = "Holidays")
    protected ServicedOrganisationRefsStructure holidays;

    /**
     * Gets the value of the workingDays property.
     * 
     * @return
     *     possible object is
     *     {@link ServicedOrganisationRefsStructure }
     *     
     */
    public ServicedOrganisationRefsStructure getWorkingDays() {
        return workingDays;
    }

    /**
     * Sets the value of the workingDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicedOrganisationRefsStructure }
     *     
     */
    public void setWorkingDays(ServicedOrganisationRefsStructure value) {
        this.workingDays = value;
    }

    /**
     * Gets the value of the holidays property.
     * 
     * @return
     *     possible object is
     *     {@link ServicedOrganisationRefsStructure }
     *     
     */
    public ServicedOrganisationRefsStructure getHolidays() {
        return holidays;
    }

    /**
     * Sets the value of the holidays property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicedOrganisationRefsStructure }
     *     
     */
    public void setHolidays(ServicedOrganisationRefsStructure value) {
        this.holidays = value;
    }

}