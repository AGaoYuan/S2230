package cn.bdqn.ThreadSCXF;

/**
 * ������
 * @author 21600
 *
 */
public class Producer implements Runnable{

	private Movie movie = null;
	
	private boolean flag = false;
	
	public Producer(Movie movie) {
		
		this.movie = movie;
	}


	@Override
	public void run() {
		//ѭ��¼���Ӱ����
		for (int i = 0; i < 50; i++) {
			if (flag) {
				try {
					this.movie.set("���ν��", "һ���ƻõ�Ӱ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = false;
			}else{
				try {
					this.movie.set("��͵�̰�", "һ��3D������Ӱ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = true;
			}
		}
		
		
	}
	
	
	
	
	
}
