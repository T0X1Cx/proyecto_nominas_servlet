/**
 * 
 */
package modelo;

/**
 * @author fjdl
 *
 */
public class Persona {
	public String nombre;
	public String dni;
	public char sexo;

	/**
	 * @param nombre
	 * @param dni
	 * @param sexo
	 * @throws DatosNoCorrectosException
	 */
	public Persona(String nombre, String dni, char sexo) throws DatosNoCorrectosException {
		super();
		this.nombre = nombre;

		this.dni = dni;

		if (sexo != 'F' && sexo != 'M') {
			throw new DatosNoCorrectosException();
		} else {
			this.sexo = sexo;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDni() {
		return dni;
	}

	/**
	 * @param nombre
	 * @param sexo
	 * @throws DatosNoCorrectosException
	 */
	public Persona(String nombre, char sexo) throws DatosNoCorrectosException {
		super();
		this.nombre = nombre;
		if (sexo != 'F' || sexo != 'M') {
			throw new DatosNoCorrectosException();
		} else {
			this.sexo = sexo;
		}
	}

	/**
	 * @param dni the dni to set
	 * @throws DatosNoCorrectosException
	 */
	public void setDni(String dni) throws DatosNoCorrectosException {

		this.dni = dni;

	}

	/**
	 * @return The person's name and DNI
	 */
	public String imprime() {
		return "nombre=" + nombre + ", dni=" + dni;
	}

	/**
	 * Clase interna que permite validar un DNI. Se crea un objeto del tipo
	 * ValidadorDNI y se le pasa un String a validar.
	 * 
	 * @author Manuel Mato
	 * @return true si DNI es correcto.
	 */

}
