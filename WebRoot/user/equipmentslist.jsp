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
  <a class="active" href="equipshow">浏览商品</a>
  <a href="showcart">查看我的购物车</a>
  <a href="showinfo">查看我的个人信息</a>
  <a href="showorder">查看我的订单</a>
  <a href="exituser">退出登录</a>
</div>


<form action="fuzzy" method=post>
  <input type="text" name="fuzzy" placeholder="按装备名搜索">
</form>

   <%! int total;  //定义成员变量总记录数 
 	 		int totalpage;   //定义成员变量总页数 
 	 		int size=3;   //定义成员变量每页记录数
 	 		int nowpage;   //定义成员变量当前页数
 	 		int i; 
 	 		int remainder;  //定义成员变量余数  %>
 	 	<% ArrayList<Equip> equips=(ArrayList)request.getAttribute("equips"); %>
   <div>
 	 	
 	 	
    <% if(equips!=null){
    
    	//如果结果集books不为空，则初始化总记录数、总页数和余数
    	total=equips.size();  //总记录数等于结果集books的大小
    	remainder=total%size;
    	totalpage = remainder==0 ? (total/size) : (total/size)+1 ; 
    	
    	//初始化当前页为1，确保第一次点进页面的时候不报request空指针错误
    	String strpage=request.getParameter("nowpage");
    	if(strpage==null){
    		nowpage=1;
    	}else{
    		nowpage=Integer.parseInt(strpage);  //将获取的字符当前页转换为整型当前页 方便后面加减运算
    	}

    	
    	//循环从ArrayList集合里取出数据
    	//如果当前页不是最后一页 或者 当前页是最后一页 但是余数为零 也就是最后一页刚好能装满
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
    <li><%=number %>件</li>
    <li><%=price %>金币</li>
    <li class="grey"> <a href="insertcart?name=<%=name%>&price=<%=price%>&number=<%=number%>&nowpage=<%=nowpage %>" class="button">加入购物车</a></li>
  </ul>
</div>
    
    <%		} //while
    	} // if
    	
    	//如果当前页是最后一页 且 不能被装满
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
    <li><%=number %>件</li>
    <li><%=price %>金币</li>
    <li class="grey"><a href="insertcart?name=<%=name%>&price=<%=price%>&nowpage=<%=nowpage %>" class="button">加入购物车</a></li>
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
