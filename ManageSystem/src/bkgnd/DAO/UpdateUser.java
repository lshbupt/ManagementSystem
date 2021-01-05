package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class UpdateUser {
	
	public String UpdateU(Connection conn, String id, String name, String Account,String password, String tel) throws SQLException{
		int telno = Integer.parseInt(tel);
		Statement statement = conn.createStatement();
		String sql="UPDATE USERs SET Name='"+name+"',Account='"+Account+"',TelNo="+telno+",Password='"+password+"' WHERE UserID='"+id+"';";
		String sql1="SELECT * FROM USERs WHERE UserID='"+id+"'";
		ResultSet rs = statement.executeQuery(sql1);
		if(rs.next()) {
			statement.execute(sql);
			return "操作成功，用户信息已更新。";
		}
		else {
			statement.execute(sql1);
			return "未查询到相关用户，更新失败";
		}
	}
	
}