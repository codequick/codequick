package com.codequick.command;



public class UpperFirst implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {

		String result = content.substring(0, 1).toUpperCase() + content.substring(1);
		
		return result;
		
	}

}
