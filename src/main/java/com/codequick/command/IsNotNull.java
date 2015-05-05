package com.codequick.command;


public class IsNotNull implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {

		Get get = new Get();
		String isNotNull = get.execute(content, params, object);
		return isNotNull.equals("") ? "false" : "true";
		
	}

}
