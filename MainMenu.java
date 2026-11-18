import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenu extends JFrame implements ActionListener {
    // shared data used by all forms
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Book> books = new ArrayList<Book>();

    private JButton btnStudent, btnBook, btnBorrow;

    public MainMenu() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 5, 5));
        btnStudent = new JButton("Add Student Info");
        btnBook = new JButton("Add Book Info");
        btnBorrow = new JButton("Borrow Book");
        pane.add(new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER));
        pane.add(btnStudent);
        pane.add(btnBook);
        pane.add(btnBorrow);
        btnStudent.addActionListener(this);
        btnBook.addActionListener(this);
        btnBorrow.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStudent)
            new AddStudentGUI().setVisible(true);
        else if (e.getSource() == btnBook)
            new AddBookGUI().setVisible(true);
        else if (e.getSource() == btnBorrow)
            new BorrowBookGUI().setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setTitle("Main Menu");
        frame.setSize(250, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
