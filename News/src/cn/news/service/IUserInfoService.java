package cn.news.service;

import java.util.List;

import cn.news.entity.UserInfo;

public interface IUserInfoService {
	
	//01.��֤�û���¼�ķ���
	public UserInfo isLogin(UserInfo Info) throws Exception;
	
	//0.2��ѯ�û��б�
	public List<UserInfo> findAll() throws Exception;
	
	//0.2��ѯ�ض�����
	public UserInfo getUser(int id) throws Exception;
	
	//0.3ɾ���û�
	public boolean delete(String uid)throws Exception;
	
	//0.4����û�
	public boolean save(UserInfo userInfo)throws Exception;
	
	//0.5�޸��û���
	public boolean update(UserInfo userInfo) throws Exception;
	
	//����һ��ֻ��ȡ��ҳ���ݵķ���
	public List<UserInfo> getOnePageData(int pageIndex,int pageSize) throws Exception;
	
	//��ȡ�ܼ�¼��
	public int getTotalUsers() throws Exception;
	
	public int getTotalUsersCount(String uname)throws Exception;

	public List<UserInfo> getOnePageDataHasCondition(Integer pageIndex, int pageSize, String uname)throws Exception;
	
	
}
