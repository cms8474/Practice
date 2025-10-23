package sub2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) {
		// DB정보
				String host = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "zxy0575";
				String pass = "1234";
		
		Connection conn = null;
				
		try {
		//DB 접속
			conn = DriverManager.getConnection(host, user, pass);
			
		//SQL 객체 생성(Statement, PreparedStatement)
			Statement stat = conn.createStatement();
			
		//SQL 실행
			String sql = "INSERT INTO USER1 VALUES('J101', '기뮤신', '010-1212-2221', 31)";
			stat.executeUpdate(sql);
		//결과 처리(SELECT)

		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//DB종료		
			try {
				conn.close();
			} catch (Exception e2) {
				} 
		}
		
		System.out.println("insert 완료");
	}//med
} //ed
