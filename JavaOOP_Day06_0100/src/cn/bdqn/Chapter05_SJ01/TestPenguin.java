package cn.bdqn.Chapter05_SJ01;

import java.util.*;

public class TestPenguin {

	public static void main(String[] args) {
		Penguin penguin = new Penguin("����",10,"Q��");
		Penguin penguin2 = new Penguin("��",12,"Q��");
		Penguin penguin3 = new Penguin("СQ",8,"Q��");
		List list = new ArrayList();
		list.add(penguin);
		list.add(penguin2);
		list.add(penguin3);
		
		if (list.contains(penguin2)) {//�жϼ������Ƿ��и�Ԫ��
			list.remove(penguin2);//ɾ��Ԫ��
		}
		System.out.println("���ĸ�����"+list.size());
		for (int i = 0; i < list.size(); i++) {//ѭ��Ԫ�ظ���
			Penguin p = (Penguin)list.get(i);//ǿ��ת�����������  list.get()����ΪObject����
			System.out.println("�������:"+p.getName()+"�������:"+p.getAge()+"����Ա�:"+p.getStrain());//��ӡ��������
		}
		
		
	}

}
