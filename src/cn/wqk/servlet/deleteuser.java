package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wqk.datebase.Datebase;

public class deleteuser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String username=new String(request.getParameter("username"));
		Datebase db=new Datebase();
		boolean sucess=db.deleteuser(username);
		if(sucess){
			out.print("<script language='JavaScript'>alert('ɾ���ɹ�');location.href='showuser';</script>");
		}else{
			out.print("<script language='JavaScript'>alert('ɾ��ʧ��');location.href='showuser';</script>");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
