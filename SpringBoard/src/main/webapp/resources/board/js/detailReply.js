const replyContent = document.querySelector('#replyContent');
const replyForm = document.querySelector('#replyForm');
const reply_password = document.querySelector('#reply_password');
const reply_writer = document.querySelector('#reply_writer');


const replyWriteBtn = document.querySelector('#replyWriteBtn');


replyContent.addEventListener('keydown', (e) => {
	 console.log(e);
	 
	 if(e.keyCode === 13){
		 if(!e.shiftKey){
			 // Shift 안누르고 Enter하면 submit()
			 e.preventDefault();
			 
			 if(reply_writer.value.trim() === ''){
				 alert('글쓴이가 비어있습니다');
			 } else if(reply_password.value.trim() ==='' || 
			 	reply_password.value.trim().length < 5){
				 alert('비밀번호는 4글자 이상이어야 합니다');
				 return;
			 }
			 replyForm.submit();
			 
		 } else {
			 // Shift + Enter하면 댓글에서 줄 바꿔주기
			 replyContent.innerText += '\n';
		 }
	 }
});
