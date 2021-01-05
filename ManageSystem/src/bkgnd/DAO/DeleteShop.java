package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class DeleteShop {
	
	public String DeleteS(Connection conn, String id) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="SET foreign_key_checks = 0";
		String sql1="DELETE FROM shopandgoods WHERE ShopID='"+id+"'";
		String sql2="DELETE FROM shop WHERE ShopID='"+id+"'";
		String sql3="SELECT * FROM SHOP WHERE SHOPID='"+id+"'";
		ResultSet rs = statement.executeQuery(sql3);
		if(rs.next()) {
			statement.execute(sql);
			statement.execute(sql1);
			statement.execute(sql2);
			return "操作成功，商店已删除。";
		}
		else {
			statement.execute(sql2);
			return "未查询到相关商店，删除失败";
		}
	}
	
}