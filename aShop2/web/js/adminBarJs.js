/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function click_add_newGoods_Bar_Form()
{

    document.form1.buttonName.value = "button 1"
    form1.submit()
}
            
function click_add_newGoods_Bar(){

    window.location='adminBar.jsp?&fn_add';

}

function click_Edit_GoodsBar(id){
    window.location='adminBar.jsp?&fn_edit='+id;
}

function click_DelItem_GoodsBar(id){
    window.location='adminBar.jsp?&fn_del='+id;
    
}


function click_Submit_GoodsBar(){
    
    window.location='adminBar.jsp?&submit_Accept';
}


            
            
            
