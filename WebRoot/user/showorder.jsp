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
  <a class="active" href="equipshow">�����Ʒ</a>
  <a href="showcart">�鿴�ҵĹ��ﳵ</a>
  <a href="showinfo">�鿴�ҵĸ�����Ϣ</a>
  <a href="showorder">�鿴�ҵĶ���</a>
  <a href="exituser">�˳���¼</a>
</div>
<% ArrayList<Order> orders=(ArrayList)request.getAttribute("orders"); %>
<h3><%=session.getAttribute("username") %>���㹲��<%=orders.size() %>������</h3>
    <body>
    
    
<table>
  <thead>
    <tr>
      <th>������</th>
      <th>�û��ǳ�</th>
      <th>�ջ���ַ</th>
      <th>�û���</th>
      <th>ʵ�ʸ���</th>
      <th>����״̬</th>
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
      <td data-label="������">20191205<%= id %></td>
      <td data-label="�ǳ�"><%= name %></td>
      <td data-label="�ջ���ַ"><%= address %></td>
      <td data-label="�û���"><%= username %></td>
      <td data-label="ʵ�ʸ���"><%= real_pay %><img src="./img/icon.png" alt="���" width="15px" height="15px"></td>
      <td data-label="����״̬"><% if(issend.equals("δ����")){ %><a style="color:red;font-weight:bold;" >δ����</a><% }else{ %><a style="color:green;font-weight:bold;" >�ѷ���</a><%} %></td>
    </tr>
  <% 	} 
  	}%>
  </tbody>
</table>

    <button><a href="equipshow">����</a></button>
    </body>
</html>
