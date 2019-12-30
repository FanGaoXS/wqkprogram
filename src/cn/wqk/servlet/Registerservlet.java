package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wqk.datebase.Datebase;

public class Registerservlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Datebase db=new Datebase();
		boolean sucess=db.userinsert(username, password);
		
		
		//数据表里设置了唯一性约束，如果插入失败就代表用户名重复
		if(sucess){
			out.print("<script language='JavaScript'>alert('注册成功');location.href='index.jsp';</script>");
		}else{
			out.print("<script language='JavaScript'>alert('注册失败，请检查用户名是否重复');location.href='register.jsp';</script>");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
