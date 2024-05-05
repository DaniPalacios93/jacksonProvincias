package jsonProvincias.controlers;

import com.mongodb.MongoClientURI;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class SuperControlador {

	private final int port_no = 22017;
	private final String host_name = "localhost";
	private final String db_name = "ComunidadesProvinciasPoblaciones";
	private String collectionName = "";
	
	
	private MongoDatabase db = null;
	
	
	public SuperControlador(String collection) {
		this.collectionName = collection;
	}
	
	
	/**
	 * 
	 * @return
	 */
	protected MongoDatabase getConexion() {
		
		if(db == null) {
			String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
			MongoClientURI uri = new MongoClientURI(client_url);
	        MongoClient mongo_client = new MongoClient(uri);
	        
	        db = mongo_client.getDatabase(db_name);
		}
		return db; 
	}
	
	
	/**
	 * 
	 * @return
	 */
	protected MongoCollection<Document> getCollection(){
		return getConexion().getCollection(collectionName);
	}
	

	
	
}
