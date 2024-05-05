package jsonProvincias.controlers;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import jsonProvincias.entities.Ccaa;

public class ControladorCcaa extends SuperControlador {

	private static ControladorCcaa instance = null;
	
	
	
	public ControladorCcaa() {
		super("ccaa");
	}
	

	
	public static ControladorCcaa getInstance() {
		if(instance == null) {
			instance = new ControladorCcaa();
		}
		return instance;
	}
	
	
	
	/**
	 * 
	 * @param doc
	 * @return
	 */
	private Ccaa documentToProvicia(Document doc) {
		
		Ccaa p = new Ccaa();
		
		p.setParent_code(doc.getString("parent_code"));
		p.setCode(doc.getString("code"));
		p.setLabel(doc.getString("label"));
		
		return p;
	}
	
	/**
	 * 
	 * @param col
	 * @return
	 */
    public List<Ccaa> getAllCcaa() {
 
    	MongoCollection<Document> col = getCollection();
        FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();

        List<Ccaa> allCcaa = new ArrayList<Ccaa>();
        try {
            while(cursor.hasNext()) {
            	allCcaa.add(documentToProvicia(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        return allCcaa;
    }
	
    /**
     * Ejemplo de modificación de una entidad
     * @param col
     */
    public void updateDocument (Ccaa c) {
    	
    	MongoCollection<Document> col = getCollection();
    	
        try {
        	Document query = new Document().append("code", c.getCode());
        	Bson update = Updates.combine(
        			Updates.set("label", c.getLabel())
        			);
        	
        	col.updateOne(query, update);
        	
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
	
    
    /**
     * 
     */
    public void getSelectiveDocument() {
    	
    	MongoCollection<Document> col = getCollection();
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find(Filters.eq("label", "Andalucía"));        
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
            	System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }
	
}
