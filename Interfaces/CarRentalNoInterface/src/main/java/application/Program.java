package application;
//  Uma locadora brasileira de carros cobra um valor por hora para locações de até 12 horas.
//  Porém, se a duração da locação ultrapassar 12 horas, a locação serácobrada com base em um valor diário.
//  Além do valor da locação, é acrescido no preço o valor do imposto conforme regras do país que,
//  no caso do Brasil, é 20% para valores até 100.00, ou 15% para valores acima de 100.00. Fazer um programa
//  que lê os dados da locação (modelo do carro, instante inicial e final da  locação), bem como o valor por
//  hora e o valor diário de locação. O programa deve então gerar a nota de pagamento (contendo valor da locação,
//  valor do imposto e valor total do pagamento) e informar os dados na tela.

//  PROJETO DE SERVIÇO

import model.entities.CarRental;
import model.entities.Invoice;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

        public static void main(String[] args) {

            Locale.setDefault(new Locale("US"));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            Scanner sc = new Scanner(System.in);

            System.out.println("Entre com os dados do alugue: ");
            System.out.print("Modelo do carro: ");
            String model = sc.nextLine();
            System.out.print("Retirada (dd/mm/yyyy hh:mm):");
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);
            System.out.print("Retorno (dd/mm/yyyy hh:mm):");
            LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);

            CarRental carRental = new CarRental(start, finish, new Vehicle(model));

            System.out.print("Entre com o preço por hora: R$ ");
            double pricePerHour = sc.nextDouble();
            System.out.print("Entre com o preço por dia: R$ ");
            double pricePerDay = sc.nextDouble();

            RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

            rentalService.processInvoice(carRental);

            System.out.println("FATURA: ");
            System.out.println("Pagamento básico: R$ " + String.format("%.2f",carRental.getInvoice().getBasicPayment()));
            System.out.println("Imposto: R$ " + String.format("%.2f",carRental.getInvoice().getTax()));
            System.out.println("Pagamento total: R$ " + String.format("%.2f",carRental.getInvoice().getTotalPayment()));
            sc.close();
    }
}
