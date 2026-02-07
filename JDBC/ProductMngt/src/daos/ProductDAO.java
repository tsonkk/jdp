package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import utils.JdbcUtil;

public class ProductDAO {

	public static List<Product> getAll() throws Exception {
		List<Product> prods = new ArrayList<Product>();
		Connection con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM Product";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("Name");
			int price = rs.getInt("Price");
			int catID = rs.getInt("CatID");
			Product prod = new Product(id, name, price, catID);
			prods.add(prod);
		}
		rs.close();
		st.close();
		return prods;
	}

	public static Product getDetails(int id) throws Exception {
		Product prod = null;
		Connection con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM Product WHERE ID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			String name = rs.getString("Name");
			int price = rs.getInt("Price");
			int catID = rs.getInt("CatID");
			prod = new Product(id, name, price, catID);
		}
		rs.close();
		pst.close();
		return prod;
	}

	public static List<Product> getByCatID(int catID) throws Exception {
		List<Product> prods = new ArrayList<Product>();
		Connection con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM Product WHERE CatID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, catID);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("Name");
			int price = rs.getInt("Price");
			Product prod = new Product(id, name, price, catID);
			prods.add(prod);
		}
		rs.close();
		pst.close();
		return prods;
	}

	public static List<Product> search(String keyword) throws Exception {
		List<Product> prods = new ArrayList<Product>();
		Connection con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM Product WHERE Name LIKE ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, "%" + keyword + "%");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("Name");
			int price = rs.getInt("Price");
			int catID = rs.getInt("CatID");
			Product prod = new Product(id, name, price, catID);
			prods.add(prod);
		}
		rs.close();
		pst.close();
		return prods;
	}

	public static boolean insert(Product newProd) throws Exception {
		boolean result = false;
		Connection con = JdbcUtil.getConnection();
		String sql = "INSERT INTO Product(Name, Price, CatID) VALUES(?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, newProd.name);
		pst.setInt(2, newProd.price);
		pst.setInt(3, newProd.catID);
		int rows = pst.executeUpdate();
		if (rows > 0) result = true;
		pst.close();
		return result;
	}

	public static boolean update(Product newProd) throws Exception {
		boolean result = false;
		Connection con = JdbcUtil.getConnection();
		String sql = "UPDATE Product SET Name=?, Price=?, CatID=? WHERE ID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, newProd.name);
		pst.setInt(2, newProd.price);
		pst.setInt(3, newProd.catID);
		pst.setInt(4, newProd.id);
		int rows = pst.executeUpdate();
		if (rows > 0) result = true;
		pst.close();
		return result;
	}

	public static boolean delete(int id) throws Exception {
		boolean result = false;
		Connection con = JdbcUtil.getConnection();
		String sql = "DELETE FROM Product WHERE ID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		int rows = pst.executeUpdate();
		if (rows > 0) result = true;
		pst.close();
		return result;
	}

}