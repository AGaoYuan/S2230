package cn.bdqn.ThreadCallable;

import java.util.concurrent.Callable;

/**
 * ʹ��Callable���ͽӿڴ����߳���
 * @author 21600
 *
 */
class TestResultThread implements Callable<String>{

	private int id;
	//�в������췽��
	public TestResultThread(int id){
	this.id=id;
	}
	
	@Override
	public String call() throws Exception {
		
		return "�߳����񷵻�ֵ"+id;
	}
	
	
}
