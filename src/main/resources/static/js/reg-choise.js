const regCont = document.querySelector(".reg-cont")
const choiseReg=document.querySelector(".choice-reg")
const choiseEnter=document.querySelector(".choice-enter")

//Добавление EventListener, который будет выводить форму для входа в аккаунт
choiseEnter.addEventListener("click",()=>{
    choiseEnter.style.backgroundColor="#f68213";
    choiseReg.style.backgroundColor="#ffffff";
    regCont.innerHTML="<form class=\"fEnter\">\n" +
        "            <h3 style=\"\">Войти</h3>\n" +
        "            <div class=\"input-cont\" >\n" +
        "                <span>Почта</span>\n" +
        "                <i class=\"fa-solid fa-envelope\"></i>\n" +
        "                <span> : </span>\n" +
        "                <input type=\"email\" placeholder=\"Почта\">\n" +
        "                <div class=\"line\"></div>\n" +
        "            </div>\n" +
        "            <div class=\"input-cont\" >\n" +
        "                <span>Пароль</span>\n" +
        "                <i class=\"fa-solid fa-key\"></i>\n" +
        "                <span> : </span>\n" +
        "                <input type=\"password\" placeholder=\"Пароль\">\n" +
        "            </div>\n" +
        "          <input type=\"button\" value=\"Войти\">\n" +
        "        </form>";
})
//Добавление EventListener, который будет выводить форму регистрации аккаунта
choiseReg.addEventListener("click",()=>{
    choiseReg.style.backgroundColor="#f68213";
    choiseEnter.style.backgroundColor="#ffffff";
    regCont.innerHTML="<form class=\"fReg\">\n" +
        "            <h3 style=\"\">Создать профиль</h3>\n" +
        "            <div class=\"input-cont\" >\n" +
        "                <span>Почта </span>\n" +
        "                <i class=\"fa-solid fa-envelope\"></i>\n" +
        "                <span> : </span>\n" +
        "                <input type=\"email\" placeholder=\"Почта\">\n" +
        "                <div class=\"line\"></div>\n" +
        "            </div>\n" +
        "            <div class=\"input-cont\" >\n" +
        "                <span>Пароль </span>\n" +
        "                <i class=\"fa-solid fa-key\"></i>\n" +
        "                <span> : </span>\n" +
        "\n" +
        "                <input type=\"password\" placeholder=\"Пароль\">\n" +
        "            </div>\n" +
        "            <div class=\"input-cont\" >\n" +
        "                <span>Пароль </span>\n" +
        "                <i class=\"fa-solid fa-key\"></i>\n" +
        "                <span> : </span>\n" +
        "                <input type=\"password\" placeholder=\"Повторите пароль\">\n" +
        "            </div>\n" +
        "            <input type=\"button\" value=\"Создать\">\n" +
        "        </form>";
})