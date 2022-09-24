import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;



public class Main {
  static Computer computer = new Computer("Anna's Computer");
 
  public static void main(String[] args) throws FileNotFoundException {
    
    Scanner scanner = new Scanner(new File ("Album.txt"));
    
  

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
    

   
   
    // Test Code

    System.out.println("======================");
   
    findSong("butterfly");

    computer.addSong("TT", "RUN", "1;22");//modify to add a message saying add song failed. 

    computer.addPlayList("Love");

    computer.addSongToPlayList("Love", "SaveME");
    computer.addSongToPlayList("Love", "INEEDU");

    computer.addPlayList("JPOP");

    computer.addSongToPlayList("JPOP", "dog");


    System.out.println(computer.getPlayLists().get(0).getName());
    System.out.println("++++++++++");

    play(computer.getPlayLists().get(0).getMyPlayList(), computer.getPlayLists().get(0));


    

  }

  
















  public static void findSong(String name){
    if (!(computer.findSong(name) == null)){
      System.out.println("Song " + name + " found in album " + computer.findAlbumFromSong(name).getAlbumName() );
    }
  }


  private static void play(LinkedList<Song> playlist, Playlist playlistName){

    
    Scanner scan = new Scanner (System.in);
    boolean quit = false; 
    boolean forward = true;





    ListIterator<Song> listIterator = playlist.listIterator();
    
    if(playlist.size() == 0){
      System.out.println("No songs in playlist");
      return;
    } else {

      
      System.out.println("Now playing " + listIterator.next().toString() + " from playlist <" + playlistName.getName() + ">"); //turn song object to string //add "from playlist ..."

     
      } 




      System.out.println();
      printMenu();
      while(!quit){
        int action = scan.nextInt();
        scan.nextLine();


        switch(action){ //comprehend this part!

          case 0:
              System.out.println("Playlist complete.");
              quit = true;
              break;
          case 1:
              if(!forward){
                if(listIterator.hasNext()){
                  listIterator.next();
                }
                forward = true;
              }

              if(listIterator.hasNext()){
                System.out.println("Now playing " + listIterator.next().toString());
              } else {
                System.out.println("We have reached the end of the playlist");
                forward = false;
              }

              break;
          case 2:
              if(forward){
                if(listIterator.hasPrevious()){
                  listIterator.previous();
                }

                forward = false;
              }
              if(listIterator.hasPrevious()){
                System.out.println("Now playing " + listIterator.previous().toString());
              } else{
                System.out.println("We are at the start of the playlist");
                forward = true;
              }



              break;
          case 3:
              if(forward){
                  if(listIterator.hasPrevious()){
                    System.out.println("Now replaying " + listIterator.previous().toString());
                    forward = false;
                  }else {
                    System.out.println("We are at the start of the list");
                  }
              }else {
                if(listIterator.hasNext()){
                  System.out.println("Now replaying " + listIterator.next().toString());
                  forward= true;
                }else{
                  System.out.println("We have reached the end of the list");
                }
              }



              break;
          case 4:
              printList(playlist);
              break;
          case 5:
             printMenu();
              break;

          case 6:
              if(playlist.size()>0){
                listIterator.remove(); //everytime delete, need to do .next or .previous to avoid error
                if(listIterator.hasNext()){
                  System.out.println("Now playing " + listIterator.next());
                } else if(listIterator.hasPrevious()){
                  System.out.println("Now playing " + listIterator.previous());
                }

              } else{
                System.out.println("There is no more song in the playlist");
              }

              break;



        }






      }


  }

    private static void printMenu(){
      System.out.println("Available actions: \npress");
      System.out.println("0 - to quit \n" + 
                "1 - to play next song \n" + 
                "2 - to play previous song \n" + 
                "3 - to replay the current song \n" +
                "4 - list songs in the playlist\n"+
                "5 - print available actions.\n" + 
                "6 - delete current song from playlist");
       
    }

    private static void printList(LinkedList<Song> playlist){
      Iterator<Song> iterator = playlist.iterator();
      System.out.println("=======================" );
      
      while(iterator.hasNext()){
        System.out.println(iterator.next().toString());
      }

      System.out.println("=======================");
      

    }




 

  
}
