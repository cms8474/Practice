import java.util.*;

public class MapSetPrac {
    static public void main(String[] args) {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ ■ Map(카운팅)과 Set(중복제거) ■ ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        String[] foods = {"chicken", "pizza", "chicken", "burger"};

        // ■■■■ HashMap: 개수 세기 (빈도수) -> {chicken=2, pizza=1, burger=1}
        Map<String, Integer> map = new HashMap<>();
        for (String f : foods) {
            // ★ getOrDefault: 키가 있으면 값 반환, 없으면 0 반환 (매우 중요)
            map.put(f, map.getOrDefault(f, 0) + 1);
        }

        // ■■■■ Map 순회 (Key와 Value 꺼내기)
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        
        // ■■■■ 특정 키 포함 여부
        boolean hasPizza = map.containsKey("pizza"); // true

        // ■■■■ HashSet: 중복 제거 -> [chicken, pizza, burger] (순서 보장 X)
        Set<String> set = new HashSet<>(Arrays.asList(foods)); 
        System.out.println(set.size()); // 3 (중복인 chicken 하나 사라짐)
    }
}