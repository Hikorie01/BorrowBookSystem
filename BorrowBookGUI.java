import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBookGUI extends JFrame implements ActionListener {
    private JComboBox<String> cbStudent, cbBook;
    private JButton btnBorrow;
    private JLabel lblInfo;

    public BorrowBookGUI() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        // fill combo boxes from saved objects
        cbStudent = new JComboBox<String>();
        for (Student s : MainMenu.students)
            cbStudent.addItem(s.toString());
        cbBook = new JComboBox<String>();
        for (Book b : MainMenu.books)
            cbBook.addItem(b.toString());

        btnBorrow = new JButton("Borrow");
        lblInfo = new JLabel(" ");

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        p1.add(new JLabel("Student Name & Matric:"));
        p1.add(cbStudent);
        p1.add(new JLabel("Book Title & Author:"));
        p1.add(cbBook);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(btnBorrow);

        JPanel top = new JPanel(new BorderLayout());
        top.add(p1, BorderLayout.NORTH);
        top.add(p2, BorderLayout.CENTER);

        JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(new JLabel("Borrow Information :"));
        p3.add(lblInfo);

        pane.add(top, BorderLayout.NORTH);
        pane.add(p3, BorderLayout.SOUTH);

        btnBorrow.addActionListener(this);

        setTitle("Borrow Book");
        setSize(560, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        int si = cbStudent.getSelectedIndex();
        int bi = cbBook.getSelectedIndex();
        if (si == -1 || bi == -1) {
            lblInfo.setText("Please add student and book first.");
            return;
        }
        Student s = MainMenu.students.get(si);
        Book b = MainMenu.books.get(bi);
        lblInfo.setText(b.borrowBy(s));
    }
}
