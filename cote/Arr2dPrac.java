import java.util.*;

public class Arr2dPrac {
    public static void main(String[] args) {
        // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        // 변수 생성  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        int[][] arr2D = {{1,3}, {2,4}, {3,1}, {4,2}};
        System.out.println("원본: " + Arrays.deepToString(arr2D)); 


        // n번째 원소 기준 정렬   ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
            // 1번째 원소 기준 오름차순 정렬
        Arrays.sort(arr2D, (a, b) -> {
            return a[0] - b[0];
        }); 
        System.out.println("1번 원소기준 asc: " + Arrays.deepToString(arr2D)); 

            // 2번째 원소 기준 내림차순 정렬
        Arrays.sort(arr2D, (a, b) -> {
            return b[1] - a[1];
        });
        System.out.println("2번 원소기준desc: " + Arrays.deepToString(arr2D)); 
    }
}
