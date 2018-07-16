package cn.examination.test;

import java.io.UnsupportedEncodingException;

public class Test1 {
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
		 	String s = "��ABC��DEF";   
	        System.out.println("ԭʼ�ַ�����" + s);   
	        try { 
	            System.out.println("��ȡǰ4λ��" + Test1.substring(s, 4));   
	            System.out.println("��ȡǰ6λ��" + Test1.substring(s, 6));   
	        } catch (UnsupportedEncodingException e) {   
	            e.printStackTrace();   
	        }   
	        
	}  
	
	public static boolean isChineseChar(char c) throws UnsupportedEncodingException{
		return String.valueOf(c).getBytes("GBK").length<2;
	}
	
	 public static String substring(String Character, int count)   
	            throws UnsupportedEncodingException {   
	        // ԭʼ�ַ���Ϊnull��Ҳ���ǿ��ַ���   
	        if (Character != null && !"".equals(Character)) {   
	            // ��ԭʼ�ַ���ת��ΪGBK�����ʽ   
	        	Character = new String(Character.getBytes(), "GBK");   
	            // Ҫ��ȡ���ֽ�������0����С��ԭʼ�ַ������ֽ���   
	            if (count > 0 && count < Character.getBytes("GBK").length) {   
	                StringBuffer buff = new StringBuffer();   
	                char c;   
	                for (int i = 0; i < count; i++) {   
	                    c = Character.charAt(i);   
	                    buff.append(c);   
	                    if (Test1.isChineseChar(c)) {   
	                        // �������ĺ��֣���ȡ�ֽ�������1   
	                        --count;   
	                    }   
	                }   
	                return buff.toString();   
	            }   
	        }   
	        return Character;   
	 }
	 
	 

}
