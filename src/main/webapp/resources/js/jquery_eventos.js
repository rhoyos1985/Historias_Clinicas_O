/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function mostrarlista(lista, id)
{
    var element = "#" + id + " .h3_span";
    
    $(lista).slideToggle();
    $(element).toggleClass('icon-chevron-down');
    
    return false;
}

$('h3').click(function(e){
    var oID = $(this).attr("id");
    var mnuitems ='';
    
    switch (oID) {
        case 'mnutitulo_titulop':
            mnuitems = '.mnutitulo_items1';
            break;
        case 'mnutitulo_tituloc':
            mnuitems = '.mnutitulo_items2';
            break;
        case 'mnutitulo_titulof':
            mnuitems = '.mnutitulo_items3';
            break;
        default:
            break;
    } 
    mostrarlista(mnuitems,oID);
});