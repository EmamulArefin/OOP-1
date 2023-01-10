import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Checkout
{
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author;
	Color very_light_Blue = new Color(225,246,255);
	Color dark = new Color(0,159,148);

public Checkout()
{
//frame
	JFrame fr = new JFrame("CHECKOUT-(Afif)");
    fr.setBounds(220,110,1000,600);
	fr.setLayout(null);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

fr.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					
					int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
					
					if (result == JOptionPane.YES_OPTION){
						
						File folder = new File("C:\\Users\\Mahin Afif\\OneDrive - American International University-Bangladesh\\Documents\\PROJECT JAVA\\Tonmnoy");
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
	
//Gtting The Book ID
	String runtxt="";

	try{
			File running_user_File = new File("C:\\Users\\Mahin Afif\\OneDrive - American International University-Bangladesh\\Documents\\PROJECT JAVA\\ekram\\Running_Book.txt");		
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				runtxt=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running txt problem");
		}
		
//Getting Book Info

	String User_Information_File_Path="C:\\Users\\Mahin Afif\\OneDrive - American International University-Bangladesh\\Documents\\PROJECT JAVA\\ekram\\Book Information\\Book-"+runtxt+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file);//Scan File
						
				while(scanFile.hasNext()){
					book_Id=scanFile.next();
					book_Price=scanFile.next();
					book_name=scanFile.next();
					book_category=scanFile.next();
					book_path=scanFile.next();
					book_author=scanFile.next()+" "+scanFile.next();
					break;
				}
				scanFile.close();
			}catch(Exception f)		{System.out.println("Book Info file problem");}
	
//backbutton
           Cursor view2carsor = new Cursor(Cursor.HAND_CURSOR);		   
		   JButton d1 =new JButton(new ImageIcon("back.png"));  
           d1.setBounds(23,520,40,30); 
		   d1.setCursor(view2carsor);
          d1.setContentAreaFilled(false);
		   d1.setFocusPainted(false);
		   d1.setBorderPainted(false);		   
           fr.add(d1);	
	
	
//bookname label	
	    JLabel bookname_label = new JLabel(book_name);
		bookname_label.setBounds(130,420,260,50);
		bookname_label.setFont(new Font ("Arial", Font.BOLD,35));
		fr.add(bookname_label);
		
//by label		
		JLabel author_label = new JLabel("by");
		author_label.setBounds(144,472,20,30);
		author_label.setFont(new Font ("Arial", Font.PLAIN,12));
		fr.add(author_label);
		
		JLabel author2_label = new JLabel(book_author);
		author2_label.setBounds(160,470,150,30);
		author2_label.setFont(new Font ("Arial", Font.BOLD,16));
		fr.add(author2_label);
		
//Price
	    JLabel tk2_label = new JLabel(book_Price);
		tk2_label.setBounds(855,225,100,30);
		tk2_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(tk2_label);
		
//Shipping
	    JLabel Shipping_label = new JLabel("50.00");
		Shipping_label.setBounds(855,271,100,30);
		Shipping_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Shipping_label);

//Total
		double uprice=Double.parseDouble(book_Price);
		uprice+=50;
		String Uprice=Double.toString(uprice);
		
	    JLabel Total_label = new JLabel(Uprice);
		Total_label.setBounds(855,316,100,30);
		Total_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(Total_label);
//photo
		JLabel image_label = new JLabel(new ImageIcon(book_path));
		image_label.setBounds(144,146,179,265);
		//image_label.setFont(new Font ("Arial", Font.BOLD,20));
		fr.add(image_label);
		
		
//Checkout button
		JButton buy_Button = new JButton("Checkout");
		buy_Button.setBounds(705,450,150,30);
		buy_Button.setFont(new Font ("Arial", Font.BOLD,14));
		buy_Button.setFocusPainted(false);
		buy_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buy_Button.setForeground(dark);
		buy_Button.setBackground(Color.WHITE);
		fr.add(buy_Button);
		
		
		buy_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				buy_Button.setBackground(very_light_Blue);
				buy_Button.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				buy_Button.setForeground(dark);
				buy_Button.setBackground(Color.WHITE);
			}
		});
/* //Voucher Code
		JTextField voucher_field = new JTextField();
		voucher_field.setBounds(600,400,150,30);
		new TextPrompt("Voucher Code",voucher_field);
		fr.add(voucher_field); */
		
//Address
		JTextArea address_field = new JTextArea("Enter Your Address Here");
		address_field.setBounds(650,101,260,90);
		//new TextPrompt("Address",address_field);
		fr.add(address_field);
		
		
		ImageIcon Username_Background = new ImageIcon("checkout.jpg");
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		fr.add(bg_label);
		
fr.setVisible(true);
}
}