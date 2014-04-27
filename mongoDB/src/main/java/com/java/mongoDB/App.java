package com.java.mongoDB;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			
			DB db = mongo.getDB("testdb");
			DBCollection t = db.getCollection("user");
			
			BasicDBObject doc = new BasicDBObject();
			doc.put("name", "robin");
			doc.put("address", "nepal");
			doc.put("number","1234567890");
			t.insert(doc);
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "robin");
			
			DBCursor position = t.find(searchQuery);
			
			while(position.hasNext()){
				System.out.println(position.next());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
