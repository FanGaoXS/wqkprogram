package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wqk.bean.Equip;
import cn.wqk.datebase.Datebase;

public class fuzzy extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String equip_name=new String( request.getParameter("fuzzy").getBytes("iso-8859-1") );
		Datebase db=new Datebase();
		ArrayList<Equip> equips=db.fuzzy(equip_name);
		if(equips!=null){
			request.setAttribute("equips", equips);
			request.getRequestDispatcher("user/equipmentslist.jsp?fuzzy=fuzzy").forward(request, response);
		}else{
			response.sendRedirect("equipshow");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
