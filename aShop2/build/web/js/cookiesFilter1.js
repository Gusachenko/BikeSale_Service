$(document).ready(function()
{
                
               
   var i = setInterval(function(){ 
    $("#ttt").load("jheader.jsp"); 
    },5000);           

});





function gotoa(){ 

    var temp1Val = document.getElementById("hiddenTemp1").value;
    // put your logic here
//    document.getElementById("hiddenTemp1").value = tempVal1;
}
function acceptFilter(){
    var wheelValue=document.getElementById("selectWhSize").value;
    
    $(".ztest").html("hello "+wheelValue);
}
var val="&value2=";
function itemsChanged(){
var value1 = document.getElementsByTagName('select')[0].value;


    window.location='ListItems.jsp?&value=' + value1+val;


}






var checked_boxArr = new Array();

var check_grBrand = document.getElementsByName("brandGroup");
var strBrand=new Array();

var check_grStyle = document.getElementsByName("styleGroup");
var strStyle=new Array();

var check_grWheels = document.getElementsByName("wheelsGroup");
var strWheels=new Array();

var lowCost;

var maxCost;


var wLocation="ListItems.jsp?";

var valueCookiesFilter_=["brandGroup","styleGroup","wheelsGroup"];


function sendFilterValue() 
{
//    strBrand=checkIf(check_grBrand,"brandGroup");    
//    if (strBrand!=null)
//    {
//        wLocation=wLocation.concat("&valueBrand="+strBrand);
//    }
//    strStyle=checkIf(check_grStyle,"styleGroup");    
//    if (strStyle!=null)
//    {
//        wLocation=wLocation.concat("&valueStyle="+strStyle);
//    }
//    strWheels=checkIf(check_grWheels,"wheelsGroup");
//    if (strWheels!=null)
//    {
//        wLocation=wLocation.concat("&valueWheels="+strWheels);
//    }
    //   window.location=wLocation;
    
    lowCost= document.getElementsByName("lowCost")[0].value;
    if (lowCost!=null && lowCost>0)
    {
        wLocation=wLocation.concat("&valueLowCost="+lowCost);
        setCookie("lowCost", lowCost, 365);
    }else{setCookie("lowCost", null, 365);}
    maxCost= document.getElementsByName("maxCost")[0].value;
    if (maxCost!=null && maxCost>0)
    {
        wLocation=wLocation.concat("&valueMaxCost="+maxCost);
        setCookie("maxCost", maxCost, 365);
    }else{setCookie("maxCost", null, 365);}
    

    for (var i=0;i<valueCookiesFilter_.length;i++){
    var user = (checkIf(document.getElementsByName(valueCookiesFilter_[i]),valueCookiesFilter_[i]));
        if (user != "" && user != null) {
            setCookie(valueCookiesFilter_[i], escape(user+""), 365);
        }else{
            
            setCookie(valueCookiesFilter_[i], null, 365);
        }
        user=null;
    }
   
        location.reload();
}


function checkIf(elem,name)
{
    var strVal;
    var checked_arr=new Array();
     for (i=0;i<elem.length;i++)
{
    if(elem[i].checked)
    {
        strVal=document.getElementsByName(name)[i].value;
        checked_arr.push(strVal);
    }
}
    if (strVal==undefined){return null;}else{return checked_arr;}
}


function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}








// Инициализируем таблицу перевода
var trans = [];
for (var i = 0x410; i <= 0x44F; i++)
  trans[i] = i - 0x350; // А-Яа-я
trans[0x401] = 0xA8;    // Ё
trans[0x451] = 0xB8;    // ё

// Сохраняем стандартную функцию escape()
var escapeOrig = window.escape;

// Переопределяем функцию escape()
window.escape = function(str)
{
  var ret = [];
  // Составляем массив кодов символов, попутно переводим кириллицу
  for (var i = 0; i < str.length; i++)
  {
    var n = str.charCodeAt(i);
    if (typeof trans[n] != 'undefined')
      n = trans[n];
    if (n <= 0xFF)
      ret.push(n);
  }
  return escapeOrig(String.fromCharCode.apply(null, ret));
}
