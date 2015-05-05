package com.codequick.command;


public class IsNull implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {

		Get get = new Get();
		String isNull = get.execute(content, params, object);
		return isNull.equals("") ? "true" : "false";
		
	}

}
