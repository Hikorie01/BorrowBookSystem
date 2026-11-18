public class Book {
    private String title, author;
    private Student borrower;   // only one copy

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }

    public String borrowBy(Student s) {
        if (borrower != null)
            return "Sorry, " + title + " has already been borrowed.";
        if (s.getBook() != null)
            return "Sorry, " + s.getName() + " has already borrowed a book.";
        borrower = s;
        s.setBook(this);
        return s.getName() + " with matric number " + s.getMatric() + " has borrow a book with title " + title + ".";
    }

    public String toString() {
        return title + " (" + author + ")";
    }
}
