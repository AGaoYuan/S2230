package cn.soso.entity;


import cn.soso.common.Common;
import cn.soso.service.NetService;

/**
 * �����ײ�
 * @author Mr.Gao
 *
 */
public class NetPackage extends ServicePackage implements NetService{
	
	private int flow; //����������MB��
	
	public NetPackage(){
		this.flow = 1024*3;
		this.price = 68.0;
	}
	
	public NetPackage(double price,int flow){
		super(price);
		this.flow = flow;
	}
	
	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}
	
	//�������еķ���
	@Override
	public void showInfo() {
		System.out.println("�����ײͣ�����������"+flow/1024+"GB/�£�������"
	+this.price+"Ԫ/�¡�");
		
	}

	//�����ӿ��еķ���
	
	public void netPlay2(int flow, MobileCard card) throws Exception {
		int reminFlow = this.flow-card.getRealFlow();
		if (this.flow<=reminFlow) {
			card.setRealFlow(card.getRealFlow()+flow);
		}else{
			double consumeMoney = 0.1*(flow-reminFlow);
			if (card.getMoney() >= consumeMoney) {
				card.setRealFlow(card.getRealFlow()+flow);
				card.setConsumAmount(card.getConsumAmount()+consumeMoney);
			}else{
				int temp = (int) (card.getMoney()/0.1);
				throw new Exception("�������㣬���ֵ����ʹ�ã�");
			}
		}
		
	}

	@Override
	public int netPlay(int flow, MobileCard card) throws Exception {
		int temp = flow;
		for (int i = 0; i < flow; i++) {
			if (this.flow-card.getRealFlow()>=1) {
				card.setRealFlow(card.getRealFlow()+1);
			}else if (card.getMoney()>=0.1) {
				card.setRealFlow(card.getRealFlow()+1);
				card.setMoney(Common.sub(card.getMoney(), 0.1));
				card.setConsumAmount(card.getConsumAmount()+0.1);
			}else {
				temp = i;
				throw new Exception("������ʹ������"+i+"MB���������㣬���ֵ����ʹ�ã�");
			}
		}
		return temp;
	}
	
	
	
	
	
}
