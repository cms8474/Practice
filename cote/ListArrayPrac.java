import java.util.*;

public class ListArrayPrac {
    static public void main(String[] args) {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ ■ ■ ■ ■ 배열 ■ ■ ■ ■ ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        int[] arr = {5, 1, 3, 2, 4};
        String[] strArr = {"apple", "banana", "kiwi"};

        // ■■■■ 배열 정렬 (오름차순) -> {1, 2, 3, 4, 5}
        Arrays.sort(arr); 

        // ■■■■ 배열 정렬 (내림차순) -> {5, 4, 3, 2, 1}
        arr = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder())
                .mapToInt(z -> z).toArray();

        // ■■■■ 배열 자르기 (인덱스 0~2, 즉 0번부터 1번까지) -> {5, 4}
        int[] subArr = Arrays.copyOfRange(arr, 0, 2); // {5, 4}
        //또는 subArr = Arrays.copyOf(arr, 2); = {5, 4}

        // ■■■■ 배열 -> 리스트 변환 (String)
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));
        strList.add("grape"); // {"apple", "banana", "kiwi", "grape"}

        // ■■■■ int 배열 -> 리스트 변환
        List<Integer> intLi = new ArrayList<>();
        for (int i : arr) intLi.add(i); // 권장
        //intLi = Arrays.stream(arr).boxed().toList(); // 불변List{5, 4, 3, 2, 1}

        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ ■ ■ ■ 리스트 ■ ■ ■ ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        // ■■■■ 리스트 정렬 (오름차순)
        Collections.sort(strList); 
        strList.sort((a,b) -> a.compareTo(b)); // {apple, banana, grape, kiwi}
        intLi.sort((a,b) -> a - b); // {1, 2, 3, 4, 5}

        // ■■■■ 리스트 정렬 (내림차순)
        Collections.sort(strList, Collections.reverseOrder());
        strList.sort((a,b) -> b.compareTo(a)); // {kiwi, grape, banana, apple}
        intLi.sort((a,b) -> b - a); // {5, 4, 3, 2, 1}

        // ■■■■ 리스트 삽입, 수정, 삭제
        strList.add("orange"); // 삽입 {"kiwi", "grape", "banana", "apple", "orange"}
        strList.set(4, "mango"); // 수정 {"kiwi", "grape", "banana", "apple", "mango"}
        strList.remove(4); // 4번 원소 삭제 {"kiwi", "grape", "banana", "apple"}


        // ■■■■ 리스트 -> 배열 변환 (String)
        strArr = strList.toArray(new String[0]); // {"kiwi", "grape", "banana", "apple"}

        // ■■■■ 리스트 -> 배열 변환 (int) *중요: int는 stream 써야 편함
        arr = intLi.stream().mapToInt(i -> i).toArray(); // {1, 2, 3, 4, 5}
        
    }
}