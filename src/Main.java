import model.Book;
import service.LibraryService;
import util.InputValidator;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        LibraryService service = new LibraryService();

        System.out.println("**************************************************");
        System.out.println("*                                                *");
        System.out.println("*            WELCOME TO THE LIBRARY              *");
        System.out.println("*            MANAGEMENT SYSTEM                   *");
        System.out.println("*                                                *");
        System.out.println("**************************************************");
        System.out.println("\nLoading...");

        try {
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e);
        }
        while (true){

            System.out.println("\n==================================================");
            System.out.println("         LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==================================================");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.println("==================================================");
            System.out.print("Enter Your Choice: ");

            int choice= sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Book book = new Book();

                    book.setBookid(InputValidator.readPositiveInt(sc,"Enter Book id: "));
                    sc.nextLine();

                    book.setTitle(InputValidator.readNonEmptyString(sc,"Enter Title: "));

                    book.setAuthor(InputValidator.readNonEmptyString(sc,"Enter Author: "));

                    book.setCategory(InputValidator.readNonEmptyString(sc,"Enter Category: "));

                    book.setPrice(InputValidator.readPositiveDouble(sc,"Enter Price: "));

                    book.setIssued(InputValidator.readIssuedStatus(sc,"Is Book Issued? (true/false): "));

                    service.addBook(book);
                    break;


                case 2:
                    service.viewBooks();
                    break;

                case 3:
                    System.out.println("Enter the id of book you want to search: ");
                    service.searchBook(sc.nextInt());
                    break;

                case 4:

                    Book updatebook = new Book();

                    updatebook.setBookid(InputValidator.readPositiveInt(sc, "Enter Book ID to Update: "));
                    sc.nextLine();

                    updatebook.setTitle(InputValidator.readNonEmptyString(sc, "Enter New Title: "));
                    updatebook.setAuthor(InputValidator.readNonEmptyString(sc, "Enter New Author: "));
                    updatebook.setCategory(InputValidator.readNonEmptyString(sc, "Enter New Category: "));
                    updatebook.setPrice(InputValidator.readPositiveDouble(sc, "Enter New Price: "));
                    updatebook.setIssued(InputValidator.readIssuedStatus(sc,"Is Book Issued? (true/false): "));

                    service.updateBook(updatebook);

                case 5:
                    System.out.println("Enter the book_id of the Book you want to delete: ");
                    int deletebook = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Are you sure you want to Delete this book " + deletebook + " (Y/N): ");
                    String yesno = sc.nextLine();

                    if (yesno.equalsIgnoreCase("y")){
                        service.deleteBook(deletebook);
                    }else {
                        System.out.println("The Book is not Deleted");
                    }
                    break;

                case 6:
                    System.out.println("Enter book_id of the book you want to issue: ");
                    service.issueBook(sc.nextInt());
                    break;

                case 7:
                    System.out.println("Enter book_id of the book you want to issue: ");
                    service.returnBook(sc.nextInt());
                    break;

                case 8:

                    System.out.println("\n===============================================");
                    System.out.println("Thank you for using Library Management System!");
                    System.out.println("Have a Nice Day!");
                    System.out.println("===============================================");

                    sc.close();
                    System.exit(0);
                    break;
            }
        }
    }
}
