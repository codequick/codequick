package com.codequick.command;


public class Not implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {
		return content.equals("true") ? "false" : "true";
	}

}
