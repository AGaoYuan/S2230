package cn.bdqn.Chapter01;

/**
 * ����
 * @author Mr.Gao
 *
 */
public class Dog {

	private String Name = "������";//����
	private int Health = 100;//����ֵ
	private int Love = 0;//���ܶ�
	private String Strain = "��������������Ȯ";//Ʒ��
	
	public Dog() {}

	public Dog(String name, int health, int love, String strain) {
		Name = name;
		Health = health;
		Love = love;
		Strain = strain;
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
		this.Love = love;
	}
	public String getStrain() {
		return Strain;
	}
	public void setStrain(String strain) {
		this.Strain = strain;
	}
	
	public void eat() {
		if (Health >= 100) {
			System.out.println("������Ҫ���˶���");
		}else {
			Health = Health + 3;
			System.out.println("�����Ա����ˣ�");
		}
	}
	
	public void play() {
		if (Health < 60) {
			System.out.println("���������ˣ�");
		} else {
			System.out.println("�������ں�������ˣ��");
			Health += -10;
			Love += +3;
		}
	}
	
	public void print() {
		System.out.println("�����԰ף�\n�ҵ����ֽ�"+this.Name
				+"����ֵ��"+this.Health+"�����˵����ܶ���"+this.Love+"����һֻ"+this.Strain);
	}
	
	
}
