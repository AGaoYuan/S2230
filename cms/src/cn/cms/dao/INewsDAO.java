package cn.cms.dao;

import java.util.List;

import cn.cms.entity.News;

/**
 * �鼮�ӿ�
 * @author 21600
 *
 */
public interface INewsDAO {
	/**
	 * �����鼮����
	 * @return �����鼮���󼯺�
	 */
	List<News> findAllResultSet();
	
	
	
}
