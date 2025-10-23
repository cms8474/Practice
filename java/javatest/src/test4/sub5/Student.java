package test4.sub5;

public class Student {
	private String		name;
	private String		studentId;
	private Subject[] 	subjects;
	private int[]		scores;
	private int			subjectCount;
	
	public Student(String name, String studentId) {
		this.name = name;
		this.studentId = studentId;
		this.subjects = new Subject[10];
		this.scores = new int[10];
		this.subjectCount = 0;
	}
	
	public void enrollSubject(Subject std) {
		subjects[subjectCount] = std;
		std.addStudent(this);
		scores[subjectCount++] = 0;
		System.out.println(name + " - " + std.getName() + " 과목 신청완료");
	}
	
	public void setScore(Subject sub, int score) {
		for(int i=0 ; i<subjectCount ; i++) {
			if(subjects[i]==sub) {
				this.scores[i]	= score;
				System.out.println(name + " " + sub.getName() + " 과목 점수 입력완료");
			}
		}
		
	}
	
	public void printStudentInfo() {
		System.out.println("학생명: " + name);
		System.out.println("아이디: " + studentId);
		System.out.println("성적");
		for(int i=0 ; i<subjectCount ; i++) {
			System.out.println("- "+subjects[i].getName() + " : " + scores[i]);
		}
		
		
	}
	
	
	public String getName() {
		return this.name;
	}

}
