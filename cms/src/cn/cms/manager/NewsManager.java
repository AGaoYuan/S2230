package cn.cms.manager;

import java.util.List;

import cn.cms.dao.INewsDAO;
import cn.cms.dao.impl.NewsDAOImpl;
import cn.cms.entity.News;
import cn.cms.service.INewsService;
import cn.cms.service.impl.NewsServiceimpl;
import cn.cms.util.FileIO;

/**
 * �����鼮��
 * @author 21600
 *
 */
public class NewsManager {
	
	/**
	 * ת���ļ��еı�ǩ���ݣ���д�뵽Ӳ���ϵ�html�ļ�
	 * @throws Exception �쳣
	 */
	public void toHtml() throws Exception{
		//������ȡ����
		FileIO fi = new FileIO();
		//ָ��·��
		String rf = fi.readFile("D:/�Ͽ�ʹ��/Java/S2230/workspace/cms/news.template");
		//����Service���ʵ�������
		INewsService ind = new NewsServiceimpl();
		//���ö�ȡ���ݿ���News�������ݵķ���
		List<News> fa = ind.findAll();
		//ѭ��ȥ�滻�ļ��е�����
		for (int i = 0; i < fa.size(); i++) {
			News news = fa.get(i);
			String ss = new String();
			ss = rf;
			ss = ss.replace("{title}", news.getTitle());
			ss = ss.replace("{author}", news.getAuthor());
			ss = ss.replace("{createTime}", news.getCreateTime().toString());
			ss = ss.replace("{content}", news.getContent());
			//��������
			String filePath = "E:/news+"+i+".html";
			
			//д��Ӳ��
			fi.writeFile(filePath, ss);
		}
		
		
		
		
	}
	
}
