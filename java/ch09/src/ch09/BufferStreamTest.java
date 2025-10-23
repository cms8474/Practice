package ch09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 날짜 250723
 * 이름 최민수
 * 내용 자바 stream(Buffer) 실습
 */
public class BufferStreamTest {
	public static void main(String[] args) {

		// 스트림 연결 할 파일 등록(파일 복붙)ㄴ
		// ~/샘플1(소스) -> 이 파일 -> ~/샘플2(타겟)
		String source = "C:\\Users\\GGG\\Desktop\\person.tif";
		String target = "C:\\Users\\GGG\\Desktop\\person2.tif";
		
		try {
			//////////////////////////
			// 기본 스트림 생성(파일연결) ///
			FileInputStream  fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(target);
			
			//////////////////////////
			// 버퍼 스트림 생성(파일연결) ///
			BufferedInputStream bis  = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			
			///////////////
			// 데이터 옮기기 //
			while(true) {
				
				//파일 읽기 (샘플1(소스)를 읽어!)
				int data = bis.read();
				
							
				if(data == -1) {break;} // 파일 내용 없음 = 종료
				
				char ch = (char) data;
				
				// 바이트 스트림 출력
				char ch1 = (char)data;
				//System.out.println(ch1);
				
							
				System.out.println(data);	// ascii 출력
				System.out.println(ch1);		// char  출력
				
				///////////// 
				///////////// 파일 쓰기
				///////////// 
				
				bos.write(data); // fis로 읽은 소스 -> fos로 쓰기
				
			} //w ed
		
			// 스트림 작업 종료
			fis.close();
			fos.close();
			bis.close();
			bos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("  PG EXIT...  ");
		
		
		
		
		
	} //med
} //ed
