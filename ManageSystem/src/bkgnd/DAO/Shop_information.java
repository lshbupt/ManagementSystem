package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��ȡ�̼���Ϣ
public class Shop_information {
	
	public ResultSet getShop(Connection conn) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="select * from SHOP";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	
}
