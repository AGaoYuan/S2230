package cn.examination.test;

import java.util.List;

import cn.examination.entity.dog;
import cn.examination.server.IOperationDogServer;
import cn.examination.server.Impl.IOperationDogServerImpl;

public class DogTest {

	public static void main(String[] args) {
		dog dog = new dog();
		dog.setName("��");
		dog.setHealth(100);
		dog.setLove(50);
		dog.setStrain("��֪��");
		
		IOperationDogServer ids = new IOperationDogServerImpl();
		try {
			List<dog> list = ids.findResult();
			for (dog dogs : list) {
				System.out.println(dogs.getName()+"\t"+dogs.getHealth()+"\t"+dogs.getLove()+"\t"+dogs.getStrain());
				
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		/*int iscount;
		try {
			iscount = ids.saveAll();
			if (iscount>0) {
				System.out.println("��ӳɹ���");
			}else{
				System.out.println("���ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		

	}

}
