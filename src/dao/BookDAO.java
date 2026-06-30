//BookDAO = Data Access Object

package dao;

import model.Book;
import database.DBConnection;

import java.sql.*;


public class BookDAO {

    public void addBook(Book book){

        String query="INSERT INTO books(book_id, title, author, category, price, issued) VALUES (?,?,?,?,?,?)";

        try {

            Connection con=DBConnection.getConnection();

            PreparedStatement ps= con.prepareStatement(query);

            ps.setInt(1,book.getBookid());
            ps.setString(2,book.getTitle());
            ps.setString(3,book.getAuthor());
            ps.setString(4,book.getCategory());
            ps.setDouble(5,book.getPrice());


            if (book.isIssued()) {
                ps.setString(6, "Y");
            } else {
                ps.setString(6, "N");
            }

            int rows=ps.executeUpdate();

            if (rows>0){
                System.out.println("\n=================================");
                System.out.println(" Book Added Successfully!");
                System.out.println("=================================");
            }else {
                System.out.println("Failed to Add Book");
            }

            ps.close();
            con.close();

        }catch (SQLException e){
            if (e.getErrorCode() == 1){
                System.out.println("Book ID already exists.");
            }else {
                System.out.println("Database Error: " + e.getMessage());
            }
        }
    }

    public void viewBooks(){
        try {

            String query = "SELECT * FROM books";

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println();
            System.out.println("                                 ========== BOOK LIST ==========");
            System.out.println("==================================================================================================");
            System.out.printf("%-10s %-25s %-20s %-15s %-10s %-10s%n", "ID", "Title", "Author", "Category", "Price","Issued");

            System.out.println("==================================================================================================");

            while (rs.next()){

                int id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String category = rs.getString("category");
                double price = rs.getDouble("price");
//                boolean issued = rs.getBoolean("issued");
                String status = rs.getString("issued").equalsIgnoreCase("Y") ? "Issued" : "Available";

                System.out.printf("%-10d %-25s %-20s %-15s %-10.2f %-10s%n", id, title, author, category, price, status);
            }
            System.out.println("==================================================================================================");

            rs.close();
            ps.close();
            con.close();

        }catch (SQLException e) {
            System.out.println("Unable to fetch books from the database.");
        }
    }

    public void searchBook(int book_id){

        String query = "SELECT * FROM books WHERE book_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,book_id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                System.out.println("\n========== BOOK DETAILS ==========");
                System.out.println("Book ID   : " + rs.getInt("book_id"));
                System.out.println("Title     : " + rs.getString("title"));
                System.out.println("Author    : " + rs.getString("author"));
                System.out.println("Category  : " + rs.getString("category"));
                System.out.println("Price     : ₹" + rs.getDouble("price"));
                System.out.println("Issued    : " +
                        (rs.getString("issued").equals("Y") ? "Yes" : "No"));
                System.out.println("==================================");

            }else {
                System.out.println("Book not found");
            }

            rs.close();
            ps.close();
            con.close();

        }catch (SQLException e) {
            System.out.println("Unable to search book.");
            System.out.println("Reason: " + e.getMessage());
        }

    }

    public void updateBook(Book book){

        String query = "UPDATE books SET title=?, author=?, category=?, issued=? WHERE book_id=?";

        try {
            Connection con =  DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getCategory());

            if (book.isIssued()){
                ps.setString(4,"Y");
            }else {
                ps.setString(4,"N");
            }

            ps.setInt(5, book.getBookid());

            int rows = ps.executeUpdate();

            if (rows>0){
                System.out.println("\n=================================");
                System.out.println(" Book Updated Successfully!");
                System.out.println("=================================");
            }else {
                System.out.println("Book Not Found.");
            }

            ps.close();
            con.close();

        }catch (SQLException e) {
            System.out.println("Unable to update book.");
            System.out.println("Reason: " + e.getMessage());
        }
    }

    public void deleteBook(int book_id){

        String query = "DELETE FROM books WHERE book_id=?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1,book_id);

            int rows = ps.executeUpdate();

            if (rows>0){
                System.out.println("\n=================================");
                System.out.println(" Book Deleted Successfully!");
                System.out.println("=================================");
            }else {
                System.out.println("Book Not Found.");
            }

            ps.close();
            con.close();
        }catch (SQLException e) {
            System.out.println("Unable to delete book.");
            System.out.println("Reason: " + e.getMessage());
        }
    }

    public void issueBook(int book_id){

        String selectQuery = "SELECT issued FROM books WHERE book_id = ?";
        String updateQuery = "UPDATE books SET issued = 'Y' WHERE book_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement(selectQuery);

            ps1.setInt(1,book_id);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()){
                String status = rs.getString("issued");
                if (status.equalsIgnoreCase("Y")){
                    System.out.println("Book is already issued.");
                }else {
                    PreparedStatement ps2 = con.prepareStatement(updateQuery);
                    ps2.setInt(1,book_id);

                    int rows = ps2.executeUpdate();

                    if (rows > 0 ){
                        System.out.println("\n=================================");
                        System.out.println(" Book Issueed Successfully!");
                        System.out.println("=================================");
                    }else {
                        System.out.println("Failed to Issue Book.");
                    }
                    ps2.close();
                }
            }else {
                System.out.println("Book Not Found.");
            }
            rs.close();
            ps1.close();
            con.close();

        }catch (SQLException e) {
            System.out.println("Unable to issue book.");
            System.out.println("Reason: " + e.getMessage());
        }
    }
    public void returnBook(int book_id){

        String selectquery = "SELECT issued FROM books WHERE book_id = ?";
        String updateQuery = "UPDATE books SET issued = 'N' WHERE book_id = ?";

        try {

            Connection con = DBConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement(selectquery);

            ps1.setInt(1,book_id);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()){
                String status = rs.getString("issued");

                if (status.equalsIgnoreCase("N")){
                    System.out.println("Book is not Issued.");
                }else {
                    PreparedStatement ps2 = con.prepareStatement(updateQuery);
                    ps2.setInt(1,book_id);

                    int rows = ps2.executeUpdate();

                    if (rows > 0){
                        System.out.println("\n=================================");
                        System.out.println(" Book Returned Successfully!");
                        System.out.println("=================================");
                    }else {
                        System.out.println("Failed to return Book");
                    }
                    ps2.close();
                }
            }else {
                System.out.println("Book Not Found.");
            }
            rs.close();
            ps1.close();
            con.close();

        }catch (SQLException e) {
            System.out.println("Unable to return book.");
            System.out.println("Reason: " + e.getMessage());
        }
    }
}
