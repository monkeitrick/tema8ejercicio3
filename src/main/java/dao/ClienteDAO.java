package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Cliente;
import conex.BDConex;

public class ClienteDAO {

	
	public static Cliente buscaCliente(String nom, String pass)
	{
		Cliente cliente = null;
        String sql = "SELECT * FROM clientes where nombre=? and password=?";
        Connection con;
        try {
            con = BDConex.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nom);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                cliente = new Cliente(rs.getInt("id"),rs.getString("nombre"),rs.getString("password"),rs.getString("domicilio"),rs.getString("codigopostal"),rs.getString("telefono"),rs.getString("email"));
            
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
        	System.out.println("Error en buscaClienteDAO(nom,pass)");
            System.out.println(ex.getMessage());
        }
	        
		return cliente;
	}
	
	
	public static boolean buscaCliente(String nom)
	{
        String sql = "SELECT * FROM clientes where nombre=?";
        Connection con;
        try {
            con = BDConex.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nom);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                return true;
            
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
        	System.out.println("Error en buscaClienteDAO(nom)");
            System.out.println(ex.getMessage());
        }
	        
		return false;
	}
	
	
	public static boolean guardarCliente(Cliente cliente)
	{        
        String sql = "INSERT INTO clientes(id, nombre, password, domicilio, codigopostal, telefono, email) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = BDConex.getConnection();
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, KeysDAO.siguienteId("clientes"));
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getPassword());
            st.setString(4, cliente.getDomicilio());
            st.setString(5, cliente.getCodigopostal());
            st.setString(6, cliente.getTelefono());
            st.setString(7, cliente.getEmail());
            
            st.execute();

            st.close();
            con.close();
            return true;
        } catch (SQLException ex) {
        	System.out.println("Error en guardarCliente()");
            System.out.println(ex.getMessage());	        
            return false;
        }
	}
	
	public static boolean actualizarCliente(Cliente cliente)
	{
		String sql = "UPDATE clientes set nombre=?, password=?, domicilio=?, codigopostal=?, telefono=?, email=?) where id = ? ";
        try {
            Connection con = BDConex.getConnection();
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(7, KeysDAO.siguienteId("clientes"));
            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getPassword());
            st.setString(3, cliente.getDomicilio());
            st.setString(4, cliente.getCodigopostal());
            st.setString(5, cliente.getTelefono());
            st.setString(6, cliente.getEmail());
            
            st.execute();

            st.close();
            con.close();
            return true;
        } catch (SQLException ex) {
        	System.out.println("Error en actualizarCliente()");
            System.out.println(ex.getMessage());	        
            return false;
        }
	}
	
}