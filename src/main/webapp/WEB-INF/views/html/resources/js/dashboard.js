$(function() {
  ctxPie = document.getElementById("pieChart").getContext("2d");
  // 生成随机颜色
  $.each(configPie.data.datasets[0].data,function(i,num){
    configPie.data.datasets[0].backgroundColor.push(getRandomColor());
  });
  pieChart = new Chart(ctxPie, configPie);
});

/**
 * 生成随机颜色
 */
function getRandomColor(){
  return "rgb(" + Math.ceil(Math.random()*255) +","+Math.ceil(Math.random()*255) + "," +Math.ceil(Math.random()*255) + ",1)";
}

function temp(){
  var configPie = {
    "widht" : "400",
    "height" : "400",
    "radius" : "120"
  };
  drawPieChart("group",configPie);
}

/**
 * 绘制饼状图
 */
function drawPieChart(canvasId,configPie) {
  // 取得画布
  var ctxPie = document.getElementById("group").getContext("2d");
  // 取得中心点
  var startX = configPie.widht/2;
  var starty = configPie.height/2;

  /**
   * @param startX 中心点X
   * @param starty 中心点Y
   * @param r 半径
   * @param start 初始位置(0为[startX+r,starty])
   * @param end 结束位置(2PI为一周,圆的周长公式为2PIr)
   */
  ctxPie.beginPath();
  ctxPie.fillStyle="#FFFF00";
  ctxPie.arc(startX,starty,configPie.radius,-Math.PI/2,Math.PI/2,false);
  ctxPie.lineTo(startX,starty);
  ctxPie.lineTo(startX,starty-configPie.radius);
  ctxPie.stroke();
  
}
