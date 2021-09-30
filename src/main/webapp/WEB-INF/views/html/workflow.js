/** 初期化处理 */
$(function() {
  var targetEle = arrIconReset();
  arrIconSet(targetEle);
});

/**
 * 工作流动作
 */
function doEvent(type){
  var parentEle = arrIconReset();
  var targetEle;
  // 对象取得
  if('Pre'==type) {
    targetEle = $(parentEle).prev()[0];
  } else if ('Next'==type){
    targetEle = $(parentEle).next()[0];
  }
  // 处理
  if(isEmpty(targetEle)){
    targetEle = parentEle;
  }
  arrIconSet(targetEle);
}

/**
 * ICON初期化
 * @return 当前St的父元素
 */
function arrIconReset(){
  // 消息清空
  showMsg('',"");
  var curStEle = $("div[class='wk_icon current']")[0];
  curStEle.className = "wk_icon";
  // 箭头
  var nextIcon = $(curStEle).next()[0];
  if(null != nextIcon) {
    nextIcon.className = nextIcon.className.replace(' currentNext','');
  }
  return $(curStEle).parents()[0];
}

/**
 * 元素设置颜色
 * @param targetEle 动作的下一步父元素
 */
function arrIconSet(targetEle){
  // 活性控制
  $('#btn_pre').prop('disabled','');
  $('#btn_next').prop('disabled','');
  if(isEmpty($(targetEle).prev()[0])) {
    $('#btn_pre').prop('disabled','true');
  }
  if(isEmpty($(targetEle).next()[0])) {
    $('#btn_next').prop('disabled','true');
  }

  $.each($(targetEle).children(),function(){
    var clsNm = this.className;
    if('wk_icon'==clsNm){
      this.className = clsNm + ' current';
    } else if('wk_icon_next'==clsNm){
      this.className = clsNm + ' currentNext';
    }
  });
}