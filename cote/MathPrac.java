public class MathPrac {
    static public void main(String[] args) {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                           "■ ■ ■ ■ ■ ■ 수학(최대/최소)과 진법 변환 ■ ■ ■ ■ ■ ■\r\n" +
                           "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        // ■■■■ 10진수(10) -> 2진수(String "1010")
        String binary = Integer.toBinaryString(10);
        // ■■■■ 10진수(10) -> 3진수(String "101")
        String base3 = Integer.toString(10, 3);

        // ■■■■ 2진수("1010") -> 10진수(int 10)
        int decimal = Integer.parseInt("1010", 2);
        // ■■■■ 3진수("101") -> 10진수(int 10)
        int decimal2 = Integer.parseInt("101", 3);

        // ■■■■ 최대/최소/절댓값/제곱근
        int max = Math.max(10, 20); // 20
        int min = Math.min(10, 20); // 10
        int abs = Math.abs(-50);    // 50
        double sqrt = Math.sqrt(16); // 4.0 (반환형 double 주의)
        double pow = Math.pow(2, 3); // 2의 3승 = 8.0 (반환형 double 주의)
    }
}