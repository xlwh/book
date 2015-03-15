package cn.itcast.service.user;

import java.io.Serializable;

import cn.itcast.bean.user.Buyer;
import cn.itcast.service.base.DAO;


public interface BuyerService extends DAO<Buyer>{
	/**
	 * ����ָ���û�
	 * @param usernames
	 */
	public void enable(Serializable ... usernames);
	/**
	 * �ж��û��Ƿ����
	 * @param username
	 * @return
	 */
	public boolean exsit(String username);
	/**
	 * �ж��û����������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean checkUser(String username, String password);
	
	/**
	 * ��������
	 * @param username �û���
	 * @param newpassword ������
	 */
	public void updatePassword(String username, String newpassword);
}