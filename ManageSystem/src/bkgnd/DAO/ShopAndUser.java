package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class ShopAndUser {
	
	public ResultSet Shop_10(Connection conn, String d1, String d2) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="SELECT ShopName, sum(NumberOfGoods)" + 
				" FROM shop s, shopandgoods sh, goodsandorder g, orders o" + 
				" WHERE o.OrderID=g.OrderID AND g.SGID=sh.SGID AND s.ShopID=sh.ShopID AND g.SGID=sh.SGID" + 
				" AND finishdate between '"+d1+ "' AND '"+d2+"'"+ 
				" GROUP BY s.SHOPID" + 
				" ORDER BY sum(NumberOfGoods) DESC" + 
				" limit 10;";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	public ResultSet User_10(Connection conn, String d1, String d2) throws SQLException{
		Statement statement = conn.createStatement();
		String sql=" SELECT Name, sum(NumberOfGoods*Price)" + 
				" FROM users u, orders o, goodsandorder g, shopandgoods s" + 
				" WHERE u.UserID=o.UserID AND o.OrderID=g.orderID AND s.SGID=g.SGID" + 
				" AND finishdate between  '"+d1+"' AND '"+d2+"'" + 
				" GROUP BY u.UserID" + 
				" ORDER BY sum(NumberOfGoods*Price) DESC" + 
				" limit 10;";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	
}
