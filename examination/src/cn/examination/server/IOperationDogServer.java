package cn.examination.server;

import java.util.List;

import cn.examination.entity.dog;

public interface IOperationDogServer {

		//���
		public int saveAll()throws Exception;
		//����
		public int Update()throws Exception;
		//��ѯ
		public List<dog> findResult()throws Exception;
	
	
	
}
