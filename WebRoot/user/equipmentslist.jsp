<%@ page language="java" import="java.util.*,cn.wqk.bean.*" pageEncoding="gb2312"%>
<style type="text/css">
<!--
body {
	margin:0;
	text-align: center;
}

* {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
  	-webkit-box-sizing: border-box;
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

.columns {
    float: left;
    width: 33.3%;
    padding: 8px;
}

.price {
    list-style-type: none;
    border: 1px solid #eee;
    margin: 0;
    padding: 0;
    -webkit-transition: 0.3s;
    transition: 0.3s;
}

.price:hover {
    box-shadow: 0 8px 12px 0 rgba(0,0,0,0.2)
}

.price .header {
    background-color: #111;
    color: white;
    font-size: 25px;
}

.price li {
    border-bottom: 1px solid #eee;
    padding: 20px;
    text-align: center;
}

.price .grey {
    background-color: #eee;
    font-size: 20px;
}

.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 10px 25px;
    text-align: center;
    text-decoration: none;
    font-size: 18px;
}

@media only screen and (max-width: 600px) {
    .columns {
        width: 100%;
    }
}
.pagination {
  list-style: none;
  display: inline-block;
  padding: 0;
  margin-top: 10px;
}
.pagination li {
  display: inline;
  text-align: center;
}
.pagination a {
  float: left;
  display: block;
  font-size: 14px;
  text-decoration: none;
  padding: 5px 12px;
  margin-left: -1px;
  border: 1px solid transparent;
  line-height: 1.5;
}
.pagination a.active {
  cursor: default;
}
.pagination a:active {
}

.modal-1 li:first-child a {
  -moz-border-radius: 6px 0 0 6px;
  -webkit-border-radius: 6px;
  border-radius: 6px 0 0 6px;
}
.modal-1 li:last-child a {
  -moz-border-radius: 0 6px 6px 0;
  -webkit-border-radius: 0;
  border-radius: 0 6px 6px 0;
}
.modal-1 a {
  border-color: #ddd;
  color: #333;
  background: #fff;
}
.modal-1 a:hover {
  background: #eee;
}
.modal-1 a.active, .modal-1 a:active {
  border-color: #555;
  background: #555;
  color: #fff;
}
input[type=text] {
    width: 500px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    margin-top:25px;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
    width: 50%;
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


<form action="fuzzy" method=post>
  <input type="text" name="fuzzy" placeholder="��װ��������">
</form>

   <%! int total;  //�����Ա�����ܼ�¼�� 
 	 		int totalpage;   //�����Ա������ҳ�� 
 	 		int size=3;   //�����Ա����ÿҳ��¼��
 	 		int nowpage;   //�����Ա������ǰҳ��
 	 		int i; 
 	 		int remainder;  //�����Ա��������  %>
 	 	<% ArrayList<Equip> equips=(ArrayList)request.getAttribute("equips"); %>
   <div>
 	 	
 	 	
    <% if(equips!=null){
    
    	//��������books��Ϊ�գ����ʼ���ܼ�¼������ҳ��������
    	total=equips.size();  //�ܼ�¼�����ڽ����books�Ĵ�С
    	remainder=total%size;
    	totalpage = remainder==0 ? (total/size) : (total/size)+1 ; 
    	
    	//��ʼ����ǰҳΪ1��ȷ����һ�ε��ҳ���ʱ�򲻱�request��ָ�����
    	String strpage=request.getParameter("nowpage");
    	if(strpage==null){
    		nowpage=1;
    	}else{
    		nowpage=Integer.parseInt(strpage);  //����ȡ���ַ���ǰҳת��Ϊ���͵�ǰҳ �������Ӽ�����
    	}

    	
    	//ѭ����ArrayList������ȡ������
    	//�����ǰҳ�������һҳ ���� ��ǰҳ�����һҳ ��������Ϊ�� Ҳ�������һҳ�պ���װ��
    	if( (nowpage!=totalpage) ||( (nowpage==totalpage)&&(remainder==0) ) ) {
    		i=(nowpage-1)*size;
	    	while(i<nowpage*size){
	    		String id=equips.get(i).getEquip_id();
	    		String name=equips.get(i).getEquip_name();
	    		String shuxing=equips.get(i).getEquip_shuxing();
	    		String price=equips.get(i).getEquip_price();
	    		String describe=equips.get(i).getEquip_describe();
	    		String history=equips.get(i).getEquip_history();
	    		String type=equips.get(i).getEquip_type();
	    		String number=equips.get(i).getEquip_number();
	    		i++;
    	%>
    	  
<div class="columns">
  <ul class="price">
    <li class="header"><%=name %></li>
    <li class="grey"><%=type %></li>
    <li><%=shuxing %></li>
    <li><%=describe %></li>
    <li><%=history %></li>
    <li><%=number %>��</li>
    <li><%=price %>���</li>
    <li class="grey"> <a href="insertcart?name=<%=name%>&price=<%=price%>&number=<%=number%>&nowpage=<%=nowpage %>" class="button">���빺�ﳵ</a></li>
  </ul>
</div>
    
    <%		} //while
    	} // if
    	
    	//�����ǰҳ�����һҳ �� ���ܱ�װ��
    	else if( (nowpage==totalpage)&&(remainder!=0) ){
    		 i=(nowpage-1)*size;
	    	while(i<(nowpage-1)*size+remainder){
	    		String id=equips.get(i).getEquip_id();
	    		String name=equips.get(i).getEquip_name();
	    		String shuxing=equips.get(i).getEquip_shuxing();
	    		String price=equips.get(i).getEquip_price();
	    		String describe=equips.get(i).getEquip_describe();
	    		String history=equips.get(i).getEquip_history();
	    		String type=equips.get(i).getEquip_type();
	    		String number=equips.get(i).getEquip_number();
	    		i++;
    	%>
<div class="columns">
  <ul class="price">
    <li class="header"><%=name %></li>
    <li class="grey"><%=type %></li>
    <li><%=shuxing %></li>
    <li><%=describe %></li>
    <li><%=history %></li>
    <li><%=number %>��</li>
    <li><%=price %>���</li>
    <li class="grey"><a href="insertcart?name=<%=name%>&price=<%=price%>&nowpage=<%=nowpage %>" class="button">���빺�ﳵ</a></li>
  </ul>
</div>
    <%		} //while %>
   	<% 	 } //else if
   		 

    } // if(equips) %>
    <% String fuzzy=request.getParameter("fuzzy"); %>
    <% if(fuzzy==null) {fuzzy="notfuzzy";}%>
    <% if(!fuzzy.equals("fuzzy")){ %>
<ul class="pagination modal-1">
	<li><a <% if(nowpage>1){ %> href="equipshow?nowpage=<%=nowpage-1%>"  <% } %> class="prev">&laquo;</a>
	</li>
  <% for(int i=0;i<totalpage;i++){ %>
  <li> <a href=" equipshow?nowpage=<%=i+1 %> " <%  if(nowpage==i+1) { %> class= "active"<% } %> ><%=i+1 %></a></li>
  <% } %>
	<li><a <% if(nowpage<totalpage){ %> href="equipshow?nowpage=<%=nowpage+1%>"  <% } %> class="next">&raquo;</a>
</ul>
 <% } %>
 </div>
  </body>
</html>
