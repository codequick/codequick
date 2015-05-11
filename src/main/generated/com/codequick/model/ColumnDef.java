//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.05.10 às 10:54:30 PM BRT 
//


package com.codequick.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Classe Java de ColumnDef complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ColumnDef"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="catalog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="schema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="columnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="columnSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="decimalDigits" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="radix" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nullable" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="columnDefault" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="charOctetLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ordinalPosition" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="isNullable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="scopeCatalog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="scopeSchema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="scopeTable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sourceDataType" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="isAutoincrement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shortColumnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="propertyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="propertyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fkTableDef" type="{http://model.codequick.com}TableDef" minOccurs="0"/&gt;
 *         &lt;element name="tableDef" type="{http://model.codequick.com}TableDef" minOccurs="0"/&gt;
 *         &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="keySeq" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="identity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColumnDef", propOrder = {
    "catalog",
    "schema",
    "tableName",
    "columnName",
    "dataType",
    "typeName",
    "columnSize",
    "decimalDigits",
    "radix",
    "nullable",
    "remarks",
    "columnDefault",
    "charOctetLength",
    "ordinalPosition",
    "isNullable",
    "scopeCatalog",
    "scopeSchema",
    "scopeTable",
    "sourceDataType",
    "isAutoincrement",
    "shortColumnName",
    "propertyName",
    "propertyType",
    "fkTableDef",
    "tableDef",
    "fieldType",
    "keySeq",
    "identity"
})
public class ColumnDef
    implements ToString
{

    protected String catalog;
    protected String schema;
    protected String tableName;
    protected String columnName;
    protected Integer dataType;
    protected String typeName;
    protected Integer columnSize;
    protected Integer decimalDigits;
    protected Integer radix;
    protected Integer nullable;
    protected String remarks;
    protected String columnDefault;
    protected Integer charOctetLength;
    protected Integer ordinalPosition;
    protected String isNullable;
    protected String scopeCatalog;
    protected String scopeSchema;
    protected String scopeTable;
    protected Short sourceDataType;
    protected String isAutoincrement;
    protected String shortColumnName;
    protected String propertyName;
    protected String propertyType;
    protected TableDef fkTableDef;
    protected TableDef tableDef;
    protected String fieldType;
    protected Short keySeq;
    protected Boolean identity;

    /**
     * Obtém o valor da propriedade catalog.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * Define o valor da propriedade catalog.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalog(String value) {
        this.catalog = value;
    }

    /**
     * Obtém o valor da propriedade schema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Define o valor da propriedade schema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchema(String value) {
        this.schema = value;
    }

    /**
     * Obtém o valor da propriedade tableName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Define o valor da propriedade tableName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableName(String value) {
        this.tableName = value;
    }

    /**
     * Obtém o valor da propriedade columnName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Define o valor da propriedade columnName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnName(String value) {
        this.columnName = value;
    }

    /**
     * Obtém o valor da propriedade dataType.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * Define o valor da propriedade dataType.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDataType(Integer value) {
        this.dataType = value;
    }

    /**
     * Obtém o valor da propriedade typeName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Define o valor da propriedade typeName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * Obtém o valor da propriedade columnSize.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getColumnSize() {
        return columnSize;
    }

    /**
     * Define o valor da propriedade columnSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setColumnSize(Integer value) {
        this.columnSize = value;
    }

    /**
     * Obtém o valor da propriedade decimalDigits.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDecimalDigits() {
        return decimalDigits;
    }

    /**
     * Define o valor da propriedade decimalDigits.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDecimalDigits(Integer value) {
        this.decimalDigits = value;
    }

    /**
     * Obtém o valor da propriedade radix.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRadix() {
        return radix;
    }

    /**
     * Define o valor da propriedade radix.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRadix(Integer value) {
        this.radix = value;
    }

    /**
     * Obtém o valor da propriedade nullable.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNullable() {
        return nullable;
    }

    /**
     * Define o valor da propriedade nullable.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNullable(Integer value) {
        this.nullable = value;
    }

    /**
     * Obtém o valor da propriedade remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define o valor da propriedade remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Obtém o valor da propriedade columnDefault.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnDefault() {
        return columnDefault;
    }

    /**
     * Define o valor da propriedade columnDefault.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnDefault(String value) {
        this.columnDefault = value;
    }

    /**
     * Obtém o valor da propriedade charOctetLength.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCharOctetLength() {
        return charOctetLength;
    }

    /**
     * Define o valor da propriedade charOctetLength.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCharOctetLength(Integer value) {
        this.charOctetLength = value;
    }

    /**
     * Obtém o valor da propriedade ordinalPosition.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    /**
     * Define o valor da propriedade ordinalPosition.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrdinalPosition(Integer value) {
        this.ordinalPosition = value;
    }

    /**
     * Obtém o valor da propriedade isNullable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsNullable() {
        return isNullable;
    }

    /**
     * Define o valor da propriedade isNullable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsNullable(String value) {
        this.isNullable = value;
    }

    /**
     * Obtém o valor da propriedade scopeCatalog.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScopeCatalog() {
        return scopeCatalog;
    }

    /**
     * Define o valor da propriedade scopeCatalog.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScopeCatalog(String value) {
        this.scopeCatalog = value;
    }

    /**
     * Obtém o valor da propriedade scopeSchema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScopeSchema() {
        return scopeSchema;
    }

    /**
     * Define o valor da propriedade scopeSchema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScopeSchema(String value) {
        this.scopeSchema = value;
    }

    /**
     * Obtém o valor da propriedade scopeTable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScopeTable() {
        return scopeTable;
    }

    /**
     * Define o valor da propriedade scopeTable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScopeTable(String value) {
        this.scopeTable = value;
    }

    /**
     * Obtém o valor da propriedade sourceDataType.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getSourceDataType() {
        return sourceDataType;
    }

    /**
     * Define o valor da propriedade sourceDataType.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSourceDataType(Short value) {
        this.sourceDataType = value;
    }

    /**
     * Obtém o valor da propriedade isAutoincrement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAutoincrement() {
        return isAutoincrement;
    }

    /**
     * Define o valor da propriedade isAutoincrement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAutoincrement(String value) {
        this.isAutoincrement = value;
    }

    /**
     * Obtém o valor da propriedade shortColumnName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortColumnName() {
        return shortColumnName;
    }

    /**
     * Define o valor da propriedade shortColumnName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortColumnName(String value) {
        this.shortColumnName = value;
    }

    /**
     * Obtém o valor da propriedade propertyName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Define o valor da propriedade propertyName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyName(String value) {
        this.propertyName = value;
    }

    /**
     * Obtém o valor da propriedade propertyType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * Define o valor da propriedade propertyType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyType(String value) {
        this.propertyType = value;
    }

    /**
     * Obtém o valor da propriedade fkTableDef.
     * 
     * @return
     *     possible object is
     *     {@link TableDef }
     *     
     */
    public TableDef getFkTableDef() {
        return fkTableDef;
    }

    /**
     * Define o valor da propriedade fkTableDef.
     * 
     * @param value
     *     allowed object is
     *     {@link TableDef }
     *     
     */
    public void setFkTableDef(TableDef value) {
        this.fkTableDef = value;
    }

    /**
     * Obtém o valor da propriedade tableDef.
     * 
     * @return
     *     possible object is
     *     {@link TableDef }
     *     
     */
    public TableDef getTableDef() {
        return tableDef;
    }

    /**
     * Define o valor da propriedade tableDef.
     * 
     * @param value
     *     allowed object is
     *     {@link TableDef }
     *     
     */
    public void setTableDef(TableDef value) {
        this.tableDef = value;
    }

    /**
     * Obtém o valor da propriedade fieldType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * Define o valor da propriedade fieldType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldType(String value) {
        this.fieldType = value;
    }

    /**
     * Obtém o valor da propriedade keySeq.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getKeySeq() {
        return keySeq;
    }

    /**
     * Define o valor da propriedade keySeq.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setKeySeq(Short value) {
        this.keySeq = value;
    }

    /**
     * Obtém o valor da propriedade identity.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIdentity() {
        return identity;
    }

    /**
     * Define o valor da propriedade identity.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIdentity(Boolean value) {
        this.identity = value;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            String theCatalog;
            theCatalog = this.getCatalog();
            strategy.appendField(locator, this, "catalog", buffer, theCatalog);
        }
        {
            String theSchema;
            theSchema = this.getSchema();
            strategy.appendField(locator, this, "schema", buffer, theSchema);
        }
        {
            String theTableName;
            theTableName = this.getTableName();
            strategy.appendField(locator, this, "tableName", buffer, theTableName);
        }
        {
            String theColumnName;
            theColumnName = this.getColumnName();
            strategy.appendField(locator, this, "columnName", buffer, theColumnName);
        }
        {
            Integer theDataType;
            theDataType = this.getDataType();
            strategy.appendField(locator, this, "dataType", buffer, theDataType);
        }
        {
            String theTypeName;
            theTypeName = this.getTypeName();
            strategy.appendField(locator, this, "typeName", buffer, theTypeName);
        }
        {
            Integer theColumnSize;
            theColumnSize = this.getColumnSize();
            strategy.appendField(locator, this, "columnSize", buffer, theColumnSize);
        }
        {
            Integer theDecimalDigits;
            theDecimalDigits = this.getDecimalDigits();
            strategy.appendField(locator, this, "decimalDigits", buffer, theDecimalDigits);
        }
        {
            Integer theRadix;
            theRadix = this.getRadix();
            strategy.appendField(locator, this, "radix", buffer, theRadix);
        }
        {
            Integer theNullable;
            theNullable = this.getNullable();
            strategy.appendField(locator, this, "nullable", buffer, theNullable);
        }
        {
            String theRemarks;
            theRemarks = this.getRemarks();
            strategy.appendField(locator, this, "remarks", buffer, theRemarks);
        }
        {
            String theColumnDefault;
            theColumnDefault = this.getColumnDefault();
            strategy.appendField(locator, this, "columnDefault", buffer, theColumnDefault);
        }
        {
            Integer theCharOctetLength;
            theCharOctetLength = this.getCharOctetLength();
            strategy.appendField(locator, this, "charOctetLength", buffer, theCharOctetLength);
        }
        {
            Integer theOrdinalPosition;
            theOrdinalPosition = this.getOrdinalPosition();
            strategy.appendField(locator, this, "ordinalPosition", buffer, theOrdinalPosition);
        }
        {
            String theIsNullable;
            theIsNullable = this.getIsNullable();
            strategy.appendField(locator, this, "isNullable", buffer, theIsNullable);
        }
        {
            String theScopeCatalog;
            theScopeCatalog = this.getScopeCatalog();
            strategy.appendField(locator, this, "scopeCatalog", buffer, theScopeCatalog);
        }
        {
            String theScopeSchema;
            theScopeSchema = this.getScopeSchema();
            strategy.appendField(locator, this, "scopeSchema", buffer, theScopeSchema);
        }
        {
            String theScopeTable;
            theScopeTable = this.getScopeTable();
            strategy.appendField(locator, this, "scopeTable", buffer, theScopeTable);
        }
        {
            Short theSourceDataType;
            theSourceDataType = this.getSourceDataType();
            strategy.appendField(locator, this, "sourceDataType", buffer, theSourceDataType);
        }
        {
            String theIsAutoincrement;
            theIsAutoincrement = this.getIsAutoincrement();
            strategy.appendField(locator, this, "isAutoincrement", buffer, theIsAutoincrement);
        }
        {
            String theShortColumnName;
            theShortColumnName = this.getShortColumnName();
            strategy.appendField(locator, this, "shortColumnName", buffer, theShortColumnName);
        }
        {
            String thePropertyName;
            thePropertyName = this.getPropertyName();
            strategy.appendField(locator, this, "propertyName", buffer, thePropertyName);
        }
        {
            String thePropertyType;
            thePropertyType = this.getPropertyType();
            strategy.appendField(locator, this, "propertyType", buffer, thePropertyType);
        }
        {
            TableDef theFkTableDef;
            theFkTableDef = this.getFkTableDef();
            strategy.appendField(locator, this, "fkTableDef", buffer, theFkTableDef);
        }
        {
            TableDef theTableDef;
            theTableDef = this.getTableDef();
            strategy.appendField(locator, this, "tableDef", buffer, theTableDef);
        }
        {
            String theFieldType;
            theFieldType = this.getFieldType();
            strategy.appendField(locator, this, "fieldType", buffer, theFieldType);
        }
        {
            Short theKeySeq;
            theKeySeq = this.getKeySeq();
            strategy.appendField(locator, this, "keySeq", buffer, theKeySeq);
        }
        {
            Boolean theIdentity;
            theIdentity = this.isIdentity();
            strategy.appendField(locator, this, "identity", buffer, theIdentity);
        }
        return buffer;
    }

}
