import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class Contact_Us{

//Colors
	Color LIGHT_RED = new Color (255,102,102);
	Color LIGHT_BLUE = new Color (51,153,255);
	Color Dark_CYAN = new Color (14,161,177);
	
	
	public Contact_Us()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setBounds(250,110,1000,600);
		frame.setTitle("Sign Up Panel");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Logo.png");    
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		//Frame Close Confirmation
		/* frame.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						File folder = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Classes");
						File fList[] = folder.listFiles();

						for (File f : fList) {
							if (f.getName().endsWith(".class")) {
								f.delete(); 
							}
						}
						
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					}else{
						frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);
		 */frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Container creation
		Container panel = new Container();
		panel=frame.getContentPane();
		panel.setLayout(null);
///////////////////////////////////////////////////////

/////////////////Upper Buttons
		Font upperButtonFont = new Font ("Arial", Font.BOLD,15);//Upper Buttons Font
//Home Button
		JButton home_Button=new JButton("HOME");  
		home_Button.setBounds(00,00,250,50);  
		home_Button.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		home_Button.setFont(upperButtonFont);
		home_Button.setBackground(Dark_CYAN);
		home_Button.setForeground(Color.WHITE);
		panel.add(home_Button);

		//Home Button Hover
		home_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				home_Button.setBackground(LIGHT_RED);
				home_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				home_Button.setBackground(Dark_CYAN);
				home_Button.setForeground(Color.WHITE);
			}
		});

//Balance Button
		JButton Balance_Button=new JButton("Balance");  
		Balance_Button.setBounds(250,00,250,50);
		Balance_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Balance_Button.setFont(upperButtonFont);
		Balance_Button.setBackground(Dark_CYAN);
		Balance_Button.setForeground(Color.WHITE);
		panel.add(Balance_Button);

		//Balance Button Hover
		Balance_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				Balance_Button.setBackground(LIGHT_RED);
				Balance_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				Balance_Button.setBackground(Dark_CYAN);
				Balance_Button.setForeground(Color.WHITE);
			}
		});
		
//Account Button
		JButton account_Button=new JButton("ACCOUNT");  
		account_Button.setBounds(500,00,250,50);  
		account_Button.setFont(upperButtonFont);
		account_Button.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		account_Button.setBackground(Dark_CYAN);
		account_Button.setForeground(Color.WHITE);
		panel.add(account_Button);
		
		//Account Button Hover
		account_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				account_Button.setBackground(LIGHT_RED);
				account_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				account_Button.setBackground(Dark_CYAN);
				account_Button.setForeground(Color.WHITE);
			}
		});
		
//Contact us Button
		JButton contactus_Button=new JButton("CONTACT US");  
		contactus_Button.setBounds(750,00,236,50);  
		contactus_Button.setFont(upperButtonFont);
		contactus_Button.setBackground(LIGHT_RED);
		contactus_Button.setForeground(Color.BLACK);
		panel.add(contactus_Button);
///////////////////////////
		
		
//Phone Number Label
		JLabel phoneNumber_label = new JLabel("Phone Number  :");
		phoneNumber_label.setBounds(40,428,120,20);
		phoneNumber_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(phoneNumber_label);
		
		//Number Label
		JLabel Number_label = new JLabel("+880 1772-317392");
		Number_label.setBounds(170,428,150,20);
		Number_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Number_label);
		
		
//Email Address Label
		JLabel email_label = new JLabel("Email Address   :");
		email_label.setBounds(40,465,120,20);
		email_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(email_label);
		
		//email Label
		JLabel Email_label = new JLabel("bevoidbookshop@gmail.com");
		Email_label.setBounds(170,465,210,20);
		Email_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Email_label);
		
		
		Email_label.setForeground(new Color (51,153,255));
		Email_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Mouse Listener
		Email_label.addMouseListener(new MouseAdapter() {
 
			public void mouseClicked(MouseEvent e) {
				try {
         
					Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/?ogbl#inbox?compose=CllgCHrjDvTXgCSbsnXzPzLLZKZpqjndsqNkVKjWwqgzPMhlNcSQnbfzxXXXmXSdFgNvLvRRbhg"));
					 
				} catch (IOException | URISyntaxException e1) {
					System.out.println("Browse problem");
				}
			}
		 
			@Override
			public void mouseEntered(MouseEvent e) {
				Email_label.setText("<html><a href=''>bevoidbookshop@gmail.com</a></html>");
			}
		 
			@Override
			public void mouseExited(MouseEvent e) {
				Email_label.setText("bevoidbookshop@gmail.com");
			}
		});
		
//Facebook Page Label
		JLabel fbpage_label = new JLabel("Facebook Page :");
		fbpage_label.setBounds(40,502,120,20);
		fbpage_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(fbpage_label);
		
		//fb page Label
		JLabel Facebook_label = new JLabel("Facebook Page");
		Facebook_label.setBounds(170,502,110,20);
		Facebook_label.setFont(new Font ("Arial", Font.BOLD,14));
		panel.add(Facebook_label);
		
		
		Facebook_label.setForeground(new Color (51,153,255));
		Facebook_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Mouse Listener
		Facebook_label.addMouseListener(new MouseAdapter() {
 
			public void mouseClicked(MouseEvent e) {
				try {
         
					Desktop.getDesktop().browse(new URI("https://www.facebook.com/EkramulHaqueEHR"));
					 
				} catch (IOException | URISyntaxException e1) {
					System.out.println("Browse problem");
				}
			}
		 
			@Override
			public void mouseEntered(MouseEvent e) {
				Facebook_label.setText("<html><a href=''>Facebook Page</a></html>");
			}
		 
			@Override
			public void mouseExited(MouseEvent e) {
				Facebook_label.setText("Facebook Page");
			}
		});
		
		
		
		
		
		
		
		





//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Contact_Us.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		
		
		
//Set Visibility
frame.setVisible(true);
	}
}