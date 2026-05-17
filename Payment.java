package model;

public class Payment {

    private int paymentId;

    private String customerName;

    private double amount;

    private String paymentDate;

    public Payment(
            int paymentId,
            String customerName,
            double amount,
            String paymentDate
    ) {

        this.paymentId = paymentId;

        this.customerName = customerName;

        this.amount = amount;

        this.paymentDate = paymentDate;
    }


    public int getPaymentId() {
        return paymentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}