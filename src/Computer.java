import java.util.ArrayList;

public class Computer {

  private ArrayList<Album> albums;
  private ArrayList<Playlist> playLists;
  private String name;

  public Computer(String name) {
    this.name = name;
    this.albums = new ArrayList<>();
    this.playLists = new ArrayList<>();
  }

  public ArrayList<Album> getAlbums() {
    return this.albums;
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<Playlist> getPlayLists() {
    return this.playLists;
  }
  


  public boolean addAlbum (String albumName){
    
    if (findAlbum(albumName) == null){
       this.albums.add(new Album(albumName)); //WHY??? THIS???? (Initialize)
    System.out.println("Album " + albumName + " added.");
    return true;
  }
    return false;
  }

  public  Album findAlbum(String name){
    

     for (int i = 0; i < this.albums.size(); i++){
      Album checkedAlbum = this.albums.get(i);

        if(checkedAlbum.getAlbumName().equals(name)){
          //System.out.print("Album " + checkedAlbum.getAlbumName() + " found ");
          return checkedAlbum;
       
        }  

    }
    System.out.println(name + " is not found");
  return null; // when can we return null???

  }


  public boolean addSong(String albumName, String songName, String duration){

    if (findSong(songName) == null){
      Album album = findAlbum(albumName); 
      album.addSong(songName, duration);
      System.out.println(" to album " + albumName);
  
      return true;
    }
    
    return false;
    

  }





//DUPLICATED CODE!!! BAD!!!


  public Song findSong(String songName){

    for(Album album : this.albums){
     
      for(Song song: album.getSongs()){
        
        if (song.getName().equals(songName)){
           //fix!!!!!!!!!!!!

          return song;
        }
      }

    }

   // System.out.println("Song " + songName + " not found.");
    return null;
    
  }


  public Album findAlbumFromSong(String songName){
    for(Album album : this.albums){
     
      for(Song song: album.getSongs()){
        
        if (song.getName().equals(songName)){
           //fix!!!!!!!!!!!!

          return album;
        }
      }

    }

   // System.out.println("Song " + songName + " not found.");
    return null;
  }





  public boolean addSongToPlayList(String playListName, String name){

    if(!findPlayList(playListName)){

      if(!(findSong(name) == null)){
        
        for (Playlist playlist : playLists){

          if (playlist.getName().equals(playListName)){
            playlist.addPlayList(findSong(name));

           System.out.println("Song " + name + " added to playlist " + playListName);

            return true;
          }

        }

      } else {
        System.out.println("Song " + name + " not found in all albums.");
        return false;
      }
    

    }
    
    System.out.println("Playlist " + playListName + " not found.");
    return false;
  }
  









  public boolean addPlayList(String name){
    if(findPlayList(name)){
     
      this.playLists.add(new Playlist(name));
      System.out.println(name + " playlist added.");
      return true;
    }
    return false;
  }

  public boolean findPlayList(String name){

    for(Playlist playlist : this.playLists){
      if (playlist.getName().equals(name)){
        return false;

      }
    }
   
    return true;

  }

  
}
