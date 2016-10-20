package homework6task3students;


public class Student implements Comparable<Student>{
	private String name;
	private String lastName;
	private  String fullName;
	private  int course;
	public Student(String fullName, int course)
	{
		this.fullName = fullName;
		this.course = course;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public  String getFullName()
	{
		return fullName;
	}
	 public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	public  int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
	 @Override
	    public String toString() {
	        return  fullName +" course: "+ course;
	    }

	@Override
	public int compareTo(Student o) {
		
		if (this.getCourse() > o.getCourse()) {
			return 1;
		} else if (this.getCourse() == o.getCourse()) {
			return 0;
		} else
			return -1;
	
	}
}
