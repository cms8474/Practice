package sub2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTest {
	public static void main(String[] args) {
		// DB정보
		String host = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "zxy0575";
		String pass = "1234";

		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(host,user,pass);
			Statement stmt = conn.createStatement();
			
			String sql ="UPDATE USER1 SET AGE=35 WHERE USER_ID='J101'";
			stmt.executeUpdate(sql);
			
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("update 완료");
	}

}//ed
