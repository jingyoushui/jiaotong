package ex1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Statement;


public class SqlConnection {
	private static final String URL="jdbc:mysql://localhost:3306/translation";//数据库连接字符串，这里的deom为数据库名  
    private static final String NAME="root";//登录名  
    private static final String PASSWORD="";//密码 
    public static final String name = "com.mysql.jdbc.Driver";
    public Connection conn = null;  
    public PreparedStatement pst = null;
    
    public SqlConnection(String sql)  
    {  
        //1.加载驱动  
    	try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);//获取连接  
            pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//准备执行语句  
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
