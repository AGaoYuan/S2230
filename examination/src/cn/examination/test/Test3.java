package cn.examination.test;


public class Test3 {

	/*
	 * 3) ��д���� ������Ч���ҳ�һ�������еڶ������.
	 */
	public static void main(String[] args) {
		//���ȷ���
		CountNumber();
		
		
	}
	
	public static void CountNumber(){
		int [] number = {10,50,30,90,80};
		
		int max = number[0];
		for (int i = 0; i < number.length; i++) {
			if (number[i]>max) {
				max = number[i];
			}
		}
		
		int two = number[0];
		for (int j = 0; j < number.length; j++) {
			if (number[j] > two && number[j]<max) {
				two = number[j];
			}
		}
		System.out.println("�ڶ��������"+two);
		
	}
	
	

}
