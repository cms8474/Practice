import java.util.*;

public class StringPrac {
    static public void main(String[] args) {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" + //
                        "■ ■ ■ ■ ■ ■ 문자열을 다음과 같이 바꿔라  ■ ■ ■ ■ ■ ■\r\n" + //
                        "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        String S1 = "aaa3bb2c1";
        String[] S1ans = new String[18];
        // ■■■■ aaabbc(숫자 제거), 321(숫자 추출), aaa(길이 3)
        S1ans[0] = S1.replaceAll("[0-9]", "");     // 모든 숫자 제거
        S1ans[1] = S1.replaceAll("[a-zA-Z]", "");  // 모든 알파벳 제거
        S1ans[2] = S1.substring(0,3);            // 0~2번째 인덱스 추출 -> aaa

        // ■■■■ 0번째 글자 삭제, bb2c1(0~3 삭제)
        S1ans[3] = S1.substring(1); // S1의 1번째 인덱스부터 끝까지 -> aa3bb2c1
        S1ans[4] = S1.substring(3); // S1의 3번째 인덱스부터 끝까지 -> bb2c1

        // ■■■■ aaa -> 1aa, 111
        S1ans[5] = S1ans[2].replaceFirst("a", "1"); // 첫 a만 1로 변경 -> 1aa
        S1ans[6] = S1ans[2].replaceAll("a", "1");   // 모든 a를 1로 변경 -> 111

        // ■■■■ 숫자 기준으로 자르기 {aaa, bb, c}
        String[] splits = S1.split("[0-9]");      // 숫자 기준으로 자르기
        S1ans[7] = String.join(", ", splits); // 배열을 ", "로 합치기

        // ■■■■ 좌측/우측 정렬 "aaa  ", "  aaa"
        S1ans[8] = "aaa" + " ".repeat(5 - "aaa".length()); // aaa + " "추가(5-aaa길이)
        S1ans[9] = " ".repeat(5 - "aaa".length()) + "aaa"; // " "추가(5-aaa길이) + aaa

        // ■■■■ a의 첫 인덱스, 마지막 인덱스, 포함여부
        S1ans[10] = String.valueOf(S1.indexOf("a"));     // 첫 a의 인덱스
        S1ans[11] = String.valueOf(S1.lastIndexOf("a")); // 마지막 a의 인덱스
        S1ans[12] = String.valueOf(S1.contains("a"));      // a의 포함여부

        // ■■■■ matches: 숫자만 있는지, 알파벳이 있는지
        S1ans[13] = String.valueOf(S1.matches("[0-9]+"));       // 숫자만 있는지(+: 숫자 최소 1개 이상)
        S1ans[14] = String.valueOf(S1.matches(".*[a-zA-Z].*")); // 알파벳이 있는지(.: 아무 문자 하나, *: 0개 이상)

        // ■■■■ 대문자 변환
        S1ans[15] = S1.toUpperCase(); // 소문자: toLowerCase()

        // ■■■■ "06.23"을 06, 23으로 분리
        String date = "06.23";
        S1ans[16] = date.split("\\.")[0]; // 06 (split의 구분자가 .인 경우 \\.로 표기)
        S1ans[17] = date.split("\\.")[1]; // 23

        for (String ans : S1ans) System.out.println(ans);


        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ ■ 문자열을 다른 형태로 바꿔라  ■ ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        
        String S2 = "hello";

        // ■■■■ hello -> 104 101 108 108 111 (아스키 코드 값으로 변환)
        int[] S2ans1 = new int[S2.length()];
        for(int i=0 ; i<S2.length() ; i++) {
            S2ans1[i] = (int) S2.charAt(i);
        } // char를 int로 변환 = 아스키 코드 값


        // ■■■■ String -> char[] {h, e, l, l, o}
        char[] charArray = S2.toCharArray(); // String을 char[]로 변환

        // ■■■■ char[]{h, e, l, l, o} -> String "hello"
        String hello = String.valueOf(charArray); 
        hello = new String(charArray);

        // ■■■■ String -> List<Character> {h, e, l, l, o}
        List<Character> charList = new ArrayList<>();
        for(char c : S2.toCharArray()) {
            charList.add(c);
        }

        // ■■■■ 12321 -> 12321 (문자열을 숫자로 변환)
        S2 = "12321";
        int S2ans2 = Integer.parseInt(S2); // 문자열을 숫자로 변환 = 12321
        S2ans2 = Integer.valueOf(S2); // 문자열을 숫자로 변환 = 12321
        S2ans2 = (Integer)12321;          // 자동 형변환(오토박싱)

        

    }
}
