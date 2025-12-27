import java.util.*;

public class ListPrac {
    static public void main(String[] args) {
        
        // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        // 변수 생성  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        List<Integer> li = new ArrayList<>(Arrays.asList(5,2,1,4,3));
        System.out.println("원본 List: " + li);
        
        // 정렬      ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        Collections.sort(li);                             // asc  1 2 3 4 5
        Collections.sort(li, Collections.reverseOrder()); // desc 5 4 3 2 1
        
        li.sort((a,b) -> a - b); // asc  1 2 3 4 5
        li.sort((a,b) -> b - a); // desc 5 4 3 2 1

        li.sort((a,b) -> Integer.compare(a, b)); // asc  1 2 3 4 5
        li.sort((a,b) -> Integer.compare(b, a)); // desc 5 4 3 2 1

        li.sort((a,b) -> a.compareTo(b));        // asc  1 2 3 4 5
        li.sort((a,b) -> b.compareTo(a));        // desc 5 4 3 2 1

        System.out.println("a-b" + li);

        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ ■ 배열과 리스트, 정렬과 변환  ■ ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        int[] arr = {5, 1, 3, 2, 4};
        String[] strArr = {"apple", "banana", "kiwi"};

        // ■■■■ 배열 정렬 (오름차순) -> {1, 2, 3, 4, 5}
        Arrays.sort(arr); 

        // ■■■■ 배열 자르기 (인덱스 1~3, 즉 1번부터 2번까지) -> {2, 3}
        int[] subArr = Arrays.copyOfRange(arr, 1, 3); 

        // ■■■■ 배열 -> 리스트 변환 (String)
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));
        strList.add("grape"); // 리스트라 추가 가능

        // ■■■■ 리스트 정렬 (내림차순) -> {kiwi, grape, banana, apple}
        Collections.sort(strList, Collections.reverseOrder());

        // ■■■■ 리스트 -> 배열 변환 (String)
        String[] newStrArr = strList.toArray(new String[0]);

        // ■■■■ 리스트 -> 배열 변환 (int) *중요: int는 stream 써야 편함
        List<Integer> intList = new ArrayList<>();
        intList.add(10); intList.add(20);
        int[] newIntArr = intList.stream().mapToInt(i -> i).toArray();
        
        // ■■■■ 배열 출력
        System.out.println(Arrays.toString(newIntArr)); // [10, 20]
        
        
    }
}
