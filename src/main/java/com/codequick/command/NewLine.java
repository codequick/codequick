package com.codequick.command;

import org.apache.commons.lang3.StringUtils;

public class NewLine implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {
		if (StringUtils.isNotEmpty(content)) {
			int n = Integer.parseInt(content);
			return new String(new char[n]).replace("\0", "\n");
		}
		return "\n";
	}

}
