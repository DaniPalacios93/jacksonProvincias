package mavenPapeleria.entities;

public class Provincia extends Entidad {
	
	private String _id;
	private String parent_code;
	private String code;
	private String label;
	
	
	
	// CONSTRUCTORES
	
	public Provincia() {
		super();
	}


	
	// GETTERS & SETTERS

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

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
