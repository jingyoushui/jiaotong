package ex1_1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JpSub extends JPanel implements ActionListener, ListSelectionListener{

	JLabel jl1;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;
	JTable jt1;
	
	JTextField text1=null;
	JTextField text2=null;
	JTextField text3=null;
	JTextField text4=null;
	JTextField text5=null;
	JDialog jdl ;
	JLabel jl11;
	JLabel jl2,jl3,jl4,jl5;
	JButton ok,concel;
	
	String sql,a,b,c,d;
	int e;
	 MainCalss ma=new MainCalss();
	public JpSub(){
		jl1=new JLabel("�༭�г�ʱ�̱�");
		
		this.add(jl1);
		String[] cols1 = { "������", "Ŀ�ĵ�", "����ʱ��","����ʱ��","Ʊ��"};
		 MainCalss ma=new MainCalss();
		int n1=ma.Subwaydo().length;
		
		
		String[][] rows1 = new String[n1][5];
		
		for(int i=0;i<n1;i++){
			for(int j=0;j<5;j++){
				rows1[i][j]=ma.Subwaydo()[i][j+1];
			}
		}
		
		jp1=new JPanel();
		jp2=new JPanel();
		jb1=new JButton("ɾ��");
		jb2=new JButton("���");
		jt1=new JTable(rows1,cols1);
		JScrollPane jspTable1=new JScrollPane(jt1);
		jp1.add(jl1);
		jp2.add(jb1);
		jp2.add(jb2);
		this.setLayout(new BorderLayout());
		this.add(jspTable1,BorderLayout.CENTER);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		
		jt1.getSelectionModel().addListSelectionListener(this);
		
		jt1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
			     
			       if(e.getClickCount()==1){
			        tableChanged();        
			       }
			    }
			
		});
	
	}
	
	public void getAdd(){
		 jdl = new JDialog();//�����Ի���
		text1=new JTextField(10);
		text2=new JTextField(10);
	    text3=new JTextField(10);
	    text4=new JTextField(10);
		text5=new JTextField(10);
	    jl11=new JLabel("������");
		 jl2=new JLabel("Ŀ�ĵ�");
		 jl3=new JLabel("����ʱ��");
		 jl4=new JLabel("����ʱ��");
		 jl5=new JLabel("Ʊ��");
		 concel=new JButton("���");
	    ok=new JButton("ȷ��");
		jdl.setLayout(new GridLayout(6,2));
		jdl.add(jl11);
		jdl.add(text1);
		jdl.add(jl2);
		jdl.add(text2);
		jdl.add(jl3);
		jdl.add(text3);
		jdl.add(jl4);
		jdl.add(text4);
		jdl.add(jl5);
		jdl.add(text5);
		jdl.add(concel);
		jdl.add(ok);
        jdl.setSize(300, 200);//�Ի����С
        jdl.setLocationRelativeTo(null);//�Ի������
        jdl.setVisible(true);//�ɼ�
        
        ok.addActionListener(this);
        concel.addActionListener(this);
        
        
		
		
	}
	
	
	public int tableChanged()
	 {
	  int row=jt1.getSelectedRow();    
	 // String preId=jt1.getValueAt(row,0).toString();
	  System.out.println(row);
	  return row;
	 }
	
	
//	public String getOk(){
//		a=text1.getText();
//		b=text2.getText();
//		c=text3.getText();
//		d=text4.getText();
//		e=Integer.parseInt(text5.getText());
//		
//		sql="insert into subway(������,Ŀ�ĵ�,����ʱ��,����ʱ��,Ʊ��) values(a,b,c,d,e);";
//		return sql;
//		
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jb1){
			ma.clickSub();
			
		}else if(e.getSource()==jb2){
			getAdd();
		    
		}else if(e.getSource()==ok){
			
		    ma.clickOk();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getSource() == jt1.getColumnModel().getSelectionModel()
				&& jt1.getColumnSelectionAllowed() ){
			tableChanged();
			
		}
	}
	
}