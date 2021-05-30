$(function() {
    var farm = document.getElementById('firstFarm');
    var index = 1;
    var parentFarm = createDiv("first_"+index,"parent_cell");
    
    for(var row=1;row<=16*4;row++) {
        if ((row-1)%4 == 0){
            parentFarm = createDiv("first_"+index,"parent_cell");
        }
        parentFarm.appendChild(createDiv("first_"+index+"_"+row,"item_farm"));
        if (row%4 == 0){
            farm.appendChild(parentFarm);
            index++;
        }
    }

});

function createDiv(id,classNm){
    var div = document.createElement("div");
    div.id = id;
    div.className = classNm;
    div.onmousedown = function(){
        console.log(id);
    }
    return div;
}