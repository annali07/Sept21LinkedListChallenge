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

  public Song findSong(String songName){

    for(int i = 0; i <albums.size(); i++){
   
      Album album = this.albums.get(i);
     // System.out.println(albums.get(i).getAlbumName());
      
        for (int j =0; j< album.getSongs().size(); j++){
      //    System.out.println(album.getSongs().get(j).getName());

          if(album.getSongs().get(j).getName().equals(songName)){
              
            System.out.println("Song " + album.getSongs().get(j).getName() + " found in album " + album.getAlbumName());
            
            
            return album.getSongs().get(j);


          }
        }
   

    }
   
    //System.out.println("Song " + songName + " not found.");
    return null;
    
  }


  public boolean addSongToPlayList(String playListName, String name){

    if(!findPlayList(playListName)){

      if(!(findSong(name) == null)){
        for (int i = 0; i<playLists.size(); i++){
        if (playLists.get(i).getName().equals(playListName)){
          playLists.get(i).addPlayList(findSong(name));
          System.out.println("Song " + name + " added to playlist " + playListName);
          return true;
        }
      }


      } else {
        System.out.println("Song " + name + " not found");
        return false;
       }
    

    }
    
    System.out.println("Playlist " + playListName + " not found");
    return false;
  }
  


  public boolean addPlayList(String name){
    if(findPlayList(name)){
     
      this.playLists.add(new Playlist(name));
      return true;
    }
    return false;
  }



  public boolean findPlayList(String name){

    for (int i = 0; i<this.playLists.size(); i++){

      if ( this.playLists.get(i).getName().equals(name)){
        return false;
      }
    }

    return true;
    

  }

  
}
