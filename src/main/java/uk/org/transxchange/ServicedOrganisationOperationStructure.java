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
 * The operation or non-operation of the journey or service is determined by the pattern of working days and holidays of specified serviced organisations. ServicedOrganisationOperation overrides the OperatingProfile days given by Regular Days and Periodic elements. Note that where SpecialDaysOperation or BankHolidayOperation are defined, these override the definition within ServicedOrganisationOperation.
 * 
 * <p>Java class for ServicedOrganisationOperationStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServicedOrganisationOperationStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DaysOfOperation" type="{http://www.transxchange.org.uk/}ServicedOrganisationDaysStructure" minOccurs="0"/>
 *         &lt;element name="DaysOfNonOperation" type="{http://www.transxchange.org.uk/}ServicedOrganisationDaysStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicedOrganisationOperationStructure", propOrder = {
    "daysOfOperation",
    "daysOfNonOperation"
})
public class ServicedOrganisationOperationStructure {

    @XmlElement(name = "DaysOfOperation")
    protected ServicedOrganisationDaysStructure daysOfOperation;
    @XmlElement(name = "DaysOfNonOperation")
    protected ServicedOrganisationDaysStructure daysOfNonOperation;

    /**
     * Gets the value of the daysOfOperation property.
     * 
     * @return
     *     possible object is
     *     {@link ServicedOrganisationDaysStructure }
     *     
     */
    public ServicedOrganisationDaysStructure getDaysOfOperation() {
        return daysOfOperation;
    }

    /**
     * Sets the value of the daysOfOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicedOrganisationDaysStructure }
     *     
     */
    public void setDaysOfOperation(ServicedOrganisationDaysStructure value) {
        this.daysOfOperation = value;
    }

    /**
     * Gets the value of the daysOfNonOperation property.
     * 
     * @return
     *     possible object is
     *     {@link ServicedOrganisationDaysStructure }
     *     
     */
    public ServicedOrganisationDaysStructure getDaysOfNonOperation() {
        return daysOfNonOperation;
    }

    /**
     * Sets the value of the daysOfNonOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicedOrganisationDaysStructure }
     *     
     */
    public void setDaysOfNonOperation(ServicedOrganisationDaysStructure value) {
        this.daysOfNonOperation = value;
    }

}
