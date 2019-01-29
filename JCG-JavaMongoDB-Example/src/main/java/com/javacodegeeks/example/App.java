package com.javacodegeeks.example;

import java.net.UnknownHostException;
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
public class App 
{
    public static void main( String[] args ) 
    {
        System.out.println( "Hello World!" );
//        try {
//			MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
//			
//			DB database = mongoClient.getDB("Examples");
//			DBCollection collection = database.getCollection("people");
//
//			List<Integer> books = Arrays.asList(27464, 747854);
//			DBObject person = new BasicDBObject("_id", "jo")
//			                            .append("name", "Jo Bloggs")
//			                            .append("address", new BasicDBObject("street", "123 Fake St")
//			                                                         .append("city", "Faketon")
//			                                                         .append("state", "MA")
//			                                                         .append("zip", 12345))
//			                            .append("books", books);
//			collection.insert(person);
//			DBObject query = new BasicDBObject("_id", "jo");
//			DBCursor cursor = collection.find(query);
//			DBObject jo = cursor.one();
//			System.out.println((String)cursor.one().get("name"));
//			database.dropDatabase();
			System.out.println( "Bye!" );
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			MongoClient.close()
//		}
    }
}
