//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package uk.org.transxchange;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TanPrefixEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TanPrefixEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="PB"/>
 *     &lt;enumeration value="PC"/>
 *     &lt;enumeration value="PD"/>
 *     &lt;enumeration value="PF"/>
 *     &lt;enumeration value="PG"/>
 *     &lt;enumeration value="PH"/>
 *     &lt;enumeration value="PK"/>
 *     &lt;enumeration value="PM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TanPrefixEnumeration")
@XmlEnum
public enum TanPrefixEnumeration {


    /**
     * North Eastern Traffic Area.
     * 
     */
    PB,

    /**
     * North Western Traffic Area.
     * 
     */
    PC,

    /**
     * West Midlands Traffic Area.
     * 
     */
    PD,

    /**
     * Eastern Traffic Area.
     * 
     */
    PF,

    /**
     * Welsh Traffic Area.
     * 
     */
    PG,

    /**
     * Western Traffic Area.
     * 
     */
    PH,

    /**
     * South Eastern and Metropolitan Traffic Area.
     * 
     */
    PK,

    /**
     * Scottish Traffic Area.
     * 
     */
    PM;

    public String value() {
        return name();
    }

    public static TanPrefixEnumeration fromValue(String v) {
        return valueOf(v);
    }

}