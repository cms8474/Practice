/*
  날짜 : 2025/10/27
  이름 : 최민수
  내용 : Widget Form 실습
*/
import 'package:flutter/material.dart'; // 플러터의 머티리얼 디자인 위젯을 사용하기 위해 임포트합니다.

void main(){ // 앱의 시작점인 main 함수입니다.
  runApp(const MyApp()); // MyApp 위젯을 실행하여 앱을 시작합니다.
}

class MyApp extends StatelessWidget { // 앱의 루트(최상위) 위젯입니다.
  const MyApp({super.key}); // 위젯을 식별하기 위한 key를 전달받는 생성자입니다.

  @override // 부모 클래스의 메서드를 재정의합니다.
  Widget build(BuildContext context) { // 위젯의 UI를 구성하는 메서드입니다.
    return MaterialApp( // 머티리얼 디자인 앱을 생성하는 위젯입니다.
      home: Scaffold( // 앱의 기본 레이아웃(상단바, 본문 등)을 구성하는 위젯입니다.
        appBar: AppBar(title: const Text('05.폼 위젯 실습'),), // 앱의 상단에 표시될 AppBar 위젯입니다.
        body: const FormPage(), // 화면의 본문에 표시될 내용으로 FormPage 위젯을 지정합니다.
      ),
    );
  }
}

class FormPage extends StatefulWidget { // 사용자의 입력에 따라 상태가 변하는 위젯입니다.
  const FormPage({super.key}); // 위젯을 식별하기 위한 key를 전달받는 생성자입니다.

  @override // 부모 클래스의 메서드를 재정의합니다.
  State<StatefulWidget> createState() => _FormPageState(); // 위젯의 상태를 관리할 State 객체를 생성합니다.
}

class _FormPageState extends State<FormPage> { // FormPage의 실제 상태를 관리하고 UI를 구성하는 클래스입니다.

  // 폼을 식별하고 상태를 관리하는 전역키 생성
  final _formKey = GlobalKey<FormState>(); // Form 위젯을 제어하기 위한 고유한 키(Key)를 생성합니다.
  
  // 컨트롤러 생성
  final TextEditingController _idController = TextEditingController(); // 아이디 입력 필드를 제어할 컨트롤러를 생성합니다.
  final TextEditingController _pwController = TextEditingController(); // 비밀번호 입력 필드를 제어할 컨트롤러를 생성합니다.
  final TextEditingController _nameController = TextEditingController(); // 이름 입력 필드를 제어할 컨트롤러를 생성합니다.

  // 상태 변수
  String _email = ''; // 이메일 입력 값을 저장할 변수입니다.
  bool _isCheck = false; // 가입 동의 체크박스의 선택 여부를 저장할 변수입니다.
  String _gender = 'M'; // 성별 라디오 버튼의 선택 값을 저장할 변수입니다. (기본값 'M')
  bool _isSwitched = false; // 푸시 알림 스위치의 ON/OFF 상태를 저장할 변수입니다.
  String _submitResult = ''; // 폼 제출 결과를 화면에 표시하기 위한 문자열 변수입니다.

  @override // 부모 클래스의 메서드를 재정의합니다.
  void dispose() { // 위젯이 화면에서 사라질 때 호출되는 메서드입니다.
    // 컨트롤러 리소스 해제
    _idController.dispose(); // 아이디 컨트롤러가 사용하던 메모리를 해제합니다.
    _pwController.dispose(); // 비밀번호 컨트롤러가 사용하던 메모리를 해제합니다.
    _nameController.dispose(); // 이름 컨트롤러가 사용하던 메모리를 해제합니다.
    super.dispose(); // 부모 클래스의 dispose 메서드를 호출합니다.
  }

  // 폼 취소 함수
  void _cancelForm(){ // '취소' 버튼을 눌렀을 때 호출될 함수입니다.
    // currentState가 null일 수 있으므로 null 체크 추가
    final form = _formKey.currentState; // _formKey를 이용해 현재 Form의 상태를 가져옵니다.
    if (form != null) { // Form 상태가 null이 아닐 경우에만 실행합니다.
      form.reset(); // Form에 포함된 모든 필드의 값을 초기화합니다.
    }

    _idController.clear(); // 아이디 입력 필드의 텍스트를 지웁니다.
    _pwController.clear(); // 비밀번호 입력 필드의 텍스트를 지웁니다.
    _nameController.clear(); // 이름 입력 필드의 텍스트를 지웁니다.

    setState(() { // 화면을 갱신하기 위해 setState를 호출합니다.
      _isCheck = false; // 체크박스 상태를 초기화합니다.
      _isSwitched = false; // 스위치 상태를 초기화합니다.
      _submitResult = ''; // 제출 결과 텍스트를 비웁니다.
    });
  }

  // 폼 제출 함수
  void _submitForm(){ // '제출' 버튼을 눌렀을 때 호출될 함수입니다.
    // currentState가 null일 수 있으므로 null 체크 추가
    final form = _formKey.currentState; // _formKey를 이용해 현재 Form의 상태를 가져옵니다.

    // 폼 유효성 검사
    if(form != null && form.validate()){ // Form 상태가 null이 아니고, 모든 필드의 유효성 검사를 통과했을 때
      form.save(); // 모든 필드의 onSaved 콜백 함수를 실행하여 입력 값을 저장합니다.

      String idValue = _idController.text; // 아이디 컨트롤러에서 입력 값을 가져옵니다.
      String pwValue = _pwController.text; // 비밀번호 컨트롤러에서 입력 값을 가져옵니다.
      String nameValue = _nameController.text; // 이름 컨트롤러에서 입력 값을 가져옵니다.

      setState(() { // 화면을 갱신하기 위해 setState를 호출합니다.
        _submitResult = '입력 성공!\n' // 제출 결과 문자열을 설정합니다.
            '아이디 : $idValue\n' // 입력받은 아이디를 결과 문자열에 추가합니다.
            '비밀번호 : $pwValue\n' // 입력받은 비밀번호를 결과 문자열에 추가합니다.
            '이름 : $nameValue\n' // 입력받은 이름을 결과 문자열에 추가합니다.
            '이메일 : $_email\n' // 저장된 이메일을 결과 문자열에 추가합니다.
            '가입동의 : $_isCheck\n' // 저장된 가입동의 여부를 결과 문자열에 추가합니다.
            '성별 : $_gender\n' // 저장된 성별을 결과 문자열에 추가합니다.
            '푸시 알림 허용 : $_isSwitched'; // 저장된 푸시 알림 허용 여부를 결과 문자열에 추가합니다.
      });
    }else { // 유효성 검사를 통과하지 못했을 때
      setState(() { // 화면을 갱신하기 위해 setState를 호출합니다.
        _submitResult = '입력 실패! 입력 항목을 확인하세요.'; // 실패 메시지를 설정합니다.
      });
    }
  }

  @override // 부모 클래스의 메서드를 재정의합니다.
  Widget build(BuildContext context) { // 화면 UI를 구성하는 메서드입니다.
    return SingleChildScrollView( // 화면 내용이 길어질 경우 스크롤이 가능하도록 하는 위젯입니다.
      padding: const EdgeInsets.all(10), // 위젯의 모든 바깥쪽에 10의 여백을 줍니다.
      child: Form( // 폼 관련 위젯들을 그룹화하는 컨테이너 위젯입니다.
        key: _formKey, // 위에서 생성한 _formKey를 이 Form 위젯에 연결합니다.
        child: Column( // 자식 위젯들을 세로로 배치하는 위젯입니다.
          crossAxisAlignment: CrossAxisAlignment.start, // 자식 위젯들을 왼쪽 정렬합니다.
          children: [ // Column 위젯이 가질 자식 위젯들의 목록입니다.
            TextFormField( // 텍스트를 입력받는 폼 필드 위젯입니다.
              controller: _idController, // 아이디 컨트롤러를 연결하여 입력 값을 제어합니다.
              decoration: const InputDecoration( // 입력 필드를 꾸미는 속성입니다.
                labelText: '아이디', // 입력 필드 위에 표시될 라벨 텍스트입니다.
                border: OutlineInputBorder() // 입력 필드에 외곽선을 추가합니다.
              ),
              validator: (value){ // 입력 값의 유효성을 검사하는 함수입니다.
                if (value == null || value.isEmpty) { // 값이 비어있는지 확인합니다.
                  return '아이디를 입력하세요.'; // 비어있으면 에러 메시지를 반환합니다.
                }
                if (value.length < 4) { // 값의 길이가 4 미만인지 확인합니다.
                  return '아이디는 4자 이상이어야 합니다.'; // 4자 미만이면 에러 메시지를 반환합니다.
                }
                return null; // 유효성 검사를 통과하면 null을 반환합니다.
              },
            ),

            const SizedBox(height: 10,), // 위젯 사이에 10만큼의 세로 간격을 줍니다.
            TextFormField( // 비밀번호를 입력받는 폼 필드 위젯입니다.
              controller: _pwController, // 비밀번호 컨트롤러를 연결합니다.
              obscureText: true, // 입력 텍스트를 가려줍니다. (예: ●●●●)
              decoration: const InputDecoration( // 입력 필드를 꾸미는 속성입니다.
                  labelText: '비밀번호', // 라벨 텍스트를 '비밀번호'로 설정합니다.
                  border: OutlineInputBorder() // 외곽선을 추가합니다.
              ),
              validator: (value){ // 유효성 검사 함수입니다.
                if (value == null || value.isEmpty) { // 값이 비어있는지 확인합니다.
                  return '비밀번호를 입력하세요.'; // 비어있으면 에러 메시지를 반환합니다.
                }
                if (value.length < 6) { // 값의 길이가 6 미만인지 확인합니다.
                  return '비밀번호는 6자 이상이어야 합니다.'; // 6자 미만이면 에러 메시지를 반환합니다.
                }
                return null; // 유효성 검사를 통과하면 null을 반환합니다.
              },
            ),

            const SizedBox(height: 10,), // 10만큼의 세로 간격을 줍니다.
            TextFormField( // 이름을 입력받는 폼 필드 위젯입니다.
              controller: _nameController, // 이름 컨트롤러를 연결합니다.
              decoration: const InputDecoration( // 입력 필드를 꾸미는 속성입니다.
                  labelText: '이름', // 라벨 텍스트를 '이름'으로 설정합니다.
                  border: OutlineInputBorder() // 외곽선을 추가합니다.
              ),
              validator: (value){ // 유효성 검사 함수입니다.
                if (value == null || value.isEmpty) { // 값이 비어있는지 확인합니다.
                  return '이름을 입력하세요.'; // 비어있으면 에러 메시지를 반환합니다.
                }
                return null; // 유효성 검사를 통과하면 null을 반환합니다.
              },
            ),

            const SizedBox(height: 10,), // 10만큼의 세로 간격을 줍니다.
            TextFormField( // 이메일을 입력받는 폼 필드 위젯입니다.
              decoration: const InputDecoration( // 입력 필드를 꾸미는 속성입니다.
                  labelText: '이메일', // 라벨 텍스트를 '이메일'로 설정합니다.
                  border: OutlineInputBorder() // 외곽선을 추가합니다.
              ),
              keyboardType: TextInputType.emailAddress, // 이메일 입력에 최적화된 키보드를 보여줍니다.
              validator: (value){ // 유효성 검사 함수입니다.
                if (value == null || value.isEmpty) { // 값이 비어있는지 확인합니다.
                  return '이메일을 입력하세요.'; // 비어있으면 에러 메시지를 반환합니다.
                }
                if (!value.contains('@')) { // '@' 문자를 포함하는지 확인합니다.
                  return '유효한 이메일이 아닙니다.'; // 포함하지 않으면 에러 메시지를 반환합니다.
                }
                return null; // 유효성 검사를 통과하면 null을 반환합니다.
              },
              onSaved: (value){ // 폼의 save()가 호출될 때 실행될 함수입니다.
                _email = value!; // 입력된 값을 _email 변수에 저장합니다. '!'는 value가 null이 아님을 보증합니다.
              },
            ),

            const SizedBox(height: 10,), // 10만큼의 세로 간격을 줍니다.
            CheckboxListTile( // 체크박스와 라벨이 결합된 리스트 타일 위젯입니다.
              title: const Text('회원 가입에 동의 합니다.'), // 라벨에 표시될 텍스트입니다.
              value: _isCheck, // 체크박스의 선택 상태를 _isCheck 변수와 연결합니다.
              onChanged: (value){ // 체크박스 상태가 변경될 때 호출될 함수입니다.
                setState(() { // 화면을 갱신하기 위해 setState를 호출합니다.
                  _isCheck = value ?? false; // 변경된 선택 상태(true/false)를 _isCheck 변수에 저장합니다. null일 경우 false로 처리합니다.
                });

              },
              controlAffinity: ListTileControlAffinity.leading, // 체크박스를 텍스트의 왼쪽에 배치합니다.
              contentPadding: EdgeInsets.zero, // 내용의 여백을 없앱니다.
            ),

            const SizedBox(height: 10,), // 10만큼의 세로 간격을 줍니다.
            const Text('성별 선택', style: TextStyle(fontSize: 16),), // '성별 선택' 텍스트를 표시합니다.
            Row( // 자식 위젯들을 가로로 배치하는 위젯입니다.
              children: [ // Row 위젯이 가질 자식 위젯들의 목록입니다.
                Expanded( // 자식 위젯이 남은 가로 공간을 모두 차지하도록 합니다.
                  child: RadioListTile<String>( // 라디오 버튼과 라벨이 결합된 리스트 타일 위젯입니다.
                    title: const Text('남자'), // 라벨 텍스트를 '남자'로 설정합니다.
                    value: 'M', // 이 라디오 버튼의 값으로 'M'을 지정합니다.
                    groupValue: _gender, // 현재 선택된 그룹의 값으로 _gender 변수를 사용합니다.
                    onChanged: (value) { // 이 라디오 버튼이 선택될 때 호출될 함수입니다.
                      setState(() { // 화면을 갱신하기 위해 setState를 호출합니다.
                        _gender = value ?? ''; // 선택된 값('M')을 _gender 변수에 저장합니다.
                      });
                    },
                  ),
                ),
                Expanded( // 자식 위젯이 남은 가로 공간을 모두 차지하도록 합니다.
                  child: RadioListTile<String>( // '여자'를 위한 라디오 버튼입니다.
                    title: const Text('여자'), // 라벨 텍스트를 '여자'로 설정합니다.
                    value: 'F', // 이 라디오 버튼의 값으로 'F'를 지정합니다.
                    groupValue: _gender, // 현재 선택된 그룹의 값으로 _gender 변수를 사용합니다.
                    onChanged: (value) { // 이 라디오 버튼이 선택될 때 호출될 함수입니다.
                      setState(() { // 화면을 갱신하기 위해 setState를 호출합니다.
                        _gender = value ?? ''; // 선택된 값('F')을 _gender 변수에 저장합니다.
                      });
                    },
                  ),
                ),
              ],
            ),


            const SizedBox(height: 10,), // 10만큼의 세로 간격을 줍니다.
            Row( // 자식 위젯들을 가로로 배치합니다.
              children: [
                const Text('푸시 알림 허용'), // '푸시 알림 허용' 텍스트를 표시합니다.
                const Spacer(), // 텍스트와 스위치 사이에 빈 공간을 만들어 최대한 밀어냅니다.
                Switch( // ON/OFF 토글 스위치 위젯입니다.
                  value: _isSwitched, // 스위치의 상태를 _isSwitched 변수와 연결합니다.
                  onChanged: (value){ // 스위치 상태가 변경될 때 호출될 함수입니다.
                    setState(() { // 화면을 갱신하기 위해 setState를 호출합니다.
                      _isSwitched = value; // 변경된 상태(true/false)를 _isSwitched 변수에 저장합니다.
                    });

                  }
                )
              ],

            ),

            const SizedBox(height: 10,), // 10만큼의 세로 간격을 줍니다.
            Row( // 자식 위젯들을 가로로 배치합니다.
              mainAxisAlignment: MainAxisAlignment.center, // 자식 위젯들을 가로 방향의 중앙에 정렬합니다.
              children: [
                ElevatedButton( // 입체감 있는 버튼 위젯입니다.
                  onPressed: _cancelForm, // 버튼을 누르면 _cancelForm 함수를 실행합니다.
                  child: const Text('취소') // 버튼에 표시될 텍스트입니다.
                ),
                const SizedBox(width: 10,), // 버튼 사이에 10만큼의 가로 간격을 줍니다.
                ElevatedButton( // '제출' 버튼입니다.
                  onPressed: _submitForm, // 버튼을 누르면 _submitForm 함수를 실행합니다.
                  child: const Text('제출') // 버튼에 표시될 텍스트입니다.
                ),
              ],
            ),
            const SizedBox(height: 10,), // 10만큼의 세로 간격을 줍니다.
            Text(_submitResult) // 폼 제출 결과를 표시할 텍스트 위젯입니다.
          ],
        )
      ),
    );
  }
}
