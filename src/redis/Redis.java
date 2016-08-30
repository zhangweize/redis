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
	 * 保存String类型的key-value
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void set(String key, String value) throws Exception {
		
		jedis.set(key, value);
	}

	/**
	 * 根据key 得到 String类型的value
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public String get(String key) throws Exception {
		return jedis.get(key);
	}

	/**
	 *保存Set类型的key-value
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
	 * 删除Set类型的key-value
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
	 * 获取key对应的value总数  
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public Long setSumByKey(String key) throws Exception {
		
		return jedis.scard(key);
	}

	/**
	 * 获取key对应的所有value  
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public Set<String> setGetValuesByKey(String key) throws Exception {
		
		return jedis.smembers(key);
	}

	/**
	 * 判断是否存在 
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public boolean setIsExist(String key, String value) throws Exception {
		
		return jedis.sismember(key, value);
	}

	/**
	 * 随机获取数据
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public String setRanderByKey(String key) throws Exception {

		return jedis.srandmember(key);
	}

	/**
	 * 保存Map类型key-value
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void mapSet(String key, Map<String, String> map) throws Exception {

		jedis.hmset(key, map);
	}

	/**
	 * mapkey个数
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public Long mapCount(String key) throws Exception {
		
		return jedis.hlen(key);
	}

	/**
	 * map中所有键值
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public Set<String> mapKeys(String key) throws Exception {
		
		return jedis.hkeys(key);
	}

	/**
	 * map中所有value 
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public List<String> mapVals(String key) throws Exception {
		
		return jedis.hvals(key);
	}

	/**
	 * 取出map中的name、password字段值 
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public List<String> mapGet(String key, String s1, String s2) throws Exception {

		return jedis.hmget(key, s1, s2);
	}

	/**
	 * 删除map中的某一个键值
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public void mapDel(String key, String s) throws Exception {
		
		jedis.hdel(key, s);
	}

	/**
	 * 保存List类型的key-value
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
	 * 根据key获取List范围
	 * {@inheritDoc}
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 */
	@Override
	public List<String> listRange(String key, Long start, Long end) throws Exception {
		
		return jedis.lrange(key, start, end);
	}

	/**
	 * 删除，并返回保存列表在key的第一个元素 
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
