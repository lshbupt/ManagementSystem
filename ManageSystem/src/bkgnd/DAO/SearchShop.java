package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��ȡ�̼���Ϣ
public class SearchShop {
	public ResultSet SShop(Connection conn, String id) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="select * from SHOP WHERE ShopID='"+id+"';";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
}
