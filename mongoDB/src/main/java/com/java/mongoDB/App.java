package com.java.mongoDB;

import java.net.UnknownHostException;
import java.util.Set;

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
			
			BasicDBObject q = new BasicDBObject();
			q.put("name", "robin");
			
			BasicDBObject newDoc = new BasicDBObject();
			newDoc.put("name", "robin-new");
			
			BasicDBObject updatedDoc = new BasicDBObject();
			updatedDoc.put("$set", newDoc);
			
			t.update(q, updatedDoc);
			
			BasicDBObject qNew = new BasicDBObject();
			qNew.put("name", "robin-new");
			
			DBCursor position2 = t.find(qNew);
			
			while(position2.hasNext()){
				System.out.println(position2.next());
			}
			
			//delete
			System.out.println("----DELETING COLLECTION------");
			t.drop();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
