package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class orderShop {
	
	public ResultSet getS(Connection conn, String d1, String d2, String id) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="SELECT sum(NumberOfGoods), sum(NumberOfGoods*Price)" + 
				" FROM shop s, shopandgoods sh, goodsandorder g, orders o" + 
				" WHERE o.OrderID=g.OrderID AND g.SGID=sh.SGID AND s.shopID=sh.shopID AND g.SGID=sh.SGID" + 
				" AND finishdate between '"+d1+ "' AND '"+d2+"'"+ 
				" AND s.shopID='"+id+"';";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
}
