package com.codequick;

import java.io.File;
import java.util.Properties;

import com.codequick.model.TableDef;

public class JsonEngine extends Engine {

	private JsonEngine () {
	}
	
	public static JsonEngine getInstance (Properties properties) {
		JsonEngine engine = new JsonEngine ();
		
    	engine.configDefaults(properties);

		return engine;
	}
	
	@Override
	public void saveObject(TableDef tableDef, File file, String fileName) {
		
	}

	@Override
	public TableDef parseObject(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
