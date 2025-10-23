package sub3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PreparedInsertTest {
	public static void main(String[] args) {
		// DB정보
		String host = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "zxy0575";
		String pass = "1234";

		Connection conn = null;
		
		try {
			// 접속
			conn = DriverManager.getConnection(host,user,pass);
			// 실행객체 생성(PreqpredStatment)
			// 쿼리 파라미터를 활용한 (준비된)SQL
			String sql = "INSERT INTO USER1 VALUES(?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			// 각 쿼리 파라미터 바인딩
			psmt.setString(1, "P101"); 
			psmt.setString(2, "김유신");
			psmt.setString(3, "010-1222-3333");
			psmt.setInt(4, 34);
			
			// 실행
			psmt.executeUpdate();
			
			//select
			
			
			//종료.close();
			psmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();

			
		}
	}

}
