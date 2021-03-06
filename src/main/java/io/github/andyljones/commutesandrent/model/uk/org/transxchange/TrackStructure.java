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
 * A track describes a piece of the path of a route link that can be projected onto the geospatial model. The choice of how route links are divided into tracks is left to TransXChange implementors. For example, a major road junction might represent the end of one track and the beginning of the next.
 * 
 * <p>Java class for TrackStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrackStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mapping" type="{http://www.transxchange.org.uk/}LineStringStructure"/>
 *         &lt;element name="MapSystemReference" type="{http://www.transxchange.org.uk/}MapSystemReferenceStructure" minOccurs="0"/>
 *         &lt;element name="Instructions" type="{http://www.transxchange.org.uk/}TrackInstructionsStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackStructure", propOrder = {
    "mapping",
    "mapSystemReference",
    "instructions"
})
public class TrackStructure {

    @XmlElement(name = "Mapping", required = true)
    protected LineStringStructure mapping;
    @XmlElement(name = "MapSystemReference")
    protected MapSystemReferenceStructure mapSystemReference;
    @XmlElement(name = "Instructions")
    protected TrackInstructionsStructure instructions;

    /**
     * Gets the value of the mapping property.
     * 
     * @return
     *     possible object is
     *     {@link LineStringStructure }
     *     
     */
    public LineStringStructure getMapping() {
        return mapping;
    }

    /**
     * Sets the value of the mapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineStringStructure }
     *     
     */
    public void setMapping(LineStringStructure value) {
        this.mapping = value;
    }

    /**
     * Gets the value of the mapSystemReference property.
     * 
     * @return
     *     possible object is
     *     {@link MapSystemReferenceStructure }
     *     
     */
    public MapSystemReferenceStructure getMapSystemReference() {
        return mapSystemReference;
    }

    /**
     * Sets the value of the mapSystemReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapSystemReferenceStructure }
     *     
     */
    public void setMapSystemReference(MapSystemReferenceStructure value) {
        this.mapSystemReference = value;
    }

    /**
     * Gets the value of the instructions property.
     * 
     * @return
     *     possible object is
     *     {@link TrackInstructionsStructure }
     *     
     */
    public TrackInstructionsStructure getInstructions() {
        return instructions;
    }

    /**
     * Sets the value of the instructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackInstructionsStructure }
     *     
     */
    public void setInstructions(TrackInstructionsStructure value) {
        this.instructions = value;
    }

}
