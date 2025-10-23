package sub2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class SelectTest {
	public static void main(String[] args) {
		// DB정보
		String host = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "zxy0575";
		String pass = "1234";
		
		//조회 결과반환용 리스트 생성
		List<User1VO> users = new ArrayList<>();

		Connection conn = null;
		
		try {
			// 접속
			conn = DriverManager.getConnection(host,user,pass);
			
			// 실행객체 생성
			Statement stmt = conn.createStatement();
			
			
			// 실행
			String sql = "Select * FROM USER1";
			
			// 실행결과(ResultSet)를 rs에 할당
			// ResultSet은 cursor를 가짐. next()로 커서 이동 가능
			ResultSet rs = stmt.executeQuery(sql); 
			
			// 결과처리 (일반적으로)리스트 생성
			while(rs.next()) { 
				//커서가 next()로 row 이동. 값이 있으면 TRUE
				//커서가 있는 행의 get자료타입(열) 획득 후 vo.변수 할당
				User1VO vo = new User1VO();
				vo.setUser_id(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setAge(rs.getInt(4));
				
				//리스트 삽입
				users.add(vo);
				
			}
			
			
			// 종료
			rs.close();
			stmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			System.out.println("ed");
		}
		
		// 리스트 출력
		for(User1VO user1 : users) {
			System.out.println(user1);
		}
		
	}

}
