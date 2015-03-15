package cn.itcast.service.product;

import java.util.List;

import cn.itcast.bean.product.ProductType;
import cn.itcast.service.base.DAO;


public interface ProductTypeService extends DAO<ProductType> {
	/**
	 * ��ȡ������id
	 * @param parentids ����id����
	 * @return
	 */
	public List<Integer> getSubTypeid(Integer[] parentids);
}