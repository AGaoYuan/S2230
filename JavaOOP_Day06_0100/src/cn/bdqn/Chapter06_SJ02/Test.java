package cn.bdqn.Chapter06_SJ02;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		Dog dog = new Dog("���",20,"��������");
		Dog dog2 = new Dog("С��",12,"��ʿ��");
		Dog dog3 = new Dog("����",8,"С��");
		System.out.println("");
		Map<String,Dog> map = new HashMap<String,Dog>();
		map.put(dog.getName(), dog);
		map.put(dog2.getName(), dog2);
		map.put(dog3.getName(), dog3);
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key);
			Dog dog4 = map.get(key);
			System.out.println("����Ϊ��"+dog4.getName()+"����Ϊ��"+dog4.getAge()+"Ʒ��Ϊ��"+dog4.getStrain());
		}
		
		

	}

}
