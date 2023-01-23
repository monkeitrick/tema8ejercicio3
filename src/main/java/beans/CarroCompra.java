package beans;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CarroCompra {
	private HashMap<Integer,LineaPedido> carro= new HashMap<Integer,LineaPedido>(); 
	
	
	public void aniadeLinea(LineaPedido l) {
		Iterator<Integer> iterator= carro.keySet().iterator();
		boolean contiene=false;
		Integer id=0;
		while(iterator.hasNext()) {
			Integer key=iterator.next();
			LineaPedido l2=carro.get(key);
			if(l2==l) {
				l2.setCantidad(l2.getCantidad()+1);
				contiene=true;
				id=key;
			}
		}
		if(contiene==false) {
			carro.put(id, l);
		}
	}
	
	public void borraLinea (int iditem) {
		carro.remove(iditem);
	}
	
	public LineaPedido getLineaPedido(int idItem){
		return carro.get(idItem);
	}
	
	public Collection<LineaPedido> getLineasPedidio(){
		return  carro.values();
	}
	
	public double total() {
		double total = 0;
		Set<Integer> keys = carro.keySet();
		for(int key  : keys)
			total += (carro.get(key).getItem().getPrecio()) * (carro.get(key).getCantidad());   //precio * cantidad  del producto de LineaPedido
		
		return total;
	}
	
	public void removeAll(){
		carro.clear();
	}
	
	
	public boolean vacio(){
		return carro.isEmpty();
	}
}
