package ui;
import dao.UserDAO;

import javax.swing.*;
import java.awt.*;

public class LoginUI {

    public LoginUI() {

        JFrame f = new JFrame("Login");
        f.setSize(300, 200);
        f.setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(3,1,10,10));

        JTextField email = new JTextField();
        JButton loginBtn = new JButton("Login");

        p.add(new JLabel("Enter Email:"));
        p.add(email);
        p.add(loginBtn);

        f.add(p);
        f.setVisible(true);

        loginBtn.addActionListener(e -> {

            boolean ok = new UserDAO().loginUser(email.getText());

            if (ok) {
                JOptionPane.showMessageDialog(f, "Login Success ✅");
            } else {
                JOptionPane.showMessageDialog(f, "User Not Found ❌");
            }
        });
    }
}