package com.codequick.command;

import com.codequick.Analizer;

public class GetVar implements Command {

	@Override
	public String validate(String content, String[] params) {

		String value = null;
		
		if (Analizer.getProperties() != null) {
			value = Analizer.getProperties().getProperty(content);
		}
		
		if (value == null) {
			value = "";
		}
		
		return value;
		
	}

	@Override
	public String execute(String content, String[] params, Object object) {

		return validate(content, params);
		
	}

}
