package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Customer;
import utils.JdbcUtil;

public class CustomerDAO {

	public static List<Customer> getAll() throws Exception {
		List<Customer> custs = new ArrayList<Customer>();
		Connection con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM Customer";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("Name");
			int age = rs.getInt("Age");
			Customer cust = new Customer(id, name, age);
			custs.add(cust);
		}
		rs.close();
		st.close();
		return custs;
	}

	public static boolean insert(Customer newCust) throws Exception {
		boolean result = false;
		Connection con = JdbcUtil.getConnection();
		String sql = "INSERT INTO Customer(Name, Age) VALUES(?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, newCust.name);
		pst.setInt(2, newCust.age);
		int rows = pst.executeUpdate();
		if (rows > 0) result = true;
		pst.close();
		return result;
	}

	public static boolean update(Customer newCust) throws Exception {
		boolean result = false;
		Connection con = JdbcUtil.getConnection();
		String sql = "UPDATE Customer SET Name=?, Age=? WHERE ID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, newCust.name);
		pst.setInt(2, newCust.age);
		pst.setInt(3, newCust.id);
		int rows = pst.executeUpdate();
		if (rows > 0) result = true;
		pst.close();
		return result;
	}

	public static boolean delete(int id) throws Exception {
		boolean result = false;
		Connection con = JdbcUtil.getConnection();
		String sql = "DELETE FROM Customer WHERE ID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		int rows = pst.executeUpdate();
		if (rows > 0) result = true;
		pst.close();
		return result;
	}

}