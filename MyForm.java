// TCSD 14 JAVA Course HW_3
// Yiftach navot 304956279
// Rannan tivoni 302500228

package HW_3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MyForm extends JFrame implements ActionListener {
	// create all elements of first Form
	MyClass my_Class = new MyClass();
	JTextField name_field = new JTextField(10);
	JTextField id_field = new JTextField(10);
	JTextField gender_field = new JTextField(10);
	JTextField avg_field= new JTextField(10);
	JTextField dep_field = new JTextField(10);
	JLabel name_Label = new JLabel("Name:");
    JLabel id_Label = new JLabel("Id:");
    JLabel gender_Label = new JLabel("Gender:");
    JLabel avg_Label = new JLabel("Average:");
    JLabel dep_Label = new JLabel("Department:");
    JButton Next = new JButton("Next");
    JButton Save = new JButton("SaveToFile");
    
    public MyForm()
    {
    	super("Student Form"); // headline of window
    	Add_Panels();
    	Add_Function();
    	Testing();
    }
    
    private void Add_Panels()
    {
    	JPanel fields_panel = new JPanel(new GridLayout(5,2)); // Creating the first panel
    	fields_panel.add(name_Label);
    	fields_panel.add(name_field);
    	fields_panel.add(id_Label);
    	fields_panel.add(id_field);
    	fields_panel.add(gender_Label);
    	fields_panel.add(gender_field);
    	fields_panel.add(avg_Label);
    	fields_panel.add(avg_field);
    	fields_panel.add(dep_Label);
    	fields_panel.add(dep_field);

    	JPanel buttons_panel = new JPanel(new GridLayout(1,3)); // Creating the second panel
    	buttons_panel.add(Next);
    	buttons_panel.add(Save);
    	
    	setLayout(new BorderLayout()); // insert panels to the main layout
    	add(buttons_panel, BorderLayout.SOUTH);
    	add(fields_panel, BorderLayout.NORTH);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.pack();
    }
    
    private void Add_Function()
    {
    	name_field.addActionListener(this);
    	id_field.addActionListener(this);
    	gender_field.addActionListener(this);
    	avg_field.addActionListener(this);
    	dep_field.addActionListener(this);
        Next.addActionListener(this);
        Save.addActionListener(this);  
    }
    
    private void Testing()
    {
        Student s = new Student("mike", 1, 'M', 85.2, "guy");
        Student s1 = new Student("john", 2, 'M', 70.2, "guy");
        Student s2 = new Student("sam", 3, 'F', 81.3, "girl");
        
        my_Class.getDetails(s);
        my_Class.getDetails(s1);
        my_Class.getDetails(s2);
    }
    	
    @Override
	public void actionPerformed(ActionEvent action) {
		
		if(action.getSource() == Save)
		{
			if (id_field.getText().equals("") || name_field.getText().equals("") ||
					gender_field.getText().equals("") || avg_field.getText().equals("") || dep_field.getText().equals(""))
			{
				System.out.println("not enough details!");
				return;
			}
			
			Student s = new Student(name_field.getText(),Long.parseLong(id_field.getText()),
					gender_field.getText().charAt(0),Double.parseDouble(avg_field.getText()),dep_field.getText());
			System.out.println(s.toString());
			my_Class.getDetails(s);
			
			id_field.setText("");
			name_field.setText("");
			gender_field.setText("");
			avg_field.setText("");
			dep_field.setText("");
		}
		
		if(action.getSource() == Next)
		{
			try {
				this.my_Class.putDetails("src/outarr.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			SecondForm second_form = new SecondForm(this.my_Class, this);
			second_form.show();
			this.setVisible(false);
		}	
	}
}


