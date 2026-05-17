package ui;

import javax.swing.*;
import java.awt.*;

public class LoginUI {

    public LoginUI() {

        JFrame frame =
                new JFrame("Admin Login");

        frame.setSize(400,300);

        frame.setLocationRelativeTo(null);

        frame.setLayout(null);

        // ===== EMAIL =====

        JLabel emailLabel =
                new JLabel("Enter Email:");

        emailLabel.setBounds(40,40,150,30);

        emailLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        frame.add(emailLabel);

        JTextField emailField =
                new JTextField();

        emailField.setBounds(40,80,300,35);

        frame.add(emailField);

        // ===== PASSWORD =====

        JLabel passwordLabel =
                new JLabel("Enter Password:");

        passwordLabel.setBounds(40,130,170,30);

        passwordLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        frame.add(passwordLabel);

        JPasswordField passwordField =
                new JPasswordField();

        passwordField.setBounds(40,170,300,35);

        frame.add(passwordField);

        // ===== LOGIN BUTTON =====

        JButton loginBtn =
                new JButton("Login");

        loginBtn.setBounds(110,220,150,40);

        loginBtn.setBackground(
                new Color(255,80,140)
        );

        loginBtn.setForeground(Color.WHITE);

        loginBtn.setFocusPainted(false);

        loginBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        frame.add(loginBtn);

        // ===== LOGIN ACTION =====

        loginBtn.addActionListener(e -> {

            String email =
                    emailField.getText();

            String password =
                    String.valueOf(
                            passwordField.getPassword()
                    );

            // ===== ADMIN LOGIN =====

            if(
                    email.equals("WD137@gmail.com")
                            &&
                            password.equals("123")
            ){

                JOptionPane.showMessageDialog(
                        null,
                        "Admin Login Successful"
                );

                frame.dispose();

                new MainUI(true);

            }else{

                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Email or Password"
                );
            }
        });

        frame.setVisible(true);
    }
}