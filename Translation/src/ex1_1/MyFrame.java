package ex1_1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame {

	 
	JSplitPane jsp;
	JList jlist;
	MyPanel jp1;
	JpCity jpCity;
	JpSub jpSubway;
	JpAir jpAirp;
	static JPanel card;  
    static CardLayout cl;
	
	public static void main (String[] args){
		MyFrame frm=new MyFrame();
	}
	public MyFrame(){
		//创建组件
		final String []words={"编辑城市信息","编辑列车时刻表","编辑飞机航班","查询","刷新"};
		jlist = new JList(words);
		jp1=new MyPanel();	
		jpCity=new JpCity();
		jpSubway=new JpSub();
		jpAirp=new JpAir();
		
		

		card = new JPanel();  
        cl = new CardLayout();
		
        card.setLayout(cl);
        card.add(jp1,"p1");
        card.add(jpCity,"p2");
        card.add(jpSubway,"p3");
		card.add(jpAirp,"p4");
		
		
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,card);
		jsp.setOneTouchExpandable(true);
		this.add(jsp);
		
		jlist.addMouseListener(new MouseAdapter(){
			public  void mouseClicked(MouseEvent e){
				JList jlist1 = (JList) e.getSource();
				int index = jlist1.getSelectedIndex();
				if(e.getClickCount()==1||e.getClickCount()==2){
					  
					//System.out.println(index);
					if(index==0){
						cl.show(card,"p2");
					
						//jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,cl.next(card));
						
					}else if(index==1){
						cl.show(card,"p3");
					}else if(index==2){
						cl.show(card,"p4");
									
					}else if(index==3){
						cl.show(card,"p1");
											
					}else if(index==4){
						jsp.repaint();
					}
						
				}else{
					cl.show(card,"p1");			
				}	

			}
			
		});
		
	
		
		this.setSize(600,300);
		this.setLocation(200,200);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}































