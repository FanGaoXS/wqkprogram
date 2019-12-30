<%@ page language="java" import="java.util.*,cn.wqk.bean.*" pageEncoding="gb2312"%> 
<style type="text/css">
<!--
body {
	margin:0;
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
<body>
  
<div class="topnav">
  <a class="active" href="equipshow">浏览商品</a>
  <a href="showcart">查看我的购物车</a>
  <a href="showinfo">查看我的个人信息</a>
  <a href="showorder">查看我的订单</a>
  <a href="exituser">退出登录</a>
</div>
<% ArrayList<Cart> carts=(ArrayList)request.getAttribute("carts"); 
  	double sum=0; %>
  <h3><%=session.getAttribute("username") %>，这是你的购物车，你有<%=carts.size() %>件装备等待结算</h3>
 
<table>
 <thead> 
  <tr>
  <th>装备名称</th>
  <th>单价</th>
  <th>数量</th>
  <th>优惠</th>
  <th>实付</th>
  <th></th>
  </tr>
 </thead>
 <tbody>
   <% if(carts!=null){
    	
    	for(int i=0;i<carts.size();i++){
    		int id=carts.get(i).getId();
    		String name=carts.get(i).getName();
    		String unit_price=carts.get(i).getUnit_price();
    		String total_price=carts.get(i).getTotal_price();
    		String real_pay=carts.get(i).getReal_pay();
    		sum=Double.parseDouble(real_pay)+sum;
   %>
   <tr>
	   <td data-label="装备名"><%=name %></td>
	   <td data-label="单价"><%=unit_price %></td>
	   <td data-label="数量">1</td>
	   <td data-label="优惠">9.8折<img src="./img/sale.png" alt="打折" width="20px" height="20px"></td>
	   <td data-label="实付"><%=real_pay %></td>
	   <td data-label="删除"><a style="text-decoration:none;color:black;" href="deletecart?id=<%=id %>">删除</a></td>
   </tr>
   <%  } //for%>
   <tr>
   <td>总计：</td>
   <td></td>
   <td></td>
   <td></td>
   <td></td>
   <td><%=sum %></td>
   </tr>
   <%} //if carts%>
   </tbody>
  </table>
   <button><a href="settle?sum=<%=sum %>&&size=<%=carts.size() %> ">确认付款</a></button>
  </body>
</html>
