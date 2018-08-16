package cn.news.service;

import java.util.List;

import cn.news.entity.Category;

public interface ICategoryService {
	
	//0.1��ѯ�����б�
	public List<Category> findAlls() throws Exception;
	
	//0.2��ѯ�ض�����
	public Category getCate(int id) throws Exception;
	
	//0.3�޸���������
	public boolean updateCate(Category category)throws Exception;
	
	//0.4ɾ���û�
	public boolean delete(String cid)throws Exception;
	
	//0.5����û�
	public boolean save(Category category)throws Exception;
	
	//����һ��ֻ��ȡ��ҳ���ݵķ���
	public List<Category> getOnePageData(int pageIndex,int pageSize) throws Exception;
	
	//��ȡ�ܼ�¼��
	public int getTotalCate() throws Exception;
	
	
	
}
