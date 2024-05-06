package jsonProvincias.controlers;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Updates;

import jsonProvincias.entities.Provincia;

public class ControladorProvincia extends SuperControlador{
	
	private static ControladorProvincia instance = null;
	
	
	
	public ControladorProvincia() {
		super("provincias");
	}

	
	
	public static ControladorProvincia getInstance() {
		if(instance == null) {
			instance = new ControladorProvincia();
		}
		return instance;
	}
	
	
	/**
	 * 
	 * @param doc
	 * @return
	 */
	private Provincia documentToProvicia(Document doc) {
		
		Provincia p = new Provincia();
		
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
    public List<Provincia> getAllProvincias() {
 
    	MongoCollection<Document> col = getCollection();
        FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();

        List<Provincia> allProvincias = new ArrayList<Provincia>();
        try {
            while(cursor.hasNext()) {
            	allProvincias.add(documentToProvicia(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        return allProvincias;
    }
 
    
    /**
     * Ejemplo de modificación de una entidad
     * @param col
     */
    public void updateDocument (Provincia p) {
    	
    	MongoCollection<Document> col = getCollection();
    	
        try {
        	Document query = new Document().append("code", p.getCode());
        	Bson update = Updates.combine(
        			Updates.set("parent_code", p.getParent_code()),
        			Updates.set("label", p.getLabel())
        			);
        	
        	col.updateOne(query, update);
        	
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
	
	
}
