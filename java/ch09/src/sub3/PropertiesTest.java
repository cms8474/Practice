package sub3;

import java.io.FileOutputStream;
import java.util.Properties;

/*
 * 날짜 250723
 * 이름 최민수
 * 내용 자바 프로퍼티스 컬렉션(자료구조) 실습
 */
public class PropertiesTest {
	public static void main(String[] args) {
		// 프로퍼티: 키-값이 모두 "문자열"인 자료구조
		Properties prop	=	new Properties();
		//↑(동일) Map<String, String> map = new HashMap();
		
		prop.setProperty("A", "Apple");
		prop.setProperty("B", "Banana");
		prop.setProperty("C", "Cherry");
		
		System.out.println(prop);
		
		
		// 직렬화(가 아니지만 일단 비슷함)
		String path = "C:\\Users\\GGG\\Desktop\\fruit.properties";
		
		try {
			FileOutputStream fos	=	new	FileOutputStream(path);
			prop.store(fos, null);
			
			fos.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		System.out.println("ed");
		
		
	}//med
}
