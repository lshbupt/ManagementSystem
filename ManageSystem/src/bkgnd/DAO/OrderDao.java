package bkgnd.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bkgnd.model.shop;

public class OrderDao {
	public static ResultSet topgoods(Connection conn,shop Shop,String leftDate,String rightDate) throws SQLException {
		ResultSet rs;
		String sql="select g.Name ,sum(go.numberofgoods)"
				+ "from orders o,goodsandorder go,shopandgoods sg,goods g "
				+ "where o.orderid=go.orderid AND go.sgid=sg.sgid AND sg.goodid=g.goodid AND sg.shopid=?"
				+ "AND o.status=? AND o.finishdate>=? AND o.finishdate<=? "
				+"group by g.Name"
				+ " order by sum(go.numberofgoods) DESC";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, Shop.getShopID());
		ps.setString(2, "Completed");
		ps.setString(3, leftDate);
		ps.setString(4, rightDate);
		rs=ps.executeQuery();
		return rs;
	}
	public static ResultSet showOrder(Connection conn,shop Shop) throws SQLException {
		ResultSet rs;
		String sql="select go.OrderID,o.UserID,o.Date,o.time,g.name,sg.price,"
				+ "go.numberofgoods,(sg.price*go.numberofgoods)AS total,g.firsttype,g.secondarytype,o.status,o.finishDate,o.finishtime "
				+ "from orders o,goodsandorder go,shopandgoods sg,goods g "
				+ "where o.orderid=go.orderid AND go.sgid=sg.sgid AND sg.goodid=g.goodid AND sg.shopid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, Shop.getShopID());
		rs=ps.executeQuery();
		return rs;
   }
   public static ResultSet showOrder(Connection conn,shop Shop,String leftdate,String rightdate,String type,String status) throws SQLException {
		ResultSet rs;
		if(status=="-不限-") {
		if(type=="-不限-") {
		String sql="select go.OrderID,o.UserID,o.Date,o.time,g.name,sg.price,"
				+ "go.numberofgoods,(sg.price*go.numberofgoods)AS total,g.firsttype,g.secondarytype,o.status,o.finishDate,o.finishtime "
				+ "from orders o,goodsandorder go,shopandgoods sg,goods g "
				+ "where o.orderid=go.orderid AND go.sgid=sg.sgid AND sg.goodid=g.goodid AND sg.shopid=? AND o.Date>=? AND o.Date<=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, Shop.getShopID());
		ps.setString(2, leftdate);
		ps.setString(3, rightdate);
		rs=ps.executeQuery();
		return rs;}
		else {
			String sql="select go.OrderID,o.UserID,o.Date,o.time,g.name,sg.price,"
					+ "go.numberofgoods,(sg.price*go.numberofgoods)AS total,g.firsttype,g.secondarytype,o.status,o.finishDate,o.finishtime "
					+ "from orders o,goodsandorder go,shopandgoods sg,goods g "
					+ "where o.orderid=go.orderid AND go.sgid=sg.sgid AND sg.goodid=g.goodid AND sg.shopid=? AND o.Date>=? AND o.Date<=? AND g.secondarytype=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Shop.getShopID());
			ps.setString(2, leftdate);
			ps.setString(3, rightdate);
			ps.setString(4, type);
			rs=ps.executeQuery();
			return rs;
		}
		}
		else {
			if(type=="-不限-") {
				String sql="select go.OrderID,o.UserID,o.Date,o.time,g.name,sg.price,"
						+ "go.numberofgoods,(sg.price*go.numberofgoods)AS total,g.firsttype,g.secondarytype,o.status,o.finishDate,o.finishtime "
						+ "from orders o,goodsandorder go,shopandgoods sg,goods g "
						+ "where o.orderid=go.orderid AND go.sgid=sg.sgid AND sg.goodid=g.goodid AND sg.shopid=? AND o.Date>=? AND o.Date<=? AND o.status=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, Shop.getShopID());
				ps.setString(2, leftdate);
				ps.setString(3, rightdate);
				ps.setString(4, status);
				rs=ps.executeQuery();
				return rs;}
				else {
					String sql="select go.OrderID,o.UserID,o.Date,o.time,g.name,sg.price,"
							+ "go.numberofgoods,(sg.price*go.numberofgoods)AS total,g.firsttype,g.secondarytype,o.status,o.finishDate,o.finishtime "
							+ "from orders o,goodsandorder go,shopandgoods sg,goods g "
							+ "where o.orderid=go.orderid AND go.sgid=sg.sgid AND sg.goodid=g.goodid AND sg.shopid=? AND o.Date>=? AND o.Date<=? AND g.secondarytype=? AND o.status=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, Shop.getShopID());
					ps.setString(2, leftdate);
					ps.setString(3, rightdate);
					ps.setString(4, type);
					ps.setString(5, status);
					rs=ps.executeQuery();
					return rs;
				}
		}
   }
   public static void updateOrderStatus(Connection conn,String OrderID,String status) throws SQLException {
	  /* if(status=="") {
		   JOptionPane.showMessageDialog(null, "当前订单状态不可改变！！");
	   }
	   else {*/
	   if(status=="Completed"||(status=="Canceled")) {
		   String sql="update orders set status=?,FinishDate=?,FinishTime=? where orderid=?";
		   PreparedStatement ps=conn.prepareStatement(sql);
		   ps.setString(1, status);
		   ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
		   ps.setTime(3, new java.sql.Time(System.currentTimeMillis()));
		   ps.setString(4, OrderID);
		   ps.execute();
	   }
	   else {
		   String sql="update orders set status=?,FinishDate=?,FinishTime=? where orderid=?";
		   PreparedStatement ps=conn.prepareStatement(sql);
		   ps.setString(1, status);
		   ps.setDate(2, null);
		   ps.setTime(3, null);
		   ps.setString(4, OrderID);
		   ps.execute();
	   }
	   }
	//}
}
