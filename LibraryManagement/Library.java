package LibraryManagement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
class Book{
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
abstract class LibraryOperations{
    boolean isIdExist(ArrayList<Book> books,int ID){
        for(Book b:books){
            if(b.getBookId()==ID){
                return true;
            }
        }
        return false;
    }
    public abstract void execute(ArrayList<Book> books,Scanner sc);
}
class AddingBook extends LibraryOperations{
    @Override 
    public void execute(ArrayList<Book> books, Scanner sc){
        try{
           System.out.print("\n----------ADDING A BOOK----------");
            System.out.print("\nEnter the Book Name : ");
            String bookName=sc.nextLine();
            System.out.print("\nEnter the Book ID : ");
            int bookId=sc.nextInt();
            if(isIdExist(books, bookId)){
                do{
                    System.out.print("The entered ID already exists.\nSo enter a new Book ID  : ");
                    bookId=sc.nextInt();
                }while(isIdExist(books, bookId));
            }
            sc.nextLine();
            System.out.print("\nEnter the Author Name : ");
            String bookAuthor=sc.nextLine();
            books.add(new Book(bookName, bookId, bookAuthor));
            System.out.print("\nBook is added Successfully..........");
        }
        catch(InputMismatchException e){
            System.out.print("Please enter the valid details.........");
            sc.nextLine();
        }
    }    
}
class DisplayBooks extends LibraryOperations{
    @Override   
    public void execute(ArrayList<Book> books,Scanner sc){
    System.out.println("----------DISPLAYING BOOKS----------");
        if(!(books.isEmpty())){
        for(Book b:books){
            System.out.println(b);
        }
        }
        else{
            System.out.print("\nThe Library is empty.............");
        }
    }
}
class IssueBook extends LibraryOperations{
    @Override 
    public void execute(ArrayList<Book> books,Scanner sc){
    if(books.isEmpty()){
            System.out.print("\nThe Library is empty");
            return;
            }
            try{
            System.out.print("\nEnter the ID to be issued : ");
            int idToBeIssued=sc.nextInt();
            if(isIdExist(books, idToBeIssued)){
                for(Book b:books){
                if(b.getBookId()==idToBeIssued){
                if(b.getAvailability()){
                    b.setAvailability(false);
                    System.out.print("\nSuccessfully Issued \"The "+b.getBookName()+"\" ...............");
                    return;
                }
                else{
                    System.out.print("The book is already issued........");
                }
                }
            }
            }
            else{
             System.out.print("\nThe entered ID doesn't exist....");   
            }
            }
            catch(InputMismatchException e){
                System.out.print("Enter the Valid ID(Integers only ex.:123456)");
                sc.nextLine();
            }    
    }
}
class ReturnBook extends LibraryOperations{
    @Override 
    public void execute(ArrayList<Book> books,Scanner sc){
    if(books.isEmpty()){
            System.out.print("\nThe library is empty. So check from which library you got that book.......");
            return;   
            }
            try{
            System.out.print("\nEnter the ID to return : ");
            int idToBeReturned=sc.nextInt();
            if(isIdExist(books, idToBeReturned)){
            for(Book b:books){
                if(b.getBookId()==idToBeReturned){
                    if(!(b.getAvailability())){
                    b.setAvailability(true);
                    System.out.print("\nThe book \""+b.getBookName()+"\" is successfully returned.....");
                    return;
                    }
                    else{
                        System.out.print("\nThe book doesn't issued........");
                    }
                }
            }
            }
            else{ 
                System.out.print("\nEntered ID doesn't exist.............");
            }   
            }
            catch(InputMismatchException e){
                System.out.print("Enter the Valid ID(Integers only ex.:123456)");
                sc.nextLine();
            }    
    }
}

public class Library {
    static void menu(){
        System.out.print("\n---------------MENU---------------\n");
        System.out.print("1. Add Book\n2. Display Books\n3. Issue Book\n4. Return Book\n5. Exit\n");
    }

    static int input(Scanner sc){
    try{
    int option=sc.nextInt();
    sc.nextLine();
    if((option>5)||(option<1)){
    do{
        menu();
        System.out.println("\nEnter a valid option : ");
        option=sc.nextInt();
        sc.nextLine();
        }while(((option>5)||(option<1)));
    }
        return option; 
    }
    catch(InputMismatchException e){
        System.out.print("Enter the input as integers, which are ranging from 1 to 5 (1 - 5)");
        sc.nextLine();
        return 0;
    }
    }

    static void exiting(){
        System.out.print("\nExiting...............");
        System.out.print("\nThank you for using this library");
    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    ArrayList<Book> books=new ArrayList<>();
    int option=0;
    LibraryOperations operation=null;
    do{
        menu();
        option=input(sc);   
        switch(option){
        case 1:
            operation=new AddingBook();
            break;
        case 2:
            operation=new DisplayBooks();
            break;
        case 3:
            operation=new IssueBook();
            break;
        case 4:
            operation=new ReturnBook();
            break;
        case 5:
            exiting();
            break;
        default:
            break;

    }
    if(option!=5){
        operation.execute(books, sc);
    }
}while(option!=5);
    sc.close();
}
}
