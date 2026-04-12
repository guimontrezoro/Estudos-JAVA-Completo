package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // mantido: apesar de não ser obrigatório, deixei porque já existia

    private Date moment;
    private OrderStatus status;
    private Client client; // corrigido: o diagrama mostra que Order tem um Client associado

    private List<Orderitem> items = new ArrayList<>();

    public Order() {
    }

    public Order(OrderStatus status, Client client) { // corrigido: construtor agora recebe status e client
        this.moment = new Date(); // corrigido: instante do pedido deve ser o instante do sistema
        this.status = status;
        this.client = client; // corrigido: associa o cliente ao pedido
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

    public Client getClient() { // corrigido: getter do client
        return client;
    }

    public void setClient(Client client) { // corrigido: setter do client
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