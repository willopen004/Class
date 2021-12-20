// TCSD 14 JAVA Course HW_3
// Yiftach navot 304956279
// Rannan tivoni 302500228

package HW_3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SecondForm extends JFrame implements ActionListener {
	JLabel headline_Label = new JLabel("Students");
	JTextArea screen_field = new JTextArea("");
    JButton ShowAll = new JButton("Show all");
    JButton ShowAllNewFile = new JButton("Show all over avg 80");
    JButton Back = new JButton("Back");
    private ArrayList<Student> students;
    private MyForm first_Form = new MyForm();
    
    public SecondForm(MyClass my_Class, MyForm First_Form)
    {
    	super("all Students info"); // headline of window
    	Add_Panels();
    	Add_Function();    
    	first_Form = First_Form;
    	students = first_Form.my_Class.getStudents();
    }
    
    private void Add_Panels()
    {
    	JPanel screen_panel = new JPanel(new BorderLayout()); // Creating the first panel
    	screen_panel.add(headline_Label, BorderLayout.NORTH);
    	screen_panel.add(screen_field, BorderLayout.SOUTH);
    	screen_field.setPreferredSize(new Dimension(500,200));;

    	JPanel buttons_panel = new JPanel(new FlowLayout()); // Creating the second panel
    	buttons_panel.add(ShowAll);
    	buttons_panel.add(ShowAllNewFile);
    	buttons_panel.add(Back);
    	
    	setLayout(new BorderLayout()); // insert panels to the main layout
    	add(screen_panel, BorderLayout.NORTH);
    	add(buttons_panel, BorderLayout.SOUTH);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.pack();
    }
    
    private void Add_Function()
    {
    	ShowAll.addActionListener(this);
    	ShowAllNewFile.addActionListener(this);
    	Back.addActionListener(this);  
    }

	@Override
	public void actionPerformed(ActionEvent action) {
		if(action.getSource() == ShowAll)
		{	
			FileReader reader = null;
			try {
				 reader = new FileReader("src/outarr.txt");
				screen_field.read(reader, "src/outarr.txt");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		if(action.getSource() == ShowAllNewFile)
		{
			BufferedWriter Writer = null;
			try {
				Writer = new BufferedWriter(new FileWriter("src/80 average.txt"));
			} catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
			for (int i = 0; i < students.size(); i++)
			{
				if (students.get(i).average >= 80)
				{
					// BufferedWriter allows to write and insert whole input lines
					try {
						Writer.write(students.get(i).toString());
						Writer.newLine();
						System.out.println(students.get(i).toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
				try {
					Writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			FileReader reader = null;
			try {
				 reader = new FileReader("src/80 average.txt");
				screen_field.read(reader, "src/80 average.txt");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		if(action.getSource() == Back)
		{
			first_Form.setVisible(true);
			this.dispose();
		}
	}
}
