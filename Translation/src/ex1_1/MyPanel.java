package ex1_1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class MyPanel extends JPanel implements ActionListener{
	JLabel jb1;
	JLabel jb2;
	JLabel jb3;
	JLabel jb4;
	JLabel jb5;
	JPanel jp2;
	JPanel jp3;
	
	 Weight we=new Weight();
	 
	
	private JTable table;
    //private DefaultTableModel tableModel; 
    String[] cols = { "������", "Ŀ�ĵ�", "��תվ","ʱ��","����","�۸�"};
	String[][] rows = new String[5][6];
	//JTable tblStudents=null;
	//private void initTable(){

    	//tblStudents= new JTable(rows, cols);
    //}
	
	
	JButton seach;
	JComboBox startCity;
	JComboBox endCity;
	JComboBox transWay;
	JComboBox selWay;
	
	
	public MyPanel(){
		we.getWordes();
		we.getWeight();
		jp2=new JPanel();
		jp3=new JPanel();
		//this.setLayout(new GridLayout(2,1));
		this.add(jp2);
		this.add(jp3);
		jp2.setLayout(new GridLayout(2,5,30,10));
		
		String []startWords=we.Words;
		String []endWords=we.Words;
		String []tranWords={"��","�ɻ�"};
		String []selWords={"���","��ʡǮ"};
		startCity=new JComboBox(startWords);
		
		endCity=new JComboBox(endWords);
		transWay=new JComboBox(tranWords);
		selWay=new JComboBox(selWords);
		seach=new JButton("��ѯ");
		jb1=new JLabel("������");
		jb2=new JLabel("Ŀ�ĵ�");
		jb3=new JLabel("��ͨ��ʽ");
		jb4=new JLabel("���ŷ���");
		jb5=new JLabel("һ����ѯ");
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(startCity);
		jp2.add(endCity);
		jp2.add(transWay);
		jp2.add(selWay);
		jp2.add(seach);
		seach.addActionListener(this);
		
		//tableModel = new DefaultTableModel(rows,cols);
	     table = new JTable(rows,cols);
	    
	    // initTable();
	     JScrollPane jspTable=new JScrollPane(table);
	   
		 jp3.add(jspTable);
	
	}
	
	
	public int SubCount(int n, String[] a){
		int m=0;
		m=n*20;
		
		return m;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		we.getWeight();
		we.getWordes();
		int s1=startCity.getSelectedIndex();
		int s2=endCity.getSelectedIndex();
		int s3=transWay.getSelectedIndex();
		int s4=selWay.getSelectedIndex();
		String Startcity=(String)startCity.getSelectedItem();
		String Endcity=(String)endCity.getSelectedItem();		
		String Transway=(String)transWay.getSelectedItem();
		String Selway=(String)selWay.getSelectedItem();
		Dijkstra dij=new Dijkstra();
		
		 int[][] weight=we.Weight;
	        int start=s1; 
	        int end=s2;
	        String a="";
	        double time=0.0;
	        double price=0.0;
		if(e.getSource()==seach){
			
			int[] shortPath = dij.Dijsktra(weight,start,end);  
	          
//	        for(int i = 0;i < shortPath.length;i++){
//	        	if(i==end){
//	             System.out.println("��"+Startcity+"������"+i+"����̾���Ϊ��"+shortPath[i]);   
//	        	}
//	        }
			
			//System.out.println(Startcity+Endcity+Transway+Selway);
			//System.out.println(dij.path2);
			int b=0;
			for(int i=0;i<dij.path2.length();i++){
				b=dij.path2.charAt(i)-48;
				if(b!=s1&&b!=s2){
					System.out.println(b);
					a=a+we.Words[b];
				}
			}
			
			
		 rows[0][0]=Startcity;
		 rows[0][1]=Endcity;
		 rows[0][2]=a;
		 rows[0][4]=shortPath[end]+"ǧ��";
		 if(Transway.equals("��")){
			 time=shortPath[end]/20+(dij.path2.length()-2)*0.5;
			
			 price=shortPath[end]*10;
		 }else if(Transway.equals("�ɻ�")){
			 time=shortPath[end]/60+(dij.path2.length()-2)*0.5;
			 price=shortPath[end]*30;
		 }
		 
		 rows[0][3]=time+"Сʱ";
		 rows[0][5]=price+"Ԫ";
		 jp3.repaint();
			
		}
		
	}
	
	
}