import java.util.*;

public class Solution {

    static void frontToEndN(Queue<Integer> q, int qsize){
        if(qsize <= 0) return;

        q.add(q.poll());

        frontToEndN(q, qsize - 1);

    }


    static void sortedInsert(Queue<Integer> q, int temp, int qsize){
        if(q.isEmpty() || qsize == 0){
            q.add(temp);
            return;
        } else if(temp <= q.peek()) {
            q.add(temp);
            frontToEndN(q, qsize);
        } else {
            q.add(q.poll());
            sortedInsert(q, temp, qsize - 1);
        }
    }

    static public void sortQueue (Queue<Integer> q) {
        if(q.isEmpty()) return;

        int temp = q.poll();
        sortQueue(q);
        
        sortedInsert(q, temp, q.size());
    }

    public static void main(String[] args) {

        // 재귀함수와 주어진 함수만으로 큐를 정렬하라
        // empty, push, pop, size, front

        //Input: queue = {10, 7, 16, 9, 20, 5} 
        //Output: 5 7 9 10 16 20
        //Input: queue = {0, -2, -1, 2, 3, 1} 
        //Output: -2 -1 0 1 2 3 

        // 테스트 케이스
        Queue<Integer> qu = new LinkedList<>();
        qu.add(10);
        qu.add(7);
        qu.add(16);
        qu.add(9);
        qu.add(20);
        qu.add(5);

        sortQueue(qu);

        
        while (!qu.isEmpty()) {
            System.out.print(qu.poll() + " ");
        }

        return;

    }

}