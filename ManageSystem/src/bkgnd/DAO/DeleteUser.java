package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��ȡ�̼���Ϣ
public class DeleteUser {
	
	public String DeleteU(Connection conn, String id) throws SQLException{
		Statement statement = conn.createStatement();
		String sql="SET foreign_key_checks = 0";
		String sql1="DELETE FROM USERs WHERE UserID='"+id+"'";
		String sql2="SELECT * FROM USERs WHERE UserID='"+id+"'";
		ResultSet rs = statement.executeQuery(sql2);
		if(rs.next()) {
			statement.execute(sql);
			statement.execute(sql1);
			return "�����ɹ����û���ɾ����";
		}
		else {
			statement.execute(sql2);
			return "δ��ѯ������û���ɾ��ʧ��";
		}
	}
	
}