import java.util.*;

public class StackQueuePrac {
    static public void main(String[] args) {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ ■ Stack(후입선출)과 Queue(선입선출) ■ ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        // ■■■■ Stack: 짝 맞추기, 뒤로가기 등
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // 넣기
        stack.push(2); 
        stack.pop();   // 꺼내기 (2 나옴)
        stack.peek();  // 확인만 하기 (1 확인, 꺼내진 않음)

        // ■■■■ Queue: 순서대로 처리 (BFS 등) -> LinkedList 사용
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 넣기
        queue.offer(2);
        queue.poll();   // 꺼내기 (1 나옴)
        queue.peek();   // 확인만 하기 (2 확인)
    }
}