$(function() {

    if (null != window.opener) {
        $('body').css("zoom","0.75");
    }

    if (typeof (mode) == "undefined") {
        // HTML处理
    } else if (null != result) {
        $("#updRst").show();
        // popup且更新成功后关闭窗口
        if (null != window.opener) {
            window.close();
        }
    }

});
