package test5;

import java.util.ArrayList;
import java.util.List;

class Member {
	String id;
	String name;
	int age;
	
	public Member(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		//return "Member [id=" + id + ", name=" + name + ", age=" + age + "]";
		return this.id + ", " + this.name +", " +  this.age ;
	}
}

public class Test08 {
	public static void main(String[] args) {
		Member m1 = new Member("a101", "김유신", 23);
		Member m2 = new Member("a102", "김춘추", 21);
		Member m3 = new Member("a103", "장보고", 33);
		
		ArrayList<Member> memberList = new ArrayList<>();
		memberList.add(m1);
		memberList.add(m2);
		memberList.add(m3);
		
		for(Member m : memberList) {
			System.out.println(m);
		}
	}//med
}//ed
