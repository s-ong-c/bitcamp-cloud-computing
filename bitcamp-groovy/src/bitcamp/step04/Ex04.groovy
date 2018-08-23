package bitcamp.step04
// 메서드 - 맵 파라미터

def f1(map) {
  for(e in map) {
      println e.key+"="+e.value
  }
  println"---------------------"
}
// 방법 1
f1(["홍길동":20,"홍길착":10,"홍길홍":40])


//방법 2
// 괄호를 생략한다면 ,맵의 대괄호도 생략해야한다.
f1 "홍길동":20,"홍길착":10,"홍길홍":40

//방법 3
// key 에 대해서 따옴표를 생략 가능 
// 단 key 에 공백이나 특수 문자를 포함한 경우에는 따옴표를 생략할 수 없다. 
f1 홍길동:20,홍길착:10,홍길홍:90