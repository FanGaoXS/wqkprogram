package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wqk.datebase.Datebase;

public class Filterservlet extends HttpServlet implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		HttpSession session=((HttpServletRequest)request).getSession();
		String username=(String) session.getAttribute("username");
		if(username!=null){
			chain.doFilter(request, response);
		}else{
			out.print("<script language='JavaScript'>alert('∑√Œ  ß∞‹£¨«Îµ«¬º');window.location.href='../index.jsp';</script>");
		}
		out.flush();
		out.close();
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
