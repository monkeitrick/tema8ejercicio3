package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import dao.ClienteDAO;
import dao.KeysDAO;
import dao.PedidoDAO;

@WebServlet(name = "ServletRegistro", urlPatterns = {"/ServletRegistro"})
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	    }	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean res = false;
		String usuario = request.getParameter("inpUser");
		String pass = request.getParameter("inpPass");
		String domicilio = request.getParameter("inpDomi");
		String cp = request.getParameter("inpCP");
		String telf = request.getParameter("inpTelf");
		String email = request.getParameter("inpEmail");
		if(!usuario.equals("") && !pass.equals("") && !domicilio.equals("") && !cp.equals("") && !telf.equals("") && !email.equals(""))  
		{
			if(!ClienteDAO.buscaCliente(usuario))
			{
				Cliente cliente = new Cliente(KeysDAO.siguienteId("clientes"),usuario,pass,domicilio,cp,telf,email);
				res = ClienteDAO.guardarCliente(cliente);
			}
			else
				request.getSession().setAttribute("mensaje", "usuario ya existente");
		}
		else
			request.getSession().setAttribute("mensaje", "rellena todos los campos");
		
		if(res)
		{
			request.getSession().setAttribute("mensaje", "usuario creado correctamente");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else  
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		
	}

}