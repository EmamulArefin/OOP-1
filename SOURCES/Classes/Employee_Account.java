import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Employee_Account{
	
	String user, employee_ID, employee_Pass, employee_Name;
	int empofileNo;
	
	public Employee_Account(){
		
		
		/////////////Frame creation...........................
		JFrame fr = new JFrame();
		fr.setBounds(250,110,1000,600);
		fr.setTitle("Employee Account Panel");
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Logo.png");    
		fr.setIconImage(frame_icon);
		fr.setResizable(false);
		/////////////Frame Close Confirmation..............
		      fr.addWindowListener(new WindowAdapter(){
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
						
						fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					}else{
						fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					   }
				    }
			    }
		    );  
		
			
			
	    //////////////Conteiner creation...............................
			Container c = new Container();
			c = fr.getContentPane();
			c.setLayout(null);
//////////////////////////////////////////////////////////////Reading Employee File NO/////////////////////////////////////////////////////
		String empofilenumber="";
		try{
			File otp_File = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Employye_File_NO.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				empofilenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			empofileNo= Integer.parseInt(empofilenumber);
			empofileNo=empofileNo-1;
						
		}catch(Exception f)		{System.out.println("Employee file No Reading Problem in Employee Panel");}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
			System.out.println("Running user file problem in Employee Panel");
		}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Match the Employee got from running user file with the list of Employees
		for(int i=1; i<=empofileNo; i++)
		{
			String User_Information_File_Path="D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Employee Information\\Employee-"+i+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
						
				while(scanFile.hasNext()){
					employee_ID=scanFile.next();
					employee_Pass=scanFile.next();
					employee_Name=scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(employee_ID.equals(user))
				{
					break;
				}
			}catch(Exception f)		{System.out.println("Employee File Problem in Username Panel");}
		}
//Got the all information about user|||||Now time to display them

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////
                                 // Jlable-1  //(Set for name)	
			Font font1 = new Font("Arial", Font.BOLD,25);
			JLabel lable1 = new JLabel (employee_Name);
			lable1.setBounds(150,420,150,30);
			lable1.setFont(font1);
			
			
		///////////////////////////////////////////////////////////////////////////
                                 // Jlable-2 //(Set user name)	
			Font font2 = new Font("Arial", Font.PLAIN,18);
			JLabel lable2 = new JLabel ("Employee ID :  "+employee_ID);
			lable2.setBounds(550,422,250,30);
			lable2.setFont(font2);
			
		//////////////////////////////Gif Label////////////////////////////////////
		
			/* JLabel gif_lable = new JLabel (new ImageIcon("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Void Logo.gif"));
			gif_lable.setBounds(520,140,350,200);
			gif_lable.setOpaque(true);
			gif_lable.setBackground(Color.YELLOW);
			c.add(gif_lable); */
        ///////////////////////////////////////////////////////////////////////////
                                 // Jlable-3  //(Set Password)	
			/* Font font3 = new Font("Arial", Font.PLAIN,18);
			JLabel lable3 = new JLabel ("Password :  "+employee_Pass);
			lable3.setBounds(550,305,300,30);
			lable3.setBackground(Color.YELLOW);
			lable3.setForeground(Color.BLACK);
			lable3.setFont(font3); 
			c.add(lable3);*/
			
			///////////////////////////////////////////////////////////////////////////
                                
								  
			
			
			c.add(lable1);
			c.add(lable2);
			


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		   //Back Batton
		   JButton backbatton = new JButton();
		   backbatton.setBounds(10,530,40,27);
		   backbatton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   backbatton.setToolTipText("Back");
		   c.add(backbatton);
		   backbatton.setContentAreaFilled(false);
           backbatton.setFocusPainted(false);
           backbatton.setBorderPainted(false);
		   
		   
		   
		   
		   JButton change_password = new JButton("Change Password");
		   change_password.setBounds(120,530,150,25);
		   change_password.setFont(new Font("Arial", Font.BOLD, 13));
		   change_password.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   c.add(change_password);
		   
		   
		   
		   
		   
//Set Background Image
		ImageIcon Newpass_Background = new ImageIcon("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Employee_Profile.jpg");
		
		JLabel bg_label = new JLabel(Newpass_Background);
		bg_label.setBounds(0,0,986,563);
		c.add(bg_label);
		   
/////////////////////////////////////Action Listeners////////////////////////////////////////////////
		  backbatton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new Employee_View();
				
			}});
			
			
		   change_password.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				fr.setVisible(false);
				new Employee_Change_Password();
				
			}});
		   
		   
		   
		   fr.setVisible(true);

	}

}	
			
			
		
		

