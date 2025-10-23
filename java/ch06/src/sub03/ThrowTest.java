package sub03;
/*
 * 날짜 250721
 * 이름 최민수
 * 내용 자바 예외 발생시키기 실습
 */

// 사용자 정의 예외 클래스
class MinusException extends Exception {
	public MinusException(String message) {
		super(message);
	}
}

class OverException extends Exception {
	public OverException(String message) {
		super(message);
	}
}

class Score {
	public void check(int score) throws MinusException, OverException {
		
		if(score < 0) {
			// 예외발생 시키기
			throw new MinusException("점수는 음수가 될 수 없습니다");
			
		}else if(score > 100) {
			// 예외발생 시키기
			throw new OverException("100점 초과 못함");
			
		}else {
			System.out.println("점수 이상 무");
			
		}
		
	}
}

public class ThrowTest {
	public static void main(String[] args) {
		Score score = new Score();
		
		try {
			//score.check(-3);
			score.check(120);
			//score.check(96);
		} catch (MinusException e) {
			e.printStackTrace();
		} catch (OverException e) {
			e.printStackTrace();
		}
		
	} //med

}//ted
