//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.10 at 10:57:01 PM GMT 
//


package io.github.andyljones.commutesandrent.model.uk.org.transxchange;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * A transport operator that includes licensing details that are mandatory for service registration.
 * 
 * <p>Java class for LicensedOperatorStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LicensedOperatorStructure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.transxchange.org.uk/}OperatorStructure">
 *       &lt;sequence>
 *         &lt;element name="NationalOperatorCode" type="{http://www.transxchange.org.uk/}NationalOperatorCodeType" minOccurs="0"/>
 *         &lt;element name="OperatorCode" type="{http://www.transxchange.org.uk/}OperatorCodeType" minOccurs="0"/>
 *         &lt;element name="OperatorShortName" type="{http://www.transxchange.org.uk/}OperatorShortNameType"/>
 *         &lt;element name="OperatorNameOnLicence" type="{http://www.transxchange.org.uk/}NaturalLanguageStringStructure"/>
 *         &lt;element name="TradingName" type="{http://www.transxchange.org.uk/}OperatorTradingNameType" minOccurs="0"/>
 *         &lt;element name="LicenceNumber" type="{http://www.transxchange.org.uk/}OperatorLicenceNumberType"/>
 *         &lt;element name="LicenceClassification" type="{http://www.transxchange.org.uk/}OperatorLicenceEnumeration"/>
 *         &lt;group ref="{http://www.transxchange.org.uk/}LicensedOperatorContactGroup"/>
 *         &lt;element name="Garages" type="{http://www.transxchange.org.uk/}GaragesStructure" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicensedOperatorStructure")
public class LicensedOperatorStructure
    extends OperatorStructure
{


}