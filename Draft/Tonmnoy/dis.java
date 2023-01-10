import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.datatransfer.*;

public class dis extends JFrame 
{
	public dis()
	{ 
	
//FRAME 
           JFrame fr = new JFrame("Discount-(AFIF)");
		   fr.setBounds(220,110,1000,600);
		   fr.setLayout(null);
		   Image fr_icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asus\\Desktop\\Final Project\\SOURCES\\Images\\Logo.png");    
	       fr.setIconImage(fr_icon);
	       fr.setResizable(false);
		   fr.setLayout(null);
		   
		   fr.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						File folder = new File("C:\\Users\\Asus\\Desktop\\Final Project\\SOURCES\\Classes");
						File fList[] = folder.listFiles();

						for (File f : fList) {
							if (f.getName().endsWith(".class")) {
								f.delete(); 
							}
						}
						
						fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}else{
						fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);


//Set Background Image
		ImageIcon Username_Background = new ImageIcon("C:\\Users\\Asus\\Desktop\\Final Project\\SOURCES\\Images\\offergui.jpg");
		
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		fr.add(bg_label);			
		
		  
		JTextField t2=new JTextField("BEVOID10");  
        t2.setBounds(500,448,90,35); 
     //set font for JTextField
		t2.setEditable(false);
		t2.setVisible(false);		  
        fr.add(t2);   
         
		 
				   
		   
//backbutton
		   JButton d1 =new JButton(new ImageIcon("back.png"));  
           d1.setBounds(13,525,60,30); 
		   d1.setCursor(new Cursor(Cursor.HAND_CURSOR));
           d1.setContentAreaFilled(false);
		   d1.setFocusPainted(false);
		   d1.setBorderPainted(false);		   
           fr.add(d1);	
          	   
//Copy Button
           JButton d3 =new JButton();  
           d3.setBounds(542,430,20,20);
		   d3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   d3.setContentAreaFilled(false);
		   d3.setFocusPainted(false);
		   d3.setBorderPainted(false);
           fr.add(d3);
           	

		   
//back action listener
		    d1.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent l){
					fr.setVisible(false);
					new Home();
				
				
				}
			});
		
		     
				
				d3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent l){
				
						String strr=t2.getText(); 
						Clipboard clip = Toolkit.getDefaultToolkit ().getSystemClipboard ();
						StringSelection strsele = new StringSelection(strr);
						clip.setContents(strsele,strsele);
						JOptionPane.showMessageDialog(null, "text is copied" );
					}
				});
			
			
				
/////////////////////////////////////////////////////////////////////////////////////////////
	
	 fr.setVisible(true);
	}
}
