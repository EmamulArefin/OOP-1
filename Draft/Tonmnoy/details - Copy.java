import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class details
{
	
	String book_Id, book_Price, book_name, book_category, book_path, book_author;
	Color light = new Color(146,193,199);
	Color dark = new Color(0,159,148);
    int valueInt;

public details()
{
			
//frame
	JFrame fr = new JFrame("DETAILS-(Afif)");
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
	
	
	
	
//bookname label	
	    JLabel bookname_label = new JLabel(book_name);
		bookname_label.setBounds(400,130,260,50);
		bookname_label.setFont(new Font ("Arial", Font.BOLD,35));
		fr.add(bookname_label);
		
//author name label		
		JLabel author_label = new JLabel("Author Name:");
		author_label.setBounds(400,200,95,30);
		author_label.setFont(new Font ("Arial", Font.PLAIN,15));
		fr.add(author_label);
		
		JLabel author2_label = new JLabel(book_author);
		author2_label.setBounds(500,200,150,30);
		author2_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(author2_label);
//category label		
		JLabel Category_label = new JLabel("Category:");
		Category_label.setBounds(400,225,70,30);
		Category_label.setFont(new Font ("Arial", Font.PLAIN,15));
		fr.add(Category_label);
		
		JLabel category2_label = new JLabel(book_category);
		category2_label.setBounds(475,225,150,30);
		category2_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(category2_label);
//id label		
		JLabel ID_label = new JLabel("Book ID:");
		ID_label.setBounds(400,250,75,30);
		ID_label.setFont(new Font ("Arial", Font.PLAIN,15));
		fr.add(ID_label);
		
		JLabel ID2_label = new JLabel(book_Id);
		ID2_label.setBounds(470,250,10,30);
		ID2_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(ID2_label);
		
//Price
        JLabel tk_label = new JLabel("TK.");
		tk_label.setBounds(400,280,30,30);
		tk_label.setFont(new Font ("Arial", Font.BOLD,15));
		fr.add(tk_label);

	    JLabel tk2_label = new JLabel(book_Price);
		tk2_label.setBounds(430,279,100,30);
		tk2_label.setFont(new Font ("Arial", Font.BOLD,20));		
		fr.add(tk2_label);
		
//increment or decrement quantity
         JButton incBtn = new JButton();	
		 incBtn.setBounds(400,315,15,15);
		 incBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 incBtn.setFocusPainted(false);
         incBtn.setContentAreaFilled(false);		  
		 incBtn.setBorderPainted(false);
         incBtn.setOpaque(false);
         		 	 
         JButton decBtn = new JButton();
		 decBtn.setBounds(458,315,15,15);
		 decBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 decBtn.setContentAreaFilled(false);		  
		 decBtn.setBorderPainted(false);
		 decBtn.setFocusPainted(false); 
		 decBtn.setOpaque(false);
		
		 
		 
//////////////////////// QUANTITY////////////////////////////////
         JLabel showLbl = new JLabel("01");
         showLbl.setBounds(430,315,15,15);
				 
         fr.add(showLbl);
		 fr.add(incBtn);
		 fr.add(decBtn);
		 
		 
            incBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valueInt = Integer.parseInt(showLbl.getText());
                valueInt++;
                if (valueInt >= 10) {
                    showLbl.setText(String.valueOf(valueInt));
                } else {
                    showLbl.setText("0" + String.valueOf(valueInt));
                }
            }
        });

        decBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valueInt = Integer.parseInt(showLbl.getText());
                if (valueInt > 0) {
                    valueInt--;
                }
                if (valueInt >= 10) {
                    showLbl.setText(String.valueOf(valueInt));
                } else {
                    showLbl.setText("0" + String.valueOf(valueInt));
                }
            }
        });
		
//photo
		JLabel image_label = new JLabel(new ImageIcon(book_path));
		image_label.setBounds(150,150,179,265);
		//image_label.setFont(new Font ("Arial", Font.BOLD,20));
		fr.add(image_label);
		
		
//Buy Now button
		JButton buy_Button = new JButton("PLACE ORDER");
		buy_Button.setBounds(400,380,150,30);
		buy_Button.setFont(new Font ("Arial", Font.BOLD,14));
		buy_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buy_Button.setForeground(dark);
		buy_Button.setBackground(Color.WHITE);
		fr.add(buy_Button);
		
		
		buy_Button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				buy_Button.setBackground(dark);
				buy_Button.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				buy_Button.setForeground(dark);
				buy_Button.setBackground(Color.WHITE);
			}
		});
		
		
//Voucher Code
		JTextField voucher_field = new JTextField();
		voucher_field.setBounds(400,345,120,25);
		new TextPrompt("Apply Voucher Code",voucher_field);
		fr.add(voucher_field);
		
//Set Background
		ImageIcon Username_Background = new ImageIcon("place-order.jpg");
		JLabel bg_label = new JLabel(Username_Background);
		bg_label.setBounds(0,0,986,563);
		fr.add(bg_label);
	
fr.setVisible(true);
}
}