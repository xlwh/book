package cn.itcast.service.book;

import cn.itcast.bean.book.GeneratedOrderid;
import cn.itcast.service.base.DAO;

public interface GeneratedOrderidService extends DAO<GeneratedOrderid> {
	/**
	 * ���ɶ�����ˮ��
	 * @return
	 */
	public int buildOrderid();
	/**
	 * ��ʼ��
	 */
	public void init();
}
