package entities;

public class Orderitem {

    private Integer quantity;
    private Double price;
    private Product product; // corrigido: cada Orderitem precisa guardar o product correspondente

    public Orderitem() {
    }

    public Orderitem(Integer quantity, Double price, Product product) { // corrigido: construtor agora recebe também o product
        this.quantity = quantity;
        this.price = price;
        this.product = product; // corrigido: armazena o product do item
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) { // corrigido: adicionado setter do price para completar a classe
        this.price = price;
    }

    public Product getProduct() { // corrigido: getter do product
        return product;
    }

    public void setProduct(Product product) { // corrigido: setter do product
        this.product = product;
    }

    public double subTotal() {
        return quantity * price;
    }
}