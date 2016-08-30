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
	void set(String key, String value) throws Exception;// 添加
	String get(String key) throws Exception;// 获取
	
	//set
	void setAdd(String key, Set<String> value) throws Exception;//添加
	void setDel(String key, Set<String> value) throws Exception;//删除 
	Long setSumByKey(String key) throws Exception;//获取key对应的value总数  
	Set<String> setGetValuesByKey(String key) throws Exception;////获取key对应的所有value  
	boolean setIsExist(String key, String value) throws Exception;//判断是否存在 
	String setRanderByKey(String key) throws Exception;	//随机获取数据  

	//map
	void mapSet(String key, Map<String,String> map) throws Exception;//添加  
	Long mapCount(String key) throws Exception;//mapkey个数
	Set<String> mapKeys(String key) throws Exception;//map中所有键值  
	List<String> mapVals(String key) throws Exception;////map中所有value  
	List<String> mapGet(String key, String s1, String s2) throws Exception;//取出map中的name、password字段值 
	void mapDel(String key, String s) throws Exception;;//删除map中的某一个键值
	
	//list
	void listPush(String key, List<String> list) throws Exception;//添加 
	List<String> listRange(String key, Long start, Long end) throws Exception;//获取 
	String listPop(String key) throws Exception;//删除，并返回保存列表在key的第一个元素 
	
	void del(String key) throws Exception;//删除
	
	  //append  
   void append(String key,String value) throws Exception;//追加  

	
}
