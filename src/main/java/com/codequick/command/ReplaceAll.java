package com.codequick.command;

import com.codequick.Analizer;



public class ReplaceAll implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {
		
		String[] operands = content.split(Analizer.parameter_separator);
		
		return operands[0].replaceAll(operands[1], operands[2]);
		
	}

}
