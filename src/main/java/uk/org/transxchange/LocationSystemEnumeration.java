//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package uk.org.transxchange;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocationSystemEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LocationSystemEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="WGS84"/>
 *     &lt;enumeration value="Grid"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LocationSystemEnumeration")
@XmlEnum
public enum LocationSystemEnumeration {


    /**
     * All coordinate will be in World Geodetic System 84 (WGS 84) format.  http://www.wgs84.com/
     * 
     */
    @XmlEnumValue("WGS84")
    WGS_84("WGS84"),

    /**
     * All coordinates will be in a grid based system.
     * 
     */
    @XmlEnumValue("Grid")
    GRID("Grid");
    private final String value;

    LocationSystemEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LocationSystemEnumeration fromValue(String v) {
        for (LocationSystemEnumeration c: LocationSystemEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
