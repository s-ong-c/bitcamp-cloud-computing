// 모듈 정의
// - 모듈로 리턴할 함수나 객체를 만든다.
// module.exports 객체에 담아 리턴한다.

function plus(a,b){return a+b}
function minus(a,b){return a-b}
function mutiple(a,b){return a*b}
function divide(a,b){return a/b}


//module 객체에 exports 라는 객체가 들어 있다.
//exports 객체에 함수를 담아 놓으면
// 모듈을 사용하는 코드에서 require()라는 호출하면 exports 객체를 리턴한다.
module.exports.plus = plus;
module.exports.minus = minus;

// module 생략 가능
exports.mutiple = mutiple;
exports.divide = divide;

//결론 
// => module 에서 리턴하고 싶다면 exports객체 담아서 사용!!!