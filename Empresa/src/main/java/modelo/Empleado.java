/**
 * 
 */
package modelo;

/**
 * @author fjdl
 *
 */
public class Empleado extends Persona {

	private int categoria=1;
	public int anyos=0;
	
	/**
	 * @param nombre
	 * @param dni
	 * @param sexo
	 * @param categoria
	 * @param anyos
	 */
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException{
		super(nombre, dni, sexo);
		this.setCategoria(categoria);
		if (anyos>=0)
			this.anyos = anyos;
		else throw new DatosNoCorrectosException();
	}

	/**
	 * @param nombre
	 * @param dni
	 * @param sexo
	 * @throws DatosNoCorrectosException 
	 */
	public Empleado(String nombre, String dni, char sexo) throws DatosNoCorrectosException {
		super(nombre, dni, sexo);
//		this.categoria=1;
//		this.anyos=0;
	}

	/**
	 * @return the categoria
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 * @throws DatosNoCorrectosException 
	 */
	public void setCategoria(int categoria) throws DatosNoCorrectosException {
		if (categoria<1 || categoria>10) {
			throw new DatosNoCorrectosException();
		}else {
			this.categoria = categoria;
		}
	}

	public int getAnyos() {
		return anyos;
	}

	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}

	/**
	 * 
	 */
	public void incrAnyo() {
		this.anyos++;
	}


	/**
	 *
	 */
	public String imprime() {
		return "Empleado ["+ super.imprime() +", categoria=" + categoria + ", anyos=" + anyos + " ]";
	}
	
	
	
	
	
	

}
