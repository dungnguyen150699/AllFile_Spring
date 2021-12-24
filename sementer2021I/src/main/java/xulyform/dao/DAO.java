package xulyform.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DAO {
	Connection con;
	public DAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/springmvcbasicfree";
		String username="root";
		String password="b17dccn160";
		con = DriverManager.getConnection(url,username,password);
	}
}
