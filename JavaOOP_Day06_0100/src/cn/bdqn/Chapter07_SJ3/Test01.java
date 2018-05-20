package cn.bdqn.Chapter07_SJ3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test01 {

	public static void main(String[] args) {
		Penguin penguin = new Penguin();
		penguin.setName("��");
		penguin.setAge(12);
		
		Penguin penguin2 = new Penguin();
		penguin2.setName("����");
		penguin2.setAge(13);
		
		Map<String, Penguin> map =new HashMap<String, Penguin>();
		map.put(penguin.getName(), penguin);
		map.put(penguin2.getName(), penguin2);
		
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			Penguin penguin3 = map.get(next);
			System.out.println("����"+next+"����"+penguin3.getAge());
		}
		
		

	}

}
