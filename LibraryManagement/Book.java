package LibraryManagement;

public class Book {
    private String bookName;
    private int bookId;
    private String bookAuthor;
    private boolean isAvailable=true;
    Book(String bookName,int bookId,String bookAuthor){
        this.bookName=bookName;
        this.bookAuthor=bookAuthor;
        this.bookId=bookId;
    }
    void setBookName(String bookName){
        this.bookName=bookName;
    }
    String getBookName(){
        return bookName;
    }
    void setBookAuthor(String bookAuthor){
        this.bookAuthor=bookAuthor;
    }
    String getBookAuthor(){
        return bookAuthor;
    }
    void setBookId(int bookId){
        this.bookId=bookId;
    }
    int getBookId(){
        return bookId;
    }
    void setAvailability(boolean isAvailable){
        this.isAvailable=isAvailable;
    }
    boolean getAvailability(){
        return isAvailable;
    }
    public String toString(){
        return "\nID : "+getBookId() +
               "\nName : "+getBookName() +
               "\nAuthor : "+getBookAuthor() +
               "\nAvailability : " + (getAvailability()?"Available":"Issued");
    }
}

