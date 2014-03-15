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
 * Data type for a child reference to a stop area that is defined elsewhere using a StopAreaStructure. The reference is by area code.
 * 
 * <p>Java class for StopAreaWrappedRefStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StopAreaWrappedRefStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StopAreaRef" type="{http://www.transxchange.org.uk/}StopAreaRefStructure"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StopAreaWrappedRefStructure", propOrder = {
    "stopAreaRef"
})
public class StopAreaWrappedRefStructure {

    @XmlElement(name = "StopAreaRef", required = true)
    protected StopAreaRefStructure stopAreaRef;

    /**
     * Gets the value of the stopAreaRef property.
     * 
     * @return
     *     possible object is
     *     {@link StopAreaRefStructure }
     *     
     */
    public StopAreaRefStructure getStopAreaRef() {
        return stopAreaRef;
    }

    /**
     * Sets the value of the stopAreaRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link StopAreaRefStructure }
     *     
     */
    public void setStopAreaRef(StopAreaRefStructure value) {
        this.stopAreaRef = value;
    }

}