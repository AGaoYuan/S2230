package cn.jbit.myschool.dao;


import java.sql.ResultSet;
import java.util.List;

import cn.jbit.myschool.entity.Student;

/**
 * ����MyschoolѧУ�Ľӿ�
 * @author 21600
 *
 */
public interface MySchoolDao {
	/**
	 * ���ѧ����Ϣ
	 * @param student
	 * @return ������Ӱ�������
	 */
	int save(Student student);
	/**
	 * ɾ��һ��ѧ��
	 * @param student
	 * @return ������Ӱ�������
	 */
	int del(Student student);
	/**
	 * �޸�һ��ѧ����Ϣ
	 * @param student
	 * @return ������Ӱ�������
	 */
	int update(Student student);
	/**
	 * ��ȡָ���ǳƵ�ѧ������׼��ѯ
	 * @param name �ǳ�
	 * @return ����ѧ������
	 */
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Student> executeQuery();
	
	Student getByName(String name);
	/**
	 * ��ȡָ���ǳƵ�ѧ���б�ģ����ѯ
	 * @param name �ǳ�
	 * @return ѧ���б�
	 */
	List<Student> findByName(String name);
	
	
	/**
	 * ��ȡָ���꼶��ѧ���б�
	 * @param type �꼶���
	 * @return ѧ���б�
	 */
	List<String> findBytype(String type);
	
	
	
	
	
}
