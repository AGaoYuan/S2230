package cn.soso.biz;

import java.util.*;

import cn.soso.entity.MobileCard;
import cn.soso.entity.ServicePackage;
import cn.soso.utils.CardUtil;

public class SosoMgr {

	Scanner in = new Scanner(System.in);

	CardUtil utils = new CardUtil();

	public static void main(String[] args) {
		
		
		
		SosoMgr soso = new SosoMgr();

		soso.paintMainMeun();

		System.out.println("ллʹ�ã�");

	}

	public void paintMainMeun() {
		// ����˵�ѡ����ű���
		int meunChoose = 0;
		// ����洢�ֻ����ű���
		String mobileNumber = "";
		// ��������
		String password = "";

		/*
		 * ���ó�ʼ����Ϣ�ķ���
		 */
		utils.init();
		utils.initScene();

		do {
			System.out.println("\n***********��ӭʹ�����ƶ�ҵ�����***********");
			System.out.println("1.�û���¼       2.�û�ע��    3.ʹ����    4.���ѳ�ֵ   5.�ʷ�˵��   6.�˳�ϵͳ");
			System.out.println("��ѡ��");
			meunChoose = in.nextInt();
			switch (meunChoose) {
			case 1:
				System.out.println("�������ֻ����ţ�");
				mobileNumber = in.next();
				System.out.println("���������룺");
				password = in.next();
				if (utils.isExistCard(mobileNumber, password)) {
					CardMenu(mobileNumber);
				} else {
					System.err.println("�Բ������������Ϣ�����޷���½��(�����û���ֻ��ţ�����ȥע�ᣡ)");
				}
				continue;
			case 2:
				registCard();
				
				continue;
			case 3:
				System.out.println("�������ֻ��ţ�");
				mobileNumber = in.next();

				if (utils.isExistCard(mobileNumber)) {
					try {
						utils.useSoso(mobileNumber);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				} else {
					System.out.println("�Բ��𣬸ÿ���δע�ᣬ����ʹ�ã�");
				}
				continue;
			case 4:
				System.out.println("�������ֵ���ţ�");
				mobileNumber = in.next();
				if (utils.isExistCard(mobileNumber)) {
					System.out.println("�������ֵ��");
					double money = in.nextDouble();
					utils.chargeMoney(mobileNumber, money);
				} else {
					System.out.println("�Բ���Ҫ��ֵ�Ŀ���δע�ᣬ�޷���ֵ��");
				}

				continue;
			case 5:
				utils.showDescription();
				continue;
			case 6:
				System.out.println("ллʹ�ã�");
				System.exit(1);
				break;
			default:
				System.out.println("��������ȷ�����֣�");
				break;
			}
		} while (true);

	}

	public int CardMenu(String mobileNumber) {
		int menuChoose = 0;
		do {
			System.out.println("\n*****���ƶ��û��˵�*****");
			System.out.println("1.�����˵���ѯ");
			System.out.println("2.�ײ�������ѯ");
			System.out.println("3.��ӡ�����굥");
			System.out.println("4.�ײͱ��");
			System.out.println("5.��������");
			System.out.println("��ѡ��(����1~5ѡ���ܣ�������������һ��)��");
			menuChoose = in.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("\n*****�����˵���ѯ*****");
				utils.showAmountDetaul(mobileNumber);
				continue;
			case 2:
				System.out.println("\n*****�ײ�������ѯ*****");
				utils.showRemainDetail(mobileNumber);
				continue;
			case 3:
				System.out.println("\n*****�����굥��ѯ*****");
				utils.printConsumInfo(mobileNumber);
				continue;
			case 4:
				System.out.println("\n*****�ײͱ��*****");
				System.out.println("1.�����ײ�  2.�����ײ�  3.�����ײ�  ��ѡ��(���)��");
				int num = in.nextInt();
				if (num!=1&&num!=2&&num!=3) {
					System.err.println("������ָ���ײͣ�");
					continue;
				}else {
					utils.changingPack(mobileNumber, num);
				}
				
				continue;
			case 5:
				System.out.println("\n*****��������*****");
				utils.delCard(mobileNumber);
				System.out.println("ллʹ�ã�");
				System.exit(1);
			}
			break;
		} while (true);
		return menuChoose;
	}

	public void registCard() {
		String[] newNumbers = utils.getNewNumbers(9);
		System.out.println("*****��ѡ��Ŀ���*****");

		for (int i = 0; i < 9; i++) {
			System.out.print((i + 1) + "." + newNumbers[i] + "\t\t");
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println("��ѡ�񿨺�(����1~9�����)��");
		String number = newNumbers[in.nextInt() - 1];
		System.out.println("1.�����ײ�  2.�����ײ�  3.�����ײ� ����ѡ���ײ�(�������)��");
		ServicePackage pack = utils.createPack(in.nextInt());
		System.out.println("������������");
		String name = in.next();

		System.out.println("���������룺");
		String password = in.next();

		double money = 0;
		System.out.println("������Ԥ�滰�ѽ�");
		money = in.nextDouble();
		while (money < pack.getPrice()) {
			System.out.println("��Ԥ��Ļ��ѽ�����֧�����¹̶��ײ��ʷѣ������³�ֵ��");
			money = in.nextDouble();
		}
		MobileCard mobileCard = new MobileCard
				(name, password, number, pack, pack.getPrice(), money - pack.getPrice());
		utils.addCard(mobileCard);

	}

}
