package mavenPapeleria.controllers;

import org.bson.Document;

import mavenPapeleria.entities.Provincia;

public class ControladorProvincia extends SuperControlador{

	
	private Provincia documentToProvicia(Document doc) {
		
		Provincia p = new Provincia();
		
		p.setParent_code(doc.getString("parent_code"));
		p.setCode(doc.getString("code"));
		p.setLabel(doc.getString("label"));
		
		return p;
		
	}
	
	
}
