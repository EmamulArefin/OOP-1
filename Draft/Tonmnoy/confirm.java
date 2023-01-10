import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class confirm
{
	public confirm ()
	{
		//frame
	JFrame fr = new JFrame("CONFIRMATION-(Afif)");
    fr.setBounds(220,110,1000,600);
	fr.setLayout(null);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	/* fr.addWindowListener(new WindowAdapter(){
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
		); */
						fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	
	
	
	}
}
