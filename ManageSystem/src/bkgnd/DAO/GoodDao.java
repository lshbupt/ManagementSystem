package bkgnd.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GoodDao {
	public ResultSet TotalGood(Connection conn) throws SQLException {
		ResultSet rs;
		String sql="select * from goods ";
		PreparedStatement ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		return rs;
	}
}
