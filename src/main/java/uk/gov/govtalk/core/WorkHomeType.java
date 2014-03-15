//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:51:42 PM GMT 
//


package uk.gov.govtalk.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkHomeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WorkHomeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="work"/>
 *     &lt;enumeration value="home"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WorkHomeType", namespace = "http://www.govtalk.gov.uk/core")
@XmlEnum
public enum WorkHomeType {

    @XmlEnumValue("work")
    WORK("work"),
    @XmlEnumValue("home")
    HOME("home");
    private final String value;

    WorkHomeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkHomeType fromValue(String v) {
        for (WorkHomeType c: WorkHomeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}