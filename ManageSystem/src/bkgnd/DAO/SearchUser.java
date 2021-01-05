package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class SearchUser {
	public ResultSet SUser(Connection conn, String id) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="select * from USERs WHERE UserID='"+id+"';";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
}
