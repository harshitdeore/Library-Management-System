package model;

public class Book {
    private int book_id;
    private String title;
    private String author;
    private String category;
    private double price;
    private boolean issued;

    public Book(){

    }

    private Book(int book_id, String title, String author, String category, double price, boolean issued){
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.issued = issued;
    }

    public int getBookid(){
        return book_id;
    }

    public void setBookid(int book_id){
        this.book_id = book_id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public boolean isIssued(){
        return issued;
    }

    public void setIssued(boolean issued){
        this.issued = issued;
    }


    @Override
    public String toString(){
        return "Book{" + "bookId= " + book_id + ", title='" + title + "\'" + ", author='" + author + "\'"
                + ", category='" + category + "\'" + ", price=" + price + "issued=" + issued + "}" ;
    }
}
