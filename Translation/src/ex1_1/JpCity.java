package ex1_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

class JpCity extends JPanel implements ActionListener{

	JLabel jl1;
	JButton jb1;
	JButton jb2;
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JTable jt1;
	
	Weight we=new Weight();
	
  
	
	public JpCity(){
		we.getWordes();
		 String[] cols1 = { "城市名", "相邻城市","距离"};
		 int m=we.changW().length;
		 
			String[][] rows1 = new String[m][3];
			
			for(int i=0;i<m;i++){
				for(int j=0;j<2;j++){
					rows1[i][j]=we.Words[we.changW()[i][j]];
				}
				rows1[i][2]=we.changW()[i][2]+"千米";
			}
			
		jp1=new JPanel();
		jp2=new JPanel();
		jl1=new JLabel("编辑城市信息");
		jb1=new JButton("删除");
		jb2=new JButton("添加");
		jt1=new JTable(rows1,cols1);
		JScrollPane jspTable1=new JScrollPane(jt1);
		jp1.add(jl1);
		jp2.add(jb1);
		jp2.add(jb2);
		this.setLayout(new BorderLayout());
		this.add(jspTable1,BorderLayout.CENTER);
		this.add(jp1,BorderLayout.NORTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//this.add(jp13);
		this.add(jp2,BorderLayout.SOUTH);
		jt1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
			     
			       if(e.getClickCount()==1){
			        tableChanged();        
			       }
			    }
			
		});
		
	}
	
	public void tableChanged()
	 {
	  int row=jt1.getSelectedRow();    
	  String preId=jt1.getValueAt(row,0).toString();
	  System.out.println(preId);
	 }
	
	public String[] subword(String[] word, String a){
		int n=word.length;
		for(int i=0;i<n;i++){
			if(a==word[i]){
				word[i]=null;
			}
		}
		return word;
		
	}
	public String[] addword(String[] word,String a){
		int n=word.length;
		word[n]=a;
		return word;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		we.getWordes();
		if(e.getSource()==jb1){
			int row=jt1.getSelectedRow();    
			String preId=jt1.getValueAt(row,0).toString();
			int m=0;
			for(int i=0;i<we.Words.length;i++){
				if(we.Words[i].equals(preId)){
					m=i;
				}
			}
			
			we.subwords(m);
			
			jt1.repaint();
		
		}else if(e.getSource()==jb2){
			
		}
	}
	
}
