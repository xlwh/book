package cn.itcast.service.uploadfile;

import java.util.List;

import cn.itcast.bean.uploadfile.UploadFile;
import cn.itcast.service.base.DAO;


public interface UploadFileService extends DAO<UploadFile> {
	/**
	 * ��ȡ�ļ�·��
	 * @param ids
	 * @return
	 */
	public List<String> getFilepath(Integer[] ids);
}
