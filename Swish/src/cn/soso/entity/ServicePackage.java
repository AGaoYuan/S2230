package cn.soso.entity;

/**
 * �����ײ͵ĳ�����
 * @author Mr.Gao
 *
 */
public abstract class ServicePackage {
	
	protected double price; //�ײ����ʷ�(Ԫ)
	
	public ServicePackage(){}
	
	public ServicePackage(double price){
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	//��ʾ�ײ�����
	public abstract void showInfo();
	
}
