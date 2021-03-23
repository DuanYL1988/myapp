<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=5">
<script type="text/javascript">
function testReg(){
    var inputVal = document.getElementById("textInput").value;
    console.log(inputVal);
    checkNumeric(inputVal);
}

function checkNumeric(value){
    var regex = new RegExp(/[0-9]/g);
    value = value+"";
    regexpCheck(regex,value);
}

function regexpCheck(reg,txt){
    var rst = txt.replace(reg,"");
    if(rst.length > 0){
        console.log("not matched");
    }
}
</script>
</head>
<body>
  <input type="text" id="textInput" >
  <input type="button" value="正则测试" onclick="testReg()">
</body>
</html>