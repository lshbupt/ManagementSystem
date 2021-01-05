package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class orderByTime {
	
	public ResultSet get10(Connection conn, String d1, String d2) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="SELECT Name, sum(NumberOfGoods*Price)" + 
				" FROM goods s, shopandgoods sh, goodsandorder g, orders o" + 
				" WHERE o.OrderID=g.OrderID AND g.SGID=sh.SGID AND s.GoodID=sh.GoodID AND g.SGID=sh.SGID" + 
				" AND finishdate between '"+d1+ "' AND '"+d2+"'"+ 
				" GROUP BY s.GOODID" + 
				" ORDER BY sum(NumberOfGoods*Price) DESC" + 
				" limit 10;";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	public ResultSet getmost(Connection conn, String d1, String d2) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="SELECT DISTINCT count(o.orderid), sum(price*numberofgoods)" + 
				" FROM ORDERS o, goodsandorder g, shopandgoods s" + 
				" WHERE o.orderid=g.orderid AND g.SGID=s.SGID "+
				" AND o.finishdate between '"+d1+"' AND '"+d2+"';";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	
}
