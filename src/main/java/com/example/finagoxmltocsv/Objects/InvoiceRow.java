//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.10 at 02:49:48 PM EET 
//


package com.example.finagoxmltocsv.Objects;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for InvoiceRow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceRow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ArticleIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArticleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderedQuantity" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="QuantityUnitCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="UnitPriceAmount" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="AmountCurrencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="UnitPriceUnitCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RowVatRatePercent" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="RowVatAmount" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="AmountCurrencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RowVatExcludedAmount" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="AmountCurrencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RowAmount" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="AmountCurrencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceRow", propOrder = {
    "articleIdentifier",
    "articleName",
    "orderedQuantity",
    "unitPriceAmount",
    "rowVatRatePercent",
    "rowVatAmount",
    "rowVatExcludedAmount",
    "rowAmount"
})
public class InvoiceRow {

    @XmlElement(name = "ArticleIdentifier")
    protected String articleIdentifier;
    @XmlElement(name = "ArticleName")
    protected String articleName;
    @XmlElement(name = "OrderedQuantity")
    protected InvoiceRow.OrderedQuantity orderedQuantity;
    @XmlElement(name = "UnitPriceAmount")
    protected InvoiceRow.UnitPriceAmount unitPriceAmount;
    @XmlElement(name = "RowVatRatePercent")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger rowVatRatePercent;
    @XmlElement(name = "RowVatAmount")
    protected InvoiceRow.RowVatAmount rowVatAmount;
    @XmlElement(name = "RowVatExcludedAmount")
    protected InvoiceRow.RowVatExcludedAmount rowVatExcludedAmount;
    @XmlElement(name = "RowAmount")
    protected InvoiceRow.RowAmount rowAmount;

    /**
     * Gets the value of the articleIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleIdentifier() {
        return articleIdentifier;
    }

    /**
     * Sets the value of the articleIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleIdentifier(String value) {
        this.articleIdentifier = value;
    }

    /**
     * Gets the value of the articleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * Sets the value of the articleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleName(String value) {
        this.articleName = value;
    }

    /**
     * Gets the value of the orderedQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceRow.OrderedQuantity }
     *     
     */
    public InvoiceRow.OrderedQuantity getOrderedQuantity() {
        return orderedQuantity;
    }

    /**
     * Sets the value of the orderedQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceRow.OrderedQuantity }
     *     
     */
    public void setOrderedQuantity(InvoiceRow.OrderedQuantity value) {
        this.orderedQuantity = value;
    }

    /**
     * Gets the value of the unitPriceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceRow.UnitPriceAmount }
     *     
     */
    public InvoiceRow.UnitPriceAmount getUnitPriceAmount() {
        return unitPriceAmount;
    }

    /**
     * Sets the value of the unitPriceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceRow.UnitPriceAmount }
     *     
     */
    public void setUnitPriceAmount(InvoiceRow.UnitPriceAmount value) {
        this.unitPriceAmount = value;
    }

    /**
     * Gets the value of the rowVatRatePercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRowVatRatePercent() {
        return rowVatRatePercent;
    }

    /**
     * Sets the value of the rowVatRatePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRowVatRatePercent(BigInteger value) {
        this.rowVatRatePercent = value;
    }

    /**
     * Gets the value of the rowVatAmount property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceRow.RowVatAmount }
     *     
     */
    public InvoiceRow.RowVatAmount getRowVatAmount() {
        return rowVatAmount;
    }

    /**
     * Sets the value of the rowVatAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceRow.RowVatAmount }
     *     
     */
    public void setRowVatAmount(InvoiceRow.RowVatAmount value) {
        this.rowVatAmount = value;
    }

    /**
     * Gets the value of the rowVatExcludedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceRow.RowVatExcludedAmount }
     *     
     */
    public InvoiceRow.RowVatExcludedAmount getRowVatExcludedAmount() {
        return rowVatExcludedAmount;
    }

    /**
     * Sets the value of the rowVatExcludedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceRow.RowVatExcludedAmount }
     *     
     */
    public void setRowVatExcludedAmount(InvoiceRow.RowVatExcludedAmount value) {
        this.rowVatExcludedAmount = value;
    }

    /**
     * Gets the value of the rowAmount property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceRow.RowAmount }
     *     
     */
    public InvoiceRow.RowAmount getRowAmount() {
        return rowAmount;
    }

    /**
     * Sets the value of the rowAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceRow.RowAmount }
     *     
     */
    public void setRowAmount(InvoiceRow.RowAmount value) {
        this.rowAmount = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="QuantityUnitCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class OrderedQuantity {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "QuantityUnitCode")
        protected String quantityUnitCode;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the quantityUnitCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQuantityUnitCode() {
            return quantityUnitCode;
        }

        /**
         * Sets the value of the quantityUnitCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQuantityUnitCode(String value) {
            this.quantityUnitCode = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="AmountCurrencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class RowAmount {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "AmountCurrencyIdentifier")
        protected String amountCurrencyIdentifier;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the amountCurrencyIdentifier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAmountCurrencyIdentifier() {
            return amountCurrencyIdentifier;
        }

        /**
         * Sets the value of the amountCurrencyIdentifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAmountCurrencyIdentifier(String value) {
            this.amountCurrencyIdentifier = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="AmountCurrencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class RowVatAmount {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "AmountCurrencyIdentifier")
        protected String amountCurrencyIdentifier;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the amountCurrencyIdentifier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAmountCurrencyIdentifier() {
            return amountCurrencyIdentifier;
        }

        /**
         * Sets the value of the amountCurrencyIdentifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAmountCurrencyIdentifier(String value) {
            this.amountCurrencyIdentifier = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="AmountCurrencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class RowVatExcludedAmount {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "AmountCurrencyIdentifier")
        protected String amountCurrencyIdentifier;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the amountCurrencyIdentifier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAmountCurrencyIdentifier() {
            return amountCurrencyIdentifier;
        }

        /**
         * Sets the value of the amountCurrencyIdentifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAmountCurrencyIdentifier(String value) {
            this.amountCurrencyIdentifier = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="AmountCurrencyIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="UnitPriceUnitCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class UnitPriceAmount {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "AmountCurrencyIdentifier")
        protected String amountCurrencyIdentifier;
        @XmlAttribute(name = "UnitPriceUnitCode")
        protected String unitPriceUnitCode;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the amountCurrencyIdentifier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAmountCurrencyIdentifier() {
            return amountCurrencyIdentifier;
        }

        /**
         * Sets the value of the amountCurrencyIdentifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAmountCurrencyIdentifier(String value) {
            this.amountCurrencyIdentifier = value;
        }

        /**
         * Gets the value of the unitPriceUnitCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnitPriceUnitCode() {
            return unitPriceUnitCode;
        }

        /**
         * Sets the value of the unitPriceUnitCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnitPriceUnitCode(String value) {
            this.unitPriceUnitCode = value;
        }

    }

}