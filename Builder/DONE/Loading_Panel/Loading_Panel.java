import javax.swing.*;
import java.awt.*;
 
public class Loading_Panel {
    Color LIGHT_RED = new Color (255,102,102);
	Color Dark_BLUE = new Color (30,75,149);
	
	JFrame frame;
    JLabel image=new JLabel(new ImageIcon("C:\\Users\\Asus\\Desktop\\vdw_dribbble.gif"));
    JProgressBar progressBar=new JProgressBar();
    //JLabel message=new JLabel();
    // JLabel text=new JLabel("TUTORIALS FIELD");
	
    public Loading_Panel()
    {
        createGUI();
        addProgressBar();
        addImage();
        // addText();
        // addMessage();
        runningPBar();
    }
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,350);
        frame.setLocationRelativeTo(null);
        //frame.getContentPane().setBackground(Color.magenta);
        frame.setVisible(true);
 
    }
    public void addImage(){
        image.setSize(600,350);
        frame.add(image);
    }
    /* public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,30));
        text.setBounds(170,220,600,40);
        text.setForeground(Color.BLUE);
        frame.add(text);
    }
	
    public void addMessage()
    {
        message.setBounds(250,320,200,40);//Setting the size and location of the label
        message.setForeground(Color.black);//Setting foreground Color
        message.setFont(new Font("arial",Font.BOLD,15));//Setting font properties
        frame.add(message);//adding label to the frame
    } */
    public void addProgressBar(){
        progressBar.setBounds(0,345,615,5);
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(false);
        progressBar.setBackground(Dark_BLUE);
        progressBar.setForeground(LIGHT_RED);
        progressBar.setValue(0);
        frame.add(progressBar);
    }
    public void runningPBar(){
        int i=0;//Creating an integer variable and intializing it to 0
 
        while( i<=100)
        {
            try{
                Thread.sleep(37);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                // message.setText("LOADING "+Integer.toString(i)+"%");//Setting text of the message JLabel
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }
 
 
 
        }
    }
}