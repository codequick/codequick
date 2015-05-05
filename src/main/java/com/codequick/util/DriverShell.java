package com.codequick.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;


public class DriverShell implements Driver {
	
	private Driver driver;
	
	DriverShell(Driver driver) {
		this.driver = driver;
	}
	
	public boolean acceptsURL(String url) throws SQLException {
		return this.driver.acceptsURL(url);
	}
	
	public Connection connect(String url, Properties properties) throws SQLException {
		return this.driver.connect(url, properties);
	}
	
	public int getMajorVersion() {
		return this.driver.getMajorVersion();
	}
	
	public int getMinorVersion() {
		return this.driver.getMinorVersion();
	}
	
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties properties) throws SQLException {
		return this.driver.getPropertyInfo(url, properties);
	}
	
	public boolean jdbcCompliant() {
		return this.driver.jdbcCompliant();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
	
}