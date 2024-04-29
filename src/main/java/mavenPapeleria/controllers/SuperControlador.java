package mavenPapeleria.controllers;

import com.mongodb.MongoClientURI;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;



public class SuperControlador {

	private final int port_no = 22017;
	private final String host_name = "localhost";
	private final String db_name = "ComunidadesProvinciasPoblaciones";
	
	
	private MongoDatabase db = null;
	
	
	
	protected MongoDatabase getConexion() {
		
		if(db == null) {
			String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
			MongoClientURI uri = new MongoClientURI(client_url);
	        MongoClient mongo_client = new MongoClient(uri);
	        
	        db = mongo_client.getDatabase(db_name);
		}
		return db; 
	}
	
	
	

	
	
}
