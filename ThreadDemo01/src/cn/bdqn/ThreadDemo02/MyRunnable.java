package cn.bdqn.ThreadDemo02;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 12; i++) {
			System.out.println("��ǰ�߳�Ϊ��"+Thread.currentThread().getName()+":"+i);
		}
		
	}
	
	
	
}
