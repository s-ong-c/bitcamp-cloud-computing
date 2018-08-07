// 주제 : 데이터베이스 프로그래밍 -select 실행


const mysql = require('mysql');

var con = mysql.createConnection({
  host:'13.125.9.121',

  database:'studydb',
  user:'study',
  password:'1111'
});


console.log(mysql);
console.log(con);

con.connect(function(err){

  if(err)throw err;

  console.log('연결성공');

});

//query(sql , 실행 후 호출될 함수)
// =>SQL 실행 예약 ! 지금 당장 실행되는 것이 아니다>>
con.query('select*from pms2_member',function(err,results){
  if(err)throw err;

  console.log('결과를 가져왔다',results);
});


con.end(function(err){
  if(err)throw err;
  console.log('연결을 끊었습니다.');
});
console.log('연결테스트!');
console.log('select 실행!!');
