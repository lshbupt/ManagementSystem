package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class OrderType {
	
	public ResultSet orderT(Connection conn, String str) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="SELECT SUM(NumberOfGoods), SUM(price*NumberOfGoods)" + 
				" FROM goods g, shopandgoods s, goodsandorder go" + 
				" WHERE g.GoodID=s.GoodID AND s.SGID=go.SGID" + 
				" AND secondarytype='"+str+"';";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
}
