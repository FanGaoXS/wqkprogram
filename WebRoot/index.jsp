<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<style type="text/css">
<!--
body {
    background: #555;
    margin: 0 auto;
}
.content {
    max-width: 300px;
    margin: 0 auto;
    background: white;
    padding: 10px;
    text-align:center;
    position: relative;
    top: 50%; /*ƫ��*/
    transform: translateY(-50%);
    border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
a{
	text-decoration:none;
	color:black;
	}
input[type=text],[type=password]{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit]{
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover{
  background-color: #45a049;
}
-->
</style>
<style type="text/css">
<!--
b{
	backround:red;
	color:b}
-->
</style>
<html>
  <body>
  <div class="content">
  <form action="Loginservlet" method=post name=login>
  <label>�û���</label>
  <input type=text name=username>
  <label>����</label>
  <input type=password name=password>
  <input type=submit value=ȷ�ϵ�¼>
  <a href="register.jsp">����ע��</a>
  <a href="user/equipmentslist.jsp">�ο�</a>
  </form>
  
  </div>
  </body>
</html>
