package cn.wqk.dbinterface;

import java.util.ArrayList;

import cn.wqk.bean.Cart;
import cn.wqk.bean.Equip;
import cn.wqk.bean.Order;
import cn.wqk.bean.User;

public interface datebaseinterface {
	public ArrayList<Equip> equipshow(); //����װ����ʾ
	public boolean equipminus(String name,int equip_number);  //���£����٣�װ����棨����װ������
	public boolean insertcart(String name,int unit_price,int total_price,double real_pay);  //���ﳵ��Ĳ���
	public ArrayList<Cart> showcart();  //��ʾ���ﳵ��
	public boolean deletecart(int id);  //ɾ�����ﳵ��������
	public User showinfo(String username);  //��ʾ������Ϣ��
	public boolean userinsert(String username,String password);  //�������û���ע�ᣩ
	public String userpassword(String username);  //��ȡ�û����� �����ڵ�¼���бȶ�
	public boolean updateinfo(String username,String password,String name,String sex,String intro,String address);//�޸��û���Ϣ
	public ArrayList<Order> showorder(String username);  //��ʾ���������û�����
	public boolean insertorder(String username,String name,String address,String real_pay);  //���붩��������������
	public boolean clearcart();  //��չ��ﳵ
	public ArrayList<Equip> fuzzy(String equip_name);  //ģ����ѯ������װ����
	public ArrayList<User> showuser();  //չʾȫ���û���Ϣ
	public ArrayList<Order> allorder(); //չʾ���ж���
	public boolean deleteorder(String id); //ɾ������������id��
	public boolean sendequip(String id);
}
