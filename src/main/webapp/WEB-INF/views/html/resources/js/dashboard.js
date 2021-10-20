$(function() {
  drawPie("serviceType",serviceType);
  drawPie("charge",charge);
  drawPie("workStatus",workStatus);
});

function drawPie(eleId,obj){
  ctxPie = document.getElementById(eleId).getContext("2d");
  var configs = {
    "type" : "pie",
    "data": {
      "datasets": [
        {
          "data": obj.count,
          "backgroundColor": [
          ]
        },
        {
          "data": [getSum(obj.count)],
          "backgroundColor": [
            "white"
          ],
          "labels": []
        }
      ],
      "labels": obj.label
    },
    "options": {
      "responsive": false,
      "maintainAspectRatio": true
    }
  };

  // 生成随机颜色
  $.each(obj.count,function(){
    configs.data.datasets[0].backgroundColor.push(getRandomColor());
  });
  pieChart = new Chart(ctxPie, configs);

}

function getSum(arrs){
  var sum = 0;
  $.each(arrs,function(){
    sum = sum + parseInt(this);
  });
  return sum;
}

/**
 * 生成随机颜色
 */
function getRandomColor(){
  var color = "rgb(" + Math.ceil(Math.random()*255) +","+Math.ceil(Math.random()*255) + "," +Math.ceil(Math.random()*255) + ",1)";
  return color;
}
