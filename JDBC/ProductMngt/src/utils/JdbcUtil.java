package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

	private static Connection con = null;

	public static Connection getConnection() throws Exception {
		if (con == null || con.isClosed()) {
			// for MySQL 8.0
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://db40322.public.databaseasp.net:3306/db40322", "db40322", "Y-e5@8BqP_t4");
			
			// for SQL Server 2025
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//con = DriverManager.getConnection("jdbc:sqlserver://db40321.public.databaseasp.net;databaseName=db40321;TrustServerCertificate=True", "db40321", "o!6Q+9RgM%k5");
		}
		return con;
	}

}