package test3;

public class Student {
	protected static int		studentId;
	private String	studentName;
	private String	major;
	private int		grade;
	
	public Student(String studentName, String major, int grade){
		this.studentId++;
		this.studentName = studentName;
		this.major = major;
		this.grade = grade;
	}
	
	public void studentInfo() {
		System.out.println("---------------");
		System.out.println("학번 : "+studentId);
		System.out.println("이름 : "+studentName);
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+grade);
	}

}
