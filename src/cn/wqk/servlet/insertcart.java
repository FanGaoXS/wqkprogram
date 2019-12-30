package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wqk.datebase.Datebase;

public class insertcart extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		String name=new String( request.getParameter("name").getBytes("iso-8859-1") );  //×°±¸Ãû
		String price=request.getParameter("price");
		
		int unit_price=Integer.parseInt(price);
		int number=1;
		int total_price=unit_price*number;
		double real_pay=total_price*0.98;
		Datebase db=new Datebase();
		boolean sucess=db.insertcart(name, unit_price, total_price, real_pay);
		Datebase db2=new Datebase();
		if(sucess){
			int equip_number=Integer.parseInt(request.getParameter("number"))-1;
			db2.equipminus(name, equip_number);
		}else{
		}
		request.getRequestDispatcher("equipshow").forward(request, response);
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
