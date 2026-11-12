package LibraryManagement;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class AddingBook extends LibraryOperations{
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
