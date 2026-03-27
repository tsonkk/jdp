/*
 * Cloud databases: https://www.monsterasp.net
 * Management tools:
 * 		MySQL: HeidiSQL
 * 		MSSQL: SQL Management Studio
 * Drivers:
 * 		MySQL: https://dev.mysql.com/downloads/connector/j/
 * 		MSSQL: https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect2DB {

	public static void main(String[] args) throws Exception {
		// b0
		/* MSSQL
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://dbXXXXX.public.databaseasp.net;databaseName=dbXXXXX;TrustServerCertificate=True";
		String user = "dbXXXXX";
		String password = "123456789";*/
		/* MySQL */
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://dbXXXXX.public.databaseasp.net:3306/dbXXXXX";
		String user = "dbXXXXX";
		String password = "123456789";
		// b1
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		// b2
		String sql = "SELECT * FROM Customer";
		Statement st = con.createStatement();
		// b3
		ResultSet rs = st.executeQuery(sql);
		// b4
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
		}
		// b5
		rs.close();
		st.close();
		con.close();
	}

}
