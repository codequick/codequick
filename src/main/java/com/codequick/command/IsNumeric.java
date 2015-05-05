package com.codequick.command;


public class IsNumeric implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {

		return (content.equals("Long") 
				|| content.equals("Integer")
				|| content.equals("BigDecimal")
				|| content.equals("Float")
				|| content.equals("Double")
				|| content.equals("Short")
				|| content.equals("Byte")) + "";
		
	}

}
