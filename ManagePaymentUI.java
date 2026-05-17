package ui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ManagePaymentUI {

    public ManagePaymentUI() {

        JFrame frame =
                new JFrame("Manage Payments");

        frame.setSize(700,550);

        frame.setLocationRelativeTo(null);

        frame.setLayout(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        // ================= TITLE =================

        JLabel title =
                new JLabel("Update / Delete Payment");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        title.setBounds(120,30,450,40);

        frame.add(title);

        // ================= PAYMENT ID =================

        JLabel idLabel =
                new JLabel("Payment ID");

        idLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        idLabel.setBounds(60,120,150,30);

        frame.add(idLabel);

        JTextField idField =
                new JTextField();

        idField.setBounds(250,120,280,35);

        frame.add(idField);

        // ================= CUSTOMER NAME =================

        JLabel customerLabel =
                new JLabel("Customer Name");

        customerLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        customerLabel.setBounds(60,190,170,30);

        frame.add(customerLabel);

        JTextField customerField =
                new JTextField();

        customerField.setBounds(250,190,280,35);

        frame.add(customerField);

        // ================= AMOUNT =================

        JLabel amountLabel =
                new JLabel("Amount");

        amountLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        amountLabel.setBounds(60,260,170,30);

        frame.add(amountLabel);

        JTextField amountField =
                new JTextField();

        amountField.setBounds(250,260,280,35);

        frame.add(amountField);

        // ================= PAYMENT METHOD =================

        JLabel methodLabel =
                new JLabel("Payment Method");

        methodLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        methodLabel.setBounds(60,330,170,30);

        frame.add(methodLabel);

        JTextField methodField =
                new JTextField();

        methodField.setBounds(250,330,280,35);

        frame.add(methodField);

        // ================= UPDATE BUTTON =================

        JButton updateBtn =
                new JButton("Update Payment");

        updateBtn.setBounds(100,430,190,45);

        updateBtn.setBackground(
                new Color(230,200,150)
        );

        updateBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        frame.add(updateBtn);

        // ================= DELETE BUTTON =================

        JButton deleteBtn =
                new JButton("Delete Payment");

        deleteBtn.setBounds(350,430,190,45);

        deleteBtn.setBackground(
                new Color(255,120,140)
        );

        deleteBtn.setForeground(Color.WHITE);

        deleteBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        frame.add(deleteBtn);

        // ================= UPDATE =================

        updateBtn.addActionListener(e -> {

            try{

                File file =
                        new File("src/payments.txt");

                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(file)
                        );

                ArrayList<String> lines =
                        new ArrayList<>();

                String line;

                while((line = reader.readLine()) != null){

                    if(line.contains(
                            "Payment ID: "
                                    + idField.getText()
                    )){

                        line =
                                "Payment ID: "
                                        + idField.getText()

                                        + " | Customer Name: "
                                        + customerField.getText()

                                        + " | Amount: "
                                        + amountField.getText()

                                        + " | Payment Method: "
                                        + methodField.getText();
                    }

                    lines.add(line);
                }

                reader.close();

                FileWriter writer =
                        new FileWriter(file);

                for(String l : lines){

                    writer.write(l + "\n");
                }

                writer.close();

                JOptionPane.showMessageDialog(

                        null,

                        "Payment Updated!"
                );

            }catch(Exception ex){

                ex.printStackTrace();
            }
        });

        // ================= DELETE =================

        deleteBtn.addActionListener(e -> {

            try{

                File file =
                        new File("src/payments.txt");

                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(file)
                        );

                ArrayList<String> lines =
                        new ArrayList<>();

                String line;

                while((line = reader.readLine()) != null){

                    if(!line.contains(
                            "Payment ID: "
                                    + idField.getText()
                    )){

                        lines.add(line);
                    }
                }

                reader.close();

                FileWriter writer =
                        new FileWriter(file);

                for(String l : lines){

                    writer.write(l + "\n");
                }

                writer.close();

                JOptionPane.showMessageDialog(

                        null,

                        "Payment Deleted!"
                );

            }catch(Exception ex){

                ex.printStackTrace();
            }
        });

        frame.setVisible(true);
    }
}