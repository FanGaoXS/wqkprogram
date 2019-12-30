package cn.wqk.datebase;

import java.sql.*;
import java.util.ArrayList;

import cn.wqk.bean.*;
import cn.wqk.dbinterface.datebaseinterface;

public class Datebase implements datebaseinterface{
	Connection con;
	Statement sql;
	ResultSet rs;
	PreparedStatement pstm;
	
	//���췽��
	public Datebase(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wqk?user=root&password=&characterEncoding=gb2312");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	//װ����ȫ����ѯ
	public ArrayList<Equip> equipshow(){
		ArrayList<Equip> equips=new ArrayList<Equip>();
		try {
			sql=con.createStatement();
			rs=sql.executeQuery("select * from equipments");
			while(rs.next()){
				Equip equip=new Equip();
				equip.setEquip_id(rs.getString("equip_id"));
				equip.setEquip_name(rs.getString("equip_name"));
				equip.setEquip_shuxing(rs.getString("equip_shuxing"));
				equip.setEquip_price(rs.getString("equip_price"));
				equip.setEquip_describe(rs.getString("equip_describe"));
				equip.setEquip_history(rs.getString("equip_history"));
				equip.setEquip_type(rs.getString("equip_type"));
				equip.setEquip_number(rs.getString("equip_number"));
				equips.add(equip);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equips;
	}
	
	//���£����٣�װ����棨����װ������
	public boolean equipminus(String name,int equip_number){
		boolean sucess = false;
		try {
			pstm=con.prepareStatement("update equipments set equip_number=? where equip_name=?");
			pstm.setInt(1, equip_number);
			pstm.setString(2, name);
			int temp=pstm.executeUpdate();
			if(temp!=0){sucess=true;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sucess;
	}
	
	
	//���ﳵ��������
	public boolean insertcart(String name,int unit_price,int total_price,double real_pay){
		//��ʼsucessֵΪfalse
				boolean sucess = false;
				try {
					pstm=con.prepareStatement("insert into equipcart (name,unit_price,total_price,real_pay) values(?,?,?,?)");
					pstm.setString(1,name);
					pstm.setInt(2,unit_price);
					pstm.setInt(3,total_price);
					pstm.setDouble(4,real_pay);
					int temp=pstm.executeUpdate();
					//ִ�гɹ���temp�᷵��һ��ֵ�����ֵ��Ϊ��
					if(temp!=0){sucess=true;}//temp��ִ�гɹ�����true��sucess
				    con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return sucess;
	}
	
	//�鿴���ﳵ
	public ArrayList<Cart> showcart(){
		ArrayList<Cart> carts=new ArrayList<Cart>();
		try {
			pstm=con.prepareStatement("select * from equipcart");
			rs=pstm.executeQuery();
			while(rs.next()){
				Cart cart=new Cart();
				cart.setId(rs.getInt("id"));
				cart.setName(rs.getString("name"));
				cart.setUnit_price(rs.getString("unit_price"));
				cart.setTotal_price(rs.getString("total_price"));
				cart.setReal_pay(rs.getString("real_pay"));
				carts.add(cart);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carts;
	}
	
	
	//���ﳵ���װ��ɾ��������װ������գ�
	public boolean deletecart(int id){
		boolean sucess = false;
		try {
			pstm=con.prepareStatement("delete from equipcart where id=?");
			pstm.setInt(1,id);
			//Ԥ�������װ�����
			int temp=pstm.executeUpdate();
			if(temp!=0){sucess=true;}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sucess;
	}
	
	//������Ϣ��ȫ���鿴
	/*
	public ArrayList<User> showinfo(){
		ArrayList<User> users=new ArrayList<User>();
		try {
			sql=con.createStatement();
			rs=sql.executeQuery("select * from user");
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setIntro(rs.getString("intro"));
				user.setAddress(rs.getString("address"));
				users.add(user);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	*/
	
	//�û���鿴�����û�����
	public User showinfo(String username){
		User user = new User();
		try {
			pstm=con.prepareStatement("select * from user where username=?");
			pstm.setString(1,username);
			//Ԥ�������װ�����
			rs=pstm.executeQuery();
			rs.next();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setIntro(rs.getString("intro"));
			user.setAddress(rs.getString("address"));
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	//�û���������
		public boolean userinsert(String username,String password){
			//��ʼsucessֵΪfalse
			boolean sucess = false;
			try {
				pstm=con.prepareStatement("insert into user (username,password) values(?,?)");
				pstm.setString(1,username);
				pstm.setString(2,password);
				int temp=pstm.executeUpdate();
				//ִ�гɹ���temp�᷵��һ��ֵ�����ֵ��Ϊ��
				if(temp!=0){sucess=true;}//temp��ִ�гɹ�����true��sucess
			    con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
		
		//�û����ѯ���� �����û����飩
		public String userpassword(String username){
			String password = null;
			try {
				pstm=con.prepareStatement("select password from user where username=?");
				pstm.setString(1,username);
				//Ԥ�������װ�����
				rs=pstm.executeQuery();
				rs.next();
				password=rs.getString(1);
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return password;
		}
		
		//�û������
		public boolean updateinfo(String username,String password,String name,String sex,String intro,String address){
			boolean sucess=false;
			try {
				pstm=con.prepareStatement("update user set password=?,name=?,sex=?,intro=?,address=? where username=?");
				pstm.setString(1, password);
				pstm.setString(2, name);
				pstm.setString(3, sex);
				pstm.setString(4, intro);
				pstm.setString(5, address);
				pstm.setString(6, username);
				int temp=pstm.executeUpdate();
				if(temp!=0){sucess=true;}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
		
		//������鿴�����û�����
		public ArrayList<Order> showorder(String username){
			ArrayList<Order> orders=new ArrayList<Order>();
			try {
				pstm=con.prepareStatement("select * from bill where username=?");
				pstm.setString(1,username);
				//Ԥ�������װ�����
				rs=pstm.executeQuery();
				while(rs.next()){
					Order order=new Order();
					order.setId(rs.getString("id"));
					order.setUsername(rs.getString("username"));
					order.setName(rs.getString("name"));
					order.setAddress(rs.getString("address"));
					order.setReal_pay(rs.getString("real_pay"));
					order.setIssend(rs.getString("issend"));
					orders.add(order);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return orders;
		}
		
		//���붩����
		public boolean insertorder(String username,String name,String address,String real_pay){
			//��ʼsucessֵΪfalse
			boolean sucess = false;
			try {
				pstm=con.prepareStatement("insert into bill (username,name,address,real_pay,issend) values(?,?,?,?,?)");
				pstm.setString(1,username);
				pstm.setString(2,name);
				pstm.setString(3,address);
				pstm.setString(4,real_pay);
				pstm.setString(5, "δ����");
				int temp=pstm.executeUpdate();
				//ִ�гɹ���temp�᷵��һ��ֵ�����ֵ��Ϊ��
				if(temp!=0){sucess=true;}//temp��ִ�гɹ�����true��sucess
			    con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
		
		
		//��չ��ﳵ�������û���ɾ����
		public boolean clearcart(){
			boolean sucess=false;
			try {
				pstm=con.prepareStatement("delete from equipcart");
				int temp=pstm.executeUpdate();
				if(temp!=0){sucess=true;}//temp��ִ�гɹ�����true��sucess
			    con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
		
		//��ѯװ��������װ������ģ����ѯ
		public ArrayList<Equip> fuzzy(String equip_name){
			ArrayList<Equip> equips=new ArrayList<Equip>();
			try {
				pstm=con.prepareStatement("select * from equipments where equip_name like ? ");
				pstm.setString(1,"%"+equip_name+"%");
				rs=pstm.executeQuery();
				while(rs.next()){
					Equip equip=new Equip();
					equip.setEquip_id(rs.getString("equip_id"));
					equip.setEquip_name(rs.getString("equip_name"));
					equip.setEquip_shuxing(rs.getString("equip_shuxing"));
					equip.setEquip_price(rs.getString("equip_price"));
					equip.setEquip_describe(rs.getString("equip_describe"));
					equip.setEquip_history(rs.getString("equip_history"));
					equip.setEquip_type(rs.getString("equip_type"));
					equip.setEquip_number(rs.getString("equip_number"));
					equips.add(equip);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return equips;
		}
		
		//չʾȫ���û���Ϣ
		public ArrayList<User> showuser(){
			ArrayList<User> users=new ArrayList<User>();
			try {
				sql=con.createStatement();
				rs=sql.executeQuery("select * from user");
				while(rs.next()){
					User user=new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setSex(rs.getString("sex"));
					user.setIntro(rs.getString("intro"));
					user.setAddress(rs.getString("address"));
					users.add(user);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return users;
		}
		
		//ɾ���û�(�����û���)
		public boolean deleteuser(String username){
			boolean sucess=false;
			try {
				pstm=con.prepareStatement("delete from user where username=?");
				pstm.setString(1, username);
				int temp=pstm.executeUpdate();
				if(temp!=0){sucess=true;}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
		
		
		//չʾ���ж���
		public ArrayList<Order> allorder(){
			ArrayList<Order> orders=new ArrayList<Order>();
			try {
				pstm=con.prepareStatement("select * from bill");
				//Ԥ�������װ�����
				rs=pstm.executeQuery();
				while(rs.next()){
					Order order=new Order();
					order.setId(rs.getString("id"));
					order.setUsername(rs.getString("username"));
					order.setName(rs.getString("name"));
					order.setAddress(rs.getString("address"));
					order.setReal_pay(rs.getString("real_pay"));
					order.setIssend(rs.getString("issend"));
					orders.add(order);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return orders;
		}
		
		
		//ɾ�����������ݶ����ţ�
		public boolean deleteorder(String id){
			boolean sucess=false;
			try {
				pstm=con.prepareStatement("delete from bill where id=?");
				pstm.setString(1, id);
				int temp=pstm.executeUpdate();
				if(temp!=0){sucess=true;}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
		
		//����
		public boolean sendequip(String id){
			boolean sucess=false;
			try {
				pstm=con.prepareStatement("update bill set issend=? where id=?");
				pstm.setString(1, "�ѷ���");
				pstm.setString(2, id);
				int temp=pstm.executeUpdate();
				if(temp!=0){sucess=true;}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
}
