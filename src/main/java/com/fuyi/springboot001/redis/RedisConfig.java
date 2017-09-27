package com.fuyi.springboot001.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration // 相当于applicationContext.xml
public class RedisConfig {
	
	@Value("${spring.redis.cluster.nodes}")
	private String clusterNodes;
	
	@Bean //<bean>
	public JedisCluster getJedisCluster() {
		//分割集群节点
		//String[] cNodes = clusterNodes.split(",");
		
		//创建Set集合对象
		/*Set<HostAndPort> nodes = new HashSet<>();
		for(String node : cNodes) {
			String[] split = node.split(":");
			nodes.add(new HostAndPort(split[0], Integer.parseInt(split[1])));
		}*/
		
		//创建REDIS集群对象
		String[] split = clusterNodes.split(":");
		HostAndPort node = new HostAndPort(split[0], Integer.parseInt(split[1]));
		JedisCluster jedisCluster = new JedisCluster(node);
		jedisCluster.auth("root");
		return jedisCluster;
	}

}
