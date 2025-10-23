package sub3;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*
 * 날짜 250723
 * 이름 최민수
 * 내용 자바 직렬화 실습
 */
public class DeserializeTest {
	public static void main(String[] args) {
		
		// 직렬화를 위한 Serializable 구현된 객체
		String path = "C:\\Users\\GGG\\Desktop\\apple.data";
				
		
		try {
			//역직렬화를 위한 기본스트림과 보조스트림 생성
			FileInputStream		fis =	new FileInputStream(path);
			ObjectInputStream	ois	=	new ObjectInputStream(fis);
			
			//역직렬화
			Apple	apple	=	(Apple)	ois.readObject();
			apple.show();
			
			//스트림 종료
			ois.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		System.out.println("ed");
		
		
	}//med

}
