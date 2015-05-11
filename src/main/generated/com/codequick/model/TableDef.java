//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.05.10 às 10:54:30 PM BRT 
//


package com.codequick.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Classe Java de TableDef complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TableDef"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="catalog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="schema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="typeCatalog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="typeSchema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="selfReferencingColName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="refGeneration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="packageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="className" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pkName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="columnDefs" type="{http://model.codequick.com}ColumnDef" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableDef", propOrder = {
    "catalog",
    "schema",
    "name",
    "type",
    "remarks",
    "typeCatalog",
    "typeSchema",
    "typeName",
    "selfReferencingColName",
    "refGeneration",
    "packageName",
    "className",
    "pkName",
    "columnDefs"
})
@XmlRootElement(name = "TableDef")
public class TableDef
    implements ToString
{

    protected String catalog;
    protected String schema;
    protected String name;
    protected String type;
    protected String remarks;
    protected String typeCatalog;
    protected String typeSchema;
    protected String typeName;
    protected String selfReferencingColName;
    protected String refGeneration;
    protected String packageName;
    protected String className;
    protected String pkName;
    protected List<ColumnDef> columnDefs;

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
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
     * Obtém o valor da propriedade typeCatalog.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCatalog() {
        return typeCatalog;
    }

    /**
     * Define o valor da propriedade typeCatalog.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCatalog(String value) {
        this.typeCatalog = value;
    }

    /**
     * Obtém o valor da propriedade typeSchema.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeSchema() {
        return typeSchema;
    }

    /**
     * Define o valor da propriedade typeSchema.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeSchema(String value) {
        this.typeSchema = value;
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
     * Obtém o valor da propriedade selfReferencingColName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelfReferencingColName() {
        return selfReferencingColName;
    }

    /**
     * Define o valor da propriedade selfReferencingColName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelfReferencingColName(String value) {
        this.selfReferencingColName = value;
    }

    /**
     * Obtém o valor da propriedade refGeneration.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefGeneration() {
        return refGeneration;
    }

    /**
     * Define o valor da propriedade refGeneration.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefGeneration(String value) {
        this.refGeneration = value;
    }

    /**
     * Obtém o valor da propriedade packageName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Define o valor da propriedade packageName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageName(String value) {
        this.packageName = value;
    }

    /**
     * Obtém o valor da propriedade className.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Define o valor da propriedade className.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Obtém o valor da propriedade pkName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPkName() {
        return pkName;
    }

    /**
     * Define o valor da propriedade pkName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPkName(String value) {
        this.pkName = value;
    }

    /**
     * Gets the value of the columnDefs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnDefs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnDefs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnDef }
     * 
     * 
     */
    public List<ColumnDef> getColumnDefs() {
        if (columnDefs == null) {
            columnDefs = new ArrayList<ColumnDef>();
        }
        return this.columnDefs;
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
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            String theType;
            theType = this.getType();
            strategy.appendField(locator, this, "type", buffer, theType);
        }
        {
            String theRemarks;
            theRemarks = this.getRemarks();
            strategy.appendField(locator, this, "remarks", buffer, theRemarks);
        }
        {
            String theTypeCatalog;
            theTypeCatalog = this.getTypeCatalog();
            strategy.appendField(locator, this, "typeCatalog", buffer, theTypeCatalog);
        }
        {
            String theTypeSchema;
            theTypeSchema = this.getTypeSchema();
            strategy.appendField(locator, this, "typeSchema", buffer, theTypeSchema);
        }
        {
            String theTypeName;
            theTypeName = this.getTypeName();
            strategy.appendField(locator, this, "typeName", buffer, theTypeName);
        }
        {
            String theSelfReferencingColName;
            theSelfReferencingColName = this.getSelfReferencingColName();
            strategy.appendField(locator, this, "selfReferencingColName", buffer, theSelfReferencingColName);
        }
        {
            String theRefGeneration;
            theRefGeneration = this.getRefGeneration();
            strategy.appendField(locator, this, "refGeneration", buffer, theRefGeneration);
        }
        {
            String thePackageName;
            thePackageName = this.getPackageName();
            strategy.appendField(locator, this, "packageName", buffer, thePackageName);
        }
        {
            String theClassName;
            theClassName = this.getClassName();
            strategy.appendField(locator, this, "className", buffer, theClassName);
        }
        {
            String thePkName;
            thePkName = this.getPkName();
            strategy.appendField(locator, this, "pkName", buffer, thePkName);
        }
        {
            List<ColumnDef> theColumnDefs;
            theColumnDefs = (((this.columnDefs!= null)&&(!this.columnDefs.isEmpty()))?this.getColumnDefs():null);
            strategy.appendField(locator, this, "columnDefs", buffer, theColumnDefs);
        }
        return buffer;
    }

}
