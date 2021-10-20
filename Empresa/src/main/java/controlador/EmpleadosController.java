package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;

/**
 * Servlet implementation class EmpleadosController
 */
public class EmpleadosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		switch (opcion) {
		case "empleados":

			try {
				List<Empleado> lista = new ArrayList<Empleado>();
				lista = EmpleadosDAO.getEmpleados();
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/empleados.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "buscaSalario":

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/buscaSalario.jsp");
			requestDispatcher.forward(request, response);

			break;

		case "buscaEmpleados":

			requestDispatcher = request.getRequestDispatcher("/buscaSalario.jsp");
			requestDispatcher.forward(request, response);

			break;
		case "empleadosBusqueda":

			requestDispatcher = request.getRequestDispatcher("/empleadosBusqueda.jsp");
			requestDispatcher.forward(request, response);

			break;

		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		switch (opcion) {
		case "muestraSalario":
			String dni = request.getParameter("varDNI");

			try {

				int sueldo = EmpleadosDAO.getSueldo(dni);
				request.setAttribute("sueldo", sueldo);
				Empleado e = EmpleadosDAO.getEmpleado(dni);
				request.setAttribute("empleado", e);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/muestraSalario.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
				// TODO: handle exception
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "muestraEmpleadosBusqueda":

			try {

				String categoria = "";
				String anyos = "";
				String sexo = "";
				ArrayList<Empleado> lista = new ArrayList<Empleado>();

				dni = request.getParameter("varDNI");
				String nombre = request.getParameter("varNombre");
				categoria = request.getParameter("varCategoria");
				anyos = request.getParameter("varAnyos");
				sexo = request.getParameter("varSexo");

				if (dni != null) {

					lista.add(EmpleadosDAO.getEmpleado(dni));

				} else if (nombre != null) {

					lista = EmpleadosDAO.getEmpleadoNombre(nombre);

				} else if (categoria != null) {

					lista = EmpleadosDAO.getEmpleadoCategoria(Integer.parseInt(categoria));

				} else if (anyos != null) {

					lista = EmpleadosDAO.getEmpleadoAnyos(Integer.parseInt(anyos));

				} else if (sexo != null) {

					lista = EmpleadosDAO.getEmpleadoSexo(sexo.charAt(0));

				}

				request.setAttribute("lista", lista);
				
			} catch (SQLException e) {

				e.printStackTrace();
				// TODO: handle exception
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/muestraEmpleadosBusqueda.jsp");
			requestDispatcher.forward(request, response);
			break;

		default:
			break;
		}

	}

}
