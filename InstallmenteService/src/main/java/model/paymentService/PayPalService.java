package model.paymentService;

public class PayPalService implements OnlinePaymentService {

    private static final double simpleTax = 0.01;
    private static final double payRate = 0.02;

    public double getSimpleTax(double amount, int months){
        return amount * simpleTax * months;
    }

    public double getPayRate(double amount){
        return amount * payRate;
    }

}
