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
  <a class="active" href="equipshow">�����Ʒ</a>
  <a href="showcart">�鿴�ҵĹ��ﳵ</a>
  <a href="showinfo">�鿴�ҵĸ�����Ϣ</a>
  <a href="showorder">�鿴�ҵĶ���</a>
  <a href="exituser">�˳���¼</a>
</div>
<% ArrayList<Cart> carts=(ArrayList)request.getAttribute("carts"); 
  	double sum=0; %>
  <h3><%=session.getAttribute("username") %>��������Ĺ��ﳵ������<%=carts.size() %>��װ���ȴ�����</h3>
 
<table>
 <thead> 
  <tr>
  <th>װ������</th>
  <th>����</th>
  <th>����</th>
  <th>�Ż�</th>
  <th>ʵ��</th>
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
	   <td data-label="װ����"><%=name %></td>
	   <td data-label="����"><%=unit_price %></td>
	   <td data-label="����">1</td>
	   <td data-label="�Ż�">9.8��<img src="./img/sale.png" alt="����" width="20px" height="20px"></td>
	   <td data-label="ʵ��"><%=real_pay %></td>
	   <td data-label="ɾ��"><a style="text-decoration:none;color:black;" href="deletecart?id=<%=id %>">ɾ��</a></td>
   </tr>
   <%  } //for%>
   <tr>
   <td>�ܼƣ�</td>
   <td></td>
   <td></td>
   <td></td>
   <td></td>
   <td><%=sum %></td>
   </tr>
   <%} //if carts%>
   </tbody>
  </table>
   <button><a href="settle?sum=<%=sum %>&&size=<%=carts.size() %> ">ȷ�ϸ���</a></button>
  </body>
</html>
