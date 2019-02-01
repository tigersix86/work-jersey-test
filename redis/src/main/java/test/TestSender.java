package test;

import redis.clients.jedis.Jedis;

public class TestSender {

	public static void main(String[] args) {
		Jedis jPublisher = new Jedis();
		jPublisher.publish("channel", "test message");
		System.out.println("Message sent");
		jPublisher.close();
	}

}
