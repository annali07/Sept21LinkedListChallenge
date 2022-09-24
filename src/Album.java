import java.util.ArrayList;

public class Album {

  private String albumName;
 // private String artist;
  private ArrayList<Song> songs;
  
  public Album(String albumName) {
    this.albumName = albumName;
    //this.artist = artist;


    this.songs = new ArrayList<>();
 
    
  }

  public String getAlbumName() {
    return this.albumName;
  }

  public ArrayList<Song> getSongs() {
    return this.songs;
  }

  public boolean addSong(String songName, String duration){

      if (findSong(songName) == null) {

      this.songs.add(new Song(songName, duration));
      System.out.print("Song " + songName + "\t" + duration + " added");
      return true;    
      }
      return false;
    
  }

  private Song findSong(String title){

    for(Song checkedSong: this.songs){ //go through a list of entries. For each command. Create a variable checkedSong for every entry on the songs arrayList
      if(checkedSong.getName().equals(title)){
        return checkedSong;
      }

    }
    return null;
  }
  

}
