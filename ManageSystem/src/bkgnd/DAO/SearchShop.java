package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class SearchShop {
	public ResultSet SShop(Connection conn, String id) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="select * from SHOP WHERE ShopID='"+id+"';";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
}
