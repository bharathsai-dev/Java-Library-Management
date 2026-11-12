package LibraryManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IssueBook extends LibraryOperations{
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
