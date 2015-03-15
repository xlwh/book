package cn.itcast.service.book;

import cn.itcast.bean.BuyCart;
import cn.itcast.bean.book.DeliverWay;
import cn.itcast.bean.book.Order;
import cn.itcast.bean.book.PaymentWay;
import cn.itcast.service.base.DAO;

public interface OrderService extends DAO<Order> {
	/**
	 * ��������
	 * @param orderids ������
	 */
	public void unlock(String... orderids);
	/**
	 * ��������
	 * @param orderid ������
	 * @param username �����û�
	 * @return
	 */
	public Order addLock(String orderid, String username);
	/**
	 * �Ѷ���תΪ���ջ�״̬
	 * @param orderid ������
	 */
	public void turnReceived(String orderid);
	/**
	 * �Ѷ���תΪ�ѷ���״̬
	 * @param orderid ������
	 */
	public void turnDelivered(String orderid);
	/**
	 * �Ѷ���תΪ�ȴ�����״̬
	 * @param orderid ������
	 */
	public void turnWaitdeliver(String orderid);
	
	/**
	 * ����ȷ���Ѹ���
	 * @param orderid ������
	 */
	public void confirmPayment(String orderid);
	/**
	 * ���ͨ������
	 * @param orderid ������
	 */
	public void confirmOrder(String orderid);
	/**
	 * ȡ������
	 * @param orderid ������
	 */
	public void cannelOrder(String orderid);
	/**
	 * ���ɶ���
	 * @param buyCart ���ﳵ
	 * @param username �û���
	 * @return
	 */
	public Order createOrder(BuyCart buyCart, String username);
	/**
	 * ����֧����ʽ
	 * @param orderid ������
	 * @param paymentWay ֧����ʽ
	 */
	public void updatePaymentWay(String orderid, PaymentWay paymentWay);
	/**
	 * �������ͷ�ʽ
	 * @param orderid ������
	 * @param deliverWay ���ͷ�ʽ
	 */
	public void updateDeliverWay(String orderid, DeliverWay deliverWay);
	/**
	 * �������ͷ�
	 * @param orderid ������
	 * @param deliverFee ���ͷ�
	 */
	public void updateDeliverFee(String orderid, float deliverFee);
}
