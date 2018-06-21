package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThread {

	public static void main(String[] args) {
		//����ExecutorService�ӿ�������Executors�ഴ����newFixedThreadPool�̳߳�
		ExecutorService cach = Executors.newFixedThreadPool(3);//�޶��߳���Ϊ3
		
		for (int i = 0; i < 10; i++) {
			//ִ��MyRunnable�߳���
			cach.execute(new MyRunnalbes2(i));
		}
		cach.shutdown();
		

	}

}
class MyRunnalbes2 implements Runnable{

	int num;
	
	public MyRunnalbes2(int num){
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+num);
		
	}
}
