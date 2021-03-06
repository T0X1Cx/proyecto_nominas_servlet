/**
 * 
 */
package modelo;

import java.io.*;
import java.sql.*;
import java.util.*;

import DAO.ConexionBD;

public class EmpleadosDAO {

	public static List<Empleado> getEmpleados() throws SQLException, DatosNoCorrectosException {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();
		ArrayList<Empleado> lista_empleados = new ArrayList<Empleado>();
		Empleado e;

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select nombre, dni, sexo, categoria, anyos from empleados");

		while (rs.next()) {
			e = new Empleado(rs.getString(1), rs.getString(2), rs.getString(3).toCharArray()[0], rs.getInt(4),
					rs.getInt(5));
			lista_empleados.add(e);

		}

		return lista_empleados;

	}

	public static List<String[]> getNominas() {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();
		ArrayList<String[]> lista_nominas = new ArrayList<String[]>();
		String[] n = new String[2];
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select dni, sueldo from nominas");

			while (rs.next()) {
				n[0] = rs.getString(1);
				n[1] = String.valueOf(rs.getInt(2));
				lista_nominas.add(n);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return lista_nominas;
	}

	public static void altaEmpleado(Empleado e) {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();

		try {
			Statement st = con.createStatement();
			// Insertamos el empleado
			st.execute("insert into empleados(nombre,dni,sexo,categoria,anyos) values ('" + e.nombre + "','" + e.dni
					+ "','" + e.sexo + "','" + e.getCategoria() + "','" + e.anyos + "')");
			// Insertamos el sueldo del empleado
			st.execute("insert into nominas(dni, sueldo) values ('" + e.dni + "','" + Nomina.sueldo(e) + "')");

			// hacemos el backup del punto 4
			backup(e);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void altaEmpleado(String nombre, String dni, char sexo, int categoria, int anyos) {
		try {
			Empleado e = new Empleado(nombre, dni, sexo, categoria, anyos);
			altaEmpleado(e);
		} catch (DatosNoCorrectosException ex) {
			ex.printStackTrace();
		}
	}

	public static void altaEmpleado(String nombreFichero) {
		String line;
		;
		Empleado e;
		String[] datosEmp;

		try {
			// Fichero de entrada
			File fentrada = new File(nombreFichero);
			FileReader fr = new FileReader(fentrada);
			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {
				// Leemos línea por línea el fichero de entrada
				line = br.readLine();
				datosEmp = line.split(";");
				if (datosEmp.length == 3) // en el caso de que en la línea solo haya 3 datos del empleado
					e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0]);
				else // en el caso de que vayan todos los datos
					e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0],
							Integer.parseInt(datosEmp[3]), Integer.parseInt(datosEmp[4]));
				altaEmpleado(e);
//TO-DO	        updateSueldo(e.dni); //Comprobar
			}
			br.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (DatosNoCorrectosException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @param dni
	 * @return
	 * @throws SQLException
	 */
	public static int getSueldo(String dni) throws SQLException {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();
		int sueldo = 0;

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select sueldo from nominas where dni= '" + dni + "'");

		
			while (rs.next()) {
				sueldo = rs.getInt(1);
			}

		return sueldo;
	}

	/**
	 * @param dni
	 * @return
	 */
	public static boolean exists(String dni) {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();
		boolean exists = false;

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(*) from empleados where dni='" + dni + "'");

			if (rs != null)
				exists = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return exists;
	}

	public static Empleado getEmpleado(String dni) throws SQLException, DatosNoCorrectosException {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();
		Empleado e = null;

		Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select nombre, dni, sexo, categoria, anyos from empleados where dni='" + dni + "'");

		// Solo puede haber un empleado con el mismo dni
		while (rs.next()) {
			e = new Empleado(rs.getString(1), rs.getString(2), rs.getString(3).toCharArray()[0], rs.getInt(4),
					rs.getInt(5));
		}

		return e;
	}

	public static void updateEmpleado(Empleado e) {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();

		try {
			Statement st = con.createStatement();
			System.out.println(
					"update empleados e set e.nombre='" + e.nombre + "' and e.sexo='" + e.sexo + "' and e.categoria="
							+ e.getCategoria() + " and e.anyos=" + e.anyos + " where e.dni='" + e.dni + "'");
			// actualizamos el empleado (todos los campos, independientemente del que se
			// haya cambiado
			st.execute("update empleados e set e.nombre='" + e.nombre + "' and e.sexo='" + e.sexo + "' and e.categoria="
					+ e.getCategoria() + " and e.anyos=" + e.anyos + " where e.dni='" + e.dni + "'");
			// actualizamos el sueldo del empleado por si ha cambiado su categoría
			st.execute("update nominas set sueldo=" + Nomina.sueldo(e) + " where dni='" + e.dni + "'");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void updateSueldo(String dni) throws DatosNoCorrectosException {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();

		try {
			Statement st = con.createStatement();
			// actualizamos el sueldo del empleado por si ha cambiado su categoría
			st.execute("update nominas set sueldo=" + Nomina.sueldo(getEmpleado(dni)) + " where dni='" + dni + "'");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void bajaEmpleado(String dni) {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();

		try {
			Statement st = con.createStatement();
			// Insertamos el empleado
			st.execute("delete from empleados where dni = '" + dni + "'"); // Debería borrar en cascada
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @param e
	 */
	public static void cerrarConexion() {
		ConexionBD.close();
	}

	/**
	 * @param e
	 */
	public static void backup(Empleado e) {
		// Fichero de texto de salida para actualizar el de entrada
		File fbackup = new File("backup-empleados.txt");
		try {
			FileWriter fw = new FileWriter(fbackup.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			// Actualizamos el fichero de entrada, incluyendo el salario en el mismo fichero
			// de backup
			bw.write(e.nombre + ";" + e.dni + ";" + e.sexo + ";" + e.getCategoria() + ";" + e.anyos + ";"
					+ Nomina.sueldo(e) + '\n');

			// Cerramos todos los búferes
			bw.close();
			fw.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ArrayList<Empleado> getEmpleadoCategoria(int cat) throws SQLException, DatosNoCorrectosException {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();
		Empleado e = null;
		ArrayList<Empleado> lista = new ArrayList<Empleado>();

		Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select nombre, dni, sexo, categoria, anyos from empleados where categoria= '" + cat + "'");

		while (rs.next()) {
			e = new Empleado(rs.getString(1), rs.getString(2), rs.getString(3).toCharArray()[0], rs.getInt(4),
					rs.getInt(5));
			
			lista.add(e);
		}

		return lista;
	}
	
	public static ArrayList<Empleado> getEmpleadoAnyos(int anyos) throws SQLException, DatosNoCorrectosException {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();
		Empleado e = null;
		ArrayList<Empleado> lista = new ArrayList<Empleado>();


		Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select nombre, dni, sexo, categoria, anyos from empleados where anyos = '" + anyos + "'");

		
		while (rs.next()) {
			e = new Empleado(rs.getString(1), rs.getString(2), rs.getString(3).toCharArray()[0], rs.getInt(4),
					rs.getInt(5));
			
			lista.add(e);
		}

		return lista;
	}
	
	public static ArrayList<Empleado> getEmpleadoNombre(String nombre) throws SQLException, DatosNoCorrectosException {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();
		Empleado e = null;
		ArrayList<Empleado> lista = new ArrayList<Empleado>();


		Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select nombre, dni, sexo, categoria, anyos from empleados where nombre='" + nombre + "'");

		
		while (rs.next()) {
			e = new Empleado(rs.getString(1), rs.getString(2), rs.getString(3).toCharArray()[0], rs.getInt(4),
					rs.getInt(5));
			
			lista.add(e);
		}

		return lista;
	}
	
	public static ArrayList<Empleado> getEmpleadoSexo(Character sexo) throws SQLException, DatosNoCorrectosException {
		// Conexón a la base de datos
		Connection con = ConexionBD.getConnection();
		Empleado e = null;
		ArrayList<Empleado> lista = new ArrayList<Empleado>();

		Statement st = con.createStatement();
		ResultSet rs = st
				.executeQuery("select nombre, dni, sexo, categoria, anyos from empleados where sexo='" + sexo + "'");

		
		while (rs.next()) {
			e = new Empleado(rs.getString(1), rs.getString(2), rs.getString(3).toCharArray()[0], rs.getInt(4),
					rs.getInt(5));
			
			lista.add(e);
			
		}

		return lista;
	}

}
