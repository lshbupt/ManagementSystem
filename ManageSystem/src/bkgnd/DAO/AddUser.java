package bkgnd.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��ȡ�̼���Ϣ
public class AddUser {
	
	public void AddU(Connection conn, String name, String account, String password, String tel) throws SQLException{
		int telno = Integer.parseInt(tel);
		Statement statement = conn.createStatement();
		String sql="SELECT MAX(UserID) from USER";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		String id = addOne(rs.getString("MAX(UserID)"));
		String sql1="INSERT INTO USER VALUES('"+id+"','"+password+"','"+name+"',"+telno+",'"+account+"');";
		statement.execute(sql1);
	}
	
	public static String addOne(String testStr){
	    String[] strs = testStr.split("[^0-9]");//���ݲ������ֵ��ַ�����ַ���
	    String numStr = strs[strs.length-1];//ȡ�����һ������
	    if(numStr != null && numStr.length()>0){//������һ��û������(Ҳ���ǲ������ֽ�β)����NumberFormatException�쳣
	        int n = numStr.length();//ȡ���ַ����ĳ���
	        int num = Integer.parseInt(numStr)+1;//�������ּ�һ
	        String added = String.valueOf(num);
	        n = Math.min(n, added.length());
	        //ƴ���ַ���
	        return testStr.subSequence(0, testStr.length()-n)+added;
	    }else{
	        throw new NumberFormatException();
	    }
	}
	
}
