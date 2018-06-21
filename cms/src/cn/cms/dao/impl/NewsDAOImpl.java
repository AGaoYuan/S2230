package cn.cms.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.cms.dao.BaseDao;
import cn.cms.dao.INewsDAO;
import cn.cms.entity.News;

/**
 * ʵ���鼮�ӿڵ���
 * @author 21600
 *
 */
public class NewsDAOImpl extends BaseDao implements INewsDAO{

	/**
	 * ��дINewsDAO�ӿ��еķ���
	 * ������News���ͼ���
	 */
	@Override
	public List<News> findAllResultSet() {
		List<News> list =new ArrayList<News>();
		try {
			String sql = "select * from News";
			//����BaseDAO�з��ؽ������������ִ��SQL
			ResultSet rs = super.getResultSet(sql);
			if (rs!=null) {
				while(rs.next()){
					News news = new News();
					news.setId(rs.getInt("id"));
					news.setTitle(rs.getString("title"));
					news.setAuthor(rs.getString("author"));
					news.setCreateTime(rs.getDate("createTime"));
					news.setContent(rs.getString("content"));
					list.add(news);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
}
