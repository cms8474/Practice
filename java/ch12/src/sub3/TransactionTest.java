package sub3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("에러 발생 하시겠습니까?");
		
		int answer = sc.nextInt();
		
		// DB정보
		String host = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bank";
		String pass = "1234";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(host,user,pass);
			
			//트랜잭션 자동 커밋 해제
			conn.setAutoCommit(false);
			
			String sql1 = "UPDATE ACCOUNT SET ACC_BALANCE = ACC_BALANCE - 10000 WHERE ACC_CID=?";
			String sql2 = "UPDATE ACCOUNT SET ACC_BALANCE = ACC_BALANCE + 10000 WHERE ACC_CID=?";
			PreparedStatement psmt1 = conn.prepareStatement(sql1);
			PreparedStatement psmt2 = conn.prepareStatement(sql2);
			psmt1.setString(1, "730423-1000001");
			psmt2.setString(1, "830513-2000003");
			
			psmt1.executeUpdate();
			
			if(answer == 1) {
				throw new Exception("에러 발생~!");
			}
			
			
			psmt2.executeUpdate();
			conn.commit();//수동커밋 실행
			
			
			psmt1.close();
			psmt2.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();}
			
		}
		
		
		System.out.println("프로그램 종료");
	} //med
} //ed
