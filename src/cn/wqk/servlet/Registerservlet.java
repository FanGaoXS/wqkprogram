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
		
		
		//���ݱ���������Ψһ��Լ�����������ʧ�ܾʹ����û����ظ�
		if(sucess){
			out.print("<script language='JavaScript'>alert('ע��ɹ�');location.href='index.jsp';</script>");
		}else{
			out.print("<script language='JavaScript'>alert('ע��ʧ�ܣ������û����Ƿ��ظ�');location.href='register.jsp';</script>");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
