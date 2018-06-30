package ex1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Statement;


public class SqlConnection {
	private static final String URL="jdbc:mysql://localhost:3306/translation";//���ݿ������ַ����������deomΪ���ݿ���  
    private static final String NAME="root";//��¼��  
    private static final String PASSWORD="";//���� 
    public static final String name = "com.mysql.jdbc.Driver";
    public Connection conn = null;  
    public PreparedStatement pst = null;
    
    public SqlConnection(String sql)  
    {  
        //1.��������  
    	try {  
            Class.forName(name);//ָ����������  
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);//��ȡ����  
            pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//׼��ִ�����  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
}
