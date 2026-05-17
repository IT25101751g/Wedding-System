package dao;

import model.Payment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    private static final String FILE =
            "payments.txt";

    // ================= ADD PAYMENT =================
    public void addPayment(Payment payment) {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(FILE, true)
                     )) {

            bw.write(

                    payment.getPaymentId() + "," +

                            payment.getCustomerName() + "," +

                            payment.getAmount() + "," +

                            payment.getPaymentDate()
            );

            bw.newLine();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ================= GET ALL PAYMENTS =================
    public List<Payment> getAllPayments() {

        List<Payment> payments =
                new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(FILE)
                     )) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data =
                        line.split(",");

                Payment payment =
                        new Payment(

                                Integer.parseInt(data[0]),

                                data[1],

                                Double.parseDouble(data[2]),

                                data[3]
                        );

                payments.add(payment);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return payments;
    }
}