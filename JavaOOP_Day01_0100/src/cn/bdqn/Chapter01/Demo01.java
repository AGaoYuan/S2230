package cn.bdqn.Chapter01;

import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Dog dog = new Dog();
		System.out.println("��ӭ���������");
		System.out.println("������Ҫ�����ĳ������֣�");
		String Name = in.next();
		dog.setName(Name);
		System.out.println("��ѡ��Ҫ�����ĳ������ͣ�(1������   2�����)");
		int num =in.nextInt();
		switch (num) {
		case 1:
			dog.print();
			break;
		case 2:
			Penguin pe = new Penguin();
			System.out.println("����������Ա�(1����  2����)");
			pe.setName(Name);
			int sex = in.nextInt();
			if (sex == 1) {
				pe.sex = pe.SEX_MALE;
			}
			else if(sex == 2) {
				pe.sex = pe.SEX_FEMALE;
			}
			pe.print();
			break;

		default:
			break;
		}
		
		
		
	}

}
