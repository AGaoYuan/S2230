package cn.soso.entity;


import cn.soso.common.Common;
import cn.soso.service.CallService;
import cn.soso.service.NetService;
import cn.soso.service.SendService;

/**
 * �����ײ�
 * @author Mr.Gao
 *
 */
public class SuperPackage extends ServicePackage implements CallService,SendService,NetService{
	
	private int talkTime; //ͨ��ʱ�������ӣ�
	private int smsCount; //��������������
	private int flow; //����������MB��
	
	public SuperPackage(){
		this.talkTime = 200;
		this.smsCount = 50;
		this.flow = 1*1024;
		this.price = 78.0;
		
	}
	
	public SuperPackage(double price, int talkTime, int smsCount, int flow) {
		super(price);
		this.talkTime = talkTime;
		this.smsCount = smsCount;
		this.flow = flow;
	}

	public int getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
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
		System.out.println("�����ײͣ�ͨ��ʱ��Ϊ"+this.talkTime
				+"����/�£���������Ϊ"+this.smsCount
				+"��/�£���������Ϊ"+this.flow/1024+"GB/�¡�");
	}
	
	//�����ӿ��еķ���
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

	//���Ͷ��Žӿ��еķ���
	@Override
	public int send(int Count, MobileCard card) throws Exception {
		int temp = smsCount;
		for (int i = 0; i < smsCount; i++) {
			if (this.smsCount-card.getRealSMSCount()>=1) {
				card.setRealSMSCount(card.getRealSMSCount()+1);
			}else if (card.getMoney()>=0.1) {
				card.setRealSMSCount(card.getRealSMSCount()+1);
				card.setMoney(Common.sub(card.getMoney(), 0.1));
				card.setConsumAmount(card.getConsumAmount()+0.1);
			}else {
				temp = i;
				throw new Exception("�����ѷ��Ͷ���"+i+"�����������㣬���ֵ����ʹ�� ��");
			}
		}
		return temp;
	}

	//ͨ���ӿ��еķ���
	@Override
	public int call(int minCount, MobileCard card) throws Exception {
		int temp = minCount;
		for (int i = 0; i < minCount; i++) {
			if (this.talkTime-card.getRealTalkTime()>=1) {
				card.setRealTalkTime(card.getRealTalkTime()+1);
			}else if (card.getMoney()>=0.2) {
				card.setRealTalkTime(card.getRealTalkTime()+1);
				card.setMoney(Common.sub(card.getMoney(),0.2));
				card.setConsumAmount(card.getConsumAmount()+0.2);
			}else {
				temp = i;
				throw new Exception("������ͨ��"+i+"���ӣ��������㣬���ֵ����ʹ�ã�");
			}
		}
		
		return temp;
	}
	
	
}
