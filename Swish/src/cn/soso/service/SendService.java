package cn.soso.service;

import cn.soso.entity.MobileCard;

/**
 * ���ŷ���ӿ�
 * @author Mr.Gao
 *
 */
public interface SendService {
	
	public int send(int Count,MobileCard card) throws Exception;
	
}
