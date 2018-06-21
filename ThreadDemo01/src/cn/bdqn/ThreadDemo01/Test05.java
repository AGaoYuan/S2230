package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �Զ����̳߳�
 * @author 21600
 *
 */
public class Test05 {
	public static void main(String[] args) {
		//�����Զ����̳߳� �߳���Ϊ5 ����߳���Ϊ7 ������ʱ�̵߳�ʱ��Ϊ300���룬������������������Ϊ4
		ThreadPoolExecutor executor = new 
		ThreadPoolExecutor(5, 7, 300, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(4));
		for (int i = 1; i < 12; i++) {
			//����MyRunnable�߳�
			executor.execute(new MyRunnabless(i));
			//��ӡ�̳߳��е��߳����������еȴ������������Ѿ�ִ�����������
			System.out.println("�̳߳����߳�����"+executor.getPoolSize()+"�����еȴ�����������"
			+executor.getQueue().size()+"�Ѿ�ִ�������������"+executor.getCompletedTaskCount());
		}
		//�����̳߳�
		executor.shutdown();
		
	}
}
class MyRunnabless implements Runnable{

	int num;
	public MyRunnabless(int num){
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println("����ִ������"+num);
		try {
			//����2��
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ִ����ϣ�"+num);
		
	}
}