//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package io.github.andyljones.commutesandrent.model.uk.org.transxchange;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Classification and description of the bus service. This does not identify the individual bus journeys (defined as part of VehicleJourney)
 * 
 * <p>Java class for ServiceStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceCode" type="{http://www.transxchange.org.uk/}ServiceCodeType"/>
 *         &lt;element name="PrivateCode" type="{http://www.transxchange.org.uk/}PrivateCodeType" minOccurs="0"/>
 *         &lt;element name="Lines">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Line" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="LineName" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="id" type="{http://www.transxchange.org.uk/}IdType" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OperatingPeriod" type="{http://www.transxchange.org.uk/}HalfOpenDateRangeStructure"/>
 *         &lt;element name="OperatingProfile" type="{http://www.transxchange.org.uk/}OperatingProfileStructure" minOccurs="0"/>
 *         &lt;element name="ServiceClassification" type="{http://www.transxchange.org.uk/}ServiceClassificationStructure" minOccurs="0"/>
 *         &lt;element name="TicketMachineServiceCode" type="{http://www.transxchange.org.uk/}TicketMachineServiceCodeType" minOccurs="0"/>
 *         &lt;element name="RegisteredOperatorRef" type="{http://www.transxchange.org.uk/}OperatorRefStructure"/>
 *         &lt;element name="AssociatedOperators" type="{http://www.transxchange.org.uk/}OperatorRoleStructure" minOccurs="0"/>
 *         &lt;group ref="{http://www.transxchange.org.uk/}ServiceInfoGroup"/>
 *         &lt;group ref="{http://www.transxchange.org.uk/}ServiceDescriptionGroup"/>
 *         &lt;group ref="{http://www.transxchange.org.uk/}ServiceComponentGroup"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.transxchange.org.uk/}ModificationDetailsGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceStructure", propOrder = {
    "serviceCode",
    "privateCode",
    "lines",
    "operatingPeriod",
    "operatingProfile",
    "serviceClassification",
    "ticketMachineServiceCode",
    "registeredOperatorRef",
    "associatedOperators",
    "serviceHasMirror",
    "stopRequirements",
    "mode",
    "publicUse",
    "serviceAvailability",
    "express",
    "description",
    "note",
    "schematicMap",
    "toBeMarketedWith",
    "standardService",
    "flexibleService",
    "direction",
    "journeyPatternInterchange"
})
public class ServiceStructure {

    @XmlElement(name = "ServiceCode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String serviceCode;
    @XmlElement(name = "PrivateCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String privateCode;
    @XmlElement(name = "Lines", required = true)
    protected ServiceStructure.Lines lines;
    @XmlElement(name = "OperatingPeriod", required = true)
    protected HalfOpenDateRangeStructure operatingPeriod;
    @XmlElement(name = "OperatingProfile")
    protected OperatingProfileStructure operatingProfile;
    @XmlElement(name = "ServiceClassification")
    protected ServiceClassificationStructure serviceClassification;
    @XmlElement(name = "TicketMachineServiceCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ticketMachineServiceCode;
    @XmlElement(name = "RegisteredOperatorRef", required = true)
    protected OperatorRefStructure registeredOperatorRef;
    @XmlElement(name = "AssociatedOperators")
    protected OperatorRoleStructure associatedOperators;
    @XmlElement(name = "ServiceHasMirror", defaultValue = "false")
    protected Boolean serviceHasMirror;
    @XmlElement(name = "StopRequirements", required = true)
    protected StopRequirementsStructure stopRequirements;
    @XmlElement(name = "Mode", defaultValue = "bus")
    protected VehicleModesEnumeration mode;
    @XmlElement(name = "PublicUse", defaultValue = "true")
    protected Boolean publicUse;
    @XmlElement(name = "ServiceAvailability")
    protected ServiceStructure.ServiceAvailability serviceAvailability;
    @XmlElement(name = "Express", defaultValue = "false")
    protected Boolean express;
    @XmlElement(name = "Description")
    protected NaturalLanguageStringStructure description;
    @XmlElement(name = "Note")
    protected List<NoteStructure> note;
    @XmlElement(name = "SchematicMap")
    protected List<String> schematicMap;
    @XmlElement(name = "ToBeMarketedWith")
    protected ToBeMarketedWithStructure toBeMarketedWith;
    @XmlElement(name = "StandardService")
    protected StandardServiceStructure standardService;
    @XmlElement(name = "FlexibleService")
    protected FlexibleServiceStructure flexibleService;
    @XmlElement(name = "Direction", defaultValue = "outbound")
    protected ServiceVehicleDirectionEnumeration direction;
    @XmlElement(name = "JourneyPatternInterchange")
    protected List<ServiceStructure.JourneyPatternInterchange> journeyPatternInterchange;
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
     * Gets the value of the serviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Sets the value of the serviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Gets the value of the privateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivateCode() {
        return privateCode;
    }

    /**
     * Sets the value of the privateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivateCode(String value) {
        this.privateCode = value;
    }

    /**
     * Gets the value of the lines property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStructure.Lines }
     *     
     */
    public ServiceStructure.Lines getLines() {
        return lines;
    }

    /**
     * Sets the value of the lines property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStructure.Lines }
     *     
     */
    public void setLines(ServiceStructure.Lines value) {
        this.lines = value;
    }

    /**
     * Gets the value of the operatingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link HalfOpenDateRangeStructure }
     *     
     */
    public HalfOpenDateRangeStructure getOperatingPeriod() {
        return operatingPeriod;
    }

    /**
     * Sets the value of the operatingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link HalfOpenDateRangeStructure }
     *     
     */
    public void setOperatingPeriod(HalfOpenDateRangeStructure value) {
        this.operatingPeriod = value;
    }

    /**
     * Gets the value of the operatingProfile property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingProfileStructure }
     *     
     */
    public OperatingProfileStructure getOperatingProfile() {
        return operatingProfile;
    }

    /**
     * Sets the value of the operatingProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingProfileStructure }
     *     
     */
    public void setOperatingProfile(OperatingProfileStructure value) {
        this.operatingProfile = value;
    }

    /**
     * Gets the value of the serviceClassification property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceClassificationStructure }
     *     
     */
    public ServiceClassificationStructure getServiceClassification() {
        return serviceClassification;
    }

    /**
     * Sets the value of the serviceClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceClassificationStructure }
     *     
     */
    public void setServiceClassification(ServiceClassificationStructure value) {
        this.serviceClassification = value;
    }

    /**
     * Gets the value of the ticketMachineServiceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketMachineServiceCode() {
        return ticketMachineServiceCode;
    }

    /**
     * Sets the value of the ticketMachineServiceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketMachineServiceCode(String value) {
        this.ticketMachineServiceCode = value;
    }

    /**
     * Gets the value of the registeredOperatorRef property.
     * 
     * @return
     *     possible object is
     *     {@link OperatorRefStructure }
     *     
     */
    public OperatorRefStructure getRegisteredOperatorRef() {
        return registeredOperatorRef;
    }

    /**
     * Sets the value of the registeredOperatorRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatorRefStructure }
     *     
     */
    public void setRegisteredOperatorRef(OperatorRefStructure value) {
        this.registeredOperatorRef = value;
    }

    /**
     * Gets the value of the associatedOperators property.
     * 
     * @return
     *     possible object is
     *     {@link OperatorRoleStructure }
     *     
     */
    public OperatorRoleStructure getAssociatedOperators() {
        return associatedOperators;
    }

    /**
     * Sets the value of the associatedOperators property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatorRoleStructure }
     *     
     */
    public void setAssociatedOperators(OperatorRoleStructure value) {
        this.associatedOperators = value;
    }

    /**
     * Gets the value of the serviceHasMirror property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isServiceHasMirror() {
        return serviceHasMirror;
    }

    /**
     * Sets the value of the serviceHasMirror property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setServiceHasMirror(Boolean value) {
        this.serviceHasMirror = value;
    }

    /**
     * Gets the value of the stopRequirements property.
     * 
     * @return
     *     possible object is
     *     {@link StopRequirementsStructure }
     *     
     */
    public StopRequirementsStructure getStopRequirements() {
        return stopRequirements;
    }

    /**
     * Sets the value of the stopRequirements property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopRequirementsStructure }
     *     
     */
    public void setStopRequirements(StopRequirementsStructure value) {
        this.stopRequirements = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleModesEnumeration }
     *     
     */
    public VehicleModesEnumeration getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleModesEnumeration }
     *     
     */
    public void setMode(VehicleModesEnumeration value) {
        this.mode = value;
    }

    /**
     * Gets the value of the publicUse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPublicUse() {
        return publicUse;
    }

    /**
     * Sets the value of the publicUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPublicUse(Boolean value) {
        this.publicUse = value;
    }

    /**
     * Gets the value of the serviceAvailability property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStructure.ServiceAvailability }
     *     
     */
    public ServiceStructure.ServiceAvailability getServiceAvailability() {
        return serviceAvailability;
    }

    /**
     * Sets the value of the serviceAvailability property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStructure.ServiceAvailability }
     *     
     */
    public void setServiceAvailability(ServiceStructure.ServiceAvailability value) {
        this.serviceAvailability = value;
    }

    /**
     * Gets the value of the express property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExpress() {
        return express;
    }

    /**
     * Sets the value of the express property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExpress(Boolean value) {
        this.express = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public NaturalLanguageStringStructure getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageStringStructure }
     *     
     */
    public void setDescription(NaturalLanguageStringStructure value) {
        this.description = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteStructure }
     * 
     * 
     */
    public List<NoteStructure> getNote() {
        if (note == null) {
            note = new ArrayList<NoteStructure>();
        }
        return this.note;
    }

    /**
     * Gets the value of the schematicMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schematicMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchematicMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSchematicMap() {
        if (schematicMap == null) {
            schematicMap = new ArrayList<String>();
        }
        return this.schematicMap;
    }

    /**
     * Gets the value of the toBeMarketedWith property.
     * 
     * @return
     *     possible object is
     *     {@link ToBeMarketedWithStructure }
     *     
     */
    public ToBeMarketedWithStructure getToBeMarketedWith() {
        return toBeMarketedWith;
    }

    /**
     * Sets the value of the toBeMarketedWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToBeMarketedWithStructure }
     *     
     */
    public void setToBeMarketedWith(ToBeMarketedWithStructure value) {
        this.toBeMarketedWith = value;
    }

    /**
     * Gets the value of the standardService property.
     * 
     * @return
     *     possible object is
     *     {@link StandardServiceStructure }
     *     
     */
    public StandardServiceStructure getStandardService() {
        return standardService;
    }

    /**
     * Sets the value of the standardService property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardServiceStructure }
     *     
     */
    public void setStandardService(StandardServiceStructure value) {
        this.standardService = value;
    }

    /**
     * Gets the value of the flexibleService property.
     * 
     * @return
     *     possible object is
     *     {@link FlexibleServiceStructure }
     *     
     */
    public FlexibleServiceStructure getFlexibleService() {
        return flexibleService;
    }

    /**
     * Sets the value of the flexibleService property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlexibleServiceStructure }
     *     
     */
    public void setFlexibleService(FlexibleServiceStructure value) {
        this.flexibleService = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceVehicleDirectionEnumeration }
     *     
     */
    public ServiceVehicleDirectionEnumeration getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceVehicleDirectionEnumeration }
     *     
     */
    public void setDirection(ServiceVehicleDirectionEnumeration value) {
        this.direction = value;
    }

    /**
     * Gets the value of the journeyPatternInterchange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the journeyPatternInterchange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJourneyPatternInterchange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceStructure.JourneyPatternInterchange }
     * 
     * 
     */
    public List<ServiceStructure.JourneyPatternInterchange> getJourneyPatternInterchange() {
        if (journeyPatternInterchange == null) {
            journeyPatternInterchange = new ArrayList<ServiceStructure.JourneyPatternInterchange>();
        }
        return this.journeyPatternInterchange;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.transxchange.org.uk/}JourneyPatternInterchangeStructure">
     *       &lt;attGroup ref="{http://www.transxchange.org.uk/}ModificationDetailsGroup"/>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class JourneyPatternInterchange
        extends JourneyPatternInterchangeStructure
    {

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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Line" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="LineName" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="id" type="{http://www.transxchange.org.uk/}IdType" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "line"
    })
    public static class Lines {

        @XmlElement(name = "Line", required = true)
        protected List<ServiceStructure.Lines.Line> line;

        /**
         * Gets the value of the line property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the line property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ServiceStructure.Lines.Line }
         * 
         * 
         */
        public List<ServiceStructure.Lines.Line> getLine() {
            if (line == null) {
                line = new ArrayList<ServiceStructure.Lines.Line>();
            }
            return this.line;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="LineName" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure"/>
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
        @XmlType(name = "", propOrder = {
            "lineName"
        })
        public static class Line {

            @XmlElement(name = "LineName", required = true)
            protected NaturalLanguageStringStructure lineName;
            @XmlAttribute(name = "id")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String id;

            /**
             * Gets the value of the lineName property.
             * 
             * @return
             *     possible object is
             *     {@link NaturalLanguageStringStructure }
             *     
             */
            public NaturalLanguageStringStructure getLineName() {
                return lineName;
            }

            /**
             * Sets the value of the lineName property.
             * 
             * @param value
             *     allowed object is
             *     {@link NaturalLanguageStringStructure }
             *     
             */
            public void setLineName(NaturalLanguageStringStructure value) {
                this.lineName = value;
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;choice>
     *           &lt;choice>
     *             &lt;element name="Daytime" type="{http://www.transxchange.org.uk/}EmptyType"/>
     *             &lt;element name="Peak" type="{http://www.transxchange.org.uk/}EmptyType"/>
     *             &lt;element name="OffPeak" type="{http://www.transxchange.org.uk/}EmptyType"/>
     *           &lt;/choice>
     *           &lt;element name="Night" type="{http://www.transxchange.org.uk/}EmptyType"/>
     *         &lt;/choice>
     *         &lt;element name="TwentyFourHour" type="{http://www.transxchange.org.uk/}EmptyType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "daytime",
        "peak",
        "offPeak",
        "night",
        "twentyFourHour"
    })
    public static class ServiceAvailability {

        @XmlElement(name = "Daytime")
        protected String daytime;
        @XmlElement(name = "Peak")
        protected String peak;
        @XmlElement(name = "OffPeak")
        protected String offPeak;
        @XmlElement(name = "Night")
        protected String night;
        @XmlElement(name = "TwentyFourHour")
        protected String twentyFourHour;

        /**
         * Gets the value of the daytime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDaytime() {
            return daytime;
        }

        /**
         * Sets the value of the daytime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDaytime(String value) {
            this.daytime = value;
        }

        /**
         * Gets the value of the peak property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPeak() {
            return peak;
        }

        /**
         * Sets the value of the peak property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPeak(String value) {
            this.peak = value;
        }

        /**
         * Gets the value of the offPeak property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOffPeak() {
            return offPeak;
        }

        /**
         * Sets the value of the offPeak property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOffPeak(String value) {
            this.offPeak = value;
        }

        /**
         * Gets the value of the night property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNight() {
            return night;
        }

        /**
         * Sets the value of the night property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNight(String value) {
            this.night = value;
        }

        /**
         * Gets the value of the twentyFourHour property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTwentyFourHour() {
            return twentyFourHour;
        }

        /**
         * Sets the value of the twentyFourHour property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTwentyFourHour(String value) {
            this.twentyFourHour = value;
        }

    }

}