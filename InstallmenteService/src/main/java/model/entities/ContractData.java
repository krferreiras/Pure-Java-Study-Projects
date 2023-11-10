package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractData {

    private Integer contractNumber;
    private LocalDate contractDate;
    private Double contractValue;

    private List<Installment> installments = new ArrayList<>();

    public ContractData() {
    }

    public ContractData(Integer contractNumber, LocalDate contractDate, Double contractValue) {
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
        this.contractValue = contractValue;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

}
