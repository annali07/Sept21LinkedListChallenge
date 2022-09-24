import java.util.LinkedList;

public class Playlist {

  private String name;
  private LinkedList<Song> myPlayList; 


  public Playlist(String name) {
    this.name = name;
    this.myPlayList = new LinkedList<>() ;
  }


  public String getName() {
    return this.name;
  }

  public LinkedList<Song> getMyPlayList() {
    return this.myPlayList;
  }

  public void addPlayList(Song song){
    this.myPlayList.add(song);
  }


  
}
