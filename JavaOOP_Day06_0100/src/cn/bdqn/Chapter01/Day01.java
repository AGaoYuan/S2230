package cn.bdqn.Chapter01;

import java.util.*;

public class Day01 {

	public static void main(String[] args) {
		Dog dog = new Dog("ŷŷ","ѩ����");
		Dog dog2 = new Dog("����","��������");
		Dog dog3 = new Dog("�Ʒ�","��������");
		Dog dog4 = new Dog("����","ѩ����");
		Map dogs = new HashMap();
		dogs.put(dog.getName(), dog);
		dogs.put(dog2.getName(), dog2);
		dogs.put(dog3.getName(), dog3);
		dogs.put(dog4.getName(), dog4);
		Set keys = dogs.keySet();
		Iterator it= keys.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			System.out.println(key);
			Dog dog5 = (Dog) dogs.get(key);
		}
		
		/*for (Object key : keys) {
			System.out.println(key);
		}*/
		
		
		/*System.out.println("������ "+dogs.size()+"��������");
		System.out.println("�ֱ���");
		if (dogs.contains(dog2)) {
			dogs.remove(dog2);
		}
		
		for (int i = 0; i < dogs.size(); i++) {
			Dog dog5 = (Dog) dogs.get(i);
			
			System.out.println(dog5.getName()+"\t"+dog5.getStrain());
		}
		System.out.println("                                   ");
		
		
		for (Object obj : dogs) {
			System.out.println(((Dog)obj).getName());
		}*/
		

	}

}
