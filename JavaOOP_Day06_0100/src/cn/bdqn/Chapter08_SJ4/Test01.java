package cn.bdqn.Chapter08_SJ4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test01 {

	public static void main(String[] args) {
		Penguin penguin = new Penguin();
		penguin.setID(001);
		penguin.setName("��");
		penguin.setAge(12);
		
		Penguin penguin2 = new Penguin();
		penguin2.setID(002);
		penguin2.setName("����");
		penguin2.setAge(13);
		
		
		Map<Integer, Penguin> map =new HashMap<Integer, Penguin>();
		map.put(penguin.getID(), penguin);
		map.put(penguin2.getID(), penguin2);
		
		Set<Entry<Integer, Penguin>> entrySet = map.entrySet();
		for (Entry<Integer, Penguin> item : entrySet) {
			System.out.println("��ţ�"+item.getKey()+"������"+item.getValue().getName()+"���䣺"+item.getValue().getAge());
		}
		
		
		Iterator<Integer> iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			Integer next = iterator.next();
			Penguin penguin3 = map.get(next);
			System.out.println("����"+next+"����"+penguin3.getAge()+"��ţ�"+penguin3.getID());
		}
		
		
		

	}

}
