<%@ page language="java" import="java.util.*,cn.wqk.bean.*" pageEncoding="gb2312"%>
<style type="text/css">
<!--
body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: #555;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
    background-color: #4CAF50;
    color: white;
}
.smart-green {
margin-top:50px;
margin-left:auto;
margin-right:auto;
max-width: 500px;
background: #F8F8F8;
padding: 30px 30px 20px 30px;
font: 12px Arial, Helvetica, sans-serif;
color: #666;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
}
.smart-green h1 {
font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
padding: 20px 0px 20px 40px;
display: block;
margin: -30px -30px 10px -30px;
color: #FFF;
background: #4CAF50;
text-shadow: 1px 1px 1px #949494;
border-radius: 5px 5px 0px 0px;
-webkit-border-radius: 5px 5px 0px 0px;
-moz-border-radius: 5px 5px 0px 0px;
border-bottom:1px solid #89AF4C;

}
.smart-green h1>span {
display: block;
font-size: 11px;
color: #FFF;
}

.smart-green label {
display: block;
margin: 0px 0px 5px;
}
.smart-green label>span {
float: left;
margin-top: 10px;
color: #5E5E5E;
}
.smart-green input[type="text"], .smart-green textarea, .smart-green select {
color: #555;
height: 30px;
line-height:15px;
width: 100%;
padding: 0px 0px 0px 10px;
margin-top: 2px;
border: 1px solid #E5E5E5;
background: #FBFBFB;
outline: 0;
-webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
font: normal 14px/14px Arial, Helvetica, sans-serif;
}
.smart-green textarea{
height:100px;
padding-top: 10px;
}
.smart-green select {
background: url('down-arrow.png') no-repeat right, -moz-linear-gradient(top, #FBFBFB 0%, #E9E9E9 100%);
background: url('down-arrow.png') no-repeat right, -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FBFBFB), color-stop(100%,#E9E9E9));
appearance:none;
-webkit-appearance:none;
-moz-appearance: none;
text-indent: 0.01px;
text-overflow: '';
width:100%;
height:30px;
}
.smart-green .button {
background-color: #4CAF50;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-border-radius: 5px;
border: none;
padding: 10px 25px 10px 25px;
color: #FFF;
text-shadow: 1px 1px 1px #949494;
}
.smart-green .button:hover {
background-color:#80A24A;
}
-->
</style>
<% User user=(User)request.getAttribute("user"); %>
<html>
<div class="topnav">
  <a class="active" href="equipshow">�����Ʒ</a>
  <a href="showcart">�鿴�ҵĹ��ﳵ</a>
  <a href="showinfo">�鿴�ҵĸ�����Ϣ</a>
  <a href="showorder">�鿴�ҵĶ���</a>
  <a href="exituser">�˳���¼</a>
</div>
<body>
<form action="updateinfo" method="post" class="smart-green" >
	<h1><%=session.getAttribute("username") %>
	
		<span>���������ĸ�����Ϣ</span>
	</h1>
	
	<label>
		<span>�û���</span>
		<input type="text" name=username  value= <%=user.getUsername() %> readonly />
	</label>
	
	<label>
		<span>����</span>
		<input type="text" name=password  value= <%=user.getPassword() %> />
	</label>
	
	<label>
		<span>�ǳ�</span>
		<input type="text" name=name placeholder="����������ǳ�"  value= "<%=user.getName() %>" />
	</label>
	
	<label>
		<span>�Ա�</span>
		<input type="text" name=sex placeholder="����������Ա�" value= "<%=user.getSex() %>" />
	</label>
	
	<label>
		<span>����ǩ��</span>
		<input type="text" name=intro placeholder="��������ĸ���ǩ��"  value= "<%=user.getIntro() %>" />
	</label>
	<label>
		<span>�ջ���ַ</span>
		<input type="text" name=address placeholder="����������ջ���ַ"  value= "<%=user.getAddress() %>" />
	</label>
	
	
	<label>
		<span>&nbsp;</span>
		<input type=submit class="button" value="�ύ" />
	</label>
</form>
  
  
 </body>
</html>
