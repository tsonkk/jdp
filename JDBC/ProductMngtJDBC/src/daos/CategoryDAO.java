package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Category;
import utils.JdbcUtil;

public class CategoryDAO {

	public static List<Category> getAll() throws Exception {
		List<Category> cats = new ArrayList<Category>();
		Connection con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM Category";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("Name");
			Category cat = new Category(id, name);
			cats.add(cat);
		}
		rs.close();
		st.close();
		return cats;
	}

	public static Category getDetails(int id) throws Exception {
		Category cat = null;
		Connection con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM Category WHERE ID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			String name = rs.getString("Name");
			cat = new Category(id, name);
		}
		rs.close();
		pst.close();
		return cat;
	}

	public static List<Category> search(String keyword) throws Exception {
		List<Category> cats = new ArrayList<Category>();
		Connection con = JdbcUtil.getConnection();
		String sql = "SELECT * FROM Category WHERE Name LIKE ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, "%" + keyword + "%");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("Name");
			Category cat = new Category(id, name);
			cats.add(cat);
		}
		rs.close();
		pst.close();
		return cats;
	}

	public static boolean insert(Category newCat) throws Exception {
		boolean result = false;
		Connection con = JdbcUtil.getConnection();
		String sql = "INSERT INTO Category(Name) VALUES(?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, newCat.name);
		int rows = pst.executeUpdate();
		if (rows > 0) result = true;
		pst.close();
		return result;
	}

	public static int insert2newID(Category newCat) throws Exception {
		int result = 0;
		Connection con = JdbcUtil.getConnection();
		String sql = "INSERT INTO Category(Name) VALUES(?)";
		PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, newCat.name);
		int rows = pst.executeUpdate();
		if (rows > 0) {
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				result = id;
			}
			rs.close();
		}
		pst.close();
		return result;
	}

	public static boolean update(Category newCat) throws Exception {
		boolean result = false;
		Connection con = JdbcUtil.getConnection();
		String sql = "UPDATE Category SET Name=? WHERE ID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, newCat.name);
		pst.setInt(2, newCat.id);
		int rows = pst.executeUpdate();
		if (rows > 0) result = true;
		pst.close();
		return result;
	}

	public static boolean delete(int id) throws Exception {
		boolean result = false;
		Connection con = JdbcUtil.getConnection();
		String sql = "DELETE FROM Category WHERE ID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		int rows = pst.executeUpdate();
		if (rows > 0) result = true;
		pst.close();
		return result;
	}

}