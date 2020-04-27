

import java.awt.*;
import java.awt.event.*; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.io.*;


// Create a simple GUI window
public class PlayWindow extends JFrame implements ActionListener {
   /**
	 * 
	 */
	JFrame frame;
	JCheckBox myCheck;
	JRadioButton male,female;
	ButtonGroup gender;
	JComboBox selector;
	final JTextField popup;
	
	private static final long serialVersionUID = 1L;
	PlayWindow() {
	   int[] bounds = {400,400};
      //Create and set up the window.
	  
      frame = new JFrame("Parion");
      String geometries[] = {"Helix", "Loop", "Box"};
	  selector = new JComboBox(geometries);
	  selector.setBounds(50,300,100,20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLabel textLabel = new JLabel("I'm a label in the window",SwingConstants.LEFT);
      //textLabel.setPreferredSize(new Dimension(300, 100));
      //frame.getContentPane().add(textLabel, BorderLayout.CENTER);
      textLabel.setBounds(bounds[0]/2-70,0,140,20);
      
      myCheck = new JCheckBox("testbox", true);
      myCheck.setBounds(300, 300, 100, 50);
      frame.add(myCheck);
      
      JLabel blank = new JLabel(new ImageIcon("blank.png"));
      blank.setBounds(100, 200, 50, 50);
      
      male = new JRadioButton("Male",true);
      male.setBounds(0, 200, 100, 20);
      female = new JRadioButton("Female");
      female.setBounds(0, 220, 100, 50);
      gender = new ButtonGroup();
      gender.add(male);
      gender.add(female);
      frame.add(male);
      frame.add(female);
      
      JPanel panel = new JPanel();
      getContentPane().add(paint);
      setSize(450, 450);
      //Window Logo
      ImageIcon logoicon = new ImageIcon("logo2.png");
      Image logo = logoicon.getImage();
      frame.setIconImage(logo);
      
      //Play Button
      JButton play = new JButton("Play");
      play.setBounds(20, 20, 80, 20);
      
      
      popup = new JTextField();
      popup.setBounds(100, 100, 150, 20);
      popup.addFocusListener(new FocusAdapter() {
    	public void focusGained(FocusEvent e) {
    		JTextField source = (JTextField)e.getComponent();
    		source.setText("");
    		//source.removeFocusListener(this); //turns off focus listener after the textfield is selected
    	}
      });
      
      play.addActionListener(this);  
      frame.add(play);
      frame.add(popup);
      
      frame.add(selector);
      frame.add(textLabel);
      frame.setSize(bounds[0], bounds[1]);
      //Display the window.
      frame.setLocationRelativeTo(null); //places window toward center of screen?
      frame.setLayout(null);
      //frame.pack(); //compacts window to fit assets	
      frame.setVisible(true);
   }
   public void actionPerformed(ActionEvent e){  
	   String msg = "Test";
       popup.setText("Welcome to Javatpoint.");  
	   if(myCheck.isSelected()) {
		   msg = "you've checked the box";
	   }
	   if(male.isSelected()) {
		   msg += "\nmale";
	   } else {
		   msg += "\nfemale";
	   }
	   msg += "\n"+selector.getItemAt(selector.getSelectedIndex());
       JOptionPane.showMessageDialog(this,msg);
//       try {
//       ProcessBuilder pb = new ProcessBuilder("runLoop.bat");
//       Process p = pb.start();
//       }catch(Exception p){System.out.println(p);}
       
    	   
   
       String command = "cmd /c start \"\" runLoop.bat";
       
       try {
      Process proc = Runtime.getRuntime().exec(command);
      	System.out.println(proc);
       } catch(IOException p) {
    	   System.out.println(p);
       }
       
   }
   
	public void paint(Graphics g) {
		   super.paint(g); 
		    Graphics2D g2 = (Graphics2D) g;
		    Line2D lin = new Line2D.Float(100, 100, 250, 260);
		    g2.draw(lin);
	   }
   public static void main(String[] args) {
      PlayWindow play = new PlayWindow();
      play.setVisible(true);
   }
} 

