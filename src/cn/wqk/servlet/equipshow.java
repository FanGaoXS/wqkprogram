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

public class equipshow extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");		
		Datebase db=new Datebase();
		ArrayList<Equip> equips=db.equipshow();
		request.setAttribute("equips", equips);		
		request.getRequestDispatcher("user/equipmentslist.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
