package cn.cms.service;

import java.util.List;

import cn.cms.entity.News;

public interface INewsService {

	/**
	 * ��ȡͼ�鼯�Ϸ���
	 * @return
	 */
	List<News> findAll();
	
	
}
