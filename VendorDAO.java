package dao;

import model.Vendor;
import java.io.*;
import java.util.*;

public class VendorDAO {

    private static final String FILE = "vendors.txt";

    public void addVendor(Vendor v) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
            bw.write(v.getId() + "," + v.getName() + "," + v.getService());
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Vendor> getAllVendors() {
        List<Vendor> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                list.add(new Vendor(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2]
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}