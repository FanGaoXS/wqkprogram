package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wqk.datebase.Datebase;

public class updateinfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=new String( request.getParameter("name").getBytes("iso-8859-1") );
		String sex=new String( request.getParameter("sex").getBytes("iso-8859-1") );
		String intro=new String( request.getParameter("intro").getBytes("iso-8859-1") );
		String address=new String( request.getParameter("address").getBytes("iso-8859-1") );
		
		Datebase db=new Datebase();
		boolean sucess=db.updateinfo(username,password,name,sex,intro,address);
		if(sucess){
			out.print("<script language='JavaScript'>alert('个人信息已完善');location.href='equipshow';</script>");
		}else{
			out.print("<script language='JavaScript'>alert('修改失败，请联系管理员');location.href='showinfo';</script>");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
