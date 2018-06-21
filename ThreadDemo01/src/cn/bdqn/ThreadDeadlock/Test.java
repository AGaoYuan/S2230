package cn.bdqn.ThreadDeadlock;

/**
 * ��������
 * @author 21600
 *
 */
public class Test {

	public static void main(String[] args) {
		Object bobby = new Object();
		Object duck = new Object();
		Thread t1 = new Thread(new Tangtang(bobby, duck));
		Thread d2 = new Thread(new Doudou(bobby, duck));
		t1.start();
		d2.start();
	}

}

class Tangtang implements Runnable{
	Object bobby;
	Object duck;
	public Tangtang(Object bobby, Object duck) {
		this.bobby = bobby;
		this.duck = duck;
	}
	@Override
	public void run() {
		synchronized(bobby){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (duck) {
					
				}
			System.out.println("���ǰѰűȸ������棡");
		}
	}
}

class Doudou implements Runnable{
	Object bobby;//�ű�
	Object duck;//���Ѽ
	public Doudou(Object bobby, Object duck) {
		this.bobby = bobby;
		this.duck = duck;
	}
	
	@Override
	public void run() {
		synchronized(duck){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (bobby) {
				
			}
			System.out.println("���������Ѽ�������棡");
		}
		
	}
}
