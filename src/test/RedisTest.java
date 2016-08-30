/**
 * Copyright (c) 2014-2016 www.nryuncang.com. All Rights Reserved.
 */
package test;

import java.util.HashSet;
import java.util.Set;

import redis.Redis;

/**
 * 
 *
 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
 * @version 1.0.0
 */
public class RedisTest {

	/**
	 * 
	 *
	 * @param args [参数说明]
	 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
	 * @version 1.0.0
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		sadd();
	}
	
	public static void sadd() throws Exception{
		Redis r = new Redis();
		Set<String> set = new HashSet<String>();
		set.add("w");
		set.add("b");
		r.setAdd("zsss",set);
		Set<String> t = r.setGetValuesByKey("zsss");
		System.out.println(t);
	}

}
