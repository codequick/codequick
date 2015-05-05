//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.05.05 às 12:56:30 AM BRT 
//


package com.codequick.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codequick.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TableDef_QNAME = new QName("http://model.codequick.com", "TableDef");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codequick.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TableDef }
     * 
     */
    public TableDef createTableDef() {
        return new TableDef();
    }

    /**
     * Create an instance of {@link ColumnDef }
     * 
     */
    public ColumnDef createColumnDef() {
        return new ColumnDef();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TableDef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.codequick.com", name = "TableDef")
    public JAXBElement<TableDef> createTableDef(TableDef value) {
        return new JAXBElement<TableDef>(_TableDef_QNAME, TableDef.class, null, value);
    }

}
