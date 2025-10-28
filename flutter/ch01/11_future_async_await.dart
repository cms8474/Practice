/*
  날짜 : 2025 1024
  이름 : 최민수
  내용 : Dart 비동기처리
*/
import 'dart:async';

// Future 객체(promise)는 미래에 가져오는 값을 의미하는 객체
Future<String> fetchData(){
  return Future.delayed(Duration(seconds: 3), (){
    return 'fetchData!';
  });
}

// Stream을 반환하는 함수
Stream<int> countStream() async* {

  for(int i=1 ; i<=5 ; i++){
    await Future.delayed(Duration(seconds: 1));
    yield i; // 스트림으로 데이터 내보내기(emit)
}

}


void main() async {

  // 비동기 작업 수행 1 5 2 fetchData! 4
  print('here...1');

  fetchData()
        .then((data){
          // 비동기 함수 결과값
          print('here...2: $data');
        })
        .catchError((err){
          // 에러 발생시
          print('here...3: $err');
        })
        .whenComplete((){
          // 작업 종료시
          print('here...4 비동기 작업 완료');
        });
  print('here...5');

  // async/await 실행 // 1 2(fatchData!) 4 5
  // 1 5 일 2(fD!) 4 이(fD!) 사 오
  // await는 앞 작업이 끝난 후 실행
  print('async_await...일');


  try {
    String data = await fetchData();
    print('async_await...이 : $data');
  }catch(e) {
    print('async_await...삼 : $e');
  }finally{
    print('async_await...사 비동기 작업 완료');
  }
  print('async_await...오');




  /*/////////////////////////////////////////////////////////////////
  * Future vs Stream
  *   - Future는 한 번만 비동기 값을 반환하는 비동기 처리
  *   - Stream은 시간이 지남에 따라 데이터를 순차적으로 전달하는 비동기 처리
  *//////////////////////////////////////////////////////////////////

  // Stream 작업
  final controller = StreamController<String>(); // String은 스트림으로 보내는 dataType

  // Stream 리스너 등록
  controller.stream
      .listen((data){
        print('stream...1 : $data');
      })
      .onError((err){
        print('stream error');
      });

  // 스트림 데이터 전송
  controller.sink.add('hello');
  controller.sink.add('welcome');
  controller.sink.add('greeting');

  // Stream 함수 호출
  Stream<int> stream = countStream();

  await for(int number in stream){
    print('스트림 데이터 수신 : $number');

  }


}
