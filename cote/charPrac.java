public class charPrac {
    public static void main(String[] args) {

        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" + //
                           "■ ■ ■ ■ ■ ■ 문자를 다음과 같이 바꿔라  ■ ■ ■ ■ ■ ■\r\n" + //
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        char[] chArr = new char[12];
        char cha = 'a', chZ = 'Z';
        char ch0 = '0', ch9 = '9';

        
        // ■■■■ 소문자 -> 대문자, 대문자 -> 소문자
        // { 'a'->'A', 'Z'->'z', 'b'->'B', 'Y'->'y' }
        chArr[0] = (char)(cha - ('a' - 'A')); // 97 - (97 - 65) = 65 -> 'A'
        chArr[1] = (char)(chZ + ('a' - 'A')); // 90 + (97 - 65) = 122 -> 'z'
        chArr[2] = Character.toUpperCase('b'); // 'b' -> 'B'
        chArr[3] = Character.toLowerCase('Y'); // 'Y' -> 'y'

        // ■■■■ 문자 -> 아스키 코드 값, 아스키 코드 값 -> 문자 
        // { '0'->'3', '9'->'7', 'a'->'b', 'Z'->'Y' }
        chArr[4] = (char)(ch0 + 3);   // '0'(48) + 3 = '3'(51)
        chArr[5] = (char)(ch9 - 2);   // '9'(57) - 2 = '7'(55)
        chArr[6] = (char)(cha + 1);   // 'a' -> 97 + 1 = 98 -> 'b'
        chArr[7] = (char)(chZ - 1);   // 'Z' -> 90 - 1 = 89 -> 'Y'

        // ■■■■ 숫자 or 문자 출력
        // {'1', a}
        chArr[8] = 1 + '0';   // (int)'1' = 1 -> '1'
        chArr[9] = "a".charAt(0);     // "a" -> 'a'

        // ■■■■ 숫자인가? 문자인가?
        // {'7'->true, 'G'->false}
        chArr[10] = Character.isDigit('7') ? 'T' : 'F'; // '7'은 숫자 -> T
        chArr[11] = Character.isDigit('@') ? 'T' : 'F'; // [0-9]외에는 모두 -> F

        for(char ch : chArr) System.out.println(ch);

        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" + //
                           "■ ■ ■ ■ ■ ■ ■ ■ ■ ■ 문자 -> 형변환 ■ ■ ■ ■ ■ ■ ■ ■ ■ \r\n" + //
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
    
        // String <-> char[], String <-> char
        String str = "Hello";
        char[] charArr = str.toCharArray(); // String -> char[]
        String str2 = String.valueOf(charArr); // char[] -> String
        char ch1 = str.charAt(0); // String -> char
        String str3 = String.valueOf(ch1); // char -> String
        System.out.println(charArr); // Hello
        System.out.println(str2);    // Hello
        System.out.println(ch1);     // H
        System.out.println(str3);    // H

        

    } // main
}
