import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Account_Panel{
	
	
	String user, user_username, user_password, user_email, user_phone, user_gender, user_balance, user_name;
	
//Colors
	Color LIGHT_RED = new Color (255,102,102);
	Color LIGHT_BLUE = new Color (51,153,255);
	Color Dark_CYAN = new Color (14,161,177);
	
	static int fileNo=3;
	
	
	
	public Account_Panel(int fileNo){this.fileNo=fileNo;}//Need to call from account signup panel > back to login button listener
	public Account_Panel()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setBounds(250,110,1000,600);
		frame.setTitle("Account Panel");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Logo.png");    
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		//Frame Close Confirmation
		frame.addWindowListener(new WindowAdapter(){
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
		
		
		
		
		//Container creation
		Container panel = new Container();
		panel=frame.getContentPane();
		panel.setLayout(null);
/////////////////////////////////////////////////////////

//Get the Running user from running user file
		try{
			File running_user_File = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Running_User.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				user=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running user file problem in Account Panel");
		}
		
		
//Match the user got from running user file with the list of users
		for(int i=1; i<=fileNo; i++)
		{
			String User_Information_File_Path="D:/University/3rd semester/Java Project/Final Project/SOURCES/TXT FILES/User Information/User--"+i+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
						
				while(scanFile.hasNext()){
					user_username=scanFile.next();
					user_password=scanFile.next();
					user_email=scanFile.next();
					user_phone=scanFile.next();
					user_gender=scanFile.next();
					user_balance=scanFile.next();
					user_name=scanFile.next()+" "+scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(user_username.equals(user))
				{
					break;
				}
			}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
		}
//Got the all information about user|||||Now time to display them

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

//Books Button
		JButton BOOK_Button=new JButton("BOOKS");  
		BOOK_Button.setBounds(250,00,250,50);
		BOOK_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BOOK_Button.setFont(upperButtonFont);
		BOOK_Button.setBackground(Dark_CYAN);
		BOOK_Button.setForeground(Color.WHITE);
		panel.add(BOOK_Button);

		//Balance Button Hover
		BOOK_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				BOOK_Button.setBackground(LIGHT_RED);
				BOOK_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				BOOK_Button.setBackground(Dark_CYAN);
				BOOK_Button.setForeground(Color.WHITE);
			}
		});
		
//Account Button
		JButton account_Button=new JButton("ACCOUNT");  
		account_Button.setBounds(500,00,250,50);  
		account_Button.setFont(upperButtonFont);
		panel.add(account_Button);
		account_Button.setBackground(LIGHT_RED);
		account_Button.setForeground(Color.BLACK);

//Contact us Button
		JButton contactus_Button=new JButton("CONTACT US");  
		contactus_Button.setBounds(750,00,236,50);  
		contactus_Button.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		contactus_Button.setFont(upperButtonFont);
		contactus_Button.setBackground(Dark_CYAN);
		contactus_Button.setForeground(Color.WHITE);
		panel.add(contactus_Button);

		//Contact us Button Hover
		contactus_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				contactus_Button.setBackground(LIGHT_RED);
				contactus_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				contactus_Button.setBackground(Dark_CYAN);
				contactus_Button.setForeground(Color.WHITE);
			}
		});
		
		
		
		
		
		
		
///////////////////////////////////////////Information Labels
//Username Label
		JLabel username_label = new JLabel("Username:");
		username_label.setBounds(400,330,80,20);
		username_label.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(username_label);
		
//Users username Display
		JLabel usernameLabel = new JLabel(user_username);
		usernameLabel.setBounds(485,330,120,20);
		usernameLabel.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(usernameLabel);
		
//Name Label
		JLabel name_Label = new JLabel("Name    :");
		name_Label.setBounds(200,370,70,20);
		name_Label.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(name_Label);
		
//Users Name Display
		JLabel nameLabel = new JLabel(user_name);
		nameLabel.setBounds(275,370,180,20);
		nameLabel.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(nameLabel);

//Gender Label
		JLabel gender_Label = new JLabel("Gender :");
		gender_Label.setBounds(200,410,70,20);
		gender_Label.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(gender_Label);
		
//Users Gender Display
		JLabel genderLabel = new JLabel(user_gender);
		genderLabel.setBounds(275,410,70,20);
		genderLabel.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(genderLabel);

//Email Label
		JLabel email_Label = new JLabel("Email  :");
		email_Label.setBounds(600,370,60,20);
		email_Label.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(email_Label);
		
//User Email Dispalay
		JLabel emailLabel = new JLabel(user_email);
		emailLabel.setBounds(665,370,250,20);
		emailLabel.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(emailLabel);

//Phone Number Label
		JLabel phone_Label = new JLabel("Phone :");
		phone_Label.setBounds(600,410,60,20);
		phone_Label.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(phone_Label);

//User Phone Number Dispalay
		JLabel phoneLabel = new JLabel(user_phone);
		phoneLabel.setBounds(665,410,100,20);
		phoneLabel.setFont(new Font ("Arial", Font.PLAIN,16));
		panel.add(phoneLabel);

//Balance Label
		JLabel balance_Label = new JLabel("Balance ::");
		balance_Label.setBounds(750,110,80,20);
		balance_Label.setFont(new Font ("Arial", Font.BOLD,16));
		balance_Label.setForeground(Color.WHITE);
		panel.add(balance_Label);

//Users Balance Display
		JLabel balanceLabel = new JLabel(user_balance);
		balanceLabel.setBounds(850,112,80,20);
		balanceLabel.setFont(new Font ("Arial", Font.BOLD,18));
		balanceLabel.setForeground(Color.WHITE);
		panel.add(balanceLabel);
//////////////////////////////////////////////All Label Complete

//Change Password Button
		JButton changePassword_Button = new JButton("Change Password");
		changePassword_Button.setBounds(800,530,165,20);
		changePassword_Button.setFont(new Font ("Arial", Font.PLAIN,16));
		changePassword_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		changePassword_Button.setForeground(LIGHT_RED);
		
		changePassword_Button.setContentAreaFilled(false);
		changePassword_Button.setFocusPainted(false);
		changePassword_Button.setBorderPainted(false);
		panel.add(changePassword_Button);

		changePassword_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				changePassword_Button.setForeground(Dark_CYAN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				changePassword_Button.setForeground(LIGHT_RED);
			}
		});

//Add Balance Button
		JButton addBalance_Button = new JButton("Add Balance");
		addBalance_Button.setBounds(740,150,212,30);
		addBalance_Button.setFont(new Font ("Arial", Font.BOLD,15));
		addBalance_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addBalance_Button.setBackground(Dark_CYAN);
		addBalance_Button.setForeground(Color.BLACK);
		panel.add(addBalance_Button);
		
		//Set Add Balance Hover
		addBalance_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				addBalance_Button.setBackground(LIGHT_RED);
				addBalance_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				addBalance_Button.setBackground(Dark_CYAN);
				addBalance_Button.setForeground(Color.BLACK);
			}
		});


//ChangeName_Button
		JButton ChangeName_Button = new JButton("Change Name");
		ChangeName_Button.setBounds(800,500,165,20);
		ChangeName_Button.setFont(new Font ("Arial", Font.PLAIN,16));
		ChangeName_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ChangeName_Button.setForeground(LIGHT_RED);
		
		ChangeName_Button.setContentAreaFilled(false);
		ChangeName_Button.setFocusPainted(false);
		ChangeName_Button.setBorderPainted(false);
		panel.add(ChangeName_Button);

		ChangeName_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				ChangeName_Button.setForeground(Dark_CYAN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				ChangeName_Button.setForeground(LIGHT_RED);
			}
		});


//Logout Button
		JButton logout_Button = new JButton(new ImageIcon("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Logout.jpg"));
		logout_Button.setBounds(20,500,50,50);
		logout_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logout_Button.setBackground(Dark_CYAN);
		logout_Button.setForeground(Color.BLACK);
		
		logout_Button.setContentAreaFilled(false);
		logout_Button.setFocusPainted(false);
		logout_Button.setBorderPainted(false);
		panel.add(logout_Button);
		

//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Account_Background.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/////////////////////////////////////////////////Action Listeners

//Contact us Button action listener
		contactus_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				//new Contact_Us();
			} 
		});






























//ActionListener for Logout Button
		logout_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				//new Login_Panel();
			} 
		});
		
//ActionListener for Change Password Button
		changePassword_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				//new Change_Password();
			} 
		});
		

//ActionListener for Add Balance
		addBalance_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				//new Add_Balance();
			} 
		});
		
//ActionListener for Change Name Button
		ChangeName_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				//new Change_Name();
			} 
		});
		
		
		
		
		
		
		
		
		
//Set Visibility
frame.setVisible(true);
	}
}