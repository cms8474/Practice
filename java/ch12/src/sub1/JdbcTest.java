package sub1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * date 25 0725
 * name minsu choi
 * text java JDBC practice
 */

public class JdbcTest {
	public static void main(String[] args) {
		
		// DB정보
		String host = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "zxy0575";
		String pass = "1234";
		
		try {
			// DB 접속
			Connection conn = DriverManager.getConnection(host, user, pass);
			
			if(conn != null) {
				System.out.println("db접속 성공");
			}else {
				System.out.println("db접속 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();		}
		
	} //med
} // ed
