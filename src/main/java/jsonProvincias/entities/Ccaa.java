package jsonProvincias.entities;

public class Ccaa extends Entidad{
	
	private String parent_code;
	private String code;
	private String label;
	
	
	// CONSTRUCTORES
	
	public Ccaa() {
		super();
	}
	
	
	// GETTERS & SETTERS

	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
