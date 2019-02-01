package test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.*;
public class TestMain {

	/*
	 * Code examples from https://www.baeldung.com/jedis-java-redis-client-library
	 * 
	 */
	public static void main(String[] args) throws IOException {
		Jedis jedis = new Jedis();
		//Strings
		jedis.set("events/city/rome", "32,15,223,828");
		String cachedResponse = jedis.get("events/city/rome");
		System.out.println(cachedResponse);
		//List
		jedis.lpush("queue#tasks", "firstTask");
		jedis.lpush("queue#tasks", "secondTask");
		String task = jedis.rpop("queue#tasks");
		System.out.println(task);
		//Set
		jedis.sadd("nicknames", "nickname#1");
		jedis.sadd("nicknames", "nickname#2");
		jedis.sadd("nicknames", "nickname#1");
		Set<String> nicknames = jedis.smembers("nicknames");
		boolean exists = jedis.sismember("nicknames", "nickname#1");
		System.out.println(exists);
		for(String str : nicknames) {
			System.out.println(str);
		}
		//Hashtable
		jedis.hset("user#1", "name", "Peter");
		jedis.hset("user#1", "job", "politician");  
		String name = jedis.hget("user#1", "name");
		System.out.println(name);
		Map<String, String> fields = jedis.hgetAll("user#1");
		String job = fields.get("job");
		System.out.println(job);
		//Sorted set
		Map<String, Double> scores = new HashMap<>();
		scores.put("PlayerOne", 3000.0);
		scores.put("PlayerTwo", 1500.0);
		scores.put("PlayerThree", 8200.0);
		scores.entrySet().forEach(playerScore -> {
		    jedis.zadd("key", playerScore.getValue(), playerScore.getKey());
		});
		String player = jedis.zrevrange("ranking", 0, 1).iterator().next();
		System.out.println(player);
		Long rank = jedis.zrevrank("ranking", "PlayerOne");
		System.out.println(rank);
		//Transactions
		String friendsPrefix = "friends#";
		String userOneId = "4352523";
		String userTwoId = "5552321";
		Transaction t = jedis.multi();
		t.sadd(friendsPrefix + userOneId, userTwoId);
		t.sadd(friendsPrefix + userTwoId, userOneId);
		t.exec();
		System.out.println(jedis.smembers(friendsPrefix + userOneId).size());
		//Pipelining
		String userOneId1 = "4352523";
		String userTwoId2 = "4849888";
		Pipeline p = jedis.pipelined();
		p.sadd("searched#" + userOneId1, "paris");
		p.zadd("ranking", 126, userOneId1);
		p.zadd("ranking", 325, userTwoId2);
		Response<Boolean> pipeExists = p.sismember("searched#" + userOneId1, "paris");
		Response<Set<String>> pipeRanking = p.zrange("ranking", 0, -1);
		p.sync();
		boolean exists2 = pipeExists.get();
		Set<String> ranking = pipeRanking.get();
		System.out.println(exists2);
		System.out.println(ranking.size());
		//Subscriber
		Jedis jSubscriber = new Jedis();
		jSubscriber.subscribe(new JedisPubSub() {
		    @Override
		    public void onMessage(String channel, String message) {
		        System.out.println("Message received: " + message);
		    }
		}, "channel");

		jedis.close();
		System.out.println("Bye");
	}

}
