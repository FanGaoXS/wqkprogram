package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wqk.bean.User;
import cn.wqk.datebase.Datebase;

public class settle extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		HttpSession session=((HttpServletRequest)request).getSession();
			
		Datebase db=new Datebase();
		String username=(String) session.getAttribute("username");
		User user=db.showinfo(username);//根据username查询用户表的到结果
		
		String name=user.getName();
		String address=user.getAddress();
		
		System.out.print(name);
		if((name!=""&&name!=null&&!name.equals(""))&&(address!=""&&address!=null&&!address.equals(""))){
			String size=request.getParameter("size");
			if(!size.equals("0")){
				String real_pay=request.getParameter("sum"); //得到jsp页面传参的实际付款
				Datebase db2=new Datebase();
				boolean sucess=db2.insertorder(username, name, address, real_pay);
				if(sucess){
					//清空购物车
					Datebase db3=new Datebase();
					db3.clearcart();
					out.print("<script language='JavaScript'>alert('结算成功，祝你购物愉快');location.href='equipshow';</script>");
				}else{
					out.print("<script language='JavaScript'>alert('结算失败，请联系管理员');location.href='showcart';</script>");
				}
			}else{
				out.print("<script language='JavaScript'>alert('结算失败，你好像还没有购买商品');location.href='equipshow';</script>");
			}
		}else{
			out.print("<script language='JavaScript'>alert('结算失败，你还没有完善个人信息');location.href='showinfo';</script>");
		}
			
			
			
			
			
			
		
		
		
		
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
