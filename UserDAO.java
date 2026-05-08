package dao;


import model.User;
import java.io.*;
import java.util.*;

public class UserDAO {

    private static final String FILE = "users.txt";

    public void addUser(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
            bw.write(user.getId() + "," + user.getName() + "," + user.getEmail());
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];

                list.add(new User(id, name, email));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean loginUser(String email) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");

                if (d[2].equals(email)) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void updateUser(int id, String newName, String newEmail) {

        List<User> list = getAllUsers();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {

            for (User u : list) {

                if (u.getId() == id) {
                    u.setName(newName);
                    u.setEmail(newEmail);
                }

                bw.write(u.getId() + "," + u.getName() + "," + u.getEmail());
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {

        List<User> list = getAllUsers();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {

            for (User u : list) {

                if (u.getId() != id) {
                    bw.write(u.getId() + "," + u.getName() + "," + u.getEmail());
                    bw.newLine();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}