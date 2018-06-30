package ex1_1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;

public class MainCalss {
	static String sql1,sqlok,sqlsub,sql11,sql2,sql21,sql3,sql31,sql4,sql41=null;
	static SqlConnection db1,dbok,dbsub,db11 ,db2,db21,db3,db31,db4,db41=null;
	static ResultSet ret1 =null;
	static ResultSet ret2=null;
	static ResultSet ret3=null;
	static ResultSet ret4=null;
	

	
	public  MainCalss(){
		sql11="select count(*) from words";
		sql21="select count(*) from subway";
		sql31="select count(*) from air";
		sql41="select count(*) from weight";
		sql1="select * from words";
		sql2="select * from subway";
		sql3="select * from air";
		sql4="select * from weight";
		
		sqlok="insert into subway(出发地,目的地,出发时间,到达时间,票价)"+ "values(?,?,?,?,?);";
		//sqlsub="delete from subway where id=?";
		
		db11= new SqlConnection(sql11);
		db21= new SqlConnection(sql21);
		db1= new SqlConnection(sql1); 
		db2=new SqlConnection(sql2); 
		db3=new SqlConnection(sql3); 
		db31=new SqlConnection(sql31); 
		db4=new SqlConnection(sql4); 
		db41=new SqlConnection(sql41); 
		dbok= new SqlConnection(sqlok); 
		//dbsub=new SqlConnection(sqlsub);
		
	}
	
	
	public static String[] Sqldo(){
		String[] Words=null;
		int n=0;
		
		try {  
			ret1 = db11.pst.executeQuery();
				
			ret1.next();
			n=ret1.getInt(1);
	           ret1 = db1.pst.executeQuery();//执行语句，得到结果集  
	           Words=new String[n];
	           while (ret1.next()) {  
	               int id = ret1.getInt(1);  
	               String city = ret1.getString(2);  
	              Words[id-1]=city;
	              
	           }
	           
	           
	           //显示数据  
	         //  ret.close();  
	          // db1.close();//关闭连接  
	       } catch (SQLException e) {  
	           e.printStackTrace();  
	       }
		return Words;
		
	}
	
	public static String[][] Subwaydo(){
		String[][] sub=null;
		int n=0;
		try {  
			ret2 = db21.pst.executeQuery();
				
			ret2.next();
			n=ret2.getInt(1);
			//System.out.println(n);
	           ret2 = db2.pst.executeQuery();//执行语句，得到结果集  
	           sub=new String[n][6];
	           int a=0;
	           while (ret2.next()) {  
	             for(int i=0;i<6;i++){
	            	 sub[a][i]=ret2.getString(i+1);
	             }
	              a++;
	           }
	           
	           
	           //显示数据  
	         //  ret.close();  
	          // db1.close();//关闭连接  
	       } catch (SQLException e) {  
	           e.printStackTrace();  
	       }
		return sub;
		
	}
	
	public static String[][] Airdo(){
		String[][] air=null;
		int n=0;
		try {  
			ret3 = db31.pst.executeQuery();
				
			ret3.next();
			n=ret3.getInt(1);
			//System.out.println(n);
	           ret3 = db3.pst.executeQuery();//执行语句，得到结果集  
	           air=new String[n][6];
	           int a=0;
	           while (ret3.next()) {  
	             for(int i=0;i<6;i++){
	            	 air[a][i]=ret3.getString(i+1);
	             }
	              a++;
	           }
	           
	           
	           //显示数据  
	         //  ret.close();  
	          // db1.close();//关闭连接  
	       } catch (SQLException e) {  
	           e.printStackTrace();  
	       }
		return air;
		
	}
	
	
	public static String[][] Weightdo(){
		String[][] weight=null;
		int n=0;
		try {  
			ret4 = db41.pst.executeQuery();
				
			ret4.next();
			n=ret4.getInt(1);
			//System.out.println(n);
	           ret4 = db4.pst.executeQuery();//执行语句，得到结果集  
	           weight=new String[n][n+2];
	           int a=0;
	           while (ret4.next()) {  
	             for(int i=0;i<=n+1;i++){
	            	 weight[a][i]=ret4.getString(i+1);
	             }
	              a++;
	           }
	           
	           
	           //显示数据  
	         //  ret.close();  
	          // db1.close();//关闭连接  
	       } catch (SQLException e) {  
	           e.printStackTrace();  
	       }
		return weight;
		
	}
	
	public static void clickOk(){
		
		try {
			//PreparedStatement ps=dbok.conn.prepareStatement(sqlok);
			//JpSub jps=new JpSub();
			//dbok.pst.executeQuery();
		dbok.pst.setString(1,"shanghai");
		dbok.pst.setString(2, "beijing");
		dbok.pst.setString(3,"29-10:10" );
		dbok.pst.setString(4, "30-08:10");
		dbok.pst.setInt(5,670);
		dbok.pst.executeUpdate();
			System.out.println("kkkk");
			//db1.pst.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public static void clickSub(){
		
		JpSub jps=new JpSub();
		int n=jps.tableChanged()+1;
		sqlsub="delete from subway where id=?";
		dbsub=new SqlConnection(sqlsub);
		try{
			dbsub.pst.setInt(1, n);
			dbsub.pst.executeUpdate();
			System.out.println(n);
		}catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	 public void show(String[] s){
		 for(int i=0;i<s.length;i++){
			 System.out.print(s[i]+" ");
		 }
	 }
	 public void show(String[][] w){
		 int n=w.length;
		 int m=w[0].length;
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++){
				 System.out.print(w[i][j]+" ");
			 }
			 System.out.println();
		 }
	 }
	public static void main(String[] args) {  
        // TODO 自动生成的方法存根 
		//sql="select * from words";
     //  db1= new SqlConnection(sql); 
       MainCalss ma=new MainCalss();
       ma.show(Weightdo());
      
   }    
       
        
   
	
	
	
	
	

}
