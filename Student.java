public class Student {
    private String name, matric;
    private Book book;          // book borrowed (only one)

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
    }
    public String getName()   { return name; }
    public String getMatric() { return matric; }
    public Book getBook()     { return book; }
    public void setBook(Book b) { book = b; }

    public String toString() {
        return name + " (" + matric + ")";
    }
}
