package cn.soso.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;

import cn.soso.common.Common;
import cn.soso.entity.ConsumInfo;
import cn.soso.entity.MobileCard;
import cn.soso.entity.NetPackage;
import cn.soso.entity.Scene;
import cn.soso.entity.ServicePackage;
import cn.soso.entity.SuperPackage;
import cn.soso.entity.TalkPackage;
import cn.soso.service.CallService;
import cn.soso.service.NetService;
import cn.soso.service.SendService;

/**
 * ������
 * 
 * @author Mr.Gao
 *
 */
public class CardUtil {
	public Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
	public Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();

	List<Scene> scenes = new ArrayList<Scene>();

	public void init() {
		MobileCard card1 = new MobileCard("��ţ", "123", "13965756432", new TalkPackage(), 58.0, 42.0);

		MobileCard card2 = new MobileCard("Сţ", "123", "13956712467", new NetPackage(), 68.0, 32.0);

		MobileCard card3 = new MobileCard("΢�����", "123", "13911568956", new SuperPackage(), 78.0, 22.0);

		MobileCard card4 = new MobileCard("����", "123", "13924221868", new SuperPackage(), 78.0, 2.0);

		card4.setConsumAmount(98.0);
		card4.setRealTalkTime(500);
		card4.setRealSMSCount(100);

		cards.put("13965756432", card1);
		cards.put("13956712467", card2);
		cards.put("13911568956", card3);
		cards.put("13924221868", card4);
	}

	public void initScene() {
		scenes.add(new Scene("ͨ��", 90, "�ʺ�ͻ���˭֪������Ѳ� ͨ��90����"));
		scenes.add(new Scene("ͨ��", 30, "ѯ������������� ����ͨ��30����"));
		scenes.add(new Scene("����", 5, "���뻷������ʵʩ�����ʾ����  ���Ͷ���5��"));
		scenes.add(new Scene("����", 50, "֪ͨ�����ֻ����ţ����Ͷ���50��"));
		scenes.add(new Scene("����", 1 * 1024, "�ͺû���΢����Ƶ����   ʹ������1G"));
		scenes.add(new Scene("����", 2 * 1024, "�����ֻ����߿����磬������˯���ˣ�ʹ������2G"));

	}

	// ��֤�û�ע��
	public boolean isExistCard(String number, String passWord) {
		Set<String> numbers = cards.keySet();
		Iterator<String> it = numbers.iterator();
		while (it.hasNext()) {
			String searchNum = it.next();
			if (searchNum.equals(number) && (cards.get(searchNum)).getPassWord().equals(passWord)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param searNumber
	 * @return
	 */
	public boolean isExistCard(String searNumber) {
		Set<String> numbers = cards.keySet();
		for (String number : numbers) {
			if (number.equals(searNumber)) {
				return true;
			}
		}

		return false;
	}

	// ������ɵ绰����
	public String createNumber() {
		Random random = new Random();
		String number = "";
		int num = 0;
		do {
			num = random.nextInt(100000000);
		} while (num<10000000);
		number = "139"+num;
		Set<String> cardNumbers = cards.keySet();
		for (String cardNumber : cardNumbers) {
			if (number.equals(cardNumber)) {
				continue;
			}
		}
		
		return number;
	}

	public String[] getNewNumbers(int count) {
		String [] numbers = new String[count];
		for (int i = 0; i < count; i++) {
			numbers[i] = createNumber();
		}
		return numbers;
	}

	/*
	 * ����û�
	 */
	public void addCard(MobileCard card) {
		cards.put(card.getCardNumber(), card);
		System.out.println("ע��ɹ���");
		card.showMeg();
	}

	/*
	 * ��������
	 */
	public void delCard(String delNumber) {
		if (isExistCard(delNumber)) {
			cards.remove(delNumber);
			System.out.println("���ţ�" + delNumber + "���������ɹ���");
		} else {
			System.out.println("�Բ��𣬸ÿ���δע�ᣬ���ܰ���������");
		}

	}

	/*
	 * �ײ�������ѯ
	 */
	public void showRemainDetail(String searNumber) {
		MobileCard mobileCard = cards.get(searNumber);
		MobileCard card;
		int remainTalkTime;
		int remainSmsCount;
		int remainFlow;

		StringBuffer meg = new StringBuffer();
		card = cards.get(searNumber);
		meg.append("�����ֻ������ǣ�" + searNumber + "�ײ���ʣ�ࣺ\n");
		ServicePackage pack = card.getSerPackage();
		// ����ת�ͳ�������
		if (pack instanceof SuperPackage) {
			SuperPackage cardPack = (SuperPackage) pack;
			// ��ѯ�ײ���ʣ���ͨ��ʱ��
			remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime()
					? cardPack.getTalkTime() - card.getRealTalkTime() : 0;
			meg.append("ͨ��ʱ����" + remainTalkTime + "���� \n");
			// ��ѯ�ײ���ʣ��Ķ�������
			remainSmsCount = cardPack.getSmsCount() > card.getRealSMSCount()
					? cardPack.getSmsCount() - card.getRealSMSCount() : 0;
			meg.append("����������" + remainSmsCount + "��\n");
			remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow() - card.getRealFlow() : 0;
			meg.append("����������" + Common.dataFormat(remainFlow * 1.0 / 1024) + "GB");

			// ����ת�������ײ�
		} else if (pack instanceof NetPackage) {
			NetPackage cardPack = (NetPackage) pack;
			// ��ѯ�ײ���ʣ�������
			remainFlow = cardPack.getFlow() > card.getRealFlow() ? cardPack.getFlow() - card.getRealFlow() : 0;

			meg.append("����������" + Common.dataFormat(remainFlow * 1.0 / 1024) + "GB");

			// ����ת�ͻ���
		} else if (pack instanceof TalkPackage) {
			TalkPackage cardPack = (TalkPackage) pack;
			remainTalkTime = cardPack.getTalkTime() > card.getRealTalkTime()
					? cardPack.getTalkTime() - card.getRealTalkTime() : 0;
			meg.append("ͨ��ʱ����" + remainTalkTime + "����\n");

			remainSmsCount = cardPack.getSmsCount() > card.getRealSMSCount()
					? cardPack.getSmsCount() - card.getRealSMSCount() : 0;
			meg.append("����������" + remainSmsCount + "��");
		}
		System.out.println(meg);
	}

	/*
	 * �����˵���ѯ
	 */
	public void showAmountDetaul(String searNumber) {
		MobileCard card;
		StringBuffer meg = new StringBuffer();
		card = cards.get(searNumber);
		meg.append("���Ŀ��ţ�" + card.getCardNumber() + "�������˵���\n");
		meg.append("�ײ��ʷѣ�" + card.getSerPackage().getPrice() + "Ԫ\n");
		meg.append("�ϼƣ�" + Common.dataFormat(card.getConsumAmount()) + "Ԫ\n");
		meg.append("�˻���" + Common.dataFormat(card.getMoney()) + "Ԫ");

		System.out.println(meg);
	}

	// �����ײͶ������������ǵĹ�����
	public ServicePackage createPack(int packId) {
		ServicePackage pack = null;
		switch (packId) {
		case 1:
			pack = new TalkPackage();
			break;
		case 2:
			pack = new NetPackage();
			break;
		case 3:
			pack = new SuperPackage();
			break;
		}
		return pack;
	}

	/**
	 * ���һ��ָ���������Ѽ�¼
	 * @param number  Ҫ������Ѽ�¼�Ŀ�
	 * @param Info  Ҫ��ӵ����Ѽ�¼
	 */
	public void addConsumInfo(String number, ConsumInfo Info) {
		Set<String> numbers = consumInfos.keySet();
		Iterator<String> it = numbers.iterator();
		List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
		boolean isExist = false;
		while(it.hasNext()){
			if (it.next().equals(number)) {
				infos = consumInfos.get(number);
				infos.add(Info);
				isExist = true;
				System.out.println("�����һ�����Ѽ�¼��");
				break;
			}
		}
		if (!isExist) {
			infos.add(Info);
			consumInfos.put(number, infos);
			System.err.println("�����ڴ˿������Ѽ�¼�������һ�����Ѽ�¼��");
		}
	}

	public void useSoso(String number) {
		MobileCard card = cards.get(number);//��ȡ�ÿ�����
		ServicePackage pack = card.getSerPackage();
		Random random = new Random();
		int ranNum = 0;
		int temp = 0;
		do {
			ranNum = random.nextInt(6);
			Scene scene = scenes.get(ranNum);
			switch (ranNum) {
			case 0:
			case 1:
				if (pack instanceof CallService) {
					System.out.println(scene.getDescription());
					CallService callService = (CallService) pack;
					try{
						temp = callService.call(scene.getData(), card);
					}catch (Exception e) {
						e.printStackTrace();
					}
					addConsumInfo(number, new ConsumInfo(number,
							scene.getType(),temp));
					break;
				}else {
					continue;
				}
			case 2:
			case 3:
				if (pack instanceof SendService) {
					System.out.println(scene.getDescription());
					SendService sendService = (SendService) pack;
					try {
						temp = sendService.send(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					addConsumInfo(number, new ConsumInfo(number,
							scene.getType(),temp));
					break;
				}else {
					continue;
				}
			
			case 4:
			case 5:
				if (pack instanceof NetService) {
					System.out.println(scene.getDescription());
					
					NetService netService = (NetService) pack;
					try {
						temp = netService.netPlay(scene.getData(), card);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					addConsumInfo(number, new ConsumInfo(number,
							scene.getType(),temp));
					break;
					
				}else {
					continue;
				}
			}
			break;
		} while (true);
	}
	
	/**
	 * ��ʾ�ʷ�˵��
	 */
	public void showDescription() {
		Reader reader = null;
		try {
			reader = new FileReader("F:\\Java\\��\\�ײ��ʷ�˵��.txt");
			char [] content = new char[1024];
			int len = 0;
			StringBuffer sb = new StringBuffer();
			while((len=reader.read(content))!=-1){
				sb.append(content,0,len);
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * �����ײͷ���
	 * @param number  �ֻ�����
	 * @param packNum �˵����
	 */
	public void changingPack(String number, int packNum) {
		MobileCard card;
		ServicePackage pack;
		if (isExistCard(number)) {
			card = cards.get(number);
			switch (packNum) {
			case 1:
				pack = new TalkPackage();
				break;
			case 2:
				pack = new NetPackage();
				break;

			default:
				pack = new SuperPackage();
				break;
			}
			if (!(card.getSerPackage().getClass().getName().equals(pack.getClass().getName()))) {
				if (card.getMoney() >= pack.getPrice()) {
					card.setMoney(card.getMoney() - pack.getPrice());
					card.setSerPackage(pack);
					card.setRealTalkTime(0);
					card.setRealFlow(0);
					card.setRealSMSCount(0);
					card.setConsumAmount(pack.getPrice());
					System.out.println("�����ײͳɹ���");
					
					pack.showInfo();
				}else{
					System.out.println("�Բ�������������֧�����ײͱ����ʷѣ����ֵ���ٰ�������ײ�ҵ��");
					return;
				}
			}else{
				System.out.println("�Բ������Ѿ��Ǹ��ײ��û������軻�ײͣ�");
			}
		}else{
			System.out.println("�Բ��𣬸ÿ���δע�ᣬ���ܻ��ײͣ�");
		}
		
	}

	
	
	public void printConsumInfo(String number) {
		Writer fileWriter = null;
		try {
			fileWriter = new FileWriter(number+"���Ѽ�¼.txt");
			Set<String> numbers = consumInfos.keySet();
			Iterator<String> it = numbers.iterator();
			List<ConsumInfo> infos = new ArrayList<ConsumInfo>();
			
			boolean isExist = false;
			while(it.hasNext()){
				if (it.next().equals(number)) {
					infos = consumInfos.get(number);
					isExist = true;
					
					break;
				}
			}
			if (isExist) {
				StringBuffer content = new StringBuffer("******"+number+"���Ѽ�¼******\r\n");
				content.append("\r\n���\t����\t���ݣ�ͨ��������/������MB��/���ţ�������\r\n");
				for (int i = 0; i < infos.size(); i++) {
					ConsumInfo info = infos.get(i);
					content.append((i+1)+".\t"+info.getType()+"\t"+info.getConsumData()+"\n");
				}
				fileWriter.write(content.toString());
				fileWriter.flush();
				System.out.println("���Ѽ�¼��ӡ��ϣ�");
				
			}else{
				System.out.println("�Բ��𣬲����ڴ˺�������Ѽ�¼�����ܴ�ӡ��");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fileWriter!=null) {
				try{
					fileWriter.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
		}
		
		
	}

	/*
	 * ���ѳ�ֵ
	 */
	public void chargeMoney(String number,double money) {
		MobileCard card;
		if (money < 50) {
			System.out.println("�Բ������ֵ���Ϊ50Ԫ��");
			return;
		}
		card = cards.get(number);
		card.setMoney(card.getMoney()+money);
		System.out.println("��ֵ�ɹ�����ǰ�������Ϊ"+Common.dataFormat(card.getMoney())+"Ԫ");
		
	}

}
