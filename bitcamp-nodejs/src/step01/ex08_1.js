// 주제 : 모듈을 정의하고 사용하기
//

// => exports 에 저당된 함수 받기


var obj = require('./ex08_m')

console.log("=================")
obj.plus(100);
obj.minus(7);

console.log(obj.getResult());
