package LibraryManagement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
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