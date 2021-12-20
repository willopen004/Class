// TCSD 14 JAVA Course HW_3
// Yiftach navot 304956279
// Rannan tivoni 302500228

package HW_3;


public class Student extends Person{
	protected double average;
	protected String dep;

	public Student(String name, long id, char gender,double average, String dep)
	{
		super(name,id,gender);
		this.average = average;
		this.dep=dep;
	}
	
	public boolean setAverage(double average){
		if(average<0||average>100) {
			this.average=0.0;
			return false;
		}
		this.average=average;
		return true;
	}
	
	public double getAverage(){
		return this.average;
	}
	
	public String getdep(){
		return this.dep;
	}
	
	
	@Override	
	public void draw(){
		if(this.gender=='F')
			System.out.println(":))");
		else
			System.out.println(":((");
	}
	@Override	
	public String toString(){
		return "The name is: " + name + ", The id is: " + id +
				", The gender is: " + gender + ", the average is: " + average
				+ ", The department is: " + dep;
	}	
}
