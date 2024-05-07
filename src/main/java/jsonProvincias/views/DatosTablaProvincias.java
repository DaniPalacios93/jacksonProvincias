package jsonProvincias.views;

import java.util.List;

import jsonProvincias.controlers.ControladorProvincia;
import jsonProvincias.entities.Provincia;

public class DatosTablaProvincias {
	
	private static List<Provincia> provincias = null;
	
	
	
	/**
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {
				"parent_code",
				"code",
				"label"
				};
	}
	
	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla(){
		
		provincias = ControladorProvincia.getInstance().getAllProvincias();
		Object[][] datos = new Object[provincias.size()][getTitulosColumnas().length];
		
		for (int i = 0; i < provincias.size(); i++) {
			
			Provincia provincia = provincias.get(i);
			
			datos[i][0] = provincia.getParent_code();
			datos[i][1] = provincia.getCode();
			datos[i][2] = provincia.getLabel();
		}	
		return datos;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Provincia> getAllProvincias() {
		
		if(provincias == null) {
			provincias = ControladorProvincia.getInstance().getAllProvincias();
		}
		return provincias;
	}
	
	
}
