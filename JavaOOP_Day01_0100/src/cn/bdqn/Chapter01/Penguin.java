package cn.bdqn.Chapter01;

/**
 * �����
 * @author Mr.Gao
 *
 */
public class Penguin {

	private String Name = "������";//����
	private int Health = 100;//����ֵ
	private int Love = 0;//���ܶ�
	final String SEX_MALE = "��";
	final String SEX_FEMALE = "��";
	String sex = SEX_MALE;
	
	
	public Penguin(String name, int health, int love, String sex) {
		Name = name;
		Health = health;
		Love = love;
		this.sex = sex;
	}
	public Penguin() {
		
	}
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getHealth() {
		return Health;
	}
	public void setHealth(int health) {
		Health = health;
	}
	public int getLove() {
		return Love;
	}
	public void setLove(int love) {
		Love = love;
	}
	
	
	public void print() {
		System.out.println("�����԰ף�\n�ҵ����ֽ�"+this.Name
				+"����ֵ��"+this.Health+"�����˵����ܶ���"+this.Love+"�Ա���"+this.sex+"��");
	}
	
	
	
}
