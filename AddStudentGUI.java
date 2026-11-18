import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentGUI extends JFrame implements ActionListener {
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea area;

    public AddStudentGUI() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        txtName = new JTextField(15);
        txtMatric = new JTextField(15);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        area = new JTextArea(5, 30);

        JPanel p1 = new JPanel(new GridLayout(2, 2));     // input
        p1.add(new JLabel("Name:"));
        p1.add(txtName);
        p1.add(new JLabel("Matric:"));
        p1.add(txtMatric);

        JPanel p2 = new JPanel(new FlowLayout());         // buttons
        p2.add(btnAdd);
        p2.add(btnList);

        JPanel top = new JPanel(new BorderLayout());
        top.add(p1, BorderLayout.NORTH);
        top.add(p2, BorderLayout.CENTER);
        top.add(new JLabel("Students:"), BorderLayout.SOUTH);

        pane.add(top, BorderLayout.NORTH);
        pane.add(new JScrollPane(area), BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);

        setTitle("Add Student Info");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            Student s = new Student(txtName.getText(), txtMatric.getText());
            MainMenu.students.add(s);
            txtName.setText("");
            txtMatric.setText("");
        } else if (e.getSource() == btnList) {
            area.setText("");
            for (Student s : MainMenu.students)
                area.append("Name : " + s + "\n");
        }
    }
}
