/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
            
            var shop1;
            var shop2;
            var courier;
            var centerPos;
            
            
            var imageUnd = 'img/langico/mountainbiking2.png';
            var imageCurrent = 'img/langico/mountainbiking.png';
            
            var geocoder;
            var map;
            var markers = [];
            
            var infowindow1;
            var infowindow2;
            
       
       
       
$(document).ready(function(){
           

            $(".typeShop").hide();
            $(".typeCourier").hide();


            $('select').on('change', function() {
            if(this.value=="shop"){
                    $(".typeCourier").hide();
                    $(".typeShop").show();
                    courier.setMap(null);
                    document.getElementById("ordering_type_market_accept").disabled=true;
                    
                    document.getElementById('MarkerId').value = '0';
                    infowindow1.close();
                    infowindow2.close();
                    shop1.icon = imageUnd;
                    shop2.icon = imageUnd;
                    shop1.setMap(map);
                    shop2.setMap(map);
                }
                if(this.value=="courier"){
                    $(".typeShop").hide();
                    $(".typeCourier").show();
                    document.getElementById('MarkerId').value = '0';
                    document.getElementById("ordering_type_market_accept").disabled=true;
                } 
                
            })
            
            
               
         document.getElementById("ordering_type_market_accept").disabled=true;   
            
         initialize();   
});
       
      
            function accept_Adress_Text(){
                var val=document.getElementById('address').value;
                if(val != null){
                    window.location='checkoutFinal.jsp?&adressText='+val;
                }
            }
            
            function accept_Shop_Text(){
                var val=document.getElementById('MarkerId').value;
                
                
                 
                if(val != null){
                if(val == 0) {
                   document.getElementById("ordering_type_market_accept").disabled=true;
                }else if(val==1){                   
                   val="\"Вело-основа\" №1: просп. Культуры, 1, Санкт-Петербург, 195274";
                }else if(val==2){
                   val="\"Вело-основа\" №2: Московское ш., 3с1 Санкт-Петербург, 195274";
                }
                    window.location='checkoutFinal.jsp?&adressText='+val;
                }
            }
       
            
            
            function initialize() {
                
                centerPos=new google.maps.LatLng(59.9481439, 30.1908739);
                
                courier = new google.maps.Marker({
                      map: map,
                      icon: 'img/langico/paragliding.png',
                      zoom: 15
                  });
                
                
                geocoder = new google.maps.Geocoder();
                
                
                
                
              
                
                
                
                
                var myLatlng = new google.maps.LatLng(59.9481439, 30.1908739);
                var mapOptions = {
                    center: myLatlng,
                    zoom: 10
                };
                map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
                
                
                
                
                
                
                var myLatlng = new google.maps.LatLng(60.0337, 30.367796);
                shop1 = new google.maps.Marker({
                    icon: imageUnd,
                    position: myLatlng,
                    title:"\"Вело-основа\" №1"
                });
                var contentString1 = 
                    '<h3>\"Вело-основа\" №1</h3>'+
                    '<div>'+
                    'Магазин велосипедов и комплектующих.'+
                    '<p>Адрес: просп. Культуры, 1, Санкт-Петербург, 195274</p>'+
                     '</div>';
                infowindow1 = new google.maps.InfoWindow({content: contentString1});
                google.maps.event.addListener(shop1, 'click', function() {
                    infowindow2.close();
                    infowindow1.open(map,shop1);
                    
                    map.setZoom(15);
                    map.setCenter(shop1.getPosition());
                    
                    
                    $('#MarkerId').val('1').change();
                    
                });
                
                
                
                shop1.setMap(map);
                
                
                
                var myLatlng = new google.maps.LatLng(59.836735, 30.331931);
                shop2 = new google.maps.Marker({
                    icon: imageUnd,
                    position: myLatlng,
                    title:"\"Вело-основа\" №2"
                });
                var contentString2 = 
                    '<h3>\"Вело-основа\" №2</h3>'+
                    '<div>'+
                    'Магазин велосипедов и комплектующих.'+
                    '<p>Адрес: Московское ш., 3с1 Санкт-Петербург, 195274</p>'+
                     '</div>';
                infowindow2 = new google.maps.InfoWindow({content: contentString2});
                
                google.maps.event.addListener(shop2, 'click', function() {
                    infowindow1.close();
                    infowindow2.open(map,shop2);
                    
                    map.setZoom(15);
                    map.setCenter(shop2.getPosition());
                  
                    $('#MarkerId').val('2').change();
                    
                    
                    
                
                });
                
                shop2.setMap(map);
                
                
                
                updMarker();  
                updTypeOrder();
                  
            }
            
            
            function updMarker() {
                var index = document.getElementById("MarkerId").selectedIndex;
                if( index == 1) {
                    infowindow2.close();
                    infowindow1.open(map,shop1);
                    shop2.icon = imageUnd;
                    shop1.icon = imageCurrent;
                    
                    map.setZoom(15);
                    map.setCenter(shop1.getPosition());
                    
                    courier.setMap(null);
                    document.getElementById("ordering_type_market_accept").disabled=false;
                    
                }else if( index == 2)
                {
                    infowindow1.close();
                    infowindow2.open(map,shop2);
                    shop1.icon = imageUnd;
                    shop2.icon = imageCurrent;
                    
                    map.setZoom(15);
                    map.setCenter(shop2.getPosition());
                    
                    courier.setMap(null);
                     document.getElementById("ordering_type_market_accept").disabled=false;
                }else {
                    shop1.icon = imageUnd;
                    shop2.icon = imageUnd;
                }
                shop1.setMap(map);
                shop2.setMap(map);
                document.form1.argMarket.value = document.getElementById("MarkerId").selectedIndex;
            }
            
            
            
            function codeAddress() {
              
              
                courier.setMap(null);
                map.setZoom(15);
              
              var address = document.getElementById('address').value;
              geocoder.geocode( { 'address': address}, function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                  map.setCenter(results[0].geometry.location);
                  courier = new google.maps.Marker({
                      map: map,
                      position: results[0].geometry.location,
                      icon: 'img/langico/paragliding.png',
                      zoom: 15
                  });
                  
                  
                  
                  google.maps.event.addListener(courier, "dblclick", function() {
                        courier.setMap(null);
                    });
                  
                } else {
                  alert('Geocode was not successful for the following reason: ' + status);
                }
              });
              
                infowindow1.close();
                infowindow2.close();
                shop1.icon = imageUnd;
                shop2.icon = imageUnd;
                shop1.setMap(map);
                shop2.setMap(map);
                
                document.getElementById('MarkerId').value = '0';
 
              }


              function updTypeOrder(){
                    
                  var index = document.getElementById("typeOrder").selectedIndex;
                    if( index == 1) {
                    
                    map.setZoom(10);
                    map.setCenter(new google.maps.LatLng(59.9481439, 30.1908739));
                    
                    
                    
                    courier.setMap(null);
                    
                    
                }else if( index == 2)
                {
                    
                    infowindow2.close();
                    infowindow1.close();
                    
                    shop1.icon = imageUnd;
                    shop2.icon = imageUnd;
                    
                    map.setZoom(10);
                    map.setCenter(new google.maps.LatLng(59.9481439, 30.1908739));
                    
                    
                    
                    
                }
                shop1.setMap(map);
                shop2.setMap(map);
                
                
                  
                  
              }
              
              
              function change(){
                  
                  document.getElementById('typeOrder').value = "shop";
              }