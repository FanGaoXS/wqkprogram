package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wqk.bean.Cart;
import cn.wqk.bean.User;
import cn.wqk.datebase.Datebase;

public class showinfo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		
		HttpSession session=((HttpServletRequest)request).getSession();
		String username=(String) session.getAttribute("username");
		Datebase db=new Datebase();
		User user=db.showinfo(username);
		request.setAttribute("user", user);
		
		
		
		request.getRequestDispatcher("user/showinfo.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
