package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��ȡ�̼���Ϣ
public class UpdateUser {
	
	public String UpdateU(Connection conn, String id, String name, String Account,String password, String tel) throws SQLException{
		int telno = Integer.parseInt(tel);
		Statement statement = conn.createStatement();
		String sql="UPDATE USERs SET Name='"+name+"',Account='"+Account+"',TelNo="+telno+",Password='"+password+"' WHERE UserID='"+id+"';";
		String sql1="SELECT * FROM USERs WHERE UserID='"+id+"'";
		ResultSet rs = statement.executeQuery(sql1);
		if(rs.next()) {
			statement.execute(sql);
			return "�����ɹ����û���Ϣ�Ѹ��¡�";
		}
		else {
			statement.execute(sql1);
			return "δ��ѯ������û�������ʧ��";
		}
	}
	
}