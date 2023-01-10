import javax.swing.*;    
import java.awt.event.*;  
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.*;
import java.util.*;
class Main implements ActionListener{
	    JFrame F1;
		JButton b1,b2;
		JLabel L1,L2;
	    ImageIcon i1;
		JTextField text;
		JPasswordField value;
		
		
		Main(){
		
		F1 = new JFrame();
		
		Color col = new Color(0, 0, 0);
		Color col1 = new Color (153, 153, 255);
		Font font = new Font("Arial", Font.BOLD, 14);
		
		 
		i1 = new ImageIcon("logo.png");
		  
		L1 = new JLabel();
		L1.setText("E-mail :");
		L1.setBounds(20,20,80,30);
		L1.setForeground(col);
		L1.setBackground(col1);
		 
		 
		L2 = new JLabel();
		L2.setText("Password :");
		L2.setBounds(20,75,80,30);
		L2.setForeground(col);
		L2.setBackground(col1);
		
		 
		final JTextField text = new JTextField();  
        text.setBounds(100,20,100,30); 
		 
		final JPasswordField value = new JPasswordField();   
        value.setBounds(100,75,100,30);
		 
		b1 = new JButton("SignUP");  
        b1.setBounds(100,315,85,25);  
        b1.setForeground(col);
        b1.setFont(font);
        b1.setBackground(col1);
        b1.addActionListener(this);
		
		b2 = new JButton("Login");  
        b2.setBounds(20,315,85,25);  
        b2.setForeground(col);
        b2.setFont(font);
        b2.setBackground(col1);
        b2.addActionListener(this);
	 
		
		F1.setTitle("BUS TICKET");
		F1.setSize(800,450);
		F1.setLayout(null);
		F1.getContentPane().setBackground(new Color (240,240,245));
		F1.setResizable(false);
		F1.setLocationRelativeTo(null);
		F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F1.setVisible(true);
		
		F1.add(L1);
		F1.add(L2);
		F1.add(value);
		F1.add(text);
		F1.add(b1);
		F1.add(b2);
		}
		
		public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
		{
			//new Register();
			//F1.setVisible(false);
		}
		if(e.getSource() == b2)
		{
			//new Register();
			//F1.setVisible(false);
		}
		
}
public static void main(String args[]){
		new Main();
	}
}