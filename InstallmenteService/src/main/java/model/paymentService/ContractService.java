package model.paymentService;

import model.entities.ContractData;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private  OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(ContractData contract, Integer months){
        double basicInstallment = contract.getContractValue() / months;

        for (int i = 1; i <=months; i++) {
            LocalDate dueDate = contract.getContractDate().plusMonths(i);
            double simpleTax = onlinePaymentService.getSimpleTax(basicInstallment, i);
            double payRate = onlinePaymentService.getPayRate(basicInstallment  + simpleTax);
            double installment = basicInstallment + payRate + simpleTax;

            contract.getInstallments().add(new Installment(installment,dueDate));

        }
    }
}
