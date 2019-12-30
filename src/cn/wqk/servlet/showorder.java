package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wqk.bean.Order;
import cn.wqk.datebase.Datebase;

public class showorder extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		
		HttpSession session=((HttpServletRequest)request).getSession();
		String username=(String) session.getAttribute("username");
		Datebase db=new Datebase();
		ArrayList<Order> orders=db.showorder(username);
		request.setAttribute("orders", orders);
		
		
		request.getRequestDispatcher("user/showorder.jsp").forward(request, response);
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
