import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookGUI extends JFrame implements ActionListener {
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea area;

    public AddBookGUI() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        txtTitle = new JTextField(15);
        txtAuthor = new JTextField(15);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        area = new JTextArea(5, 30);

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        p1.add(new JLabel("Book Title:"));
        p1.add(txtTitle);
        p1.add(new JLabel("Author:"));
        p1.add(txtAuthor);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(btnAdd);
        p2.add(btnList);

        JPanel top = new JPanel(new BorderLayout());
        top.add(p1, BorderLayout.NORTH);
        top.add(p2, BorderLayout.CENTER);
        top.add(new JLabel("Books:"), BorderLayout.SOUTH);

        pane.add(top, BorderLayout.NORTH);
        pane.add(new JScrollPane(area), BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);

        setTitle("Add Book Info");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            Book b = new Book(txtTitle.getText(), txtAuthor.getText());
            MainMenu.books.add(b);
            txtTitle.setText("");
            txtAuthor.setText("");
        } else if (e.getSource() == btnList) {
            area.setText("");
            for (Book b : MainMenu.books)
                area.append("Book title : " + b.getTitle() + " (Author : " + b.getAuthor() + ")\n");
        }
    }
}
