# Borrow Book System

Java Swing GUI app (TK1143 Tutorial 5A, Section B Q7).

- MainMenu: main menu with Add Student Info, Add Book Info, Borrow Book
- AddStudentGUI / AddBookGUI: add objects and list them
- BorrowBookGUI: pick a student and a book, then Borrow
- Student / Book: data classes with toString() and borrowBy()

Rules: each student can borrow only one book, and each book title has only one copy.

## Run
    javac *.java
    java MainMenu
