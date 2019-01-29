package com.javacodegeeks.example;

import java.util.Arrays;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		/**
		 * connecting to a secured database
		 */
//    	System.out.println("Connecting to DB...");
//    	List<MongoCredential> credentialsList = new ArrayList<>();
//    	//Use username, authtication database and password in MongoCredential object
//    	MongoCredential creds = MongoCredential.createCredential("db_user", "admin", "db_password".toCharArray());
//    	credentialsList.add(creds);
//    	ServerAddress serverAddress = new ServerAddress("localhost", 27017); //host and port
//    	MongoClient mongoClient = new MongoClient(serverAddress, credentialsList);
//    	System.out.println("Connected to MongoDB...");
		/**
		 * connecting to a non secured database
		 */
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

		DB database = mongoClient.getDB("Examples");
		DBCollection collection = database.getCollection("people");

		List<Integer> books = Arrays.asList(27464, 747854);
		DBObject person = new BasicDBObject("_id", "jo").append("name", "Jo Bloggs")
				.append("address", new BasicDBObject("street", "123 Fake St").append("city", "Faketon")
						.append("state", "MA").append("zip", 12345))
				.append("books", books);
		collection.insert(person);
		DBObject query = new BasicDBObject("_id", "jo");
		DBCursor cursor = collection.find(query);
		DBObject jo = cursor.one();
		System.out.println((String) cursor.one().get("name"));
		database.dropDatabase();
		mongoClient.close();
		
		System.out.println("Bye!");
	}
}
