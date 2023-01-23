package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cliente;
import dao.ClienteDAO;
import dao.PedidoDAO;



@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	    }	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			session.invalidate();
			session = null;
		}
		session = request.getSession(true);
		
		

		boolean valido = false;
		String usuario = request.getParameter("inpUser");
		String pass = request.getParameter("inpPass");
		Cliente cliente = ClienteDAO.buscaCliente(usuario, pass);  
		if(cliente != null)
		{
			valido = true;
			request.getSession().setAttribute("user", cliente);
			request.getSession().setAttribute("productos", PedidoDAO.todosItems());
		}
		else
			request.getSession().setAttribute("mensaje", "usuario no valido"); 
		
		if(valido)
	        request.getRequestDispatcher("tienda.jsp").forward(request, response);
		else  
			request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	

	
}