package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//1º Recebendo os dados do cliente:
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		System.out.print("Data de aniversário (DD/MM/YYYY): ");
		Date birthDateClient = sdf.parse(sc.next());
		
		//Instancia o novo cliente:
		Client client = new Client(nameClient, emailClient, birthDateClient);
		
		
		//2º Recebendo os dados do pedido:
		System.out.println("Entre com os dados do pedido: ");
		System.out.print("Status: ");
		//Instancia o enum para receber o status:
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		//Instancia o objeto Order para receber o pedido:
		Order order = new Order(new Date(), status, client);
		
		System.out.print("Digite o número de itens do pedido: ");
		int n = sc.nextInt();
		for(int i = 1; i <=n; i++) {
			System.out.println("Digite os dados do item #" + i);
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Preço do produto: ");
			double productPrice = sc.nextDouble();
			//Instanciamos o objeto Product para receber os dados do produto:
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantidade: ");
			int quantityProduct = sc.nextInt();
			
			//Instanciamos o objeto OrderItem para receber os dados do pedido (product refere-se a Product):
			OrderItem orderItem = new OrderItem(quantityProduct, productPrice, product);
			
			//Invoca o método dentro de Order que adicionar itens ao ArrayList de OrderItem:
			order.addItem(orderItem);
			
		}
		
		System.out.println();
		System.out.println("Resumo do pedido: ");
		System.out.println(order);
		
		sc.close();
	}

}
