package cn.wqk.dbinterface;

import java.util.ArrayList;

import cn.wqk.bean.Cart;
import cn.wqk.bean.Equip;
import cn.wqk.bean.Order;
import cn.wqk.bean.User;

public interface datebaseinterface {
	public ArrayList<Equip> equipshow(); //所有装备显示
	public boolean equipminus(String name,int equip_number);  //更新（减少）装备库存（根据装备名）
	public boolean insertcart(String name,int unit_price,int total_price,double real_pay);  //购物车表的插入
	public ArrayList<Cart> showcart();  //显示购物车表
	public boolean deletecart(int id);  //删除购物车单条数据
	public User showinfo(String username);  //显示个人信息表
	public boolean userinsert(String username,String password);  //插入新用户（注册）
	public String userpassword(String username);  //获取用户密码 ，用于登录进行比对
	public boolean updateinfo(String username,String password,String name,String sex,String intro,String address);//修改用户信息
	public ArrayList<Order> showorder(String username);  //显示订单表（按用户名）
	public boolean insertorder(String username,String name,String address,String real_pay);  //插入订单（新增订单）
	public boolean clearcart();  //清空购物车
	public ArrayList<Equip> fuzzy(String equip_name);  //模糊查询，按照装备名
	public ArrayList<User> showuser();  //展示全部用户信息
	public ArrayList<Order> allorder(); //展示所有订单
	public boolean deleteorder(String id); //删除订单（根据id）
	public boolean sendequip(String id);
}
