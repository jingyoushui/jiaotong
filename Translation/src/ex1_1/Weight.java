package ex1_1;

import java.util.Arrays;
import java.util.ArrayList;
public class Weight {
	static MainCalss ma=new MainCalss();
	int n=ma.Sqldo().length;
	static int m1=ma.Weightdo().length;
	static int m2=ma.Weightdo()[0].length;
	final static int M=10000;//(此路不通) 
	static int[][] Weight=new int[m1][m2-2];
	public int[][] getWeight(){
		for(int i=0;i<m1;i++){
			for(int j=2;j<m2;j++){
				Weight[i][j-2]=Integer.parseInt(ma.Weightdo()[i][j]);
			}
		}
		return Weight;
	}
	
//	static int[][] Weight = {  
//        {0,10,M,30,100},  
//        {10,0,50,40,M},  
//        {M,50,0,20,10},  
//        {30,40,20,0,60},  
//        {100,M,10,60,0}  
//};  
   //String []Words={"北京","武汉","广州","深圳","上海"};
	
	String[] Words=new String[n];
	
	
	public String[] getWordes(){
		for(int i=0;i<n;i++){
			Words[i]=ma.Sqldo()[i];
		}
		return Words;
	}
	 public Weight(){
		 
		 
	 }
	 
	 public String[] subwords(int a){//操作Words数组，删除一个
		 int n=Words.length;
		 String[] wor=new String[n-1];
		 for(int i=a-1;i<n-1;i++){
			 Words[i]=Words[i+1];
		 }
		 for(int i=0;i<n-1;i++){
			 wor[i]=Words[i];
		 }
		 return wor;
	 }
	 
	 
	 
	 
	 public int[][] changW(){//取出两点间的距离
	
		 int k=0;
		 int n=Weight.length;
		 int m=0;
		
		 for(int i=0;i<n;i++){
			 for(int j=(i+1);j<n;j++){
				 if(Weight[i][j]<M){
					m+=1; 
				 }
			 }
		 }
		 int[][] a=new int[m][3];
		 for(int i=0;i<n;i++){
			 for(int j=(i+1);j<n;j++){
				 if(Weight[i][j]<M){
					a[k][0]=i;
					a[k][1]=j;
					a[k][2]=Weight[i][j];
					k+=1;
				 }
				
			 }
		 }
		 return a;
		 
	 }
	 public int[][] addWeight(int[] a){//添加城市后交通网络的改变
		 int n=Weight.length;
		 int[][] weight2=new int[n+1][n+1];
		 for(int i=0;i<n;i++){
			 for(int j=0;j<n;j++){
				 weight2[i][j]=Weight[i][j];
			 }
			 weight2[i][n]=a[i];
		 }
		 for(int j=0;j<n+1;j++){
			 weight2[n][j]=a[j];
		 }
		 return weight2;
	 }
	 
	 public void show(int[][] w){
		 int n=w.length;
		 int m=w[0].length;
		 for(int i=0;i<n;i++){
			 for(int j=0;j<m;j++){
				 System.out.print(w[i][j]+" ");
			 }
			 System.out.println();
		 }
	 }
	 
	 public void show(String[] s){
		 for(int i=0;i<s.length;i++){
			 System.out.print(s[i]+" ");
		 }
	 }
	 
	public static void main(String[] args){
		Weight we=new Weight();
		int[] a={10,20,30,40,50,60};
		we.getWeight();
		we.show(we.addWeight(a));
		we.show(we.getWeight());
		
		//we.show(we.Words);
		//we.show(ma.Sqldo());
	}
	 
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 


