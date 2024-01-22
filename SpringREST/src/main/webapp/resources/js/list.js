const fruit_name = document.getElementById('fruit_name');
const fruit_price = document.getElementById('fruit_price');
const fruit_grade = document.getElementById('fruit_grade');
const country_id = document.getElementById('country_id');


const insertBtn = document.getElementById('insert');
const updateBtn = document.getElementById('update'); 
const deleteBtn = document.getElementById('delete');

insertBtn.addEventListener('click', (e) => {
    const  xhttp = new XMLHttpRequest();

    xhttp.addEventListener('readystatechange', (e) => {

        console.log('응답받은 상태코드 : ',xhttp.status);
        if(xhttp.readyState === 4) {
            if(xhttp.status == 200 ) {
                console.log('요청이 잘 처리 되었습니다..');
                console.log(JSON.parse(xhttp.responseText));
            } else if (xhttp.status == 400){
                console.log('뭔가 잘 안됐습니다..');
                alert('업데이트 실패!');
            }
        }
    });

    // ※ <input>의 데이터로 생성한 객체라고 가정
    const userData = {
        fruit_name : fruit_name.innerText ,
        fruit_price : parseInt(fruit_price.innerText),
        fruit_grade : fruit_grade.innerText,
        country_id : country_id.innerText
    }

    xhttp.open('POST', './rest/update');

    // 데이터를 문자열로 보내야 직렬화가 가능하다
    // 요청에 함께 실려가는 문자열이 어떤 내용인지 content-type을 통해 설명해야 한다
    // JSON.parse(String) : JSON형식 문자열을 자바스크립트 객체로 변환해주는 메서드
    // JSON.stringify(Object) :  자바스크립트 객체를 JSON형식 문자열로 변환해주는 매서드
    xhttp.setRequestHeader('content-type', 'application/json');
    xhttp.send(JSON.stringify(userData));
});