public class StringBuilderPrac {
    public static void main(String[] args) {
        
        // ■■■■ StringBuilder <-> String
        StringBuilder sb = new StringBuilder("hello");
        String sbStr = sb.toString(); // StringBuilder -> String "hello"
        sb = new StringBuilder(sbStr); // String -> StringBuilder

        // ■■■■ StringBuilder <-> String[]
        String[] strArr = {"hello", "world"};
        StringBuilder sb2 = new StringBuilder();
        for(String str : strArr) { // sb2: "helloworld"
            sb2.append(str);
        }

        // ■■■■ StringBuilder 기본 메서드
        sb2.insert(5, " ");    // 5번째 인덱스에 " " 삽입 -> "hello world"
        sb2.delete(5, 6);      // 5~5번째 인덱스 삭제 -> "helloworld"
        sb2.replace(5, 10, " Java"); // 5~9번째 인덱스를 " Java"로 변경 -> "hello Java"
        int length = sb2.length();    // 길이 반환 -> 10
        sb2.reverse();                // 뒤집기 "avaJ olleh"
        
    }
}
