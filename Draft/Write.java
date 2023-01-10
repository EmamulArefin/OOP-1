import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Write{
	public static void main(String args[]){
		Write ad=new Write();
		ad.read();
	}
	
	
	
	Write(){
		try{
			Formatter ab = new Formatter("C:\\Users\\Asus\\Desktop\\Books Information\\Book-1.txt");
			ab.format("%s\r\n","100");
			ab.format("%s\r\n","150.00");
			ab.format("%s\r\n","Voy");
			ab.format("%s\r\n","Humayon Ahmed");
			
			ab.close();
			
		}catch(Exception a){
			System.out.println("Problem in Writing file in Write panel");
		}
	}
	
	void read(){
		for(int i=1; i<=3; i++){
			try{
			String id="",price="", bookName="", writer="";
			
			File file_name =new File("C:\\Users\\Asus\\Desktop\\Books Information\\Book-"+i+".txt");
			
			
			Scanner scanFile = new Scanner(file_name);
			
			while(scanFile.hasNext()){
				id=scanFile.next();
				price=scanFile.next();
				bookName=scanFile.next();
				writer=scanFile.next()+" "+scanFile.next();
			}
			scanFile.close();
			
			JOptionPane.showMessageDialog(null,id);
			JOptionPane.showMessageDialog(null,price);
			JOptionPane.showMessageDialog(null,bookName);
			JOptionPane.showMessageDialog(null,writer);
			
		}catch(Exception a){
			System.out.println("problem in read file");
		}
		}
	}
}