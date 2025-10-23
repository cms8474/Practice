package sub2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteTest {
	public static void main(String[] args) {
		// DB정보
				String host = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "zxy0575";
				String pass = "1234";

				Connection conn = null;
				
		try {
			conn = DriverManager.getConnection(host,user,pass);
			Statement stmt = conn.createStatement();
			
			String sql = "DELETE USER1 WHERE USER_ID = 'J101'";
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("삭제!");
		}
		
		
	}

}
