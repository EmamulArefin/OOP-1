import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Add_Employee
{
	int employeeFileNO;
	
	String id,pass;
	Color LIGHT = new Color (93,162,209);
	public Add_Employee()
	{
		//Main Frame;
		JFrame frame = new JFrame();
		frame.setBounds(250,110,1000,600);
		frame.setTitle("Add Employee Page");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Logo.png");    
		frame.setIconImage(frame_icon);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
/////////////////////////////////////////////////////////////////
//Getting employee file NO
		String empofileNO="";
		try{
			File otp_File = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Employye_File_NO.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				empofileNO=scanFile.next();
				break;
			}
			scanFile.close();
			
			employeeFileNO=Integer.parseInt(empofileNO);
						
		}catch(Exception f)		{System.out.println("Running user file No Reading Problem in Signup Panel");}
		
		
		
		
		
		
		
		//For container;
		Container contain = new Container();
		contain =frame.getContentPane();
		contain.setLayout(null);
		
		//For Employee ID;
		JTextField emo_ID=new JTextField();
		emo_ID.setBounds(630,183,305,50);
		contain.add(emo_ID);
		
		//For Employee Password;
		JTextField emo_Pass=new JTextField();
		emo_Pass.setBounds(630,263,305,50);
		contain.add(emo_Pass);
		
		//For Add Employee Button;
		JButton adEmpo_button = new JButton("Add Employee");
		adEmpo_button.setBounds(805,350,130,35);
		adEmpo_button.setFocusPainted(false);
		adEmpo_button.setForeground(LIGHT);
		adEmpo_button.setBackground(Color.WHITE);
		adEmpo_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain.add(adEmpo_button);
		
		
		//Add hover in Add Employee button
		adEmpo_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				adEmpo_button.setForeground(Color.WHITE);
				adEmpo_button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				adEmpo_button.setForeground(LIGHT);
				adEmpo_button.setBackground(Color.WHITE);
			}
		});
		
		//For Cancel Button;
		JButton cancel_button = new JButton("Cancel");
		cancel_button.setBounds(632,350,130,35);
		cancel_button.setFocusPainted(false);
		cancel_button.setForeground(LIGHT);
		cancel_button.setBackground(Color.WHITE);
		cancel_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain.add(cancel_button);
		
		//Add hover in Cancel button
		cancel_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				cancel_button.setForeground(Color.WHITE);
				cancel_button.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				cancel_button.setForeground(LIGHT);
				cancel_button.setBackground(Color.WHITE);
			}
		});
		
		//for Background image;
		ImageIcon bg_contain = new ImageIcon("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Background_Addempo.jpg");
		
		JLabel bg_Label = new JLabel(bg_contain);
		bg_Label.setBounds(0,0,1000,600);
		contain.add(bg_Label);
		
		//For Action command;
		//Add Employee button Action;
		adEmpo_button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				id= emo_ID.getText();
				pass= emo_Pass.getText();
				
				
				int Username_Warning=5;
				int Username_Exist_Warning=5;
				
				//Check userID ok or not
				for(int i=0; i<id.length(); i++)
				{
					if( (id.charAt(i)<48) || (id.charAt(i)>57) ){
						Username_Warning=1;
						break;
					}
				}
				
				
				
				//Checking id exist or not
				String username_exist="";
					for(int i=1; i<=(employeeFileNO-1); i++)
					{
						String User_Information_File_Path="D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Employee Information\\Employee-"+i+".txt";
						
						try{
							File user_file = new File(User_Information_File_Path);		
							Scanner scanFile = new Scanner(user_file);//Scan File
							
							while(scanFile.hasNext()){
								username_exist=scanFile.next();
								break;
							}
							scanFile.close();
							
							
							if((id.equals(username_exist)))
							{
								Username_Exist_Warning+=1;
								break;
							}
						}catch(Exception f)		{System.out.println("User File Problem in Sigup Panel");}
					}
					
					
					
	/////////////////////////////////////////////////////////////////////
				
				if( id.isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Employee ID can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( (pass.length()<6) || (pass.length()>10) )
				{
					JOptionPane.showMessageDialog(null,"Password must be 6 to 10 character","Password Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(Username_Warning!=5)
				{
					JOptionPane.showMessageDialog(null,"Employee ID Contains Digit only","Employee ID Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(Username_Exist_Warning!=5)
				{
					JOptionPane.showMessageDialog(null, "Employee ID already exist. Try different One","Employee ID Warning",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					try{
						Formatter empo_info = new Formatter("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Employee Information\\Employee-"+employeeFileNO+".txt");
						employeeFileNO++;
						
						empo_info.format("%s\r\n",id);
						empo_info.format("%s\r\n",pass);
						
						empo_info.close();
						
					}catch (Exception ae) 	{System.out.println("An error occurred in Add_Employee");}
			
			
			//Updating empofileNo
					try{
						Formatter empo_info = new Formatter("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Employye_File_NO.txt");
						
						empo_info.format("%s",""+employeeFileNO);
						
						empo_info.close();
						
					}catch (Exception ae) 	{System.out.println("An error occurred in Add_Employee");}
					
					
				}
				
				
					
					
					
              
			}});
				
		//Cancel button Action;
		cancel_button.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae) {
				new Admin_View();
				frame.setVisible(false);
			}});
		
		frame.setVisible(true);
	}
	 public static void main(String [] args)
	{
		new Add_Employee();
	} 
}