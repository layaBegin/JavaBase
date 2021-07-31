
window.onload = function () {
    let username = getCookieValue("username")
    let password = getCookieValue("password")
    if (username && password){
        document.getElementById("username").value = username;
        document.getElementById("password").value = password;
        document.getElementById("loginForm").submit();
    }
}

/*alert(getCookieValue("username"));
alert(getCookieValue("password"));*/
//username=zhangshan; password=123

function  getCookieValue(name) {
    let cookie = document.cookie;
    let strings = cookie.split("; ");
    for (let str1 of strings){
        let strings1 = str1.split("=");
        if (strings1[0] == name){
            return strings1[1];
        }
    }
    return null;
}