package cn.bdqn.Chapter03_SJ3;

import java.io.*;

public class Demo01 {

	public static void main(String[] args) throws Exception {
		Reader fr = new FileReader("E:/pet.template");
		Writer fw = new FileWriter("F:/MyDoc.txt",true);
		BufferedReader reader = new BufferedReader(fr);
		BufferedWriter writer = new BufferedWriter(fw);
		String line = null;
		StringBuffer sbf = new StringBuffer();
		while((line=reader.readLine())!=null){
			sbf.append(line);
		}
		System.out.println("�滻ǰ��"+sbf);
		String newString = sbf.toString().replace("{name}", "ŷŷ");
		newString = newString.replace("{type}", "����");
		newString = newString.replace("{master}", "��ΰ");
		System.out.println("�滻��"+newString);
		writer.write(newString.toString());
		System.out.println("�滻�ɹ���");
		
		writer.close();
		reader.close();
		fw.close();
		fr.close();
		
		

	}

}
