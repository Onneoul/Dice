Dice 앱은 주사위 모양의 버튼과 리셋 버튼으로 구성되며 주사위 모양 버튼을 누를 시 1~6까지의 숫자 중 하나를 무작위로 골라 주사위를 굴린 횟수와 함께 화면에 출력하는 앱입니다. 
주사위를 굴린 횟수와 각각의 시행때에 나온 주사위의 결과를 확인할 수 있습니다. 
또한, 화면 하단에 위치한 리셋버튼을 눌러 값을 초기화할 수도 있습니다.

하나의 화면, 두개의 Button, 한 개의 Textbox
각 버튼을 Onclick 할 시 작동하는 두개의 메소드 (roll, reset)
roll(Onclick) -> (java)rollDice -> reset(Onclick) -> (java)onReset




Activity는 다음과 같이 구성된다.

지역변수
count: 주사위를 굴린(diceRoll 메소드가 수행된) 횟수
result: 1~6 사이의 무작위 값
list: count와 result를 결합한 String을 갖는 String ArrayList


메소드
onCreate: 화면이 생성될 때 수행되는 메소드로 화면이 처음 생성되는지를 검사하고 화면을 구성한다.

onSaveInstanceState: 원본 Activity가 파괴될 때, 지역변수 등의 값을 Bundle savedInstanceState에 저장한다.

onResume: 화면이 재생성될 때, onSaveInstanceState 메소드로 생성된 기존 변수 값을 받아 TextView인 resultList에 출력하는 메소드이다.

onClickRoll: imageButton roll을 눌렀을 때, diceRoll 메소드를 실행하여 결과 값을 받아오고 이를 resultList에 출력한다.

onClickReset: reset 버튼을 클릭할 시 동작하는 메소드로 TextView resultList와 지역변수 count, result, list를 초기화하여 Dice 앱을 초기상태로 되돌린다.

diceRoll: Dice 앱의 핵심 메소드로써 1~6까지의 무작위 값을 생성하고 result에 저장한 후 result의 값에 따라 roll의 image를 result에 맞게 변경한다. 
이후 count와 result를 %d. %d의 형태의 String, text로 저장하여 list에 추가하고 onClickRoll이 resultList에 추가할 수 있도록 text를 return한다.
