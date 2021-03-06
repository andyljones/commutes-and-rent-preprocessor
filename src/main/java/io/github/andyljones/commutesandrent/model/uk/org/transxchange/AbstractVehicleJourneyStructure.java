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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Defines the structure that is common between VehicleJourneyStructure and FlexibleVehicleJourneyStructure.
 * @CreationDateTime,
 * @ModificationDateTime,
 * @Modification,
 * @RevisionNumber.
 * 
 * <p>Java class for AbstractVehicleJourneyStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractVehicleJourneyStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.transxchange.org.uk/}AbstractServicePatternStructure">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.transxchange.org.uk/}VehicleJourneyGroup"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractVehicleJourneyStructure", propOrder = {
    "vehicleJourneyCode",
    "serviceRef",
    "lineRef",
    "journeyPatternRef",
    "vehicleJourneyRef",
    "startDeadRun",
    "endDeadRun",
    "vehicleJourneyInterchange",
    "note"
})
@XmlSeeAlso({
    FlexibleVehicleJourneyStructure.class,
    VehicleJourneyStructure.class
})
public class AbstractVehicleJourneyStructure
    extends AbstractServicePatternStructure
{

    @XmlElement(name = "VehicleJourneyCode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String vehicleJourneyCode;
    @XmlElement(name = "ServiceRef", required = true)
    protected ServiceRefStructure serviceRef;
    @XmlElement(name = "LineRef", required = true)
    protected LineRefStructure lineRef;
    @XmlElement(name = "JourneyPatternRef")
    protected JourneyPatternRefStructure journeyPatternRef;
    @XmlElement(name = "VehicleJourneyRef")
    protected VehicleJourneyRefStructure vehicleJourneyRef;
    @XmlElement(name = "StartDeadRun")
    protected DeadRunStructure startDeadRun;
    @XmlElement(name = "EndDeadRun")
    protected DeadRunStructure endDeadRun;
    @XmlElement(name = "VehicleJourneyInterchange")
    protected List<AbstractVehicleJourneyStructure.VehicleJourneyInterchange> vehicleJourneyInterchange;
    @XmlElement(name = "Note")
    protected List<NoteStructure> note;
    @XmlAttribute(name = "SequenceNumber")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger sequenceNumber;

    /**
     * Gets the value of the vehicleJourneyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehicleJourneyCode() {
        return vehicleJourneyCode;
    }

    /**
     * Sets the value of the vehicleJourneyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehicleJourneyCode(String value) {
        this.vehicleJourneyCode = value;
    }

    /**
     * Gets the value of the serviceRef property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRefStructure }
     *     
     */
    public ServiceRefStructure getServiceRef() {
        return serviceRef;
    }

    /**
     * Sets the value of the serviceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRefStructure }
     *     
     */
    public void setServiceRef(ServiceRefStructure value) {
        this.serviceRef = value;
    }

    /**
     * Gets the value of the lineRef property.
     * 
     * @return
     *     possible object is
     *     {@link LineRefStructure }
     *     
     */
    public LineRefStructure getLineRef() {
        return lineRef;
    }

    /**
     * Sets the value of the lineRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineRefStructure }
     *     
     */
    public void setLineRef(LineRefStructure value) {
        this.lineRef = value;
    }

    /**
     * Gets the value of the journeyPatternRef property.
     * 
     * @return
     *     possible object is
     *     {@link JourneyPatternRefStructure }
     *     
     */
    public JourneyPatternRefStructure getJourneyPatternRef() {
        return journeyPatternRef;
    }

    /**
     * Sets the value of the journeyPatternRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyPatternRefStructure }
     *     
     */
    public void setJourneyPatternRef(JourneyPatternRefStructure value) {
        this.journeyPatternRef = value;
    }

    /**
     * Gets the value of the vehicleJourneyRef property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleJourneyRefStructure }
     *     
     */
    public VehicleJourneyRefStructure getVehicleJourneyRef() {
        return vehicleJourneyRef;
    }

    /**
     * Sets the value of the vehicleJourneyRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleJourneyRefStructure }
     *     
     */
    public void setVehicleJourneyRef(VehicleJourneyRefStructure value) {
        this.vehicleJourneyRef = value;
    }

    /**
     * Gets the value of the startDeadRun property.
     * 
     * @return
     *     possible object is
     *     {@link DeadRunStructure }
     *     
     */
    public DeadRunStructure getStartDeadRun() {
        return startDeadRun;
    }

    /**
     * Sets the value of the startDeadRun property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeadRunStructure }
     *     
     */
    public void setStartDeadRun(DeadRunStructure value) {
        this.startDeadRun = value;
    }

    /**
     * Gets the value of the endDeadRun property.
     * 
     * @return
     *     possible object is
     *     {@link DeadRunStructure }
     *     
     */
    public DeadRunStructure getEndDeadRun() {
        return endDeadRun;
    }

    /**
     * Sets the value of the endDeadRun property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeadRunStructure }
     *     
     */
    public void setEndDeadRun(DeadRunStructure value) {
        this.endDeadRun = value;
    }

    /**
     * Gets the value of the vehicleJourneyInterchange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleJourneyInterchange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleJourneyInterchange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractVehicleJourneyStructure.VehicleJourneyInterchange }
     * 
     * 
     */
    public List<AbstractVehicleJourneyStructure.VehicleJourneyInterchange> getVehicleJourneyInterchange() {
        if (vehicleJourneyInterchange == null) {
            vehicleJourneyInterchange = new ArrayList<AbstractVehicleJourneyStructure.VehicleJourneyInterchange>();
        }
        return this.vehicleJourneyInterchange;
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
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSequenceNumber(BigInteger value) {
        this.sequenceNumber = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.transxchange.org.uk/}VehicleJourneyInterchangeStructure">
     *       &lt;attGroup ref="{http://www.transxchange.org.uk/}ModificationDetailsGroup"/>
     *       &lt;attribute name="id" type="{http://www.transxchange.org.uk/}IdType" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VehicleJourneyInterchange
        extends VehicleJourneyInterchangeStructure
    {

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

}
