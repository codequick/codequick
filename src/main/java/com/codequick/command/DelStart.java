package com.codequick.command;

import com.codequick.Analizer;

public class DelStart implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {
		String[] operands = content.split(Analizer.parameter_separator);
		int start = operands[0].indexOf(operands[1]);
		if (start > -1) {
			return operands[0].substring(start, operands[0].length());
		}
		return operands[0];
	}

}
