package beans;

import java.util.Objects;

public class LineaPedido {
	private int id, cantidad;
	private Item item;
	private Pedido predido;
	public LineaPedido() {
		
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
