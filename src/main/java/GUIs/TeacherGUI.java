package GUIs;

import SQLActions.*;
import com.company.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TeacherGUI {
    static int i;
    static int j;
    static int id;
    static Color gray = new Color(193, 193, 193, 255);
    static Color blue = new Color(8, 75, 125);
    static Student[] arrStudents;
    static int[] whoIsOnButt = new int[10];

    public static void GUIRewriteData(final String id) {
        final JFrame frame = new JFrame();

        final JTextField txt1;
        final JTextField txt2;
        final JTextField txt3;
        JLabel lbl1;
        JLabel lbl2;
        JLabel lbl3;
        JButton butt1;
        JLabel background;
        Color gray = new Color(193, 193, 193, 255);
        Color blue = new Color(8, 75, 125);

        String data[] = Teacherq.getStudentsData(id).split("/"); // READ DATA AND SPLIT IT

        txt1 = new JTextField(data[0]);
        txt1.setBackground(gray);
        txt1.setForeground(blue);
        txt1.setBounds(20, 20, 50, 20);

        txt2 = new JTextField(data[1]);
        txt2.setBackground(gray);
        txt2.setForeground(blue);
        txt2.setBounds(20, 60, 50, 20);

        txt3 = new JTextField(data[2]);
        txt3.setBackground(gray);
        txt3.setForeground(blue);
        txt3.setBounds(20, 100, 190, 20);

        butt1 = new JButton("SAVE");
        butt1.setBackground(blue);
        butt1.setForeground(gray);
        butt1.setBounds(120, 20, 90, 60);

        lbl1 = new JLabel("Gr.");
        lbl1.setForeground(gray);
        lbl1.setBounds(75, 15, 30, 30);

        lbl2 = new JLabel("Pr.");
        lbl2.setForeground(gray);
        lbl2.setBounds(75, 55, 30, 30);

        lbl3 = new JLabel("p.T.");
        lbl3.setForeground(gray);
        lbl3.setBounds(213, 95, 40, 30);

        background = new JLabel("", new ImageIcon("Pictures/background.jpg"), JLabel.CENTER);
        background.setBounds(0, 0, 350, 200);

        background.add(lbl3);
        background.add(lbl2);
        background.add(lbl1);
        background.add(butt1);
        background.add(txt3);
        background.add(txt2);
        background.add(txt1);
        frame.add(background);
        frame.setSize(250, 180);
        frame.setTitle("Haide da uchim!");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        butt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Teacherq.UpdateStudentData(txt1.getText(), txt2.getText(), txt3.getText(), id);
            }
        });
    }

    public static void GUISeeAllStudents() {
        final JFrame frame = new JFrame();
        final JButton[][] buttons = new JButton[10][3];
        JLabel lbl1;
        JButton next;
        JButton last;
        int x = 0;
        int y = 25;
        //-------------------create and fill array with Student objects
        String[] arrLines = Teacherq.getAllStudents().split("\n");
        arrStudents = new Student[arrLines.length];
        final String[] arrLinesData = Teacherq.getAllStudentsData().split("\n");
        for (i = 0; i < arrLines.length; i++) {
            String[] choped = arrLines[i].split("~");
            String[] chopedData = arrLinesData[i].split("~");
            arrStudents[i] = new Student(Byte.parseByte(choped[0]), choped[1], choped[2], choped[3],
                    new SchoolData(chopedData[1], chopedData[2], chopedData[3]));
        }
        //-------------X---------
        final JLabel background;

        background = new JLabel("", new ImageIcon("Pictures/background.jpg"), JLabel.CENTER);
        background.setBounds(0, 0, 350, 200);

        lbl1 = new JLabel("", new ImageIcon("Pictures/blue.png"), JLabel.CENTER);
        lbl1.setBounds(25, 50, 435, 275);

        next = new JButton(">");
        next.setBounds(380, 0, 55, 25);
        next.setBackground(gray);
        next.setForeground(blue);

        last = new JButton("<");
        last.setBounds(0, 0, 55, 25);
        last.setBackground(gray);
        last.setForeground(blue);

        try {
            for (i = 0; i < 10; i++, y += 25) {
                for (j = 0; j < 3; j++) {
                    buttons[i][j] = new JButton();
                    if (i < arrLines.length) {
                        whoIsOnButt[i] = arrStudents[i].getId();
                        buttons[i][0].setText("ID: " + String.valueOf(arrStudents[i].getId())
                                + "  |  Username: " + arrStudents[i].getUsername() + "  |");
                    }
                    if (j == 0) {
                        buttons[i][j].setBounds(x, y, 289, 25);
                        buttons[i][j].setHorizontalAlignment(SwingConstants.LEFT);
                        buttons[i][j].setBackground(gray);
                        buttons[i][j].setForeground(blue);
                    } else if (j == 1) {
                        buttons[i][j].setText("Change");
                        buttons[i][j].setBounds(x + 289, y, 80, 25);
                        buttons[i][j].setHorizontalAlignment(SwingConstants.LEFT);
                        buttons[i][j].setBackground(gray);
                        buttons[i][j].setForeground(blue);
                    } else if (j == 2) {
                        buttons[i][j].setText("INFO");
                        buttons[i][j].setBounds(x + 369, y, 66, 25);
                        buttons[i][j].setHorizontalAlignment(SwingConstants.LEFT);
                        buttons[i][j].setBackground(gray);
                        buttons[i][j].setForeground(blue);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error!");
        }
        //----ADD-Action-listeners--------
        for (i = 0; i < whoIsOnButt.length; i++) {
            if(buttons[i][0].getText().equals("")) break;
            for (j = 0; j < 3; j++)  funcActionListeners(buttons[i][j], j , whoIsOnButt[i], arrStudents[i]);
        }

        ArrayList<String> list = new ArrayList<String>();
        list.add("baba");
        list.add("mama");
        list.forEach((n) -> System.out.println(n=""));
        //--------------X-------------

        //--------HIDE EMPTY BUTTONS----
        for (i = 0; i < 10; i++) {
            if (buttons[i][0].getText().equals("")){
                buttons[i][0].setVisible(false);
                buttons[i][1].setVisible(false);
                buttons[i][2].setVisible(false);
            }
        } //--------------X-------------

        //--------ADD ALl BUTTONS----
        for (i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                lbl1.add(buttons[i][j]);
            }
        }//--------------X-------------
        lbl1.add(next);
        lbl1.add(last);

        frame.add(lbl1);
        frame.add(background);
        frame.setSize(500, 400);
        frame.setTitle("Haide da uchim!");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    static void funcActionListeners(final JButton butt, int j, final int id, final Student Student) {
        if (j == 0) {
            butt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    butt.setBackground(blue);
                    butt.setForeground(gray);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    butt.setBackground(gray);
                    butt.setForeground(blue);
                }
            });
        }
        else if (j == 1) {
                butt.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        butt.setBackground(Color.red);
                        butt.setForeground(blue);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        butt.setBackground(gray);
                        butt.setForeground(blue);
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        GUIRewriteData(String.valueOf(id));
                    }
                });
        } else if(j == 2) {
            butt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    butt.setBackground(Color.yellow);
                    butt.setForeground(blue);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    butt.setBackground(gray);
                    butt.setForeground(blue);
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showInternalConfirmDialog(null,
                            "*************************************************************"  + '\n' +
                            "Personal data:"+ '\n' + "   ID: " + Student.getId()+ '\n' + "   Username: " +  Student.getUsername()  + '\n'
                                    + "   E-mail: " + Student.geteMail() + '\n' + "   Address: " + Student.getAddress() + '\n' + '\n'
                                    + "School data:" + '\n' +"   Grades: " +  Student.getData().getGrades() + '\n' + "   Presences: "
                                    +  Student.getData().getPresences() + '\n' + "   Project: " +  Student.getData().getProjectTopic() + '\n'
                                    + "*************************************************************"
                            ,butt.getText(), JOptionPane.CLOSED_OPTION);
                }
            });
        }

    }
}
