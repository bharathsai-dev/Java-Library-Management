package LibraryManagement;
import java.util.Scanner;
import java.util.ArrayList;

public class DisplayBooks extends LibraryOperations{
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
