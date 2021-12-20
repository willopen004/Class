// TCSD 14 JAVA Course HW_3
// Yiftach navot 304956279
// Rannan tivoni 302500228

package HW_3;
import java.io.*;
import java.util.ArrayList;

//service file for Implementations only that can be used from all classes
public class MyClass implements Details{	
	private ArrayList<Student> Students;

	public MyClass() {
		this.Students = new ArrayList<Student>(); 
	}
	
	public ArrayList<Student> getStudents() {
		return Students;
	}	
	@Override
	public void getDetails(Student s) {
		this.Students.add(s);			
	}

	@Override 
	public void putDetails(String filename) throws IOException {
	BufferedWriter Writer;
	// BufferedWriter allows to write and insert whole input lines
	Writer = new BufferedWriter(new FileWriter(filename));
	// FileWriter creates new file to write to
	
	for(int i = 0; i < Students.size(); i++)
	{
		Writer.write(Students.get(i).toString());
		Writer.newLine();
	}
	Writer.close();
	}
}