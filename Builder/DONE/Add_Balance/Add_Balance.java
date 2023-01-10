import javax.swing.*;    
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Add_Balance{
	
	
	String user, user_username, user_password, user_email, user_phone, user_gender, user_balance, user_name;
	boolean recharge_access, found_access;
	String usedCode1, usedCode2, usedCode3, usedCode4, usedCode5;
//Colors
	Color LIGHT_BLUE = new Color (16,161,192);
	Color Purple = new Color (86,90,136);

	
	
	static int fileNo=3;
	int fileIs;
	
	
	
	public Add_Balance(int fileNo){this.fileNo=fileNo;}//Need to call from account signup panel > back to login button listener
	public Add_Balance()
	{
		//Basic Frame Creation
		JFrame frame = new JFrame();
		frame.setBounds(250,110,1000,600);
		frame.setTitle("Chnage Password Panel");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Logo.png");    
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		//Frame Close Confirmation
		/* frame.addWindowListener(new WindowAdapter(){
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
						
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					}else{
						frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		); */
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//Container creation
		Container panel = new Container();
		panel=frame.getContentPane();
		panel.setLayout(null);
/////////////////////////////////////////////////////////

//Enter Voucher Code
		JLabel voucher_Label = new JLabel("Enter GiftCard Code");
		voucher_Label.setBounds(700,210,170,20);
		voucher_Label.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(voucher_Label);

	//Text Field
		JTextField voucher_Field = new JTextField();
		voucher_Field.setBounds(700,230,170,30);
		new TextPrompt("GiftCard Code", voucher_Field);
		panel.add(voucher_Field);

//Recharge Button
		JButton recharge_Button = new JButton("Recharge");
		recharge_Button.setBounds(710,270,150,30);
		recharge_Button.setFont(new Font("Arial", Font.BOLD, 14));
		recharge_Button.setBackground(LIGHT_BLUE);
		recharge_Button.setForeground(Color.WHITE);
		recharge_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(recharge_Button);

		recharge_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				recharge_Button.setBackground(Purple);
				recharge_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				recharge_Button.setBackground(LIGHT_BLUE);
				recharge_Button.setForeground(Color.WHITE);
			}
		});
		
		
		
//Back to Account Button
		JButton backToAccount_Button = new JButton("Back to Account");
		backToAccount_Button.setBounds(821,528,150,20);
		backToAccount_Button.setFont(new Font("Arial", Font.BOLD, 14));
		backToAccount_Button.setBackground(Purple);
		backToAccount_Button.setForeground(Color.WHITE);
		backToAccount_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(backToAccount_Button);

		backToAccount_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				backToAccount_Button.setBackground(LIGHT_BLUE);
				backToAccount_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				backToAccount_Button.setBackground(Purple);
				backToAccount_Button.setForeground(Color.WHITE);
			}
		});		


//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Add_Balance.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		panel.add(bg_label);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
///////////////////////////Action Listeners
		/* backToAccount_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				new Account_Panel();
			} 
		}); */











//ActionListener for Add Balance
		recharge_Button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				
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
					System.out.println("Running user file problem in Add Balance");
				}
		
		
//Match the user got from running user file with the list of users
				for(int i=1; i<=fileNo; i++)
				{
					String User_Information_File_Path="D:\\University\\3rd semester\\Java Project/Final Project/SOURCES/TXT FILES/User Information/User--"+i+".txt";
								
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
							fileIs=i;
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
				}
//Got the all information about user|||||Now time to modify them
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				String voucher=voucher_Field.getText();//Getting user input code
				
				String c1="",c2="",c3="",c4="",c5="";
				
				
			//Getting voucher codes
				try{
					File balanceCodeFile = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Balance_Codes.txt");		
					Scanner scanFile = new Scanner(balanceCodeFile);//Scan File
						
					while(scanFile.hasNext()){
						c1=scanFile.next();
						c2=scanFile.next();
						c3=scanFile.next();
						c4=scanFile.next();
						c5=scanFile.next();
						break;
					}
					scanFile.close();
						
				}catch(Exception f){
					System.out.println("Balance_Codes file has problem in Add Balance Panel");
				}
			//Got all the voucher codes
				
				
			//Match the voucher codes with user input
				if( (voucher.equals(c1)) || (voucher.equals(c2)) || (voucher.equals(c3)) || (voucher.equals(c4)) || (voucher.equals(c5)) ) {	found_access=true;	}
				else{found_access=false;		recharge_access=false;}
			//Matching Done and got the found access true or false
			
				
			//Checking if the code is already been used or not
				if(found_access){
					
					if( (voucher.equals(usedCode1)) || (voucher.equals(usedCode2)) || (voucher.equals(usedCode3)) || (voucher.equals(usedCode4)) || (voucher.equals(usedCode5)) ){
						recharge_access=false;
					}else{
						recharge_access=true;
					}
				}
///////////////////////////////
				if(recharge_access){
					double balance=Double.parseDouble(user_balance);
					balance+=500;
					user_balance = Double.toString(balance);
					
					//Writing user file with updated balance
					try{
						String User_Information_File_Path="D:/University/3rd semester/Java Project/Final Project/SOURCES/TXT FILES/User Information/User--"+fileIs+".txt";
						Formatter formatter=new Formatter(User_Information_File_Path);
						
						formatter.format("%s\r\n", user_username);
						formatter.format("%s\r\n", user_password);
						formatter.format("%s\r\n", user_email);
						formatter.format("%s\r\n", user_phone);
						formatter.format("%s\r\n", user_gender);
						formatter.format("%s\r\n", user_balance);
						formatter.format("%s\r\n", user_name);
						
						
						
						formatter.close();	
					}catch(Exception f)		{System.out.println(f);}
					//Write successfuly done
					
				
				//Storing used Code
					if( usedCode1==null ){
						usedCode1=voucher;
					}
					else if( usedCode2==null ){
						usedCode2=voucher;
					}
					else if( usedCode3==null ){
						usedCode3=voucher;
					}
					else if( usedCode4==null ){
						usedCode4=voucher;
					}else{
						usedCode5=voucher;
					}
					
					
					JOptionPane.showMessageDialog(null, "Recharge Successful","Success",1);
				}
				else{JOptionPane.showMessageDialog(null, "Invalid Code or Code has been already used","Warning",JOptionPane.WARNING_MESSAGE);}


				
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			} 
		});








//Set Visibility 
frame.setVisible(true);
	}
}