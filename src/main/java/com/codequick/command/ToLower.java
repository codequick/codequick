package com.codequick.command;



public class ToLower implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {
		return content.toLowerCase();
	}

}
