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
 * <p>Java class for ArriveDepartEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArriveDepartEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="arrive"/>
 *     &lt;enumeration value="depart"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ArriveDepartEnumeration")
@XmlEnum
public enum ArriveDepartEnumeration {

    @XmlEnumValue("arrive")
    ARRIVE("arrive"),
    @XmlEnumValue("depart")
    DEPART("depart");
    private final String value;

    ArriveDepartEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ArriveDepartEnumeration fromValue(String v) {
        for (ArriveDepartEnumeration c: ArriveDepartEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}