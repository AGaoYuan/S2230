package cn.bdqn.Chapter01;

import java.io.*;
import java.util.Scanner;

public class fileMain {

	public static void main(String[] args) {
		File file = new File("F:\\Java\\1.txt");
		/*if (file.exists()) {
			System.out.println("��ǰ�ļ�����");
		}else{
			System.out.println("��ǰ�ļ������ڣ�");
		}*/
		if (file.isDirectory()) {
			System.out.println("��ǰΪ�ļ��У�����");
		}else{
			System.out.println("��ǰ�ļ�������Ϊ��");
			
			System.out.println("�ļ��ľ���·��"+file.getAbsolutePath());
			System.out.println("�ļ���Ϊ��"+file.getName());
			System.out.println("�ļ������·����"+file.getPath());
			System.out.println("�ļ�����һ��Ŀ¼��"+file.getParent());
			System.out.println("�ļ��ĳ��ȣ�"+file.length());
		}
		System.out.println("�밴1ɾ����ɲ�����");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		if (num == 1) {
			boolean delete = file.delete();
			if (delete) {
				System.out.println("ɾ���ɹ���");
			}
		}else{
			System.out.println("ɾ��ʧ�ܣ�");
		}
		
		
		

	}

}
