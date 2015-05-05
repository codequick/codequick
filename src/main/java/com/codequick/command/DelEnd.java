package com.codequick.command;

import com.codequick.Analizer;

public class DelEnd implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {
		String[] operands = content.split(Analizer.parameter_separator);
		String val = operands[0].substring(operands[0].length() - operands[1].length(), operands[0].length());
		if (val.equals(operands[1])) {
			return operands[0].substring(0, operands[0].length() - operands[1].length());
		}
		return operands[0];
	}

}
