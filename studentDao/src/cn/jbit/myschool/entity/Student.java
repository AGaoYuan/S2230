package cn.jbit.myschool.entity;

import java.util.Date;

/**
 * ѧ��ʵ����
 * @author 21600
 *
 */
public class Student {
	private int stuNo;//ѧ��
	private String stuName;//����
	private int stuGradeid;//�꼶���
	private int stuGender;//�Ա�
	private Date stuBirthday;//��������
	private String stuPhone;//��ϵ���ֻ���
	private String stuEmail;//�����ַ
	private String stuAddress;//סַ
	private String stupassword;//����
	
	
	public String getStupassword() {
		return stupassword;
	}
	public void setStupassword(String stupassword) {
		this.stupassword = stupassword;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuGradeid() {
		return stuGradeid;
	}
	public void setStuGradeid(int stuGradeid) {
		this.stuGradeid = stuGradeid;
	}
	public int getStuGender() {
		return stuGender;
	}
	public void setStuGender(int stuGender) {
		this.stuGender = stuGender;
	}
	public Date getStuBirthday() {
		return stuBirthday;
	}
	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	
	
	
	
	
}
