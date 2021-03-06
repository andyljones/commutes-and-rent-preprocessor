//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package io.github.andyljones.commutesandrent.model.uk.org.transxchange;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessibilityHazardEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccessibilityHazardEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="difficultSurface"/>
 *     &lt;enumeration value="escalator"/>
 *     &lt;enumeration value="lift"/>
 *     &lt;enumeration value="notIlluminated"/>
 *     &lt;enumeration value="ramp"/>
 *     &lt;enumeration value="stairs"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccessibilityHazardEnumeration")
@XmlEnum
public enum AccessibilityHazardEnumeration {


    /**
     * For example, slippery surfaces or grids.
     * 
     */
    @XmlEnumValue("difficultSurface")
    DIFFICULT_SURFACE("difficultSurface"),
    @XmlEnumValue("escalator")
    ESCALATOR("escalator"),
    @XmlEnumValue("lift")
    LIFT("lift"),
    @XmlEnumValue("notIlluminated")
    NOT_ILLUMINATED("notIlluminated"),
    @XmlEnumValue("ramp")
    RAMP("ramp"),
    @XmlEnumValue("stairs")
    STAIRS("stairs");
    private final String value;

    AccessibilityHazardEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessibilityHazardEnumeration fromValue(String v) {
        for (AccessibilityHazardEnumeration c: AccessibilityHazardEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
