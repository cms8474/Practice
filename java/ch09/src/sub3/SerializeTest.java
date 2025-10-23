package sub3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*
 * 날짜 250723
 * 이름 최민수
 * 내용 자바 직렬화 실습
 */
public class SerializeTest {
	public static void main(String[] args) {
		
		// 직렬화를 위한 Serializable 구현된 객체
		Apple apple = new Apple("한국", 3000);
		String path = "C:\\Users\\GGG\\Desktop\\apple.data";
		
		try {
			FileOutputStream 	fos	= 	new FileOutputStream(path);
			ObjectOutputStream	oos	=	new ObjectOutputStream(fos);
			
			// 객체 직렬화(객체를 외부에 내보내기)
			oos.writeObject(apple);
			
			
			// 스트림 종료료
			oos.close();
			fos.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end");
		
		
	} //med
}
