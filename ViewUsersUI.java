package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewUsersUI {

    public ViewUsersUI() {

        JFrame frame = new JFrame("View Users");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        String[] columns = {"ID", "Name", "Email"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        JTable table = new JTable(model);

        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();

        for (User u : users) {
            model.addRow(new Object[]{
                    u.getId(),
                    u.getName(),
                    u.getEmail()
            });
        }

        frame.add(new JScrollPane(table));
        frame.setVisible(true);
    }
}