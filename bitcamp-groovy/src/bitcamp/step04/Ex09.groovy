package bitcamp.step04
// 메서드 - 파라미터로 클록저 넘기기 III

exec = {m ->
    m() // 파라미터로 클로저를 받아서 실행하기
    
}

exec({ // 파라미터가 없는 클로저를 만들어 exec() 에 넘긴다. 
    a =100
    b =200
    println a+b
   })


println("==--==--==--==--==-=-=-=-=-=-=-=-=")
// 함수를 호출할 떄 괄호를 생략할 수 있다.
exec{
    a =100
    b =200
    println a-b
   }

