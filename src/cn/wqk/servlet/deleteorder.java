package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wqk.datebase.Datebase;

public class deleteorder extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		Datebase db=new Datebase();
		boolean sucess=db.deleteorder(id);
		if(sucess){
			out.print("<script language='JavaScript'>alert('É¾³ý³É¹¦');location.href='allorder';</script>");
		}else{
			out.print("<script language='JavaScript'>alert('É¾³ýÊ§°Ü');location.href='allorder';</script>");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
