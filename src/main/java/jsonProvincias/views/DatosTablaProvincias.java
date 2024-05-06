package jsonProvincias.views;

import java.util.List;

import jsonProvincias.controlers.ControladorProvincia;
import jsonProvincias.entities.Provincia;

public class DatosTablaProvincias {
	
	private static List<Provincia> provincias;
	
	
	
	
	public static String[] getTitulosColumnas() {
		return new String[] {
				"parent_code",
				"code",
				"label"
				};
	}
	
	
	
	public static Object[][] getDatosDeTabla(){
		
		provincias = ControladorProvincia.getInstance().getAllProvincias();
		Object[][] datos = new Object[provincias.size()][getTitulosColumnas().length];
		
		for (int i = 0; i < provincias.size(); i++) {
			
			System.out.println("cargando datos de provincia" + i);
			
			Provincia provincia = provincias.get(i);
			
			datos[i][0] = provincia.getParent_code();
			System.out.println("La provincia " + i + " tiene un parent code de " + datos[i][0]);
			datos[i][1] = provincia.getCode();
			datos[i][2] = provincia.getLabel();
		}	
		return datos;
	}
	
	
	public static Provincia getProvinciaByFila(int i) {
		
		return provincias.get(i);
	}
	
	
}
