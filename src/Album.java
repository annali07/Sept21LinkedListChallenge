import java.util.ArrayList;

public class Album {

  private String albumName;
  private ArrayList<Song> songs;
  
  public Album(String albumName) {
    this.albumName = albumName;


    this.songs = new ArrayList<>();
 
    
  }

  public String getAlbumName() {
    return this.albumName;
  }

  public ArrayList<Song> getSongs() {
    return this.songs;
  }

 


  public boolean addSong(String songName, String duration){

      songs.add(new Song(songName, duration));
      System.out.print("Song " + songName + "\t" + duration + " added");
      return true;    

    
  }
  
  //Modify to when found a song, not add. Instead of not find a song, add

  // private Song findSong (String songName){
  //   for (int i = 0; i<songs.size(); i++){
  //     Song song = this.songs.get(i);
  //     if(song.getName().equals(songName)){
  //       return song;
  //     }
  //   }
  //   return null; //??????????????
  // }



}
