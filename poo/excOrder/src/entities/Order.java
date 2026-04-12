package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;
    private Client client; 

    private List<Orderitem> items = new ArrayList<>();

    public Order() {
    }

    public Order(OrderStatus status, Client client) {
        this.moment = new Date(); 
        this.status = status;
        this.client = client; 
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
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

    public List<Orderitem> getitemsList() {
        return items;
    }

    public void addItem(Orderitem orderitem) {
        items.add(orderitem);
    }

    public void removeItem(Orderitem orderitem) {
        items.remove(orderitem);
    }

    public double total() {
        double sum = 0;
        for (Orderitem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }
}