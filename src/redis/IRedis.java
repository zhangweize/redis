/**
 * Copyright (c) 2014-2016 www.nryuncang.com. All Rights Reserved.
 */
package redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 *
 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
 * @version 1.0.0
 */
public interface IRedis  {
	// String
	void set(String key, String value) throws Exception;// ���
	String get(String key) throws Exception;// ��ȡ
	
	//set
	void setAdd(String key, Set<String> value) throws Exception;//���
	void setDel(String key, Set<String> value) throws Exception;//ɾ�� 
	Long setSumByKey(String key) throws Exception;//��ȡkey��Ӧ��value����  
	Set<String> setGetValuesByKey(String key) throws Exception;////��ȡkey��Ӧ������value  
	boolean setIsExist(String key, String value) throws Exception;//�ж��Ƿ���� 
	String setRanderByKey(String key) throws Exception;	//�����ȡ����  

	//map
	void mapSet(String key, Map<String,String> map) throws Exception;//���  
	Long mapCount(String key) throws Exception;//mapkey����
	Set<String> mapKeys(String key) throws Exception;//map�����м�ֵ  
	List<String> mapVals(String key) throws Exception;////map������value  
	List<String> mapGet(String key, String s1, String s2) throws Exception;//ȡ��map�е�name��password�ֶ�ֵ 
	void mapDel(String key, String s) throws Exception;;//ɾ��map�е�ĳһ����ֵ
	
	//list
	void listPush(String key, List<String> list) throws Exception;//��� 
	List<String> listRange(String key, Long start, Long end) throws Exception;//��ȡ 
	String listPop(String key) throws Exception;//ɾ���������ر����б���key�ĵ�һ��Ԫ�� 
	
	void del(String key) throws Exception;//ɾ��
	
	  //append  
   void append(String key,String value) throws Exception;//׷��  

	
}
