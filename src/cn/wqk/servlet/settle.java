package cn.wqk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wqk.bean.User;
import cn.wqk.datebase.Datebase;

public class settle extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		HttpSession session=((HttpServletRequest)request).getSession();
			
		Datebase db=new Datebase();
		String username=(String) session.getAttribute("username");
		User user=db.showinfo(username);//����username��ѯ�û���ĵ����
		
		String name=user.getName();
		String address=user.getAddress();
		
		System.out.print(name);
		if((name!=""&&name!=null&&!name.equals(""))&&(address!=""&&address!=null&&!address.equals(""))){
			String size=request.getParameter("size");
			if(!size.equals("0")){
				String real_pay=request.getParameter("sum"); //�õ�jspҳ�洫�ε�ʵ�ʸ���
				Datebase db2=new Datebase();
				boolean sucess=db2.insertorder(username, name, address, real_pay);
				if(sucess){
					//��չ��ﳵ
					Datebase db3=new Datebase();
					db3.clearcart();
					out.print("<script language='JavaScript'>alert('����ɹ���ף�㹺�����');location.href='equipshow';</script>");
				}else{
					out.print("<script language='JavaScript'>alert('����ʧ�ܣ�����ϵ����Ա');location.href='showcart';</script>");
				}
			}else{
				out.print("<script language='JavaScript'>alert('����ʧ�ܣ������û�й�����Ʒ');location.href='equipshow';</script>");
			}
		}else{
			out.print("<script language='JavaScript'>alert('����ʧ�ܣ��㻹û�����Ƹ�����Ϣ');location.href='showinfo';</script>");
		}
			
			
			
			
			
			
		
		
		
		
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
