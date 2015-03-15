package cn.itcast.service.privilege;

import java.util.List;

import cn.itcast.bean.privilege.SystemPrivilege;
import cn.itcast.service.base.DAO;

public interface SystemPrivilegeService extends DAO<SystemPrivilege> {
	/**
	 * ��������ϵͳȨ��
	 * @param privileges
	 */
	public void batchSave(List<SystemPrivilege> privileges);
}
