package cn.itcast.service.product;

import cn.itcast.bean.product.ProductStyle;
import cn.itcast.service.base.DAO;


public interface ProductStyleService extends DAO<ProductStyle> {
	/**
	 * ���ø���ʽ�Ĳ�Ʒ�Ƿ��ϼ�
	 * @param productstyleids ��Ʒid����
	 * @param statu trueΪ�ϼ�,falseΪ�¼�
	 */
	public void setVisibleStatu(Integer[] productstyleids, boolean statu);
}
