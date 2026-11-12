package LibraryManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReturnBook extends LibraryOperations{
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

