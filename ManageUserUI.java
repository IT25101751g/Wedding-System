package ui;

import dao.UserDAO;

import javax.swing.*;
import java.awt.*;

public class ManageUserUI {

    public ManageUserUI() {

        JFrame f = new JFrame("Manage User");
        f.setSize(350, 250);
        f.setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(5,2,10,10));

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField email = new JTextField();

        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        p.add(new JLabel("User ID")); p.add(id);
        p.add(new JLabel("New Name")); p.add(name);
        p.add(new JLabel("New Email")); p.add(email);

        p.add(updateBtn);
        p.add(deleteBtn);

        f.add(p);
        f.setVisible(true);

        UserDAO dao = new UserDAO();

        updateBtn.addActionListener(e -> {
            dao.updateUser(
                    Integer.parseInt(id.getText()),
                    name.getText(),
                    email.getText()
            );
            JOptionPane.showMessageDialog(f, "Updated ✅");
        });

        deleteBtn.addActionListener(e -> {
            dao.deleteUser(
                    Integer.parseInt(id.getText())
            );
            JOptionPane.showMessageDialog(f, "Deleted ❌");
        });
    }
}