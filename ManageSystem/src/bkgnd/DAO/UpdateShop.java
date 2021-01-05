package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class UpdateShop {
	
	public String UpdateS(Connection conn, String id, String name, String Account, String password, String tel) throws SQLException{
		int telno = Integer.parseInt(tel);
		Statement statement = conn.createStatement();
		String sql="UPDATE SHOP SET ShopName='"+name+"',Account='"+Account+"',TelNo="+telno+",password='"+password+"' WHERE ShopID='"+id+"';";
		String sql1="SELECT * FROM SHOP WHERE SHOPID='"+id+"'";
		ResultSet rs = statement.executeQuery(sql1);
		if(rs.next()) {
			statement.execute(sql);
			return "操作成功，商店已更新。";
		}
		else {
			statement.execute(sql1);
			return "未查询到相关商店，更新失败";
		}
	}
	
}