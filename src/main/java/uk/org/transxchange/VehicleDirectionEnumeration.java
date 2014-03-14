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
 * <p>Java class for VehicleDirectionEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VehicleDirectionEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="inbound"/>
 *     &lt;enumeration value="outbound"/>
 *     &lt;enumeration value="inboundAndOutbound"/>
 *     &lt;enumeration value="circular"/>
 *     &lt;enumeration value="clockwise"/>
 *     &lt;enumeration value="antiClockwise"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VehicleDirectionEnumeration")
@XmlEnum
public enum VehicleDirectionEnumeration {

    @XmlEnumValue("inbound")
    INBOUND("inbound"),
    @XmlEnumValue("outbound")
    OUTBOUND("outbound"),
    @XmlEnumValue("inboundAndOutbound")
    INBOUND_AND_OUTBOUND("inboundAndOutbound"),
    @XmlEnumValue("circular")
    CIRCULAR("circular"),
    @XmlEnumValue("clockwise")
    CLOCKWISE("clockwise"),
    @XmlEnumValue("antiClockwise")
    ANTI_CLOCKWISE("antiClockwise");
    private final String value;

    VehicleDirectionEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VehicleDirectionEnumeration fromValue(String v) {
        for (VehicleDirectionEnumeration c: VehicleDirectionEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
