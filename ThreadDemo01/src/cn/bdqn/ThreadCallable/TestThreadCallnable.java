package cn.bdqn.ThreadCallable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadCallnable {

	public static void main(String[] args) throws Exception {
		//�����̳߳�
		ExecutorService exec=Executors.newCachedThreadPool();
		//�����߳�����
		ArrayList<Future<String>> result=new ArrayList<Future<String>>();
		//ִ������󷵻ؽ��,����ֻ��10���߳�
		for(int i=0;i<10;i++){
		Future<String> f=exec.submit(new TestResultThread(i));
		result.add(f);
		}
		//����ִ����ɺ���߳�
		for(Future<String> ft:result){
		//�ж��Ƿ�ִ�����
		if(ft.isDone()){
		System.out.println("��ɵ��̣߳�"+ft.get());
		}else{
		System.out.println("δ��ɵ��̣߳�"+ft);
		}
	}
		//�ر��̳߳�
		exec.shutdown();
		
		
		
		

	}

}
