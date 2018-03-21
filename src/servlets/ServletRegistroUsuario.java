package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UsuariosDAO;
import daosImpl.UsuariosDAOImpl;
import modelo.Usuario;


@WebServlet("/ServletRegistroUsuario")
public class ServletRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String email = request.getParameter("campoEmail");
		String pass = request.getParameter("campoPass");
		String poblacion = request.getParameter("campoPoblacion");
		
		Usuario nuevo = 
				new Usuario(nombre,email,poblacion,pass);
		UsuariosDAO usuariosDAO = new UsuariosDAOImpl();
		usuariosDAO.registarUsuario(nuevo);
		request.getRequestDispatcher("registroUsuarioOK.jsp").
			forward(request, response);
		
	}//end doPost

}//end class
