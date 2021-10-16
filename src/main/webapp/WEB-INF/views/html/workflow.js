var CURRENT_STEP;
var formEle;
var status = 0;

$(function() {
  // 初始设定
  CURRENT_STEP = wkJson.currentStep;
  formEle = document.getElementById("infoForm");
  initlize();
  // 基本情报
  initEditArea(contract.baseInfo,formEle);
  // 默认表示区域
  var displayA = wkJson.steps[CURRENT_STEP].clnm;
  initEditArea(contract[displayA],formEle);
});

/**
 * 业务控制
 */
function doStep(step,csts,objNm) {
  if (isInclude(csts,["A-1","A-2","A-3"])) {
    var nextStep = parseInt(step)+1;
    var baseNm = objNm;
    nextStep = csts + "-" + nextStep;
    if ("1" == step) {
      baseNm += "_applicationFlag";
      $("#"+nextStep).removeAttr("disabled");
    } else if ("2" == step) {
      baseNm += "_approvalFlag";
      $("#"+nextStep).removeAttr("disabled");
    } else if ("3" == step) {
      baseNm += "_sendFlag";
      
      $("input[name$='.replyFlag']").removeAttr("disabled");
      $("#A-1-A-2").removeAttr("disabled");
    }
    $("#"+baseNm).val("1");
    $("#Lbl_"+baseNm).html("済");
  }
}
