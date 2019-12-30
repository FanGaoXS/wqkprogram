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
	
	//构造方法
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
		
	//装备表全部查询
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
	
	//更新（减少）装备库存（根据装备名）
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
	
	
	//购物车表插入操作
	public boolean insertcart(String name,int unit_price,int total_price,double real_pay){
		//初始sucess值为false
				boolean sucess = false;
				try {
					pstm=con.prepareStatement("insert into equipcart (name,unit_price,total_price,real_pay) values(?,?,?,?)");
					pstm.setString(1,name);
					pstm.setInt(2,unit_price);
					pstm.setInt(3,total_price);
					pstm.setDouble(4,real_pay);
					int temp=pstm.executeUpdate();
					//执行成功后temp会返回一个值，这个值不为零
					if(temp!=0){sucess=true;}//temp则执行成功，赋true给sucess
				    con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return sucess;
	}
	
	//查看购物车
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
	
	
	//购物车里的装备删除（根据装备名清空）
	public boolean deletecart(int id){
		boolean sucess = false;
		try {
			pstm=con.prepareStatement("delete from equipcart where id=?");
			pstm.setInt(1,id);
			//预处理语句装结果集
			int temp=pstm.executeUpdate();
			if(temp!=0){sucess=true;}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sucess;
	}
	
	//个人信息表全部查看
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
	
	//用户表查看（按用户名）
	public User showinfo(String username){
		User user = new User();
		try {
			pstm=con.prepareStatement("select * from user where username=?");
			pstm.setString(1,username);
			//预处理语句装结果集
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
	
	//用户表插入操作
		public boolean userinsert(String username,String password){
			//初始sucess值为false
			boolean sucess = false;
			try {
				pstm=con.prepareStatement("insert into user (username,password) values(?,?)");
				pstm.setString(1,username);
				pstm.setString(2,password);
				int temp=pstm.executeUpdate();
				//执行成功后temp会返回一个值，这个值不为零
				if(temp!=0){sucess=true;}//temp则执行成功，赋true给sucess
			    con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
		
		//用户表查询密码 （用用户名查）
		public String userpassword(String username){
			String password = null;
			try {
				pstm=con.prepareStatement("select password from user where username=?");
				pstm.setString(1,username);
				//预处理语句装结果集
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
		
		//用户表更新
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
		
		//订单表查看（按用户名）
		public ArrayList<Order> showorder(String username){
			ArrayList<Order> orders=new ArrayList<Order>();
			try {
				pstm=con.prepareStatement("select * from bill where username=?");
				pstm.setString(1,username);
				//预处理语句装结果集
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
		
		//插入订单表
		public boolean insertorder(String username,String name,String address,String real_pay){
			//初始sucess值为false
			boolean sucess = false;
			try {
				pstm=con.prepareStatement("insert into bill (username,name,address,real_pay,issend) values(?,?,?,?,?)");
				pstm.setString(1,username);
				pstm.setString(2,name);
				pstm.setString(3,address);
				pstm.setString(4,real_pay);
				pstm.setString(5, "未发货");
				int temp=pstm.executeUpdate();
				//执行成功后temp会返回一个值，这个值不为零
				if(temp!=0){sucess=true;}//temp则执行成功，赋true给sucess
			    con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
		
		
		//清空购物车（根据用户名删除）
		public boolean clearcart(){
			boolean sucess=false;
			try {
				pstm=con.prepareStatement("delete from equipcart");
				int temp=pstm.executeUpdate();
				if(temp!=0){sucess=true;}//temp则执行成功，赋true给sucess
			    con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sucess;
		}
		
		//查询装备（根据装备名）模糊查询
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
		
		//展示全部用户信息
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
		
		//删除用户(根据用户名)
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
		
		
		//展示所有订单
		public ArrayList<Order> allorder(){
			ArrayList<Order> orders=new ArrayList<Order>();
			try {
				pstm=con.prepareStatement("select * from bill");
				//预处理语句装结果集
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
		
		
		//删除订单（根据订单号）
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
		
		//发货
		public boolean sendequip(String id){
			boolean sucess=false;
			try {
				pstm=con.prepareStatement("update bill set issend=? where id=?");
				pstm.setString(1, "已发货");
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
