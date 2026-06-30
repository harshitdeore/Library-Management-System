package service;

import dao.BookDAO;
import model.Book;

public class LibraryService {

    BookDAO dao = new BookDAO();

    public void addBook(Book book){
        dao.addBook(book);
    }

    public void viewBooks() {
        dao.viewBooks();
    }

    public void searchBook(int bookId) {
        dao.searchBook(bookId);
    }

    public void updateBook(Book book) {
        dao.updateBook(book);
    }

    public void deleteBook(int bookId) {
        dao.deleteBook(bookId);
    }

    public void issueBook(int bookId) {
        dao.issueBook(bookId);
    }

    public void returnBook(int bookId) {
        dao.returnBook(bookId);
    }
}
