
$(document).ready(function(){
//  $('#header').hide();
//  
//    $('#photoOfGoods').hide();
//    //$('#photoOfGoods').hide().eq(0).show();
      // var count = 1;
       setTimeout(function(){$('.boxStealth').fadeOut('fast')},2000);
       
      var iter = document.getElementById("descriptionItem").getAttribute("currentTab");
      $('#info span:not(:nth-child('+(parseInt(iter)+1)+'))').hide();
      
      
  $('#info-nav li').click(function(event) {
    event.preventDefault();
    $('#info span').hide();
    $('#info-nav .current').removeClass("current");
    $(this).addClass('current');
    
    var clicked = $(this).find('a:first').attr('href');
    $('#info ' + clicked).fadeIn('fast');  // fadeIn, fast - скорость проявления
  }).eq(iter).addClass('current');  // cокращает набор
});

function addToBasket() 
{
    window.location=window.location.href+"&addToBasket=true";
}