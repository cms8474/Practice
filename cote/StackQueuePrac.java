import java.util.*;

public class StackQueuePrac {
    static public void main(String[] args) {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ Stack(후입선출)과 Queue(선입선출) ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        // ■■■■ Stack(LIFO): 짝 맞추기, 뒤로가기, DFS 등
        // ■■■■ Queue(FIFO): 순서대로 처리 (BFS 등)
        
        // 선언: Deque인터페이스 , 구현: ArrayDeque
        Deque<Integer> dq = new ArrayDeque<>();
        // TOP, FRONT, HEAD [DQ 요소들] BOTTOM, BACK, TAIL

        // ■■■■ Stack처럼 사용 (최근요소먼저 빼기 = 앞으로 넣고빼기 or 뒤로 넣고빼기)
        // ■■■■■■■■■■■■■■■■■■■■■■■ 앞넣뺐 스택 PPP push peek poll(pop) ■■■■■■■■■■■■■■■■■■■■■■■;
        // (push, peek, poll) ↔ [DQ 요소들]
        dq.push(1);
        dq.push(2); // dq = top [2, 1] bottom
         // 조회 삭제
         dq.peek();   // 2 top
         dq.poll();   // 2 삭제 -> dq = [1]
         dq.poll();   // 1 삭제 -> dq = []

        // ■■■■ Queue처럼 사용 (오래된요소먼저 빼기 = 앞으로 넣고 뒤로빼기 or 뒤로 넣고 앞으로빼기)
        // ■■■■■■■■■■■■■■■■■■■■■■■ 뒤넣앞빼 큐 OPP offer peek poll ■■■■■■■■■■■■■■■■■■■■■■■;
        // (peek, poll) ← [DQ 요소들] ← (offer)
        dq.offer(1);
        dq.offer(2);   // dq = top [1, 2] bottom
        System.out.println("dq after offer: " + dq);
         // 조회 삭제
         dq.peek();  // 1 bottom
         dq.poll();  // 1 삭제 -> dq = [2]
         dq.poll();  // 2 삭제 -> dq = []
        


        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■앞으로 넣고빼기■■■■■■■■■■■■■■■■■■■■■■■");
        // 앞으로 삽입(왼쪽) push, addFirst, offerFirst
        dq.addFirst(10);
        dq.offerFirst(20);
        dq.offerFirst(30);
        dq.push(40);
        dq.push(50); // dq =  top(front) [50, 40, 30, 20, 10] bottom(back)
        System.out.println("Stack after push: " + dq); 

        // 앞으로 꺼내기(읽기) peek, getFirst
        System.out.println("peek    : " + dq.peek());     // 50
        System.out.println("getFirst: " + dq.getFirst()); // 50

        // 앞으로 꺼내기(삭제) pop, removeFirst, pollFirst
        System.out.println("pop        : " + dq.pop());         // 출력 50 ||| dq = [40, 30, 20, 10]
        System.out.println("remove     : " + dq.remove()); // 출력 40 ||| dq = [30, 20, 10]
        System.out.println("pollFirst  : " + dq.pollFirst());   // 출력 30 ||| dq = [20, 10]
        System.out.println("poll       : " + dq.poll());        // 출력 20 ||| dq = [10]

        
        System.out.println("dq: " + dq);                  // dq = top(front) [10] bottom(back)

        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■뒤로 넣고빼기■■■■■■■■■■■■■■■■■■■■■■■");
        
        // 뒤로 삽입(오른쪽) add, offer
        dq.add(11);
        dq.offer(12);
        dq.addLast(13);
        dq.offerLast(14); 
        System.out.println("After adding to back: " + dq); // dq = [10, 11, 12, 13, 14]

        // 뒤로 꺼내기(읽기) peekLast, getLast
        System.out.println("peekLast  : " + dq.peekLast());  // 14
        System.out.println("getLast   : " + dq.getLast());   // 14

        // 뒤로 꺼내기(삭제) removeLast, pollLast
        System.out.println("removeLast: " + dq.removeLast()); // 출력 14 ||| dq = [10, 11, 12, 13]
        System.out.println("removeLast: " + dq.removeLast()); // 출력 13 ||| dq = [10, 11, 12]
        System.out.println("pollLast  : " + dq.pollLast());   // 출력 12 ||| dq = [10, 11]
        System.out.println("pollLast  : " + dq.pollLast());   // 출력 11 ||| dq = [10]
        
        System.out.println("dq: " + dq);                     // dq = top(front) [10] bottom(back)

        
        
        
    }
}