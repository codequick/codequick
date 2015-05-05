package com.codequick.command;

import java.lang.reflect.Method;
import java.util.List;

import com.codequick.Analizer;


public class Loop implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {

		int sep = content.indexOf(Analizer.parameter_separator);
		
		int start = sep + Analizer.parameter_separator.length();
		start += content.indexOf("\n", start) == start ? "\n".length() : 0;
		int end = content.length();
		boolean ignoreTab = content.endsWith("\t");
		
		String filterContent = null;
		int filter = content.lastIndexOf(Analizer.filter_separator);
		
		if (filter > -1) {
			filterContent = content.substring(filter + Analizer.filter_separator.length(), content.length());
			end = filter;
			ignoreTab = content.substring(0, filter).endsWith("\t");
		}
		
		end -= (ignoreTab ? "\t".length() : 0);
		
		String itemContent = content.substring(start, end);
		
		String listModel = content.substring(0, sep);
		
		String[] objects = listModel.split("\\.");
		
		StringBuffer result = new StringBuffer(0);
		
		try {
			
			String methodName = "get" + objects[1].substring(0, 1).toUpperCase() + objects[1].substring(1);
			
			Method method = object.getClass().getMethod(methodName, (Class<?>[])null);
			
			List<?> list = (List<?>)method.invoke(object);
			
			int i=0;
			boolean first = true;
			boolean last = false;
			boolean filterOk = true;
			
			for (Object item : list) {
				last = list.size()-1 == i;
				String[] commandParams = new String[] {"index:" + i
						, "first:" + first
						, "last:" + last};
				
				if (filter > -1) {
					String filterValue = Analizer.getContent(filterContent, item, commandParams);
					filterOk = Boolean.parseBoolean(filterValue);
				}

				if (filterOk) {
					result.append((first ? "\n":"") + Analizer.getContent(itemContent, item, commandParams));
					first = false;
				}
				
				i++;
			}
			
			if (result.length() > 0) {
				if (result.lastIndexOf("\n") == result.length() - "\n".length()) {
					return result.substring(0, result.length() - "\n".length());
				}
				return result.toString();
			}
			
		} catch (Exception e) {
			System.err.format("Cannot execute command Loop for content %s.", content);
			e.printStackTrace();
		}
		
		return "";
		
	}

}
