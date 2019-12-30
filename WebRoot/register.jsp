<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<style type="text/css">
<!--
body {
    background: #555;
}
.content {
    max-width: 300px;
    margin: 0 auto;
    background: white;
    padding: 10px;
    text-align:center;
    position: relative;
    top: 50%; /*偏移*/
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

input[type=submit],[type=reset],button{
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover ,button{
  background-color: #45a049;
}
-->
</style>
<html>
  <body>
  <div class="content">
  <form action="Registerservlet" method=post name=register>
  <label>用户名</label>
	<input type=text name=username>
  <label>密码</label>
 	<input type=password name=password>
  <input type=submit value=提交注册>
  <input type=reset value=重置>
  <a href="index.jsp">返回</a>
  </form>
  </div>
  </body>
</html>
