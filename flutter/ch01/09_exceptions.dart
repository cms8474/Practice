/*
  날짜 : 2025 1023
  이름 : 최민수
  내용 : Dart 예외처리
*/





void main(){



  // 예외처리 기본
  try{
    int result = 10 ~/ 0;
    print(result);

  }catch(e){
    print('예외발생 : $e');
  }

  // 특정 예외처리
  try{
    String input ='abc';
    int number = int.parse(input);
    print('number : $number');

  }on FormatException {
    print('형식 예외 발생');
  }catch(e){
    print('예외" : $e');
  }

  // finally
  try{
    String input ='abc';
    int number = int.parse(input);
    print('number : $number');
  }catch(e){
    print('예외" : $e');
  }finally{
    print('작업완료...');
  }

  // 사용자 정의 예외
  //checkAge(-10);
  //checkAge(9);
  checkAge(21);


} // main end

class MyException implements Exception{
  final String message;
  MyException(this.message);
  
  @override
  String toString(){
    return 'MyException : $message';
  }
}

void checkAge(int age){
  if(age < 0){
    throw MyException('나이는 음수x');
  } else if(age <10){
    throw MyException('10살 이하 금지');

  }
}