package application;

import model.entities.ContractData;
import model.entities.Installment;
import model.paymentService.ContractService;
import model.paymentService.PayPalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(new Locale("US"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira os dados do contrato: ");
        System.out.print("Número do contrato: ");
        int contractNumber = sc.nextInt();
        System.out.print("Data do contrato (dd/mm/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), dtf);
        System.out.print("Valor do contrato: R$ ");
        double conctractValue = sc.nextDouble();

        ContractData contractData = new ContractData(contractNumber, contractDate, conctractValue);

        System.out.println();
        System.out.print("Insira o número de parcelas: ");
        int installmentsNumber = sc.nextInt();

        ContractService contractService = new ContractService(new PayPalService());

        contractService.processContract(contractData, installmentsNumber);

        System.out.println();
        System.out.println("Parcelas: ");
        for (Installment installment : contractData.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }
}
