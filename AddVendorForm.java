package ui;

import dao.VendorDAO;
import model.Vendor;

import javax.swing.*;
import java.awt.*;

public class AddVendorForm {

    public AddVendorForm() {

        JFrame f = new JFrame("Add Vendor");
        f.setSize(350, 250);
        f.setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(4,2,10,10));

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField service = new JTextField();

        JButton btn = new JButton("Save");

        p.add(new JLabel("ID")); p.add(id);
        p.add(new JLabel("Name")); p.add(name);
        p.add(new JLabel("Service")); p.add(service);
        p.add(new JLabel()); p.add(btn);

        f.add(p);
        f.setVisible(true);

        btn.addActionListener(e -> {
            VendorDAO dao = new VendorDAO();
            dao.addVendor(new Vendor(
                    Integer.parseInt(id.getText()),
                    name.getText(),
                    service.getText()
            ));
            JOptionPane.showMessageDialog(f, "Vendor Added ✅");
        });
    }
}