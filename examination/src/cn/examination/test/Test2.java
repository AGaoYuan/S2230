package cn.examination.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2 {

	/*
	 * 2) ���������µ��ı��ļ��ж�ȡ�����е�����������ӡ���ظ����������ظ��Ĵ����������ظ���������
	 */
	public static void main(String[] args) throws Exception {
		//���ȷ���
		readerAll();
		
		
	}
	
	public static void readerAll() throws Exception{
		BufferedReader bf = new BufferedReader(new FileReader("E:/pk/2.txt"));
		String str = bf.readLine();
		List<String> names = new ArrayList<String>();
		while (str != null) {
			//�Զ����и��ַ���
			String[] st = str.split(",");
			names.add(st[1]);
			str = bf.readLine();
		}
		Set<String> name = new HashSet<String>(names);
		for (String set : name) {
			String temp = set;
			int num = 0;
			for (String s : names) {
				if (temp.equals(s)) {
					num++;
				}

			}
			if (num >= 2) {
				System.out.println(temp + "�ظ�������" + num);

			}
		}
		bf.close();
		
	}
	

}
