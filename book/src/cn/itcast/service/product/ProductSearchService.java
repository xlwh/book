package cn.itcast.service.product;

import cn.itcast.bean.QueryResult;
import cn.itcast.bean.product.ProductInfo;

public interface ProductSearchService {
	/**
	 * ������Ʒ
	 * @param keyword �ؼ���
	 * @param firstResult ��ʼ����
	 * @param maxResult ÿҳ��ȡ�ļ�¼��
	 * @return
	 */
	public QueryResult<ProductInfo> query(String keyword, int firstResult, int maxResult);

}