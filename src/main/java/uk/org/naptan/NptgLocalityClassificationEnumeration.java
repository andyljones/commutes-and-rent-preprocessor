//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:51:42 PM GMT 
//


package uk.org.naptan;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NptgLocalityClassificationEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NptgLocalityClassificationEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="city"/>
 *     &lt;enumeration value="suburb"/>
 *     &lt;enumeration value="town"/>
 *     &lt;enumeration value="village"/>
 *     &lt;enumeration value="hamlet"/>
 *     &lt;enumeration value="urbanCentre"/>
 *     &lt;enumeration value="placeOfInterest"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="unrecorded"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NptgLocalityClassificationEnumeration")
@XmlEnum
public enum NptgLocalityClassificationEnumeration {


    /**
     * Locality is a city.
     * 
     */
    @XmlEnumValue("city")
    CITY("city"),

    /**
     * Locality is an urban sub-area.
     * 
     */
    @XmlEnumValue("suburb")
    SUBURB("suburb"),

    /**
     * Locality is a town.
     * 
     */
    @XmlEnumValue("town")
    TOWN("town"),

    /**
     * Locality is a village.
     * 
     */
    @XmlEnumValue("village")
    VILLAGE("village"),

    /**
     * Locality is a hamlet.
     * 
     */
    @XmlEnumValue("hamlet")
    HAMLET("hamlet"),

    /**
     * Locality is a City Centre or Town Centre zone of another town or city locality
     * 
     */
    @XmlEnumValue("urbanCentre")
    URBAN_CENTRE("urbanCentre"),

    /**
     * Locality is a place of interest whose name is distinct from another locality.
     * 
     */
    @XmlEnumValue("placeOfInterest")
    PLACE_OF_INTEREST("placeOfInterest"),

    /**
     * Locality is none of the other types.
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * Locality type is not yet specified..
     * 
     */
    @XmlEnumValue("unrecorded")
    UNRECORDED("unrecorded");
    private final String value;

    NptgLocalityClassificationEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NptgLocalityClassificationEnumeration fromValue(String v) {
        for (NptgLocalityClassificationEnumeration c: NptgLocalityClassificationEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
