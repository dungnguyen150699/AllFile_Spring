package xulyform.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import xulyform.model.*;

public class UserDAO extends DAO {

	public UserDAO() throws SQLException {
		super();
	}

	public boolean CheckLogin(user u) {
		boolean result = false;
		try {
			String sql = " Select * from springmvcbasicfree.user where username = ? and password=?";
			PreparedStatement p = con.prepareCall(sql);
			p.setString(1, u.getUsername());
			p.setString(2, u.getPassword());
			ResultSet rs = p.executeQuery();
			if (rs.next())
				result = true;
		} catch (SQLException ex) {
			System.err.println(ex.getErrorCode());;
		}
		return result;
	}
}
