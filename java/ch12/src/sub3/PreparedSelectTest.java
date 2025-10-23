package sub3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sub2.User1VO;

public class PreparedSelectTest {
	public static void main(String[] args) {
		// DB정보
		String host = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "zxy0575";
		String pass = "1234";

		Connection conn = null;
		List<User1VO> users = new ArrayList<User1VO>();
		
		try {
			// 접속
			conn = DriverManager.getConnection(host,user,pass);
			// 실행객체 생성(PreqpredStatment)
			// 쿼리 파라미터를 활용한 (준비된)SQL
			String sql = "SELECT * FROM USER1 WHERE AGE >= ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			// 각 쿼리 파라미터 바인딩
			psmt.setInt(1, 20);
			
			// 실행
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				//VO 객체  생성 후 리스트 할당
				User1VO vo = new User1VO();
				vo.setUser_id(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setAge(rs.getInt(4));
				
				users.add(vo);
			}
			//종료.close();
			rs.close();
			psmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();}
		
		//리스트 출력
		for(User1VO user1 : users) {
			System.out.println(user1);
		}
				
				
	} //med
} //ed
