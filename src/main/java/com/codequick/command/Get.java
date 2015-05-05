package com.codequick.command;

import java.lang.reflect.Method;

public class Get implements Command {

	@Override
	public String validate(String content, String[] params) {
		return content;
	}

	@Override
	public String execute(String content, String[] params, Object object) {
		
		String[] objects = content.split("\\.");
		
		try {
			
			for (int i=0; i < objects.length -1; i++) {
				String propertyName = objects[i+1].substring(0, 1).toUpperCase() + objects[i+1].substring(1);
				String getMethod = "get" + propertyName;
				String isMethod = "is" + propertyName;
				
				Method[] methods = object.getClass().getMethods();
				String methodName = null;
				for (Method method : methods) {
					if (method.getName().equals(getMethod)) {
						methodName = getMethod;
						break;
					} else if (method.getName().equals(isMethod)) {
						methodName = isMethod;
						break;
					}
				}
				
				if (methodName != null) {
					Method method = object.getClass().getMethod(methodName, (Class<?>[])null);
					Object result = method.invoke(object);
					object = result;
				} else {
					System.err.format("There is no method get/is for object %s.", content);
				}
				
			}
			
			if (object != null)  return object.toString();

			return "";
			
		} catch (Exception e) {
			System.err.format("Cannot execute command Get for content %s.", content);
			e.printStackTrace();
		}
		
		return "";
		
	}

}
