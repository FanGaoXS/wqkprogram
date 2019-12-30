package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wqk.datebase.Datebase;

public class deletecart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		Datebase db=new Datebase();
		boolean sucess=db.deletecart(id);
		if(sucess){
			out.print("<script language='JavaScript'>alert('删除成功');location.href='showcart';</script>");
		}else{
			out.print("<script language='JavaScript'>alert('删除失败，请联系管理员');location.href='showcart';</script>");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
