<%@ page language="java" import="java.util.*,cn.wqk.bean.*" pageEncoding="gb2312"%>
<style type="text/css">
<!--
body {
	margin:0 auto;
	text-align:center;
}

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
table {
    border: 1px solid #ccc;
    width: 80%;
    margin:0;
    padding:0;
    border-collapse: collapse;
    border-spacing: 0;
    margin: 0 auto;
  }

  table tr {
    border: 1px solid #ddd;
    padding: 5px;
  }

  table th, table td {
    padding: 10px;
    text-align: center;
  }

  table th {
    text-transform: uppercase;
    font-size: 14px;
    letter-spacing: 1px;
  }

  @media screen and (max-width: 600px) {

    table {
      border: 0;
    }

    table thead {
      display: none;
    }

    table tr {
      margin-bottom: 10px;
      display: block;
      border-bottom: 2px solid #ddd;
    }

    table td {
      display: block;
      text-align: right;
      font-size: 13px;
      border-bottom: 1px dotted #ccc;
    }

    table td:last-child {
      border-bottom: 0;
    }

    table td:before {
      content: attr(data-label);
      float: left;
      text-transform: uppercase;
      font-weight: bold;
    }
  }
button{
  width: 5%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover{
  background-color: #45a049;
}
button a{
	text-decoration:none;
	color:white;
}
-->

</style>
<html>
<div class="topnav">
  <a class="active" href="equipshow">浏览商品</a>
  <a href="showcart">查看我的购物车</a>
  <a href="showinfo">查看我的个人信息</a>
  <a href="showorder">查看我的订单</a>
  <a href="exituser">退出登录</a>
</div>
<% ArrayList<Order> orders=(ArrayList)request.getAttribute("orders"); %>
<h3><%=session.getAttribute("username") %>，你共有<%=orders.size() %>条订单</h3>
    <body>
    
    
<table>
  <thead>
    <tr>
      <th>订单号</th>
      <th>用户昵称</th>
      <th>收货地址</th>
      <th>用户名</th>
      <th>实际付款</th>
      <th>发货状态</th>
    </tr>
  </thead>
  <tbody>
  <% if (orders!=null) {
    
    
    	for(int i=0;i<orders.size();i++){
    		String id=orders.get(i).getId();
    		String name=orders.get(i).getName();
    		String address=orders.get(i).getAddress();
    		String username=orders.get(i).getUsername();
    		String real_pay=orders.get(i).getReal_pay();
    		String issend=orders.get(i).getIssend();
    	%>
    <tr>
      <td data-label="订单号">20191205<%= id %></td>
      <td data-label="昵称"><%= name %></td>
      <td data-label="收货地址"><%= address %></td>
      <td data-label="用户名"><%= username %></td>
      <td data-label="实际付款"><%= real_pay %><img src="./img/icon.png" alt="金币" width="15px" height="15px"></td>
      <td data-label="发货状态"><% if(issend.equals("未发货")){ %><a style="color:red;font-weight:bold;" >未发货</a><% }else{ %><a style="color:green;font-weight:bold;" >已发货</a><%} %></td>
    </tr>
  <% 	} 
  	}%>
  </tbody>
</table>

    <button><a href="equipshow">返回</a></button>
    </body>
</html>
