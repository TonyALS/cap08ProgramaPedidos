package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> item = new ArrayList<>();
	
	
	//Constructors:
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	
	//Getters and setters:
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	
	//Métodos:
	public void addItem(OrderItem items) {
		item.add(items);
	}
	
	public void removeItem(OrderItem items) {
		item.remove(items);
	}
	
	public Double total() {
		double sum = 0.0;
		for(OrderItem items : item) {
			sum += items.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hora do pedido: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(client + "\n");
		sb.append("Itens do pedido:\n");
		for (OrderItem items : item) {
			sb.append(item + "\n");
		}
		sb.append("Valor total: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
