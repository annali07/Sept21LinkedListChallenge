import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

 
  public static void main(String[] args) throws FileNotFoundException {
    
    Scanner scanner = new Scanner(new File ("Album.txt"));
    
    Computer computer = new Computer("Anna's Computer");

    while(scanner.hasNextLine()){

      computer.addAlbum(scanner.nextLine());
      
    }


    Scanner s = new Scanner(new File ("Red.txt"));

    while(s.hasNextLine()){
      String[] pars = s.nextLine().split(" ");

      
      computer.addSong("Red", pars [0], pars[1]);
     

    }

 
    
    Scanner ss = new Scanner(new File ("YoungForever.txt"));

    while(ss.hasNextLine()){
      String[] parts = ss.nextLine().split(" ");
      
      computer.addSong("YoungForever", parts [0], parts[1]);
     

    }

    Scanner sss = new Scanner(new File ("TT.txt"));

    while(sss.hasNextLine()){
      String[] par = sss.nextLine().split(" ");
      
      computer.addSong("TT", par [0], par[1]);
     

    }
    

   
   
    //Test Code

    // System.out.println("======================");
   
    // computer.findSong("butterfly");

    // computer.addSong("TT", "RUN", "1;22");//modify to add a message saying add song failed. 

    // computer.addPlayList("Love");
    // computer.addSongToPlayList("Love", "SaveME");


    

  }

  


  
}
