package bkgnd.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bkgnd.model.Administrator;

public class AdminDao {
	/**
	 * 管理员登陆验证
	 * 返回一个Administrator变量，如果登陆失败，则为空
	 * @param conn
	 * @param admin
	 * @return
	 * @throws Exception
	 */
   public Administrator Login(Connection conn,Administrator admin) throws Exception{
	   Administrator resultadmin=null;
	   String sql="select * from Administrator where AID=? AND password=?";
	   PreparedStatement ps =conn.prepareStatement(sql);
	   ps.setString(1,admin.getAID());
	   ps.setString(2, admin.getPassword());
	   ResultSet rs=ps.executeQuery();
	   if(rs.next()) {
		   resultadmin=new Administrator();
		   resultadmin.setAID(admin.getAID());
		   resultadmin.setPassword(admin.getPassword());
	   }
	   return resultadmin;
   }
}
