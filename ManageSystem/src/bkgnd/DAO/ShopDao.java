package bkgnd.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bkgnd.model.ShopAndGoods;
import bkgnd.model.shop;
/**
 * 商家数据获取对象（data access object)
 * @author lsh18
 *
 */
public class ShopDao {
    public void ChangePassword(Connection conn,shop Shop ,String newpassword) throws SQLException
	{
		String sql="Update Shop set password=? where shopid=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, newpassword);
		ps.setString(2, Shop.getShopID());
		ps.execute();
	}
    /**
     * 商户登陆验证
     * @param conn
     * @param Shop
     * @return
     * @throws SQLException 
     */
	
	public shop Login(Connection conn,shop Shop) throws SQLException {
		shop resultshop=null;
		String sql="select * from shop where account=? and password=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, Shop.getAccount());
		ps.setString(2, Shop.getPassword());
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			resultshop=new shop();
			resultshop.setAccount(Shop.getAccount());
			resultshop.setPassword(Shop.getPassword());
			resultshop.setShopID(rs.getString(1));
			resultshop.setShopname(rs.getString(2));
		}
		return resultshop;
	}
	/**
	 * 查询商店里的某个商品的信息
	 * @param conn
	 * @param Shop
	 * @param goodname
	 * @return
	 * @throws SQLException
	 */
	public ResultSet Goodslist(Connection conn,shop Shop,String goodname) throws SQLException {
		ResultSet rs;
		String sql="select SGID,Name,price,remain,Instruction from shopandgoods s,Goods g where s.GoodID=g.GoodID AND shopID=?";
		String sql2="select SGID,Name,price,remain,Instruction from shopandgoods s,Goods g where s.GoodID=g.GoodID AND shopID=? And Name like ?";
		if(goodname.equals("")||goodname==null) {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Shop.getShopID());
			rs=ps.executeQuery();
		}
		else {
			PreparedStatement ps=conn.prepareStatement(sql2);
			ps.setString(1, Shop.getShopID());
			ps.setString(2,"%"+goodname+"%");
			rs=ps.executeQuery();
		}
		
		return rs;
		
	}
	/**
	 * 向某个商家添加产品
	 * @param conn
	 * @param sg
	 * @throws SQLException 
	 */
	public void InsertSG(Connection conn,ShopAndGoods sg) throws SQLException {
		String sql="insert into shopandgoods values(?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, sg.getSGID());
		ps.setInt(2, sg.getPrice());
		ps.setInt(3, sg.getRemain());
		ps.setString(4, sg.getShopID());
		ps.setString(5, sg.getGoodID());
		ps.execute();
		
	}
	public void updateSG(Connection conn,String SGID,int remain,int price) throws SQLException {
		String sql="update shopandgoods  set price=?,remain=? where SGID=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, price);
		ps.setInt(2, remain);
		ps.setString(3, SGID);
		ps.execute();
	}
	public void deleteSG(Connection conn,String SGID) throws SQLException {
		String sql="delete from shopandgoods where SGID=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,SGID);
		ps.execute();
	}
}
