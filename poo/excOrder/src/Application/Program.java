package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.Orderitem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            String name = "";
            Double price = 0.0;
            Integer quantity = 0;

            System.out.print("Enter client data:\n");
            System.out.print("Name: ");
            String clientName = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Birth date (DD/MM/YYYY): ");
            Date birthDate = sdf.parse(sc.nextLine());

            Client client = new Client(clientName, email, birthDate);

            System.out.print("Enter order data:\n");
            System.out.print("Status: ");
            OrderStatus status = OrderStatus.valueOf(sc.nextLine());

            Order order = new Order(status, client); // corrigido: o momento do pedido deve vir do sistema, e o pedido deve guardar o client

            System.out.print("How many items to this order? ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.println("Enter #" + (i + 1) + " item data:\n");
                System.out.print("Product name: ");
                name = sc.nextLine();
                System.out.print("Product price: ");
                price = sc.nextDouble();
                System.out.print("Quantity: ");
                quantity = sc.nextInt();
                sc.nextLine();

                Product product = new Product(name, price); // corrigido: agora o product é criado dentro do laço para cada item
                Orderitem orderitem = new Orderitem(quantity, price, product); // corrigido: cada item agora guarda o product correspondente
                order.addItem(orderitem);
            }

            System.out.println();
            System.out.print("ORDER SUMMARY: \n");

            System.out.println("Order moment: " + sdf1.format(order.getMoment()));
            System.out.println("Order status: " + order.getStatus());
            System.out.println("Client: " + order.getClient().getClientName() + " (" // corrigido: client agora está associado ao order
                    + sdf.format(order.getClient().getBirthDate()) + ") - "
                    + order.getClient().getEmail());
            System.out.println("Order Items: \n");

            for (Orderitem item : order.getitemsList()) { // corrigido: agora percorre a lista real de itens do pedido
                System.out.println(item.getProduct().getName() + ", $" // corrigido: pega o nome do product armazenado dentro de cada item
                        + String.format("%.2f", item.getPrice()) + ", Quantity: " // corrigido: formatação com 2 casas decimais
                        + item.getQuantity() + ", Subtotal: $"
                        + String.format("%.2f", item.subTotal())); // corrigido: imprime o subtotal de cada item da lista
            }

            System.out.println("Total price: $" + String.format("%.2f", order.total())); // corrigido: formatação com 2 casas decimais
        }
    }
}