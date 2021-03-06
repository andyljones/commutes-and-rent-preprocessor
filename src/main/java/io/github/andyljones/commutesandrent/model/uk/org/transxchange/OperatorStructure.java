//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package io.github.andyljones.commutesandrent.model.uk.org.transxchange;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * A transport operator.
 * 
 * <p>Java class for OperatorStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperatorStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NationalOperatorCode" type="{http://www.transxchange.org.uk/}NationalOperatorCodeType" minOccurs="0"/>
 *         &lt;element name="OperatorCode" type="{http://www.transxchange.org.uk/}OperatorCodeType" minOccurs="0"/>
 *         &lt;element name="OperatorShortName" type="{http://www.transxchange.org.uk/}OperatorShortNameType"/>
 *         &lt;element name="OperatorNameOnLicence" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure" minOccurs="0"/>
 *         &lt;element name="TradingName" type="{http://www.transxchange.org.uk/}OperatorTradingNameType" minOccurs="0"/>
 *         &lt;element name="LicenceNumber" type="{http://www.transxchange.org.uk/}OperatorLicenceNumberType" minOccurs="0"/>
 *         &lt;element name="LicenceClassification" type="{http://www.transxchange.org.uk/}OperatorLicenceEnumeration" minOccurs="0"/>
 *         &lt;group ref="{http://www.transxchange.org.uk/}OperatorContactGroup"/>
 *         &lt;element name="Garages" type="{http://www.transxchange.org.uk/}GaragesStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.transxchange.org.uk/}ModificationDetailsGroup"/>
 *       &lt;attribute name="id" type="{http://www.transxchange.org.uk/}IdType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperatorStructure", propOrder = {
    "nationalOperatorCode",
    "operatorCode",
    "operatorShortName",
    "operatorNameOnLicence",
    "tradingName",
    "licenceNumber",
    "licenceClassification",
    "enquiryTelephoneNumber",
    "contactTelephoneNumber",
    "operatorAddresses",
    "emailAddress",
    "garages"
})
@XmlSeeAlso({
    LicensedOperatorStructure.class
})
public class OperatorStructure {

    @XmlElement(name = "NationalOperatorCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nationalOperatorCode;
    @XmlElement(name = "OperatorCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String operatorCode;
    @XmlElement(name = "OperatorShortName", required = true)
    protected String operatorShortName;
    @XmlElement(name = "OperatorNameOnLicence")
    protected NaturalLanguageStringStructure operatorNameOnLicence;
    @XmlElement(name = "TradingName")
    protected String tradingName;
    @XmlElement(name = "LicenceNumber")
    protected String licenceNumber;
    @XmlElement(name = "LicenceClassification")
    protected OperatorLicenceEnumeration licenceClassification;
    @XmlElement(name = "EnquiryTelephoneNumber")
    protected TelephoneContactStructure enquiryTelephoneNumber;
    @XmlElement(name = "ContactTelephoneNumber")
    protected TelephoneContactStructure contactTelephoneNumber;
    @XmlElement(name = "OperatorAddresses")
    protected OperatorAddressesStructure operatorAddresses;
    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "Garages")
    protected GaragesStructure garages;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    @XmlAttribute(name = "CreationDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDateTime;
    @XmlAttribute(name = "ModificationDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modificationDateTime;
    @XmlAttribute(name = "Modification")
    protected ModificationEnumeration modification;
    @XmlAttribute(name = "RevisionNumber")
    protected BigInteger revisionNumber;
    @XmlAttribute(name = "Status")
    protected StatusEnumeration status;

    /**
     * Gets the value of the nationalOperatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalOperatorCode() {
        return nationalOperatorCode;
    }

    /**
     * Sets the value of the nationalOperatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalOperatorCode(String value) {
        this.nationalOperatorCode = value;
    }

    /**
     * Gets the value of the operatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     * Sets the value of the operatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorCode(String value) {
        this.operatorCode = value;
    }

    /**
     * Gets the value of the operatorShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorShortName() {
        return operatorShortName;
    }

    /**
     * Sets the value of the operatorShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorShortName(String value) {
        this.operatorShortName = value;
    }

    /**
     * Gets the value of the operatorNameOnLicence property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public NaturalLanguageStringStructure getOperatorNameOnLicence() {
        return operatorNameOnLicence;
    }

    /**
     * Sets the value of the operatorNameOnLicence property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public void setOperatorNameOnLicence(NaturalLanguageStringStructure value) {
        this.operatorNameOnLicence = value;
    }

    /**
     * Gets the value of the tradingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradingName() {
        return tradingName;
    }

    /**
     * Sets the value of the tradingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradingName(String value) {
        this.tradingName = value;
    }

    /**
     * Gets the value of the licenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenceNumber() {
        return licenceNumber;
    }

    /**
     * Sets the value of the licenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenceNumber(String value) {
        this.licenceNumber = value;
    }

    /**
     * Gets the value of the licenceClassification property.
     * 
     * @return
     *     possible object is
     *     {@link OperatorLicenceEnumeration }
     *     
     */
    public OperatorLicenceEnumeration getLicenceClassification() {
        return licenceClassification;
    }

    /**
     * Sets the value of the licenceClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatorLicenceEnumeration }
     *     
     */
    public void setLicenceClassification(OperatorLicenceEnumeration value) {
        this.licenceClassification = value;
    }

    /**
     * Gets the value of the enquiryTelephoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneContactStructure }
     *     
     */
    public TelephoneContactStructure getEnquiryTelephoneNumber() {
        return enquiryTelephoneNumber;
    }

    /**
     * Sets the value of the enquiryTelephoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneContactStructure }
     *     
     */
    public void setEnquiryTelephoneNumber(TelephoneContactStructure value) {
        this.enquiryTelephoneNumber = value;
    }

    /**
     * Gets the value of the contactTelephoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneContactStructure }
     *     
     */
    public TelephoneContactStructure getContactTelephoneNumber() {
        return contactTelephoneNumber;
    }

    /**
     * Sets the value of the contactTelephoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneContactStructure }
     *     
     */
    public void setContactTelephoneNumber(TelephoneContactStructure value) {
        this.contactTelephoneNumber = value;
    }

    /**
     * Gets the value of the operatorAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link OperatorAddressesStructure }
     *     
     */
    public OperatorAddressesStructure getOperatorAddresses() {
        return operatorAddresses;
    }

    /**
     * Sets the value of the operatorAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatorAddressesStructure }
     *     
     */
    public void setOperatorAddresses(OperatorAddressesStructure value) {
        this.operatorAddresses = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the garages property.
     * 
     * @return
     *     possible object is
     *     {@link GaragesStructure }
     *     
     */
    public GaragesStructure getGarages() {
        return garages;
    }

    /**
     * Sets the value of the garages property.
     * 
     * @param value
     *     allowed object is
     *     {@link GaragesStructure }
     *     
     */
    public void setGarages(GaragesStructure value) {
        this.garages = value;
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

    /**
     * Gets the value of the creationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Sets the value of the creationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDateTime(XMLGregorianCalendar value) {
        this.creationDateTime = value;
    }

    /**
     * Gets the value of the modificationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModificationDateTime() {
        return modificationDateTime;
    }

    /**
     * Sets the value of the modificationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModificationDateTime(XMLGregorianCalendar value) {
        this.modificationDateTime = value;
    }

    /**
     * Gets the value of the modification property.
     * 
     * @return
     *     possible object is
     *     {@link ModificationEnumeration }
     *     
     */
    public ModificationEnumeration getModification() {
        if (modification == null) {
            return ModificationEnumeration.NEW;
        } else {
            return modification;
        }
    }

    /**
     * Sets the value of the modification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModificationEnumeration }
     *     
     */
    public void setModification(ModificationEnumeration value) {
        this.modification = value;
    }

    /**
     * Gets the value of the revisionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRevisionNumber() {
        return revisionNumber;
    }

    /**
     * Sets the value of the revisionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRevisionNumber(BigInteger value) {
        this.revisionNumber = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusEnumeration }
     *     
     */
    public StatusEnumeration getStatus() {
        if (status == null) {
            return StatusEnumeration.ACTIVE;
        } else {
            return status;
        }
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusEnumeration }
     *     
     */
    public void setStatus(StatusEnumeration value) {
        this.status = value;
    }

}
