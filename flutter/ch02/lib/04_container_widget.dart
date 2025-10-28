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
      home: const MyHomePage(title: '03.Container Widget 실습'),
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
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            width: 100,
            height: 100,
            color: Colors.red,
          ),
          Container(
            width: 100,
            height: 100,
            color: Colors.blue,
            margin: EdgeInsets.only(left: 10, top: 10), // 간격주기
            child: Text('Blue'),
          ),
          Container(
            width: 100,
            height: 100,
            //color: Colors.green, // decoration 속성과 중복사용불가
            padding: EdgeInsets.all(10),
            child: Text('Green'),
            decoration: BoxDecoration(
              color: Colors.green,
              border: Border.all(width: 5, color: Colors.black)
            ),
          ),
          Container(
            width: 100,
            height: 100,
            decoration: BoxDecoration(
              border: Border.all(width: 1, color: Colors.orange),
              shape: BoxShape.circle,
              image: DecorationImage(
                  image: AssetImage('images/flower1.jpg'),
                  fit: BoxFit.cover
              )
            ),
          )
          
        ],
      )
      
    );
  }
}
