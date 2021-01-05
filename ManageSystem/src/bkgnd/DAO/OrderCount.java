package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//获取商家信息
public class OrderCount {
	
	public ResultSet amount(Connection conn, String year, String month) throws SQLException{
		Statement statement = conn.createStatement();
		String sql=" SELECT sum(NumberOfGoods)" + 
				" FROM orders o, goodsandorder g, shopandgoods s" + 
				" WHERE o.orderID=g.orderid and s.sgid=g.sgid" + 
				" and year(finishdate)='"+year+"' "+
				" and month(finishdate)= '"+month+"';";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	public ResultSet price(Connection conn, String year, String month) throws SQLException{
		Statement statement = conn.createStatement();
		String sql=" SELECT sum(NumberOfGoods*Price)" + 
				" FROM orders o, goodsandorder g, shopandgoods s" + 
				" WHERE o.orderID=g.orderid and s.sgid=g.sgid" + 
				" and year(finishdate)='"+year+"' "+
				" and month(finishdate)= '"+month+"';";
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	
}
