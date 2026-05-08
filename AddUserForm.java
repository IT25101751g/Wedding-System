package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddUserForm {

    public AddUserForm() {

        JFrame frame = new JFrame("Add User");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ================= BACKGROUND IMAGE =================
        ImageIcon icon = new ImageIcon(getClass().getResource("/ui/bg.jpg"));
        Image img = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);

        JLabel bg = new JLabel(new ImageIcon(img));
        bg.setLayout(new GridBagLayout());

        // ================= CARD PANEL =================
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(400, 330));
        card.setBackground(new Color(255, 255, 255, 190));
        card.setBorder(new EmptyBorder(20, 20, 20, 20));
        card.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ================= TITLE =================
        JLabel title = new JLabel("Add New User");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.BLACK);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(title, gbc);

        // ================= ID =================
        gbc.gridwidth = 1;

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        gbc.gridx = 0;
        gbc.gridy = 1;

        card.add(idLabel, gbc);

        JTextField idField = new JTextField(15);
        styleField(idField);

        gbc.gridx = 1;

        card.add(idField, gbc);

        // ================= NAME =================
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        gbc.gridx = 0;
        gbc.gridy = 2;

        card.add(nameLabel, gbc);

        JTextField nameField = new JTextField(15);
        styleField(nameField);

        gbc.gridx = 1;

        card.add(nameField, gbc);

        // ================= EMAIL =================
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        gbc.gridx = 0;
        gbc.gridy = 3;

        card.add(emailLabel, gbc);

        JTextField emailField = new JTextField(15);
        styleField(emailField);

        gbc.gridx = 1;

        card.add(emailField, gbc);

        // ================= SAVE BUTTON =================
        JButton saveBtn = new JButton("Save User");

        saveBtn.setBackground(new Color(255, 224, 178));
        saveBtn.setForeground(Color.BLACK);
        saveBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        saveBtn.setFocusPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        card.add(saveBtn, gbc);

        // ================= SAVE ACTION =================
        saveBtn.addActionListener(e -> {

            try {

                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String email = emailField.getText();

                User user = new User(id, name, email);

                UserDAO dao = new UserDAO();
                dao.addUser(user);

                JOptionPane.showMessageDialog(frame,
                        "User Saved Successfully!");

                idField.setText("");
                nameField.setText("");
                emailField.setText("");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(frame,
                        "Error Saving User!");

            }
        });

        // ================= ADD CARD =================
        bg.add(card);

        frame.setContentPane(bg);
        frame.setVisible(true);
    }

    // ================= FIELD STYLE =================
    private void styleField(JTextField field) {

        field.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        field.setPreferredSize(new Dimension(200, 35));
    }
}