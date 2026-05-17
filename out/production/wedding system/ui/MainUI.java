package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainUI {
    private boolean isAdmin;
    public MainUI(boolean isAdmin) {

        this.isAdmin = isAdmin;
        JFrame frame =
                new JFrame("Wedding Planning System");

        frame.setSize(1500,850);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLayout(null);

        // ================= BACKGROUND IMAGE =================

        ImageIcon bgIcon =
                new ImageIcon(
                        getClass().getResource(
                                "/ui/bg.png"
                        )
                );

        Image bgImg =
                bgIcon.getImage().getScaledInstance(
                        1500,
                        850,
                        Image.SCALE_SMOOTH
                );

        JLabel mainPanel =
                new JLabel(
                        new ImageIcon(bgImg)
                );

        mainPanel.setBounds(0,0,1500,850);

        mainPanel.setLayout(null);

        // ================= NAVBAR =================

        JPanel navbar =
                new JPanel();

        navbar.setBounds(0,0,1500,90);

        navbar.setBackground(
                new Color(255,255,255,220)
        );

        navbar.setLayout(null);

        // ================= LOGO =================

        JLabel logo =
                new JLabel("Wedding Planner");

        logo.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        34
                )
        );

        logo.setForeground(
                new Color(255,80,140)
        );

        logo.setBounds(30,20,350,40);

        navbar.add(logo);

        // ================= NAV BUTTONS =================

        JButton homeBtn =
                createNavButton("Home");

        JButton usersBtn =
                createNavButton("Users");

        JButton vendorsBtn =
                createNavButton("Vendors");

        JButton eventsBtn =
                createNavButton("Events");

        JButton bookingsBtn =
                createNavButton("Bookings");

        JButton paymentsBtn =
                createNavButton("Payments");

        JButton reviewsBtn =
                createNavButton("Reviews");

        homeBtn.setBounds(350,25,90,35);

        usersBtn.setBounds(460,25,90,35);

        vendorsBtn.setBounds(570,25,100,35);

        eventsBtn.setBounds(690,25,90,35);

        bookingsBtn.setBounds(800,25,120,35);

        paymentsBtn.setBounds(940,25,120,35);

        reviewsBtn.setBounds(1080,25,100,35);

        navbar.add(homeBtn);

        navbar.add(usersBtn);

        navbar.add(vendorsBtn);

        navbar.add(eventsBtn);

        navbar.add(bookingsBtn);

        navbar.add(paymentsBtn);

        navbar.add(reviewsBtn);

        // ================= ADMIN BUTTON =================

        JButton adminBtn =
                new JButton("Admin");

        adminBtn.setBounds(1300,20,120,45);

        adminBtn.setBackground(
                new Color(255,80,140)
        );

        adminBtn.setForeground(Color.WHITE);

        adminBtn.setFocusPainted(false);

        adminBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        navbar.add(adminBtn);

        mainPanel.add(navbar);

        // ================= TITLES =================

        JLabel title1 =
                new JLabel(
                        "Celebrating 30 years of “I do”."
                );

        title1.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        58
                )
        );

        title1.setForeground(
                new Color(40,40,40)
        );

        title1.setBounds(170,150,1200,80);

        mainPanel.add(title1);

        JLabel title2 =
                new JLabel("Let’s plan yours.");

        title2.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        72
                )
        );

        title2.setForeground(
                new Color(255,80,140)
        );

        title2.setBounds(430,230,700,90);

        mainPanel.add(title2);

        JLabel desc =
                new JLabel(
                        "All-in-one solution for your perfect wedding planning."
                );

        desc.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        28
                )
        );

        desc.setForeground(
                new Color(50,50,50)
        );

        desc.setBounds(320,340,900,40);

        mainPanel.add(desc);

        // ================= CARDS =================

        JPanel usersCard =
                createCard(
                        "Manage Users",
                        "Add and manage users",
                        "/ui/icons/users.png"
                );

        JPanel vendorsCard =
                createCard(
                        "Manage Vendors",
                        "Add and manage vendors",
                        "/ui/icons/vendors.png"
                );

        JPanel eventsCard =
                createCard(
                        "Manage Events",
                        "Organize wedding events",
                        "/ui/icons/events.png"
                );

        JPanel bookingsCard =
                createCard(
                        "View Bookings",
                        "View all bookings",
                        "/ui/icons/bookings.png"
                );

        usersCard.setBounds(180,470,250,230);

        vendorsCard.setBounds(470,470,250,230);

        eventsCard.setBounds(760,470,250,230);

        bookingsCard.setBounds(1050,470,250,230);

        mainPanel.add(usersCard);

        mainPanel.add(vendorsCard);

        mainPanel.add(eventsCard);

        mainPanel.add(bookingsCard);

        // ================= USERS BUTTON =================

        usersBtn.addActionListener(e -> {

            String[] options;

            if(isAdmin){

                options = new String[]{
                        "Add User",
                        "View Users",
                        "Manage Users"
                };

            }else{

                options = new String[]{
                        "Add User",
                        "View Users"
                };
            }

            int choice =
                    JOptionPane.showOptionDialog(

                            null,

                            "Choose Option",

                            "User Management",

                            JOptionPane.DEFAULT_OPTION,

                            JOptionPane.INFORMATION_MESSAGE,

                            null,

                            options,

                            options[0]
                    );

            if(choice == 0){

                new AddUserForm();

            } else if(choice == 1){

                new ViewUsersUI();

            } else if(choice == 2){

                new ManageUserUI();
            }
        });

        // ================= VENDORS BUTTON =================

        vendorsBtn.addActionListener(e -> {

            String[] options;

            if(isAdmin){

                options = new String[]{
                        "Add Vendor",
                        "View Vendors",
                        "Manage Vendors"
                };

            }else{

                options = new String[]{
                        "Add Vendor",
                        "View Vendors"
                };
            }

            int choice =
                    JOptionPane.showOptionDialog(

                            null,

                            "Choose Option",

                            "Vendor Management",

                            JOptionPane.DEFAULT_OPTION,

                            JOptionPane.INFORMATION_MESSAGE,

                            null,

                            options,

                            options[0]
                    );

            if(choice == 0){

                new AddVendorForm();

            } else if(choice == 1){

                new ViewVendorsUI();

            } else if(choice == 2){

                new ManageVendorUI();
            }
        });

        // ================= EVENTS BUTTON =================

        eventsBtn.addActionListener(e -> {

            String[] options;

            if(isAdmin){

                options = new String[]{
                        "Add Event",
                        "View Events",
                        "Manage Events"
                };

            }else{

                options = new String[]{
                        "Add Event",
                        "View Events"
                };
            }
            int choice =
                    JOptionPane.showOptionDialog(

                            null,

                            "Choose Option",

                            "Event Management",

                            JOptionPane.DEFAULT_OPTION,

                            JOptionPane.INFORMATION_MESSAGE,

                            null,

                            options,

                            options[0]
                    );

            if(choice == 0){

                new AddEventForm();

            } else if(choice == 1){

                new ViewEventsUI();

            } else if(choice == 2){

                new ManageEventUI();
            }
        });

        // ================= BOOKINGS BUTTON =================

        bookingsBtn.addActionListener(e -> {
            String[] options;

            if(isAdmin){

                options = new String[]{
                        "Add Booking",
                        "View Bookings",
                        "Manage Bookings"
                };

            }else{

                options = new String[]{
                        "Add Booking",
                        "View Bookings"
                };
            }
            int choice =
                    JOptionPane.showOptionDialog(

                            null,

                            "Choose Option",

                            "Booking Management",

                            JOptionPane.DEFAULT_OPTION,

                            JOptionPane.INFORMATION_MESSAGE,

                            null,

                            options,

                            options[0]
                    );

            if(choice == 0){

                new BookingForm();

            } else if(choice == 1){

                new ViewBookingsUI();

            } else if(choice == 2){

                new ManageBookingUI();
            }
        });

        // ================= PAYMENTS BUTTON =================

        paymentsBtn.addActionListener(e -> {

            String[] options;

            if(isAdmin){

                options = new String[]{
                        "Add Payment",
                        "View Payments",
                        "Manage Payments"
                };

            }else{

                options = new String[]{
                        "Add Payment",
                        "View Payments"
                };
            }

            int choice =
                    JOptionPane.showOptionDialog(

                            null,

                            "Choose Option",

                            "Payment Management",

                            JOptionPane.DEFAULT_OPTION,

                            JOptionPane.INFORMATION_MESSAGE,

                            null,

                            options,

                            options[0]
                    );

            if(choice == 0){

                new PaymentUI();

            } else if(choice == 1){

                new ViewPaymentsUI();

            } else if(choice == 2){

                new ManagePaymentUI();
            }
        });

        // ================= REVIEWS BUTTON =================

        reviewsBtn.addActionListener(e -> {

            String[] options;

            if(isAdmin){

                options = new String[]{

                        "Add Review",

                        "View Reviews",

                        "Manage Reviews"
                };

            }else{

                options = new String[]{

                        "Add Review",

                        "View Reviews"
                };
            }

            int choice =
                    JOptionPane.showOptionDialog(

                            null,

                            "Choose Option",

                            "Review Management",

                            JOptionPane.DEFAULT_OPTION,

                            JOptionPane.INFORMATION_MESSAGE,

                            null,

                            options,

                            options[0]
                    );

            if(choice == 0){

                new AddReviewForm();

            } else if(choice == 1){

                new ViewReviewsUI();

            } else if(choice == 2){

                new ManageReviewUI();
            }
        });

        // ================= ADMIN BUTTON =================

        adminBtn.addActionListener(e -> {

            new LoginUI();
        });

        // ================= CARD CLICKS =================

        usersCard.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        usersBtn.doClick();
                    }
                }
        );

        vendorsCard.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        vendorsBtn.doClick();
                    }
                }
        );

        eventsCard.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        eventsBtn.doClick();
                    }
                }
        );

        bookingsCard.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        bookingsBtn.doClick();
                    }
                }
        );

        // ================= FOOTER =================

        JLabel footer =
                new JLabel(
                        "© 2026 Wedding Planning System"
                );

        footer.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        footer.setForeground(
                new Color(70,70,70)
        );

        footer.setBounds(600,770,400,30);

        mainPanel.add(footer);

        // ================= FRAME =================

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    // ================= NAV BUTTON METHOD =================

    private JButton createNavButton(String text){

        JButton btn =
                new JButton(text);

        btn.setFocusPainted(false);

        btn.setBorderPainted(false);

        btn.setContentAreaFilled(false);

        btn.setForeground(
                new Color(40,40,40)
        );

        btn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        return btn;
    }

    // ================= CARD METHOD =================

    private JPanel createCard(
            String title,
            String text,
            String iconPath
    ){

        JPanel panel =
                new JPanel();

        panel.setLayout(null);

        panel.setBackground(
                new Color(255,255,255,220)
        );

        panel.setBorder(
                new LineBorder(
                        new Color(255,220,230),
                        2
                )
        );

        // ================= ICON =================

        ImageIcon icon =
                new ImageIcon(
                        getClass().getResource(iconPath)
                );

        Image img =
                icon.getImage().getScaledInstance(
                        55,
                        55,
                        Image.SCALE_SMOOTH
                );

        JLabel iconLabel =
                new JLabel(
                        new ImageIcon(img)
                );

        iconLabel.setBounds(95,20,55,55);

        panel.add(iconLabel);

        // ================= TITLE =================

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        titleLabel.setForeground(
                new Color(40,40,40)
        );

        titleLabel.setBounds(30,95,220,35);

        panel.add(titleLabel);

        // ================= DESCRIPTION =================

        JLabel descLabel =
                new JLabel(
                        "<html><center>" +
                                text +
                                "</center></html>"
                );

        descLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        descLabel.setForeground(Color.GRAY);

        descLabel.setBounds(25,145,190,60);

        panel.add(descLabel);

        return panel;
    }
}