package cn.bdqn.ThreadDemo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws Exception {
		//newScheduLedThreadPool��̬�������޶����̳߳���ֻ����5���߳�ִ������
		ScheduledExecutorService ses = null;
		System.out.println("*************��ʼ**************");
		ses = Executors.newScheduledThreadPool(5);
		if (ses!=null) {
			ses.scheduleAtFixedRate(new MyRunnable(), 5, 2, TimeUnit.SECONDS);
		}else{
			ses.shutdown();
		}
		//ִ�е��̶߳����״�ִ��ʱ��Ϊ5�룬��ÿ��2��ִ��һ�Σ�����ִ�е�λΪ��
		
		
		//��дshutdown����ѭ����д��shutdown�Ͳ�����ʾ�κ�����
		//ses.shutdown();
		
		
		
	}
}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"�״��ӳ�5sִ�У�ÿ2sִ��һ�Σ�");
		
	}
	
}



