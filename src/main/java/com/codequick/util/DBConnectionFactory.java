package com.codequick.util;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConnectionFactory {

	public static Connection getConnection(String driverPath
			, String driverName
			, String urlConn
			, String user
			, String pwd) throws Exception {
		
		try {
			
			URL url = new URL("jar:file:" + driverPath + "!/");
			
			URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {url});
			
			Driver driver = (Driver)Class.forName(driverName, true, urlClassLoader).newInstance();
			
			DriverManager.registerDriver(new DriverShell(driver));
			
			return DriverManager.getConnection(urlConn, user, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
    public static void closeConnection(Connection conn) throws Exception {
    	try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

}
