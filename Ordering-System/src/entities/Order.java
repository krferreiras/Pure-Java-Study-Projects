package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> order = new ArrayList<>();
	
	public Order() {
		
	}
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<OrderItem> getOrder() {
		return order;
	}
	
	public void addItem(OrderItem item) {
		order.add(item);
	}
	
	public void removeItem(OrderItem item) {
		order.remove(item);
	}
	
	public Double total() {
		double sum = 0.0;
		for (OrderItem item : order) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Order moment: ");
		stringBuilder.append(dateFormat.format(moment) +"\n");
		stringBuilder.append("Order status: ");
		stringBuilder.append(status + "\n");
		stringBuilder.append("Client: ");
		stringBuilder.append(client + "\n");
		stringBuilder.append("Order items:\n");
		for (OrderItem item : order) {
			stringBuilder.append(item + "\n");
		}
		stringBuilder.append("Total price: U$ ");
		stringBuilder.append(String.format("%.2f", total()));
		return stringBuilder.toString();
	}
	
	

	
}
