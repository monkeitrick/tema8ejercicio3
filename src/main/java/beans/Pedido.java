package beans;

import java.sql.Date;

public class Pedido {
	private int id;
	private double total;
	private Date fecha;
	private Cliente cliente;
	
	public Pedido() {
			
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
