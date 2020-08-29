package com.atguigu.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
/**
 *自定义/算法
 */
public class RandomRule_ZY extends AbstractLoadBalancerRule{
//	Random rand;
//	public RandomRule() {
//		rand = new Random();
//	}
	private int total = 0;
	private int currentIndex = 0;
	
	public Server choose(ILoadBalancer lb, Object key) {
		if(lb==null) {
			return null;
		}
		Server server=null;
		while (server == null) {
			if(Thread.interrupted()) {
				return null;
			}
			List<Server> upList= lb.getReachableServers();
			List<Server> allList=lb.getAllServers();
			int serverCount = allList.size();
			if(serverCount == 0) {
				return null;
			}
			
//			int index =rand.nextInt(serverCount);
//			server = upList.get(index);
			//total  currentIndex
			if(total < 5) {
				server =upList.get(currentIndex);
				total++;
			}else {
				total =0;
				currentIndex++;
				if(currentIndex >= upList.size()) {
					currentIndex=0;
				}
			}
			
			if(server == null) {
				Thread.yield();
				continue;
			}
			if(server.isAlive()) {
				return (server);
			}
			server = null;
			Thread.yield();
		}
		return server;
	}
	

	public Server choose(Object key) {
		return choose(getLoadBalancer(),key);
	}
	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
	}
}
