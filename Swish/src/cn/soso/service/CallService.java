package cn.soso.service;

import cn.soso.entity.MobileCard;

/**
 * ͨ������ӿ�
 * @author Mr.Gao
 *
 */
public interface CallService {
	
	public int call(int minCount,MobileCard card) throws Exception;
	
}
