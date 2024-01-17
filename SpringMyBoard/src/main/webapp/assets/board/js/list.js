/**
 * 
 */
 
const replyBtn = document.getElementById('replyBtn');



 replyBtn.addEventListener('click',(e)=>{
	 var board_id = document.getElementById('replyBtn').getAttribute( 'name' );
	// window.open(url, target) : 새 창을 여는 자바스크립트 함수 (window는 생략가능)
	open('/board/reply?board_id='+board_id,'_blank','width=500,height=400,top=100,left=150'); //blank -> 새창	 
 });
 