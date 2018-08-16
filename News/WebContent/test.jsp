<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="css/jigsaw.css">

<style>
.container {
  width: 310px;
  margin: 100px auto;
}
input {
  display: block;
  width: 290px;
  line-height: 40px;
  margin: 10px 0;
  padding: 0 10px;
  outline: none;
  border:1px solid #c8cccf;
  border-radius: 4px;
  color:#6a6f77;
}
#msg {
  width: 100%;
  line-height: 40px;
  font-size: 14px;
  text-align: center;
}
a:link,a:visited,a:hover,a:active {
  margin-left: 100px;
  color: #0366D6;
}
</style>


<body>

<div class="container">
	<input value="admin" readonly/>
	<input type="password" value="1234567890" readonly/>
	<div id="captcha" style="position: relative"></div>
	<div id="msg"></div>
</div>

<script type="text/javascript" src="js/jigsaw.js"></script>
<script type="text/javascript">
jigsaw.init(document.getElementById('captcha'), function () {
	document.getElementById('msg').innerHTML = '登录成功！'
})
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：360、FireFox、Chrome、Opera、傲游、搜狗、世界之窗. 不支持Safari、IE8及以下浏览器。</p>
<p>来源：<a href="http://sc.chinaz.com/" target="_blank">站长素材</a></p>
</div>



</body>
</html>