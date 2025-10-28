import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: const MyHomePage(title: '06.position_widget'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Column(
        children: [

          //Align : 특정 위치에 배치하기
          Container(
            width: double.infinity, // 가로 100%
            height: 200,
            decoration: BoxDecoration(
              border: Border.all(width: 3)
            ),

            child: Align(
              alignment: Alignment.center, // 정렬 설정
              child: Container(
                width: 100,
                height: 100,
                color: Colors.blue,
              ),
            ),
          ),

          // FractionalOffset
          Container(
            width: double.infinity, // 가로 100%
            height: 200,
            decoration: BoxDecoration(
                border: Border.all(width: 3)
            ),

            child: Align(
              alignment: FractionalOffset(0.5, 0.2), // 특정 좌표로 배치하기 0~1 (x, y)
              child: Container(
                width: 100,
                height: 100,
                color: Colors.blue,
              ),
            ),
          ),

          // Stack : 위젯 겹쳐서 배치
          Stack(
            children: [
              Container(
                width: 150,
                height: 150,
                color: Colors.red,
              ),
              Container(
                width: 100,
                height: 100,
                color: Colors.blue,
              ),
              Container(
                width: 50,
                height: 50,
                color: Colors.green,
              )
            ],
          ),

          // IndexedStack
          IndexedStack(
            index: 2, // 배열 인텍스처럼 사용
            children: [
              Text('idx 0', style: TextStyle(fontSize: 12),),
              Text('idx 1', style: TextStyle(fontSize: 20),),
              Text('idx 2', style: TextStyle(fontSize: 28),)
            ]
          ),

          // Positioned
          Container(
            width: double.infinity, // 가로 100%
            height: 200,
            decoration: BoxDecoration(
              border: Border.all(width: 3)
            ),
            child: Stack(
              children: [
                Positioned( // 반드시 Stack의 자식으로 사용
                  top: 10,
                  left: 10,
                  child: Container(
                    width: 100,
                    height: 100,
                    color: Colors.red,
                    )
                ),
                Positioned( // 반드시 Stack의 자식으로 사용
                    right: 10,
                    top: 10,
                    child: Container(
                      width: 100,
                      height: 100,
                      color: Colors.blue,
                    )
                )
              ]
            )
          )



        ], // children ed
      )
      
    );
  }
}
