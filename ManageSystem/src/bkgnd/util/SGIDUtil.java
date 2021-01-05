package bkgnd.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SGIDUtil {
	/**
	 * 生成不冲突的主键
	 * @return
	 */
    public String getSGID() {
    	String SGID=null;
    	String max;
    	int sgnum;
    	Connection conn=null;
    	DBUtil dbutil=new DBUtil();
    	try {
    		 conn=dbutil.getCon();
    		String sql="select max(SGID) from shopandgoods";
    		PreparedStatement ps=conn.prepareStatement(sql);
    		ResultSet rs=ps.executeQuery();
    		if(rs.next()) {
    		max=rs.getString(1);
    		sgnum=Integer.valueOf(max.substring(2));
    		sgnum++;
    		SGID="sg"+String.format("%04d",sgnum);}
    		return SGID;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    	finally {
    		try {
				dbutil.closeConnection(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
