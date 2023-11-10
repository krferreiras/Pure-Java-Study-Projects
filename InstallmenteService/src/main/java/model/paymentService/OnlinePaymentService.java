package model.paymentService;

public interface OnlinePaymentService {

    public double getSimpleTax(double amount, int months);
    public double getPayRate(double amount);
}
