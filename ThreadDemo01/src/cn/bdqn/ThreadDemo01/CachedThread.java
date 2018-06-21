package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThread {

	public static void main(String[] args) {
		//���������̳߳أ�ʹ��Executorsʵ�����newCachedThreadPool��̬��������������ΪExecutorService�ӿ�����
		ExecutorService cach = Executors.newCachedThreadPool();
		//ѭ��10������
		for (int i = 0; i < 10; i++) {
			//�����߳�
			cach.execute(new MyRunnalbe(i));
		}
		//�ر��̳߳�
		cach.shutdown();
	}

}

class MyRunnalbe implements Runnable{

	int num;
	
	//���ι���
	public MyRunnalbe(int num){
		this.num = num;
	}
	
	//��ȡ���󲢴�ӡִ�д���
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+num);
		
	}
	
}



