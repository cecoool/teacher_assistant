package GUIs;

import SQLActions.*;
import snake.GameFrame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Locale;

public class LoginAndSignUpGUI {
    public static void GUISignIn(){
        final JFrame frame= new JFrame();
        JLabel lblTitle;
        JLabel lblUsername;
        JLabel lblPass;
        JLabel lblRepPas;
        JLabel lblMail;
        JLabel lblAddress;
        JLabel lblAddress2;
        JLabel lblNext;
        JLabel lblLast;
        final JTextField txtUsername;
        final JPasswordField txtPass;
        final JPasswordField txtRepPas;
        final JTextField txtMail;
        final JTextField txtAddress;
        JLabel background;
        Color gray = new Color(193, 193, 193, 255);
        Color blue = new Color(8, 75, 125);

        lblTitle = new JLabel("", new ImageIcon("Pictures/yes.gif"), JLabel.CENTER);
        lblTitle.setBounds(300, 10, 120, 40);

        lblUsername = new JLabel("     Username:");
        lblUsername.setBounds(50, 50, 80, 30);
        lblUsername.setForeground(gray);

        lblPass = new JLabel("     Password:");
        lblPass.setBounds(50, 80, 80, 30);
        lblPass.setForeground(gray);

        txtUsername = new JTextField();
        txtUsername.setBounds(140,57,140,20);
        txtUsername.setBackground(gray);
        txtUsername.setForeground(blue);

        txtPass = new JPasswordField();
        txtPass.setBounds(140,87,140,20);
        txtPass.setBackground(blue);
        txtPass.setForeground(gray);

        lblRepPas = new JLabel("Repeat password:");
        lblRepPas.setBounds(25, 155, 120, 30);
        lblRepPas.setForeground(gray);


        lblMail = new JLabel("   Valid e-mail:");
        lblMail.setBounds(50, 185, 80, 30);
        lblMail.setForeground(gray);

        txtRepPas = new JPasswordField();
        txtRepPas.setBounds(140,160,140,20);
        txtRepPas.setBackground(gray);
        txtRepPas.setForeground(blue);

        txtMail = new JTextField();
        txtMail.setBounds(140,190,140,20);
        txtMail.setBackground(blue);
        txtMail.setForeground(gray);

        lblAddress = new JLabel("Actual address:");
        lblAddress.setBounds(43, 255, 130, 30);
        lblAddress.setForeground(gray);

        txtAddress = new JTextField();
        txtAddress.setBounds(140,260,140,20);
        txtAddress.setBackground(gray);
        txtAddress.setForeground(blue);

        lblAddress2 = new JLabel("(by ID)");
        lblAddress2.setBounds(140,276,80,30);
        lblAddress2.setForeground(gray);

        background = new JLabel("", new ImageIcon("Pictures/background.jpg"), JLabel.CENTER);
        background.setBounds(0, 0, 700, 900);

        lblTitle = new JLabel("", new ImageIcon("Pictures/Vanilla-2.5s-280px (1).gif"), JLabel.CENTER);
        lblTitle.setBounds(290, 0, 280, 250);

        lblNext = new JLabel("", new ImageIcon("Pictures/next-removebg-preview.png"), JLabel.CENTER);
        lblNext.setBounds(468, 300, 120, 120);

        lblLast = new JLabel("", new ImageIcon("Pictures/last-removebg-preview.png"), JLabel.CENTER);
        lblLast.setBounds(-3, 300, 120, 120);

        background.add(lblNext);
        background.add(lblLast);
        background.add(lblAddress2);
        background.add(lblAddress);
        background.add(txtAddress);
        background.add(txtRepPas);
        background.add(lblRepPas);
        background.add(lblMail);
        background.add(txtMail);
        background.add(lblTitle);
        background.add(txtUsername);
        background.add(lblUsername);
        background.add(txtPass);
        background.add(lblPass);
        frame.add(background);

        frame.setSize(600, 450);
        frame.setTitle("SIGN IN");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



        lblLast.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "You will lose inputted data.", "Do you want to go back?", JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    GUILogin();
                    frame.dispose();
                }
            }
        });
        lblNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txtUsername.getText().equals("") ||
                        txtPass.getText().equals("") ||
                        txtRepPas.getText().equals("") ||
                        txtAddress.getText().equals("") ||
                        txtMail.getText().equals("")){

                    JOptionPane.showMessageDialog(null,"Please input all fields.");
                } else {
                    if (txtMail.getText().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")){

                        if( LoginAndSignUpSQL.checkForExistingName(txtUsername.getText())){
                            JOptionPane.showMessageDialog(null, "This username is taken! Try something like : name123, nameee or NaMe");
                        } else {
                            if(txtPass.getText().equals(txtRepPas.getText())){
                                LoginAndSignUpSQL.createAccount(txtUsername.getText(), txtPass.getText(), txtMail.getText(), txtAddress.getText());
                                //(create new account in mySQL)
                                JOptionPane.showMessageDialog(null, "Creating account!");
                                GUILogin();
                                frame.dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, "Passwords must match!");
                            }


                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "E-mail is invalid!");
                    }
                }
            }
        });

    }
    public static void GUILogin(){
        final JFrame frame= new JFrame();
        JLabel lblTitle;
        JLabel lblUsername;
        final JLabel lblPass;
        final JTextField txtUsername;
        final JPasswordField txtPass;
        JButton butt1;
        JButton butt2;
        JButton butt3;
        JLabel background;
        Color gray = new Color(193, 193, 193, 255);
        Color blue = new Color(8, 75, 125);
        


        lblTitle = new JLabel("", new ImageIcon("Pictures/yes.gif"), JLabel.CENTER);
        lblTitle.setBounds(110, 10, 120, 40);


        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 50, 80, 30);
        lblUsername.setForeground(gray);

        lblPass = new JLabel("Password:");
        lblPass.setBounds(50, 80, 80, 30);
        lblPass.setForeground(gray);

        txtUsername = new JTextField();
        txtUsername.setBounds(130,57,140,20);
        txtUsername.setBackground(gray);
        txtUsername.setForeground(blue);

        txtPass = new JPasswordField();
        txtPass.setBounds(130,87,140,20);
        txtPass.setBackground(blue);
        txtPass.setForeground(gray);

        butt1 = new JButton("Login") ;
        butt1.setBounds(45,120,80,30);
        butt1.setBackground(blue);
        butt1.setForeground(gray);

        butt2 = new JButton("Clear");
        butt2.setBackground(blue);
        butt2.setForeground(gray);
        butt2.setBounds(135,120,80,30);

        butt3 = new JButton("Sign in");
        butt3.setBackground(gray);
        butt3.setForeground(blue);
        butt3.setBounds(220,120,80,30);

        background = new JLabel("", new ImageIcon("Pictures/background.jpg"), JLabel.CENTER);
        background.setBounds(0, 0, 350, 200);

        background.add(butt3);
        background.add(butt2);
        background.add(butt1);
        background.add(txtPass);
        background.add(txtUsername);
        background.add(lblUsername);
        background.add(lblPass);
        background.add(lblTitle);

        frame.isUndecorated();
        frame.add(background);
        frame.setSize(350, 200);
        frame.setTitle("Haide da uchim!");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        butt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                if(LoginAndSignUpSQL.loginChek(txtUsername.getText(),txtPass.getText())){  //if username and password are correct

                    GUIMainStudents(txtUsername.getText());
                    frame.dispose();

                }else {
                    JOptionPane.showMessageDialog(null,"Your username or password are incorrect!");
                }
            }
        });

        butt2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPass.setText("");     // clear text
                txtUsername.setText("");
            }
        });
        butt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUISignIn();
                frame.dispose();
            }
        });
        lblTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GUIMainTeacher();
                frame.dispose();
            }
        });

    }
    public static void GUIMainStudents(String name ){
        final JFrame frame= new JFrame();
        JLabel lblTitle;
        JLabel lblTitleUnderTitle;
        JLabel lblGrades;
        JLabel lblPresences;
        JLabel lblProject;
        JLabel lblSnake;
        JLabel background;
        Color gray = new Color(193, 193, 193, 255);
        Color blue = new Color(8, 75, 125);

        String str = "Hello, " + name + " !";
        lblTitle = new JLabel(str);
        lblTitle.setBounds(20, 10, 300, 40);
        lblTitle.setFont(new Font("Times new Roman",Font.BOLD, 30));
        lblTitle.setForeground(gray);

        lblTitleUnderTitle = new JLabel("Are you ready to study today?");
        lblTitleUnderTitle.setBounds(120, 325, 350, 30);
        lblTitleUnderTitle.setFont(new Font("Times new Roman",Font.BOLD, 20));
        lblTitleUnderTitle.setForeground(gray);

        lblGrades = new JLabel("What grades do I have?");
        lblGrades.setBounds(20, 120, 150, 30);
        lblGrades.setForeground(gray);

        lblPresences = new JLabel("How much Presences do I have?");
        lblPresences.setBounds(20, 140, 200, 30);
        lblPresences.setForeground(gray);

        lblProject = new JLabel("What is my Final project topic?");
        lblProject.setBounds(20, 160, 180, 30);
        lblProject.setForeground(gray);

        lblSnake = new JLabel("", new ImageIcon("Pictures/COBRA.png"), JLabel.CENTER);
        lblSnake.setBounds(380, 270, 110, 110);

        background = new JLabel("", new ImageIcon("Pictures/background.jpg"), JLabel.CENTER);
        background.setBounds(0, 0, 350, 200);

        background.add(lblSnake);
        background.add(lblGrades);
        background.add(lblPresences);
        background.add(lblProject);
        background.add(lblTitleUnderTitle);
        background.add(lblTitle);

        frame.isUndecorated();
        frame.add(background);
        frame.setSize(500, 400);
        frame.setTitle("Software development");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        lblGrades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=Ve3fcInpKj0").toURI());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
        lblSnake.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GameFrame();
            }
        });
    }
    public static void GUIMainTeacher(){
        final JFrame frame= new JFrame();
        final JLabel lblTitle;
        final JLabel lblTitleUnderTitle;
        final JLabel lblAllStudents;
        final JLabel lblOnlyOneStudent;
        final JLabel lblChangeData;
        final JLabel lblSecureCode;
        final JTextField txtIDtoChange;
        final JButton btn;
        JLabel background;

        final JPasswordField txtSecureCode;
        Color gray = new Color(193, 193, 193, 255);
        Color blue = new Color(8, 75, 125);

        String str = "Welcome, Ceco";
        lblTitle = new JLabel(str);
        lblTitle.setBounds(20, 10, 300, 40);
        lblTitle.setFont(new Font("Times new Roman",Font.BOLD, 30));
        lblTitle.setForeground(gray);
        lblTitle.setVisible(false);


        lblTitleUnderTitle = new JLabel("    Work, work, work w...");
        lblTitleUnderTitle.setBounds(130, 325, 350, 30);
        lblTitleUnderTitle.setFont(new Font("Times new Roman",Font.BOLD, 20));
        lblTitleUnderTitle.setForeground(gray);
        lblTitleUnderTitle.setVisible(false);

        lblAllStudents = new JLabel("See all your students.");
        lblAllStudents.setBounds(20, 120, 150, 30);
        lblAllStudents.setForeground(gray);
        lblAllStudents.setVisible(false);

        lblOnlyOneStudent = new JLabel("See all data about one student.");
        lblOnlyOneStudent.setBounds(20, 140, 200, 30);
        lblOnlyOneStudent.setForeground(gray);
        lblOnlyOneStudent.setVisible(false);

        lblChangeData = new JLabel("Rewrite students data.");
        lblChangeData.setBounds(20, 160, 180, 30);
        lblChangeData.setForeground(gray);
        lblChangeData.setVisible(false);

        txtIDtoChange = new JTextField("ID?");
        txtIDtoChange.setBounds(20,195 ,60,20);
        txtIDtoChange.setBackground(gray);
        txtIDtoChange.setForeground(blue);
        txtIDtoChange.setVisible(false);

        txtSecureCode = new JPasswordField("");
        txtSecureCode.setBounds(190,170,100,30);
        txtSecureCode.setForeground(gray);
        txtSecureCode.setBackground(blue);

        lblSecureCode = new JLabel("  SECURE CODE");
        lblSecureCode.setBounds(190,145,110,30);
        lblSecureCode.setForeground(gray);

        btn = new JButton("Update");
        btn.setBounds(90,195,100,20);
        btn.setBackground(blue);
        btn.setForeground(gray);
        btn.setVisible(false);

        background = new JLabel("", new ImageIcon("Pictures/background.jpg"), JLabel.CENTER);
        background.setBounds(0, 0, 350, 200);

        background.add(btn);
        background.add(txtIDtoChange);
        background.add(lblAllStudents);
        background.add(lblOnlyOneStudent);
        background.add(lblChangeData);
        background.add(lblTitleUnderTitle);
        background.add(lblTitle);
        background.add(lblSecureCode);
        background.add(txtSecureCode);

        frame.add(background);
        frame.setSize(500, 400);
        frame.setTitle("Software development");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        txtSecureCode.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseExited(MouseEvent e) {
                if(txtSecureCode.getText().equals("1-1-")){
                    txtSecureCode.setVisible(false);
                    lblSecureCode.setVisible(false);
                    lblAllStudents.setVisible(true);
                    lblOnlyOneStudent.setVisible(true);
                    lblChangeData.setVisible(true);
                    lblTitleUnderTitle.setVisible(true);
                    lblTitle.setVisible(true);
                }
            }
        });

        lblAllStudents.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TeacherGUI.GUISeeAllStudents();
            }
        });

        lblChangeData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txtIDtoChange.isVisible()){
                    txtIDtoChange.setVisible(false);
                    btn.setVisible(false);
                }else{
                    txtIDtoChange.setVisible(true);
                    btn.setVisible(true);
                }

            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtIDtoChange.getText().matches("^[0-9]*$")){
                    if(Teacherq.checkForExistingID(txtIDtoChange.getText())){
                        TeacherGUI.GUIRewriteData(txtIDtoChange.getText());
                    }else JOptionPane.showMessageDialog(null,"This ID do not exist!");
                }else JOptionPane.showMessageDialog(null,"This is not a valid ID");
            }
        });
    }


}
