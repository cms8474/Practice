/**
 *
 * 날짜 2025 1023
 * 이름 최민수
 * 내용 5장 다트 함수
 *
 */

void hello(){
  print('hello dart!');
}

int add(int a, int b){
  return a + b;
}
//익명함수
var greet = (String name){
  return "Greeting ${name}!";
};
//람다함수
int plus(int a, int b) => a+b;
int minus(a, b) => a-b;
//고차함수
int calc(int x, int y, int Function(int, int) operation){
  return operation(x, y);
}

Function createHello(String name){
  return () => "Hello, ${name}";
}
// 이름이 있는 매개변수 함수
void person1({String hello = 'hello', String? name}){
  print('person1 $hello, $name');
}
void person2(String name, {String? hello}){
  print('person2 $hello, $name');
}
void person3(String name, {String? hello, required int age}){
  print('person3 $hello, $name, $age');
}
// 선택적 위치 매개변수 함수
void user1(String name, [int age=0]){
  print('user1 $name, $age');
}
void user2(String name, [int age=0, String? address]){
  print('user2 $name, $age, $address');
}
void user3(String name, [int age=0, String address = 'Unknown', String? job]){
  print('user3 $name, $age, $address, $job');
}

void main(){


  // 기본 함수
  hello();


  // 매개변수와 반환값이 있는 함수
  int result1 = add(1, 2);
  int result2 = add(2, 3);
  print('result1 : ${result1}');
  print('result2 : ${result2}');


  // 익명 함수
  print(greet('김유신'));
  print(greet('김춘추'));


  // 화살표 함수(람다식)
  int rs1 = plus(2, 3);
  int rs2 = minus(2, 3);

  print('rs1 : $rs1 & rs2 : $rs2');


  // 고차 함수(함수를 매개변수로 전달하거나 받는 함수)
  int result = calc(10, 5, minus);
  print('result : $result');

  var hello1 = createHello('홍길동');
  print(hello1());


  // 이름이 있는 매개변수(Named Parameter, {중괄호} 매개변수)
  person1();
  person1(name: 'hgd'); // 변수 명을 알려줘야 함.
  person2('hgd');
  person2('kcc', hello: 'hi');
  person3('jbg', age:21, hello: "hii");



  // 선택적 위치 매개변수(Optional Positional Parameter, {대괄호} 매개변수)
  user1('kys');
  user1('kcc', 21);
  user2('jbg');
  user2('jbg', 23);
  user2('jbg', 23, 'seoul');
  user3('jyy');
  user3('jyy', 44, 'busan', 'engineer');

















}














