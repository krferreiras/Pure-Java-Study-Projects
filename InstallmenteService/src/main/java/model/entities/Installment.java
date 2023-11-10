package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Double contractValue;
    private LocalDate dueDate;

    public Installment(){}

    public Installment(Double contractValue, LocalDate dueDate) {
        this.contractValue = contractValue;
        this.dueDate = dueDate;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString(){
        return dueDate.format(dtf) + " - R$ " + String.format("%.2f", contractValue);
    }

}
