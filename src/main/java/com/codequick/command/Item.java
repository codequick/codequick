package com.codequick.command;

public class Item implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {
		if (params != null) {
			for (String param : params) {
				String[] values = param.split(":");
				if (values[0].equals(content)) {
					return values[1];
				}
			}
		}
		return "";
	}

}
