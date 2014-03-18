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
 * <p>Java class for OperatorLicenceEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OperatorLicenceEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="standardNational"/>
 *     &lt;enumeration value="standardInternational"/>
 *     &lt;enumeration value="restricted"/>
 *     &lt;enumeration value="specialRestricted"/>
 *     &lt;enumeration value="communityBusPermit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OperatorLicenceEnumeration")
@XmlEnum
public enum OperatorLicenceEnumeration {

    @XmlEnumValue("standardNational")
    STANDARD_NATIONAL("standardNational"),
    @XmlEnumValue("standardInternational")
    STANDARD_INTERNATIONAL("standardInternational"),
    @XmlEnumValue("restricted")
    RESTRICTED("restricted"),
    @XmlEnumValue("specialRestricted")
    SPECIAL_RESTRICTED("specialRestricted"),
    @XmlEnumValue("communityBusPermit")
    COMMUNITY_BUS_PERMIT("communityBusPermit");
    private final String value;

    OperatorLicenceEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperatorLicenceEnumeration fromValue(String v) {
        for (OperatorLicenceEnumeration c: OperatorLicenceEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}