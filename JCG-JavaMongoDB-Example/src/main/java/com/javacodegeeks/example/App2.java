package com.javacodegeeks.example;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class App2 {
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
		MongoDatabase jcgDatabase = mongoClient.getDatabase("JavaCodeGeeks");

		// create collection
//		jcgDatabase.createCollection("authors");
//		jcgDatabase.createCollection("posts");

		// insert into a collection
		MongoCollection<Document> authorCollection = jcgDatabase.getCollection("authors");
//		Document document = new Document();
//		document.put("name", "Shubham");
//		document.put("company", "JCG");
//		document.put("post_count", 20);
//		authorCollection.insertOne(document);
//		System.out.println("Inserted document = " + document);

		// update a document
		//Find existing document
//		Document updateQuery = new Document();
//		updateQuery.put("name", "Shubham");
//		//Field to update
//		Document newNameDocument = new Document();
//		newNameDocument.put("name", "Shubham Aggarwal");
//		//Perform set operation
//		Document updateObject = new Document();
//		updateObject.put("$set", newNameDocument);
//		UpdateResult updateResult = authorCollection.updateOne(updateQuery, updateObject);
//		System.out.println("Documents updated: " + updateResult.getModifiedCount());
		
		// getting all documents
//		Document searchQuery = new Document();
//		searchQuery.put("company", "JCG");
//		FindIterable<Document> documents = authorCollection.find(searchQuery);
//		for (Document document: documents) {
//		    System.out.println(document);
//		}

		// deleting a document
		Document deleteSearchQuery = new Document();
		deleteSearchQuery.put("_id", new ObjectId("5c504243ebe5dd373c29098a"));
		DeleteResult deleteResult = authorCollection.deleteOne(deleteSearchQuery);
		System.out.println("Documents updated: " + deleteResult.getDeletedCount());
		
		mongoClient.close();
		
		System.out.println("Bye!");
	}
}
