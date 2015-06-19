package com.codequick;

import java.io.File;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.codequick.model.TableDef;

public class XmlEngine extends Engine {

	private XmlEngine () {
	}
	
	public static XmlEngine getInstance (Properties properties) {
		XmlEngine engine = new XmlEngine ();
		
		return engine;
	}
	
	@Override
	public void saveObject(TableDef tableDef, File file, String fileName) {
		
		// Save xml to file
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TableDef.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(tableDef, file);
			jaxbMarshaller.marshal(tableDef, System.out);

			System.out.format("Creating file %s.%n", fileName);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public TableDef parseObject(String fileName) {

		try {

			System.out.format("Loading file %s.%n", fileName);

			File file = new File(fileName);
			if (file.exists() && file.isFile()) {
				JAXBContext jaxbContext = JAXBContext.newInstance(TableDef.class);
				
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				TableDef tableDef = (TableDef) jaxbUnmarshaller.unmarshal(file);
				return tableDef;
			} else {
				System.err.format("File %s not found.%n", fileName);
			}
			
		} catch (JAXBException e) {
			System.err.format("Error to bind file %s into object.%n", fileName);
//			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
