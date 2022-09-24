public class Song {

  private String name;
  private String duration;

  public Song(String name, String duration) {
    this.name = name;
    this.duration = duration;
  }

  public String getName() {
    return this.name;
  }

  public String getDuration() {
    return this.duration;
  }

  // toString - print out contents of the Class

  @Override //what was this again
  public String toString(){
    return this.name + ": " + this.duration;
  }

  
}
