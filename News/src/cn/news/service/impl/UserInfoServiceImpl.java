package cn.news.service.impl;

import java.util.List;

import cn.news.dao.impl.UserInfoDAOImpl;
import cn.news.entity.UserInfo;
import cn.news.service.IUserInfoService;

public class UserInfoServiceImpl implements IUserInfoService{
	//����daoʵ��
	UserInfoDAOImpl ui =new UserInfoDAOImpl();
	
	//�ж��û���¼
	@Override
	public UserInfo isLogin(UserInfo Info) throws Exception {
		return ui.isLogin(Info);
	}
	
	//��ѯ�����û�
	@Override
	public List<UserInfo> findAll() throws Exception {
		return ui.findAll();
	}
	
	//ɾ����ѡ�û�
	@Override
	public boolean delete(String uid) throws Exception {
		return ui.delete(uid);
	}
	
	//���һ���û�
	@Override
	public boolean save(UserInfo userInfo) throws Exception {
		return ui.save(userInfo);
	}
	
	//�޸��û���Ϣ
	@Override
	public boolean update(UserInfo userInfo) throws Exception {
		return ui.update(userInfo);
	}
	
	//�޸�ǰ�Ȳ�ѯ��ѡ�е��û�
	@Override
	public UserInfo getUser(int id) throws Exception {
		return ui.getUser(id);
	}
	
	//��ҳ��ʾ�û���Ϣ
	@Override
	public List<UserInfo> getOnePageData(int pageIndex, int pageSize) throws Exception {
		return ui.getOnePageData(pageIndex, pageSize);
	}
	
	//ͳ�������û�����
	@Override
	public int getTotalUsers() throws Exception {
		return ui.getTotalUsers();
	}

	public int getTotalUsersCount(String uname) throws Exception {
		return ui.getTotalUsersCount(uname);
	}

	@Override
	public List<UserInfo> getOnePageDataHasCondition(Integer pageIndex, int pageSize, String uname)throws Exception {
		return ui.getOnePageDataHasCondition(pageIndex,pageSize,uname);
	}

	
	
	

	
	
	
	
}
