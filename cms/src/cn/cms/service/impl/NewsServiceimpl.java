package cn.cms.service.impl;

import java.util.List;

import cn.cms.dao.INewsDAO;
import cn.cms.dao.impl.NewsDAOImpl;
import cn.cms.entity.News;
import cn.cms.service.INewsService;

public class NewsServiceimpl implements INewsService{

	//����DAO��ʵ����Ķ���
	INewsDAO ID = new NewsDAOImpl();
	
	@Override
	public List<News> findAll() {
		//����DAO���еĽ��������
		return ID.findAllResultSet();
	}

	
	
	
	
}
