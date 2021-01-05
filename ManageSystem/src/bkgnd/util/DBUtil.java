package bkgnd.util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 数据库工具类
 * @author lsh18
 *
 */
public class DBUtil {
	private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	private String JDBC_URL = "jdbc:mysql://localhost:3306/mall?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private  String JDBC_USER="root";
	private  String  JDBC_PASSWORD="83305898abc";
	//?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @throws Exception
	 */
	public void closeConnection(Connection conn) throws Exception{
		if(conn!=null) {
			conn.close();
		}
	}
}
