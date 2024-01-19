const chosen1 = document.getElementById('chosen1');

const btn1 = document.getElementById('btn1');


btn1.addEventListener('click', (e) => {
    const xhttp = new XMLHttpRequest();
    xhttp.addEventListener('readystatechange', (e) => {
        if(xhttp.readyState === 4 && xhttp.status == 200){
            console.dir(xhttp);
            const cargo = xhttp.responseText;

            const emps = JSON.parse(cargo);
            console.log(emps);
            
            for(let i = 0 ; i < emps.length ; i++) {
                const newEmpId = document.createElement('div');
                newEmpId.classList.add('emp-id');
                newEmpId.innerText = "쵸즌원의 사원번호 : "+emps[i].employee_id;
    
                chosen1.appendChild(newEmpId);
            }


        

        }
    });

    xhttp.open('GET', './rest/chosen');
    xhttp.send();
});