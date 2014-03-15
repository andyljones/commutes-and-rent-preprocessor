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
 * <p>Java class for VehicleAtStopActivityEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VehicleAtStopActivityEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="pickUp"/>
 *     &lt;enumeration value="setDown"/>
 *     &lt;enumeration value="pickUpAndSetDown"/>
 *     &lt;enumeration value="pass"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VehicleAtStopActivityEnumeration")
@XmlEnum
public enum VehicleAtStopActivityEnumeration {

    @XmlEnumValue("pickUp")
    PICK_UP("pickUp"),
    @XmlEnumValue("setDown")
    SET_DOWN("setDown"),
    @XmlEnumValue("pickUpAndSetDown")
    PICK_UP_AND_SET_DOWN("pickUpAndSetDown"),
    @XmlEnumValue("pass")
    PASS("pass");
    private final String value;

    VehicleAtStopActivityEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VehicleAtStopActivityEnumeration fromValue(String v) {
        for (VehicleAtStopActivityEnumeration c: VehicleAtStopActivityEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}