/*
  날짜 : 2025 1023
  이름 : 최민수
  내용 : Dart 추상클래스와 인터페이스
*/

abstract class Animal {

  String name;

  Animal(this.name);

  // 추상 메서드
  void speak();

  void hello(){
    print('hello $name');
  }

}

class Dog extends Animal{
  String bread;

  Dog(String name, this.bread) : super(name);

  @override
  void speak() {
    print('$name($bread) 멍멍!');
  }
}

// 인터페이스. Dart에서는 모든 클래스가 암묵적으로
   // interface, implement로 구현
abstract class Vehicle {
  void start();
  void stop();

}

class Car implements Vehicle{

  String _brand;
  Car(this._brand);

  @override
  void start() {
    print('$_brand 출발...');
  }

  @override
  void stop(){
    print('$_brand 정지...');

  }
}

// 믹스인(Mixin)
mixin Swimmable{
  void swim(){
    print('수영중...');
  }
}

mixin Flyable{
  void fly(){
    print('비행중...');
  }
}

mixin Walkable{
  void walk(){
    print('걷는중...');
  }
}

class Duck extends Animal with Swimmable, Flyable, Walkable{
  Duck(String name) : super(name);

  @override
  void speak(){
    print('오리가 꽤꽥');
  }
}



void main(){

  // 추상클래스
  Animal animal = Dog('강하지', '푸들');
  animal.speak();

  // 인터페이스
  Vehicle car = Car('현대차');
  car.start();
  car.stop();

  //믹스인





















}








