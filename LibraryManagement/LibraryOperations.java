package LibraryManagement;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class LibraryOperations{
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
