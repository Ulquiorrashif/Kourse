
let butLickes=document.querySelectorAll(".but-licke")// массив кнопок "желаемое"


//Добавление EventListener, который будет менять цвет у кнопки
butLickes.forEach((item)=>{ //Проходимся по массиву
    item.addEventListener("click",()=>{// К каждой кнопке добавляем EventListener
        if (item.style.backgroundColor==="rgb(255, 67, 67)"){
            item.children[0].style.color="#797676";
            item.style.backgroundColor="#b4b2b2";
        }else{
            item.style.backgroundColor="#ff4343";
            item.children[0].style.color="#ff0000";
        }

    })
})

