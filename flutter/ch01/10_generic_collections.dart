/*
  날짜 : 2025 1024
  이름 : 최민수
  내용 : Dart 제네릭
*/

class Box<T> {

  T item;

  Box(this.item);

  T getItem(){
    return item;
  }

}


void main(){

  //제네릭 객체 생성
  Box stringBox = Box<String>('hello');
  String text = stringBox.getItem();
  print('text : $text');

  Box intBox = Box<int>(100);
  int num = intBox.getItem();
  print('num : $num');


  ///////////////////////////////////
  // 컬렉션(List, Set, Map)
  ///////////////////////////////////
  // List
  ///////////////////////////////////
  List<String> fruits = ['apple', 'banana', 'orange'];
  print('fruits : $fruits');

    // 요소 추가
  fruits.add('grape');
  print('fruits : $fruits');

    // 요소 참조
  print('첫 번째 과일 : ${fruits[0]}');
  print('첫 번째 과일 : ${fruits.first}');
  print('마지막 과일 : ${fruits.last}');

    // 원소 수정
  fruits[1] = 'kiwi';
  print('fruits : $fruits');

    // 원소 제거
  String removedFruit = fruits.removeAt(0);
  print('제거된 과일 : $removedFruit');
  print('fruits : $fruits');

    // 리스트 크기
  print('리스트 크기 : ${fruits.length}');

    // 리스트 반복문
  for (var fruit in fruits) {
    print('과일 : $fruit');
  }

    // 리스트 필터링
  List<int> numbers = [1, 2, 3, 4, 5];
  var evenNumbers = numbers.where((n) => n % 2 == 0);
  print('짝수 숫자 : $evenNumbers');

    // 변환
  var doubledList = numbers.map((n) => n * 2).toList();
  print('더블 리스트 : $doubledList');

    // 정렬
  numbers.sort();
  print('오름차순 정렬된 리스트 : $numbers');

  numbers.sort((a, b) => b.compareTo(a));
  print('내림차순 정렬된 리스트 : $numbers');

    // 반복처리
  numbers.forEach((n) => print('n값 : $n'));

    // 리스트 비우기
  fruits.clear();

  ///////////////////////////////////
  // Set, 중복 제거 자료구조
  ///////////////////////////////////

  Set<String> colors = {'red', 'green', 'blue'};
  print('colors : $colors');

    // 원소추가
  colors.add('orange');
  colors.add('red'); // 중복이라 처리 x
  print('colors : $colors');

    // 집합 연산
  var set1 = {1,2,3,4};
  var set2 = {3,4,5,6};

  Set<int> unionSet = set1.union(set2);
  print('합집합 : $unionSet'); // 1 2 3 4 5 6

  Set<int> intersectSet =   set1.intersection(set2);
  print('교집합 : $intersectSet'); // 3 4

  Set<int> differenceSet = set1.difference(set2);
  print('차집합 : $differenceSet'); //1 2


  ///////////////////////////////////
  // Map
  ///////////////////////////////////

    // 생성
  Map<String, String> user = {
    'id'       : 'a101',
    'name'     : 'hgd',
    'address'  : 'busan'
  };

  print('user : $user');

    // 키 참조
  print('id       : ${user['id']}');
  print('name     : ${user['name']}');
  print('address  : ${user['address']}');

    // 키 존재 여부
  print('age 키 존재 여부? : ${user.containsKey('age')}');

    // 키 목록
  print('키 목록 : ${user.keys.toList()}');

    // 값 목록
  print('값 목록 : ${user.values}');







}










