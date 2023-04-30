let check=function (str, maxlen){ //Функция определяет длину строки и сокращает ее до нужного значения
    if (str.substring(0,str.indexOf("\n")).length>=maxlen){
        str=str.substring(0,maxlen-3)
        str+="..."
        console.log(str)
        return str
    }
    console.log(str)
    // return str.substring(0,str.indexOf("\n"))
    return str;
}
let butLickes=document.querySelectorAll(".but-licke")// массив кнопок "желаемое"
let butBuy=document.querySelectorAll(".but-buy")// массив кнопок "купить"
const bsk=document.querySelector(".bsk")
let ul =bsk.querySelector("ul")
const uved=bsk.querySelector(".uved")
const form=bsk.querySelector(("#MyForm"))

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

//Добавление EventListener, перемещающий выбранный товар в корзину
butBuy.forEach((item)=>{//Проходимся по массиву
    item.onclick=(e) => {// К каждой кнопке добавляем EventListener
        //Добавление названия товара в корзину
        if (item.id !== "bu1") {
            // console.log(e.id);
            // console.log(item.parentElement.parentElement.children[3].textContent);
            // console.log(item.parentElement.parentElement.children[1].children[0].textContent);
            let test=check(item.parentElement.parentElement.children[1].children[0].textContent, 27);
            console.log(test,"asd");
            form.children[0].setAttribute("value",form.children[0].getAttribute("value")+"_"+item.parentElement.parentElement.children[3].textContent);
            ul.innerHTML += "<li>" + check(item.parentElement.parentElement.children[1].children[0].textContent, 27) + "</li>";
            uved.textContent = Number(uved.textContent) + 1;//Увеличение счетчика товара
        }
        else{
            if (e.target.nodeName != 'A'){
                console.dir(e.target.children[0])
                location.href="Korsina.html";
            }
            // return false;



        }
    }
})

















// console.dir(check(item.parentElement.parentElement.children[1].textContent,28));