package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��ȡ�̼���Ϣ
public class UpdateShop {
	
	public String UpdateS(Connection conn, String id, String name, String Account, String password, String tel) throws SQLException{
		int telno = Integer.parseInt(tel);
		Statement statement = conn.createStatement();
		String sql="UPDATE SHOP SET ShopName='"+name+"',Account='"+Account+"',TelNo="+telno+",password='"+password+"' WHERE ShopID='"+id+"';";
		String sql1="SELECT * FROM SHOP WHERE SHOPID='"+id+"'";
		ResultSet rs = statement.executeQuery(sql1);
		if(rs.next()) {
			statement.execute(sql);
			return "�����ɹ����̵��Ѹ��¡�";
		}
		else {
			statement.execute(sql1);
			return "δ��ѯ������̵꣬����ʧ��";
		}
	}
	
}