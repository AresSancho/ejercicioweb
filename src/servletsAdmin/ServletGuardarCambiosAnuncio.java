package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AnunciosDAO;
import daosImpl.AnunciosDAOImpl;
import modelo.Anuncio;

@WebServlet("/admin/ServletGuardarCambiosAnuncio")
public class ServletGuardarCambiosAnuncio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("campoTitulo");
		String precio = request.getParameter("campoPrecio");
		String descripcion = request.getParameter("campoDescripcion");
		String id = request.getParameter("campoId");
		
		//ahora deberiamos validar todos los datos
		//...
		//fin parte validacion
		
		Anuncio anuncio = new Anuncio(titulo, 
				Double.parseDouble(precio), descripcion);
		anuncio.setId(Integer.parseInt(id));
		
		AnunciosDAO anunciosDAO = new AnunciosDAOImpl();
		anunciosDAO.guardarCambiosAnuncio(anuncio);
		
		request.getRequestDispatcher("ServletListadoAnunciosAdmin").
			forward(request, response);
		
	}//end service

}//end class





