package cn.itcast.service.book;

import cn.itcast.bean.book.OrderItem;
import cn.itcast.service.base.DAO;

public interface OrderItemService extends DAO<OrderItem> {
	/**
	 * ������Ʒ��������
	 * @param itemid ������
	 * @param amount ��������
	 */
	public void updateAmount(Integer itemid, int amount);
}
