package cn.examination.test;

public class Test11 {
/*
 * 
	1).��дһ����ȡ�ַ����ĺ�����
	����Ϊһ���ַ������ֽ�����
	���Ϊ���ֽڽ�ȡ���ַ�����
	��Ҫ��֤���ֲ�����ȡ�����
	�硰��ABC����4��Ӧ�ý�ȡ����AB����
	���롰��ABC��DEF����6��Ӧ���������ABC����
	�����ǡ���ABC+���İ������
	
 */
	public static void main(String[] args) {
		//���Է���
		System.out.println(substring("��ABC��DEF", 6));
		
	}
	//������ȡ�ַ����ķ���
	 public static String substring(String Character, int count){
		 //���ַ���ת����һ���ַ�����
	     char[] chars = Character.toCharArray();
	     //����
	     int sum = 0;
	     //����StringBuilder����������ƴ��
	     StringBuilder sb = new StringBuilder();
	     //ѭ���ַ�����
		 for (char item : chars) {
			 //ת�ͳ�Ϊint���ж��ٽ�ֵ ASCII����û�к���
			if ((int)item>=128) {
				//ת�ͺ��������128�Ļ����ж�Ϊ����ռ�����ֽڣ���2
				sum+=2;
				//�ж��Ƿ�С��128
			}else if ((int)item<=128) {
				//���С��128�ģ��ʹ�����һ���ֽڣ�����sum++
				sum++;
			}
			//�ж��Ƿ�����û���Ҫ�Ľ�ȡ���ַ���
			if (sum>count) {
				//�������������ѭ��
				break;
			}
			//׷���ַ�
			sb.append(item);
		 }
		 //ת��ΪString������
		 return sb.toString();
	 }
	 
	 

}
