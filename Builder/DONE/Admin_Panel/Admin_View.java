import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class Admin_View
{
	int totalCustomer, totalEmployee, totalorder, totalBook=0;
	String book_Id, book_Price, book_name, book_category, book_path, book_author,book_quantity;
	
	String order_ID, order_bookname, order_userPhone, order_userEmail, order_quantity, order_amount, order_userName;
	
	Color LIGHT = new Color (93,162,209);
	public Admin_View()
	{
	 //Main Frame;
		JFrame frame_view = new JFrame();
		frame_view.setTitle("Admin View");
		frame_view.setBounds(250,110,1000,600);
		Image frame_icon = Toolkit.getDefaultToolkit().getImage("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Logo.png");    
		frame_view.setIconImage(frame_icon);
		frame_view.setResizable(false);
		//Frame Close Confirmation
		frame_view.addWindowListener(new WindowAdapter(){
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
						
						frame_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}else{
						frame_view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
			}
		);

						
						
						
		//Container Frame;
		Container contain_view = new Container();
		contain_view = frame_view.getContentPane();
		contain_view.setLayout(null);
//////////////////////////////////////////////
//Getting Customer Amount
		String filenumber="";
		try{
			File otp_File = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\User_File_No.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				filenumber=scanFile.next();
				break;
			}
			scanFile.close();
					
			totalCustomer= Integer.parseInt(filenumber);
			totalCustomer=totalCustomer-1;
						
		}catch(Exception f)		{System.out.println("User file problem in admin panel");}
		
//Getting Employee Amount
		String employeeFileNo="";
		try{
			File otp_File = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Employye_File_NO.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				employeeFileNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			totalEmployee= Integer.parseInt(employeeFileNo);
			totalEmployee=totalEmployee-1;
						
		}catch(Exception f)		{System.out.println("Employee file problem in admin panel");}


//Getting Order Amount
		String orderFileNo="";
		try{
			File otp_File = new File("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\OrderFileNo.txt");		
			Scanner scanFile = new Scanner(otp_File);//Scan File
						
			while(scanFile.hasNext()){
				orderFileNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			totalorder= Integer.parseInt(orderFileNo);
			totalorder=totalorder-1;
						
		}catch(Exception f)		{System.out.println("Order file problem in admin panel");}
		
///////////////////////////////////////////////////////////////////////////////////////////////
//Getting Total BOOKS



		int bookQuantity=0;
		
		for(int i=1; i<=8; i++)
		{
			String User_Information_File_Path="D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Book Information\\Book-"+i+".txt";
							
			try{
				File book_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(book_file);//Scan File
							
				while(scanFile.hasNext()){
					book_Id=scanFile.next();
					book_Price=scanFile.next();
					book_name=scanFile.next();
					book_category=scanFile.next();
					book_path=scanFile.next();
					book_author=scanFile.next()+" "+scanFile.next();
					book_quantity=scanFile.next();
					break;
				}
				scanFile.close();
				
				bookQuantity = Integer.parseInt(book_quantity);
				
				totalBook = totalBook+bookQuantity;
								
				
			}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
		}





















		//Font;
		Font font = new Font("Arial",Font.BOLD,35);
		//for Total Customer JLabel;
		JLabel total_customer = new JLabel(""+totalCustomer);
		total_customer.setBounds(165,70,90,60);
		total_customer.setFont(font);
		contain_view.add(total_customer);
		
		//for Total Employee JLabel;
		JLabel total_employee = new JLabel(""+totalEmployee);
		total_employee.setBounds(376,70,90,60);
		total_employee.setFont(font);
		contain_view.add(total_employee);
		
		//for Total book JLabel;
		JLabel total_book = new JLabel(""+totalBook);
		total_book.setBounds(586,70,90,60);
		total_book.setFont(font);
		contain_view.add(total_book);
		
		//for Total order JLabel;
		JLabel total_order = new JLabel(""+totalorder);
		total_order.setBounds(793,70,90,60);
		total_order.setFont(font);
		contain_view.add(total_order);
		
		//for Add Employee Button form admin view.
		JButton add_Employee = new JButton("Add Employee");
		add_Employee.setBounds(800,150,115,25);
		add_Employee.setFocusPainted(false);
		add_Employee.setForeground(LIGHT);
		add_Employee.setBackground(Color.WHITE);
		add_Employee.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain_view.add(add_Employee);
		
		//Add hover in Add Employee button
		add_Employee.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				add_Employee.setForeground(Color.WHITE);
				add_Employee.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				add_Employee.setForeground(LIGHT);
				add_Employee.setBackground(Color.WHITE);
			}
		});
		
		//for Employee Info Button form admin view.
		JButton employee_info = new JButton("Employee Info");
		employee_info.setBounds(30,150,115,25);
		employee_info.setFocusPainted(false);
		employee_info.setForeground(LIGHT);
		employee_info.setBackground(Color.WHITE);
		employee_info.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain_view.add(employee_info);
		
		//Add hover in Employee Info button
		employee_info.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				employee_info.setForeground(Color.WHITE);
				employee_info.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				employee_info.setForeground(LIGHT);
				employee_info.setBackground(Color.WHITE);
			}
		});
		
		//for Customer Info Button form admin view.
		JButton customer_info = new JButton("Customer Info");
		customer_info.setBounds(180,150,115,25);
		customer_info.setFocusPainted(false);
		customer_info.setForeground(LIGHT);
		customer_info.setBackground(Color.WHITE);
		customer_info.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contain_view.add(customer_info);
		
		//Add hover in Customer Info button
		customer_info.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				customer_info.setForeground(Color.WHITE);
				customer_info.setBackground(LIGHT);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				customer_info.setForeground(LIGHT);
				customer_info.setBackground(Color.WHITE);
			}
		});
		
		
		//for Tabel
		String order_data[][] = new String [totalorder][6];
		
		for(int row=0; row<=totalorder; row++)
		{
			for(int col=0; col<6; col++)
			{
				/* for(int i=1; i<=totalorder; i++)
				{ */
					String User_Information_File_Path="D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\TXT FILES\\Order_Info\\Order-"+(row+1)+".txt";
									
					try{
						File book_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(book_file);//Scan File
									
						while(scanFile.hasNext()){
							order_ID=scanFile.next();
							order_bookname=scanFile.next();
							order_userPhone=scanFile.next();
							order_userEmail=scanFile.next();
							order_quantity=scanFile.next();
							order_amount=scanFile.next();
							order_userName=scanFile.next()+" "+scanFile.next();
							break;
						}
						scanFile.close();
						
						if(col==0){
							order_data[row][col]=""+(row+1);
						}
						else if(col==1){
							order_data[row][col]=order_ID;
						}
						else if(col==2){
							order_data[row][col]=order_userName;
						}
						else if(col==3){
							order_data[row][col]=order_bookname;
						}
						else if(col==4){
							order_data[row][col]=order_amount;
						}
						else if(col==5){
							order_data[row][col]=order_quantity;
						}
						else{}
										
						
					}catch(Exception f)		{System.out.println("order file problem in admin view");}
				/* } */
				
			}
		}
				
		
		
		
		
		String table_colume[] ={"Serial","Order No","Customer Name ","Book Name","Book Price","Order Quantity"};
		JTable table_admin = new JTable(order_data,table_colume)
		
		{
			public boolean isCellEditable(int order_data, int table_colume)
			{
				return false;
			}
		};
		
		table_admin.setBounds(10,250,966,300);
		// table_admin.setFont(new Font ("Arial", Font.PLAIN, 11));
		/* JScrollPane scrol = new JScrollPane(table_admin);
		contain_view.add(scrol); */		
		
		contain_view.add(table_admin);
		
	
		//Add Background Image for Admin_View;
		ImageIcon bg_adminView = new ImageIcon("D:\\University\\3rd semester\\Java Project\\Final Project\\SOURCES\\Images\\Admin_Panel_Background.jpg");
		
		JLabel bg_Image =new JLabel(bg_adminView);
		bg_Image.setBounds(0,0,986,563);
		contain_view.add(bg_Image);



///////////////////////////////////////////////////////Action Listeners/////////////////////////////////////////////////////////////////////
		// For Add-Employee button Action;
		add_Employee.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				frame_view.setVisible(false);
				new Add_Employee();
			}});
			
		//For Employee-Info button Action;
		employee_info.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				
			}});
		
		//For Customer-Info button Action;
		customer_info.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
				
			}});
		
		frame_view.setVisible(true);
	}
}