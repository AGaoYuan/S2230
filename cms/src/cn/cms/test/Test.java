package cn.cms.test;

import cn.cms.manager.NewsManager;

/**
 * ������
 * @author 21600
 *
 */
public class Test {

	public static void main(String[] args) {
		//����
		NewsManager nm = new NewsManager();
		try {
			//���ö���
			nm.toHtml();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
