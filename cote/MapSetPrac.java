import java.util.*;

public class MapSetPrac {
    static public void main(String[] args) {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ ■ ■ ■ ■ ■ Map(카운팅) ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        String[] foods = {"chicken", "chicken", "pizza", "burger"};

        // ■■■■ HashMap: 개수 세기 (빈도수) -> {chicken=2, pizza=1, burger=1}
        Map<String, Integer> map = new HashMap<>();

        for (String f : foods) {
            // ★ getOrDefault: 키가 있으면 값 반환, 없으면 0 반환 (매우 중요)
            map.put(f, map.getOrDefault(f, 0) + 1); // 삽입, 수정 = put(키, 값)
        }

        // ■■■■ 특정 키 포함 여부
        boolean hasPizza = map.containsKey("pizza"); // true


        // ■■■■ 순회방식 1) for-each & keySet(): 읽기 전용
        //  Key와 Value 꺼내기
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key)); // 값은 get 호출 필요
        }
        
        // ■■■■ 순회방식 2) entrySet(): 읽기 전용 ★★★
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " -> " + value);
        }

        // ■■■■ 순회방식 3) iterator: 삭제 가능 ★★
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            int value = map.get(key);
            if (value == 1) {
                it.remove(); // 값이 1인 키-값 쌍 삭제
            }
        } // {chicken=2}

        // ■■■■ Map -> Set 변환
        Set<String> set = new HashSet<>(Arrays.asList(foods)); // {chicken, pizza, burger} 중복제거
        
        // ■■■■ Map -> List 변환
        List<String> foodLi = new ArrayList<>(map.keySet()); // {"chicken"}
        
        
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ ■ ■ ■ ■ ■ Set(중복제거) ■ ■ ■ ■ ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        // ■■■■ HashSet: 중복 제거 -> [chicken, pizza, burger] (순서 보장 X)
        // 순서보장 x (인덱스 없음), 인덱스로 접근 불가
        Set<Integer> numSet = new HashSet<>();
        numSet.add(10);     // 추가
        numSet.add(20);
        numSet.remove(20);  // 특정 값 제거 {10, 30}
        numSet.clear();        // 전체 제거

        numSet.add(10);     // 추가
        numSet.add(30); 
        numSet.size();         // 1 Set 크기 확인

        // ■■■■ Set 순회방식 1) for-each
        for (int num : numSet) {
            System.out.println(num);
        }   // numSet = {10, 30}

        // ■■■■ Set 순회방식 2) iterator: 삭제 가능
        Iterator<Integer> setIt = numSet.iterator();
        while (setIt.hasNext()) {
            int num = setIt.next();
            if (num == 10) {
                setIt.remove(); // 값이 10인 원소 삭제
            }
        } // numSet = {30}

        // ■■■■ int[] -> Set<Integer> 변환
        int[] numbers = {1, 2, 2, 3, 4, 4, 5};
        Set<Integer> numberSet = new HashSet<>();
        // 또는 Set<Integer> numberSet = new HashSet<>(Arrays.stream(numbers).boxed().toList());
        for (int n : numbers) {
            numberSet.add(n); // 중복 제거되어 저장
        } // numberSet = {1, 2, 3, 4, 5}

        // ■■■■ List -> Set 변환
        List<String> fruitLi = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "kiwi"));
        Set<String> fruitSet = new HashSet<>(fruitLi);        // {"apple", "banana", "kiwi"}
        
        // ■■■■ Set -> List 변환
        List<String> fruitList = new ArrayList<>(fruitSet);

    }
}