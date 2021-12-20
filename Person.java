// TCSD 14 JAVA Course HW_3
// Yiftach navot 304956279
// Rannan tivoni 302500228

package HW_3;


public class Person {
	protected String name;
	protected long id;
	protected char gender;

	public Person(String name, long id, char gender){
		this.name = name;
		this.id = id;
		this.gender = gender;	
	}

	public String getName(){
		return name;
	}
	public long getId(){
		return id;
	}

	public char getGender(){
		return gender;
	}

	public void setName(String name){
		this.name=name;
	}
	public void draw(){
		if(this.gender=='F')
			System.out.println(":)");
		else
			System.out.println(":(");
	}
	@Override
	public String toString(){
		return "The name is: " + name + ", The id is: " + id +
				", The gender is: " + gender;
	}
}
