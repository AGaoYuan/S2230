package cn.bdqn.Chapter04;

import java.util.*;

public class MyMain {

	public static void main(String[] args) {
		Dog dog = new Dog("С��",12);
		Dog dog2 = new Dog("���",12);
		Set<Dog> set = new HashSet<Dog>();
		
		set.add(dog);
		set.add(dog2);
		System.out.println(set.size());
		if (dog.equals(dog2)) {
			System.out.println("true");
		}
		
	}

}
