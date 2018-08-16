package cn.news.service;

import java.util.List;

import cn.news.entity.NewsInfo;
import cn.news.entity.UserInfo;

public interface INewsInfoService {
	
	//��ѯ�������ŵķ���
	public List<NewsInfo> findAll(NewsInfo newsInfo) throws Exception;
	
	//0.2��ѯ�ض�����
	public NewsInfo getNews(int id) throws Exception;
	
	//0.3�޸���������
	public boolean updateNews(NewsInfo newsInfo)throws Exception;
	
	//0.4ɾ���û�
	public boolean delete(String uid)throws Exception;
	
	//0.5����û�
	public boolean save(NewsInfo userInfo)throws Exception;
	
	//����һ��ֻ��ȡ��ҳ���ݵķ���
	public List<NewsInfo> getOnePageData(int pageIndex,int pageSize) throws Exception;
	
	//��ȡ�ܼ�¼��
	public int getTotalNews() throws Exception;
	
	
}
