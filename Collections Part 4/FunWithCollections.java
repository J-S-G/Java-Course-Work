package funwithcollections;

/**
 *
 * @author jg
 */

import java.util.Scanner;

public class FunWithCollections
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        SongsLibraryDLL myLibrary = new SongsLibraryDLL();
        
        myLibrary.addToRear(new Song("Aqualung", "Jethro Tull", 
                200, "disk1"));
        myLibrary.addToRear(new Song("Help", "Beatles", 
                200, "disk1"));
        myLibrary.addToRear(new Song("Bang a Gond", "T Rex", 
                200, "disk1"));
        myLibrary.addToRear(new Song("White Rabbit", 
                "Jefferson Airplane", 200, "disk1"));
        
        
        int choice = 0; 
        
        while(choice != 10)
        {
            try{
                printMenu();
                choice = getChoice();
                switch(choice)
                {
                    case 1 : myLibrary.addAfter(newSong());
                    System.out.println(myLibrary.currentSong());
                    break; 
                    case 2 : System.out.println(myLibrary.getNext());
                    break; 
                    case 3 : System.out.println(myLibrary.getPrev());
                    break; 
                    case 4 : System.out.println(myLibrary.first());
                    break; 
                    case 5 : System.out.println(myLibrary.last());
                    break; 
                    case 6 : myLibrary.deleteCurrent();
                    if(myLibrary.isEmpty())
                    {
                        System.out.println("Error: No Songs");
                    }
                    else
                    {
                        System.out.println(myLibrary.currentSong());
                    }
                    break; 
                    case 7 : System.out.println(myLibrary);
                    break; 
                    case 10 : System.out.println("Goodbye");
                    break; 
                }
            }
            catch(EmptyPlayListException e)
            {
                System.out.println("Empty Playlist " + e);
            }
        }
    }
    
    public static Song newSong()
    {
        Scanner stdin = new Scanner(System.in);
        String song; 
        String author; 
        int length; 
        String fileLocation; 
        
        System.out.println("Enter Name of song");
        song = stdin.nextLine();
        System.out.println("Enter Author");
        author = stdin.nextLine();
        System.out.println("Enter fileLocation");
        fileLocation = stdin.nextLine();
        System.out.println("Time?");
        length = stdin.nextInt();
        return new Song(song, author, length, fileLocation);
        
    }
    
    public static int getChoice()
    {
        Scanner stdin = new Scanner(System.in);
        return stdin.nextInt();
    }
    
    
    public static void printMenu()
    {
        System.out.println("Main Menu");
        System.out.println("1. New Song");
        System.out.println("2. Next Song");
        System.out.println("3. Prev Song");
        System.out.println("4. First Song");
        System.out.println("5. Last Song");
        System.out.println("6. Delete Current Song");
        System.out.println("7.  Print All Songs");
        System.out.println("10. Quit");
        
    }
    
}
