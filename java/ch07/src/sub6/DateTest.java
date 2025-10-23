package sub6;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * 날짜 250722
 * 이름 최민수
 * 내용 자바 date 클래스 실습
 */
public class DateTest {
	
	public static void main(String[] args) {
		
		// DATE 클래스
		System.out.println("DATE 클래스");
		Date date = new Date();
		System.out.println("date : " + date); //.toString() 생략
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String result = sdf.format(date);
		System.out.println("result : " + result + "\n");
		
		// Calender클래스 _ 객체 생성x(대표적인 싱글톤. new ~(); 불가)
		System.out.println("Calender 클래스");
		Calendar cal = Calendar.getInstance(); // 싱글톤 객체 생성
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int datee = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		System.out.printf("%d-%02d-%02d %02d:%02d:%02d",year,month,datee,hour,min,sec);
		
		
		
		
		
		
		
	} // med

}
