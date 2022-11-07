Dice Application은 사용자가 주사위를 굴리고, 나온 값을 확인할 수 있는 앱이다.
주사위는 1~6의 육면체 주사위이며, 화면에 나온 주사위의 눈 값이 표기되어야 한다.
뿐만 아니라 1~6까지의 숫자가 나온 횟수와 해당 횟수를 사용자가 Reset할 수 있는 버튼이 있어야 한다.
또한 주사위는 한번 굴릴 때마다 색이 바뀌어야한다.

주사위를 누를때마다 주사위를 굴리는 함수를 호출 – 해당 함수는 주사위를 돌리고, 주사위의 색을 바꾸고, Count를 증가시켜야 한다.
Reset 버튼을 누를 시 Count를 Reset

하나의 Activity, 두개의 Button, 한 개의 Textbox?
각 버튼을 Onclick 할 시 작동하는 두개의 메소드 (DiceRoll, CountReset)
Dice(Onclick) -> DiceRoll -> Reset(Onclick) -> CountReset
