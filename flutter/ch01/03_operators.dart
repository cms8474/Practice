/**
 *
 * 날짜 2025 1023
 * 이름 최민수
 * 내용 3장 다트 연산자
 *
 */

void main(){

  //////////////////////////////////////
  // 기본 연산자
  //////////////////////////////////////
  int a = 10;
  int b = 3;

  //산술
  print(a + b); // 13
  print(a - b); // 7
  print(a * b); // 30
  print(a / b); // 3.3333333333333335 (double)
  print(a ~/ b); // 3 (정수 나눗셈)
  print(a % b); // 1 (나머지)


  // 대입 연산자
  int x = 5;

  x += 3; // x = x + 3
  print(x); // 8

  x *= 2; // x = x * 2
  print(x); // 16


  // 증감 연산자
  x++;
  print(x); // 17

  --x;
  print(x); // 16

  // 비교 연산자
  print(a == b);  // false
  print(a != b);  // true
  print(a > b);   // true
  print(a < b);   // false
  print(a >= 10); // true (a는 10이므로)


  // 논리 연산자
  print(a > 1 && b > 1); // true (10 > 1 && 3 > 1)
  print(a < 10 || b < 11); // true (10 < 10(false) || 3 < 11(true))
  print(!(a > b)); // false (!(10 > 3))


  // 삼항 연산자
  String result = a > b ? 'a가 크다' : 'b가 크다';
  print(result); // a가 크다 (10 > 3 이므로)

  // 타입 검사 연산자
  dynamic value = 'hello';
  print('value is int : ${value is int}');
  print('value is String : ${value is String}');
  print('value is! String : ${value is! String}');

  //////////////////////////////////////
  // Null 관련 연산자
  //////////////////////////////////////

  // Null 병합
  int? value1;
  int result1 = value1 ?? 100; // value1이 null이면 100 대입
  print(result1); //100
  print(value1);  //null

  value1 = 50;
  int result2 = value1 ?? 200;
  print(result2); //50

  int? num1;
  int? num2;
  int? num3;

  int result3 = num1 ?? num2 ?? num3 ?? 1000;
  print(result3); //1000

  num2 = 2;
  int result4 = num1 ?? num2 ?? num3 ?? 1000;
  print(result4); // 2 (num2)


  // Null 대입
  num3 ??= 3; //num3 가 null이면 3으로 초기화
  print(num3); //3


  // Null 접근
String? nullableString;
print(nullableString?.toUpperCase()); // 접근연산자 . 앞에 ?를 붙이면 null이 아닐 경우 진행

nullableString = 'hello dart';
print(nullableString?.toUpperCase()); // 접근연산자 . 앞에 ?를 붙이면 null이 아닐 경우 진행

  // Null 강제
  int? maybeNumber = 3;
  int mustNotNullNumber = maybeNumber!;//Nullable 변수를 Not-Nullable변수에 대입 불가
                                        //그래서 null이 아님을 보장하기 위해 ! 사용
  print(mustNotNullNumber);




















}