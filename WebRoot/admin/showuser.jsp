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
    margin-top:50px;
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
  <a class="active" href="">�鿴�û�</a>
  <a href="allorder">�鿴����</a>
  <a href="exitadmin">�˳���¼</a>
</div>
<% ArrayList<User> users=(ArrayList)request.getAttribute("users");  %>
 
<table>
 <thead> 
  <tr>
  <th>�û���</th>
  <th>�û�����</th>
  <th>�û��ǳ�</th>
  <th>�Ա�</th>
  <th>����ǩ��</th>
  <th>��ַ</th>
  <th></th>
  </tr>
 </thead>
 <tbody>
   <% if(users!=null){
    	
    	for(int i=0;i<users.size();i++){
    		String username=users.get(i).getUsername();
    		String password=users.get(i).getPassword();
    		String name=users.get(i).getName();
    		String sex=users.get(i).getSex();
    		String intro=users.get(i).getIntro();
    		String address=users.get(i).getAddress();
   %>
   <tr>
	   <td data-label="�û���"><%=username %></td>
	   <td data-label="����"><%=password %></td>
	   <td data-label="�ǳ�"><%=name %></td>
	   <td data-label="�Ա�"><%=sex %></td>
	   <td data-label="����ǩ��"><%=intro %></td>
	   <td data-label="��ַ"><%=address %></td>
	   <td data-label="ɾ��"><button><a href="deleteuser?username=<%=username %> ">ɾ��</a></button></td>
   </tr>
   <%  } //for%>
   <tr>
   <td>�ܼƣ�</td>
   <td></td>
   <td></td>
   <td></td>
   <td></td>
   <td></td>
   <td><h3><%=users.size()%>��</h3></td>
   </tr>
   <%} //if users%>
   </tbody>
  </table>
  </body>
</html>
