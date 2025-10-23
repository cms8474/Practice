package sub4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
 * 날짜 250723
 * 이름 최민수
 * 내용 자바 파일처리 실습
 */
public class FileTest {
	
	public static void main(String[] args) {
		
		String path1 = "C:\\Users\\GGG\\Desktop\\source.txt";
		String path2 = "C:\\Users\\GGG\\Desktop\\Sample"; //dir
		
		// 파일 객체 생성
		File file1 = new File(path1);
		File file2 = new File(path2);
		
		// 파일 작업
		try {
			file1.createNewFile(); 	// source.txt 파일생성
			file2.mkdir(); 			// Sample dir생성
			/*
			System.out.println("file1 이름 : " +file1.getName());
			System.out.println("file1 존재여부 : " +file1.exists()); //true
			System.out.println("file1 파일여부 : " +file2.isFile());
			System.out.println("file1 경로 : " +file1.getPath());
			System.out.println("file1 시스템 경로 : " +file1.getAbsolutePath());
			System.out.println("file2 dir 여부 : " +file2.isDirectory());

			
			file1.delete();
			file2.delete();
			System.out.println("file1 존재여부 : " +file1.exists()); //false
			/*
			 * 
			 */
			// Files 실습
			Path source = Paths.get("C:\\Users\\GGG\\Desktop\\source.txt");
			Path target = Paths.get("C:\\Users\\GGG\\Desktop\\target.txt");
			Path dest 	= Paths.get("C:\\Users\\GGG\\Desktop\\dest.txt");
			
			//파일 복사 이동 삭제
			Files.copy(source, target);
			Files.move(source, dest, StandardCopyOption.REPLACE_EXISTING); //3칸:있으면 교체 옵
			Files.delete(dest);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("ed");
		
	}//med
}
