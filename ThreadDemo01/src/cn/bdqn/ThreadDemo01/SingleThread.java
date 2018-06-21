package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {

	public static void main(String[] args) {
		//�������̳߳أ���ʹ��Executorsʵ�����newSingThreadExecutor��̬���������̳߳�ֻ��һ���߳�ִ��
		ExecutorService cach = Executors.newSingleThreadExecutor();
		//ͬ��ִ��10������
		for (int i = 0; i < 10; i++) {
			//�����߳�
			cach.execute(new MyRunnalbes(i));
		}
		//�ر��̳߳�
		cach.shutdown();

	}

}
class MyRunnalbes implements Runnable{

	int num;
	
	public MyRunnalbes(int num){
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+num);
		
	}
}
