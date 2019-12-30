package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wqk.datebase.Datebase;

public class Loginservlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//管理员登录
		if(username.equals("admin")&&password.equals("admin")){
			HttpSession session=((HttpServletRequest)request).getSession();
			session.setAttribute("admin", "admin");
			response.sendRedirect("showuser"); 
		}else/*不是管理员*/{
			Datebase db=new Datebase();
			String dbpassword=db.userpassword(username); //根据用户名从数据库里读出一个密码
			if(password.equals(dbpassword)){ //如果读出的密码与接收到的密码一样就成功
				HttpSession session=((HttpServletRequest)request).getSession();
				session.setAttribute("username",username);
				response.sendRedirect("equipshow"); 
			}else{
				out.print("<script language='JavaScript'>alert('登录失败，请注册');location.href='register.jsp';</script>");
			}
		}

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request,response);
	}

}
