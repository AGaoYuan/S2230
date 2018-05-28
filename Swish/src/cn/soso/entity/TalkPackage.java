package cn.soso.entity;


import cn.soso.common.Common;
import cn.soso.service.CallService;
import cn.soso.service.SendService;

/**
 * �����ײ�
 * @author Mr.Gao
 *
 */
public class TalkPackage extends ServicePackage implements CallService,SendService{
	
	private int talkTime; //ͨ��ʱ�������ӣ�
	private int smsCount; //��������������
	
	public TalkPackage(){
		this.talkTime = 500;
		this.smsCount = 30;
		this.price = 58.0;
	}
	
	
	public TalkPackage(int talkTime, int smsCount) {
		
		this.talkTime = talkTime;
		this.smsCount = smsCount;
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

	//�������еķ���
	@Override
	public void showInfo() {
		System.out.println("�����ײͣ�ͨ�� ʱ��Ϊ"+this.talkTime+"����/�£���������Ϊ"+
	this.smsCount+"��/�£��ʷ�Ϊ"+super.price);
		
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
