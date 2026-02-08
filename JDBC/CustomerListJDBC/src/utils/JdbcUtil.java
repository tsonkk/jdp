package utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtil {
	
	private static Connection con = null;
	
	public static Connection getConnection() throws Exception {
		if (con == null || con.isClosed()) {
			// get db_properties
			Properties props = new Properties();
			FileInputStream fis = new FileInputStream("META-INF/db.properties");
			props.load(fis);
			String driver = props.getProperty("db.driver");
			String url = props.getProperty("db.url");
			String user = props.getProperty("db.user");
			String password = props.getProperty("db.password");
			fis.close();
			// get db_connection
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		}
		return con;
	}

}