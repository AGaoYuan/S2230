package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test6 {
	public static void main(String[] args) {
		//newFixedThreadPool��̬�������޶����̳߳���ֻ����3���߳�ִ������
		 ExecutorService fixed = Executors.newFixedThreadPool(3);
		 //ѭ��10��
		 for (int i = 0; i < 10; i++) {
			 //�����̳߳�
			 fixed.execute(new MyRunnableFixed(i));
			 
		 }
		 //�ر��̳߳�
		 fixed.shutdown();
	}
}
class MyRunnableFixed implements Runnable{

	int num;
	public MyRunnableFixed(int num){
		this.num = num;
	}
	
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+num);
		
	}
	
	
}