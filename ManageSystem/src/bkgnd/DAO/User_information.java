package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class User_information {
	
	public ResultSet getUser(Connection conn) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="select * from USERs";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	
}
