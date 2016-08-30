/**
 * Copyright (c) 2014-2016 www.nryuncang.com. All Rights Reserved.
 */
package redis;

/**
 * 
 *
 * @author <a href=mailto:zhangweize@nryuncang.com>zhangweize</a>
 * @version 1.0.0
 */

import redis.clients.jedis.Jedis;

public class Utils {
	private static final String ip = "127.0.0.1";
	private static final Integer port = 6379;
	
	public static  Jedis connection() {
		Jedis jedis = new Jedis(ip,port);
		return jedis;
	}
	 
}

