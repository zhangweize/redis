/**
 * Copyright (c) 2014-2016 www.nryuncang.com. All Rights Reserved.
 */
package redis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 
 *
 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
 * @version 1.0.0
 */
public class Redis implements IRedis{

	private  Jedis jedis = 	Utils.connection();
	/**
	 * ����String���͵�key-value
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void set(String key, String value) throws Exception {
		
		jedis.set(key, value);
	}

	/**
	 * ����key �õ� String���͵�value
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public String get(String key) throws Exception {
		return jedis.get(key);
	}

	/**
	 *����Set���͵�key-value
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void setAdd(String key, Set<String> value) throws Exception {
	  
		for(String str : value){
		    jedis.sadd(key, str);	
	    }
	}

	/**
	 * ɾ��Set���͵�key-value
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void setDel(String key, Set<String> value) throws Exception {
		
		Iterator<String> it = value.iterator();
		while (it.hasNext()){
			String str = it.next();
			jedis.srem(key, str);
		}
	}

	/**
	 * ��ȡkey��Ӧ��value����  
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public Long setSumByKey(String key) throws Exception {
		
		return jedis.scard(key);
	}

	/**
	 * ��ȡkey��Ӧ������value  
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public Set<String> setGetValuesByKey(String key) throws Exception {
		
		return jedis.smembers(key);
	}

	/**
	 * �ж��Ƿ���� 
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public boolean setIsExist(String key, String value) throws Exception {
		
		return jedis.sismember(key, value);
	}

	/**
	 * �����ȡ����
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public String setRanderByKey(String key) throws Exception {

		return jedis.srandmember(key);
	}

	/**
	 * ����Map����key-value
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void mapSet(String key, Map<String, String> map) throws Exception {

		jedis.hmset(key, map);
	}

	/**
	 * mapkey����
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public Long mapCount(String key) throws Exception {
		
		return jedis.hlen(key);
	}

	/**
	 * map�����м�ֵ
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public Set<String> mapKeys(String key) throws Exception {
		
		return jedis.hkeys(key);
	}

	/**
	 * map������value 
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public List<String> mapVals(String key) throws Exception {
		
		return jedis.hvals(key);
	}

	/**
	 * ȡ��map�е�name��password�ֶ�ֵ 
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public List<String> mapGet(String key, String s1, String s2) throws Exception {

		return jedis.hmget(key, s1, s2);
	}

	/**
	 * ɾ��map�е�ĳһ����ֵ
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void mapDel(String key, String s) throws Exception {
		
		jedis.hdel(key, s);
	}

	/**
	 * ����List���͵�key-value
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void listPush(String key, List<String> list) throws Exception {
		
		for(String s: list){
			jedis.lpush(key, s);
		}
	}

	/**
	 * ����key��ȡList��Χ
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public List<String> listRange(String key, Long start, Long end) throws Exception {
		
		return jedis.lrange(key, start, end);
	}

	/**
	 * ɾ���������ر����б���key�ĵ�һ��Ԫ�� 
	 * 
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public String listPop(String key) throws Exception {
		
		return jedis.lpop(key);
	}
	
	/**
	 * 
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void del(String key) throws Exception {
		
		jedis.del(key);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void append(String key, String value) throws Exception {
		
		jedis.append(key, value);
	}

}
